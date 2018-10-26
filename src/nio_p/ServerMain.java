package nio_p;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class ServerMain {
	
	public static void main(String[] args) {
		// TODO ���θ޽�
		try {
			ServerSocketChannel server = ServerSocketChannel.open();
			server.configureBlocking(true);
			server.bind(new InetSocketAddress(9501));
			
			while(true) {
				System.out.println("--------����--------");
				System.out.println("[���� ���]");

				SocketChannel client = server.accept();
				
				InetSocketAddress addr = (InetSocketAddress) client.getRemoteAddress();
				
				String clientAddr = addr.getHostName();
				
				System.out.println("[��ŷ �Ϸ�] " + clientAddr + " [" + addr.getAddress().getHostAddress() + "]");
				
				
				//Charset charset = Charset.forName("UTF-8");
				Charset charset = Charset.defaultCharset();
				System.out.println("���� : [��ŷ ����] " + clientAddr);
				
				ByteBuffer buf = null;
				buf = charset.encode("������ ������ �޽���");
				client.write(buf);
				System.out.println(clientAddr + " ������ ����");
				
				buf = ByteBuffer.allocate(100);
				int cnt = client.read(buf);
				
				buf.flip();
				
				String data = charset.decode(buf).toString();
				
				System.out.println(clientAddr + " [" + addr.getAddress().getHostAddress() + "] " + "������ ����");
				
				System.out.println(clientAddr + " [" + addr.getAddress().getHostAddress() + "] " + "���� ����");

				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
