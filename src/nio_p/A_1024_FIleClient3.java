package nio_p;
 
import java.io.IOException;
import java.io.ObjectOutputStream.PutField;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
 
public class A_1024_FIleClient3 {
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
 
        try {
            SocketChannel channel = SocketChannel.open();
            channel.configureBlocking(true);
            
            channel.connect(new InetSocketAddress("192.168.0.61", 7777));
            System.out.println("서버 접속 성공");
            
            ByteBuffer buf = ByteBuffer.allocate(1024);
            
            Charset charset = Charset.defaultCharset();
            
            channel.read(buf);
            
            buf.flip();
            
            String data = charset.decode(buf).toString();
            
            buf.clear();
            
            System.out.println("[서버]"+data);
            
            FileChannel fcw = FileChannel.open(
                    Paths.get("src/nnn/sample33.jpg"),
                    StandardOpenOption.CREATE, 
                    StandardOpenOption.WRITE);
            
            int cnt=0;
            
            while(true)
            {
                cnt = channel.read(buf);
                System.out.println("channel.read(buf) : " + channel.read(buf));
                //System.out.println("작업전? cnt : " + cnt);
                if(cnt<=0)
                    break;
                
                buf.flip();
                fcw.write(buf);
     
                buf.clear();
                System.out.println("클라이언트 :buf "+cnt);
            }
            
           ////버퍼 내용을 다 전달받아 빠져나오면 파일과 채널을 닫는다.
            fcw.close();
            channel.close();
            System.out.println("서버 접속 종료");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
 
}