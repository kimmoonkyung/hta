package nio_p;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class ServerMain {
	
	public static void main(String[] args) {
		// TODO 메인메쏟
		try {
			ServerSocketChannel server = ServerSocketChannel.open();
			server.configureBlocking(true);
			server.bind(new InetSocketAddress(9501));
			
			while(true) {
				System.out.println("--------서버--------");
				System.out.println("[연결 대기]");

				SocketChannel client = server.accept();
				
				InetSocketAddress addr = (InetSocketAddress) client.getRemoteAddress();
				
				String clientAddr = addr.getHostName();
				
				System.out.println("[도킹 완료] " + clientAddr + " [" + addr.getAddress().getHostAddress() + "]");
				
				
				//Charset charset = Charset.forName("UTF-8");
				Charset charset = Charset.defaultCharset();
				System.out.println("서버 : [도킹 해제] " + clientAddr);
				
				ByteBuffer buf = null;
				buf = charset.encode("서버가 보내는 메시지");
				client.write(buf);
				System.out.println(clientAddr + " 데이터 전송");
				
				buf = ByteBuffer.allocate(100);
				int cnt = client.read(buf);
				
				buf.flip();
				
				String data = charset.decode(buf).toString();
				
				System.out.println(clientAddr + " [" + addr.getAddress().getHostAddress() + "] " + "데이터 전송");
				
				System.out.println(clientAddr + " [" + addr.getAddress().getHostAddress() + "] " + "접속 종료");

				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
