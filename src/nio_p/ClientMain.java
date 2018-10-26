package nio_p;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class ClientMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			SocketChannel channel = SocketChannel.open();
			channel.configureBlocking(true);
			
			channel.connect(new InetSocketAddress("192.168.0.2", 7777));
			System.out.println("--------클라--------");
			System.out.println("[도킹 완료@]");
			
			ByteBuffer buf = ByteBuffer.allocate(100);
			int byteCount = channel.read(buf);
			buf.flip();
			
			Charset charset = Charset.defaultCharset();
			
			String data = charset.decode(buf).toString();
			
			System.out.println("[서버] " + data);
			
			buf = charset.encode(" gg");
			channel.write(buf);
			System.out.println("서버 데이터 송신 완료");
			
			channel.close();
			System.out.println("[도킹 해제@]");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
