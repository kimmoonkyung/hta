package nio_p;
 
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
 
public class A_1024_FileServer3 {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
 
        try {
            ServerSocketChannel server = ServerSocketChannel.open();
            server.configureBlocking(true);
            server.bind(new InetSocketAddress(7777));
            
            while(true) {
                System.out.println("서버 대기");
                
                SocketChannel client = server.accept();
                
                InetSocketAddress addr = (InetSocketAddress)client.getRemoteAddress();
                
                String clientAddr = "["+addr.getAddress().getHostAddress()+"]";
                
                System.out.println(clientAddr+ " 접속");
                
                
                Charset charset = Charset.defaultCharset();
                
                ByteBuffer buf = charset.encode("하이루");
                client.write(buf);
                
                Path path = Paths.get("ppp/sample.jpg");
                
                FileChannel fcr = FileChannel.open(
                        path, 
                        StandardOpenOption.READ);
                
                buf = ByteBuffer.allocate(1024);
                
                int cnt=0;
                
                while(true)
                {
                    cnt = fcr.read(buf);
                    
                    if(cnt ==-1)
                        break;
                    
                    buf.flip();
                    client.write(buf);
         
                    buf.clear();
                    System.out.println("buf:"+cnt);
                    
                }
                
                //////전송내용이 다전달되면 파일과 클라이어트를 닫는다!!
                fcr.close();
                client.close();
                
                System.out.println(clientAddr+ " 데이터 전송");
                
                System.out.println(clientAddr+ " 접속종료");
            }
            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}