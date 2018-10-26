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
            System.out.println("���� ���� ����");
            
            ByteBuffer buf = ByteBuffer.allocate(1024);
            
            Charset charset = Charset.defaultCharset();
            
            channel.read(buf);
            
            buf.flip();
            
            String data = charset.decode(buf).toString();
            
            buf.clear();
            
            System.out.println("[����]"+data);
            
            FileChannel fcw = FileChannel.open(
                    Paths.get("src/nnn/sample33.jpg"),
                    StandardOpenOption.CREATE, 
                    StandardOpenOption.WRITE);
            
            int cnt=0;
            
            while(true)
            {
                cnt = channel.read(buf);
                System.out.println("channel.read(buf) : " + channel.read(buf));
                //System.out.println("�۾���? cnt : " + cnt);
                if(cnt<=0)
                    break;
                
                buf.flip();
                fcw.write(buf);
     
                buf.clear();
                System.out.println("Ŭ���̾�Ʈ :buf "+cnt);
            }
            
           ////���� ������ �� ���޹޾� ���������� ���ϰ� ä���� �ݴ´�.
            fcw.close();
            channel.close();
            System.out.println("���� ���� ����");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
 
}