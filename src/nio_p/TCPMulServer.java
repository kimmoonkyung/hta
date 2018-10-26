package nio_p;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class TCPMulServer {

	ArrayList<SocketChannel> list = new ArrayList<>();
	
	class TCPMulSeverReciever extends Thread {
		
		SocketChannel socket;
		String name;

		public TCPMulSeverReciever(SocketChannel socket) {
			super();
			this.socket = socket;
			try {
				InetSocketAddress address = (InetSocketAddress) socket.getRemoteAddress();
				name = "[" + address.getAddress().getHostAddress()+"]";
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			//TODO �̳�Ŭ���� ���ù�, �� �޽���
			sendToAll(name + " ����");
			
			list.add(socket);
			sendToAll("������ �� : " + list.size());
			Charset charset = Charset.defaultCharset();
			
				try {
					while(socket!=null) {
					ByteBuffer buf = ByteBuffer.allocate(100);
					socket.read(buf);
					buf.flip();
					String data = charset.decode(buf).toString();
					sendToAll(data);
					}
					//System.out.println(data);
				} catch (Exception e) {
					
				} finally {
					list.remove(socket);
					sendToAll(name + " ����");
					sendToAll("������ �� : " + list.size());
				}
		}
	}
	
	void sendToAll(String msg) {
		
		for (SocketChannel channel : list) {
			Charset charset = Charset.defaultCharset();
			ByteBuffer buf = charset.encode(msg);
			try {
				channel.write(buf);
			} catch (IOException e) {
				
				break;
			}
		}
	}
	
	public TCPMulServer() {
		// TODO ����Ŭ���� ������
		try {
			ServerSocketChannel server = ServerSocketChannel.open();

			server.configureBlocking(true);
			server.bind(new InetSocketAddress(7777));

			while(true) {
				SocketChannel client = server.accept();
				
				new TCPMulSeverReciever(client).start();
				
				System.out.println(client.getRemoteAddress()+ " ���� : " + list.size());
			}

		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		// TODO ���� �ޚP
		new TCPMulServer();
	}

}
