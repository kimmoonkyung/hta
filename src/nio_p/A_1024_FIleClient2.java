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
			System.out.println("채널 : " + channel);
		
			Path path = Paths.get("src/nnn/sample.jpg");
			System.out.println("패스 : " + path );
			//Path path2 = Paths.get("ppp/sample.jpg"); //<-테스트용
			FileChannel fc = FileChannel.open(path, 
					StandardOpenOption.CREATE,
					StandardOpenOption.WRITE);
			
			ByteBuffer buf = ByteBuffer.allocate(1024);
			//숫자를 문자로 바꿔치기해서 보낸다.
			
			int btCnt = fc.write(buf);
			System.out.println("@@@@" + btCnt);
			//buf.putInt(1024);
			//System.out.println(buf.putInt(1024));
			//서버에서 파일을 보냄(서버는 파일의 사이즈를 알고있다,
			//(sample.jpg/buf)
			
			for (int i = 0; i < 96; i++) {
				int cnt=channel.read(buf);
				//if(cnt == -1) break;
				System.out.println("게딘트 : " + buf.getInt(96));
				System.out.println("푸딘트 : " + buf.putInt(96));
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
