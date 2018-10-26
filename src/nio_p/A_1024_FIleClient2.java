package nio_p;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class A_1024_FIleClient2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			SocketChannel channel = SocketChannel.open();
			channel.configureBlocking(true);
			
			channel.connect(new InetSocketAddress("192.168.0.61", 7777));
			System.out.println("ä�� : " + channel);
		
			Path path = Paths.get("src/nnn/sample.jpg");
			System.out.println("�н� : " + path );
			//Path path2 = Paths.get("ppp/sample.jpg"); //<-�׽�Ʈ��
			FileChannel fc = FileChannel.open(path, 
					StandardOpenOption.CREATE,
					StandardOpenOption.WRITE);
			
			ByteBuffer buf = ByteBuffer.allocate(1024);
			//���ڸ� ���ڷ� �ٲ�ġ���ؼ� ������.
			
			int btCnt = fc.write(buf);
			System.out.println("@@@@" + btCnt);
			//buf.putInt(1024);
			//System.out.println(buf.putInt(1024));
			//�������� ������ ����(������ ������ ����� �˰��ִ�,
			//(sample.jpg/buf)
			
			for (int i = 0; i < 96; i++) {
				int cnt=channel.read(buf);
				//if(cnt == -1) break;
				System.out.println("�Ե�Ʈ : " + buf.getInt(96));
				System.out.println("Ǫ��Ʈ : " + buf.putInt(96));
				buf.flip();
				fc.write(buf);
				buf.clear();
				System.out.println("client:"+cnt);
				
			}
			channel.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
