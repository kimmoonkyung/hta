package nio_p;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Scanner;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

class TCPSingleSender extends Thread {
	
	/*@FXML TextField tf_msg;
	@FXML Button bt_msg;*/
	
	SocketChannel socket;
	String name;
	
	public TCPSingleSender(SocketChannel socket) {
		super();
		this.socket = socket;
		try {
			name = "[" + InetAddress.getLocalHost().getHostAddress() + "]";
			//���� ������ ��ǻ���� IP�� �̸� ����. �� �츮 �̸����� �ص� �Ǵ°� �ƴ�?
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		// TODO ������ ��
		Charset charset = Charset.defaultCharset();
		//���Ű��� �̰� �� ���Ű��ĸ� ��ĳ�ʸ� �Ἥ?
		Scanner sc = new Scanner(System.in); // �̰Ÿ� �ؽ�Ʈ �ʵ�� �ٲٰ� 
		//bt_msg.setOnAction(bm -> {
			while(true) {						//ex) tf_send.getText()
				ByteBuffer buf = charset.encode(name + sc.nextLine());
				
				try {
					socket.write(buf);
				} catch (IOException e) {
					e.printStackTrace();
					break;
				}
			}
		//});
		
	}
}

class TCPSingleReciever extends Thread {
	SocketChannel socket;

	public TCPSingleReciever(SocketChannel socket) {
		super();
		this.socket = socket;
	}
	
	@Override
	public void run() {
		// TODO �޴� ��
		Charset charset = Charset.defaultCharset();
		while(true) {
			try {
				ByteBuffer buf = ByteBuffer.allocate(100);
				socket.read(buf);
				buf.flip();
				String data = charset.decode(buf).toString();
				System.out.println(data);
			} catch (Exception e) {
				break;
			}
			
			
		}
	}
	
}

public class TCPSingleServer {

	public static void main(String[] args) {
		// TODO ���θ޽�
		ServerSocketChannel server = null;
		try {
			server = ServerSocketChannel.open();
		
			server.configureBlocking(true);
			server.bind(new InetSocketAddress(9501));
			
			System.out.println("���� ����� ����");
			
			SocketChannel client = server.accept();
			
			new TCPSingleSender(client).start();
			new TCPSingleReciever(client).start();
		
		} catch (IOException e) {
			e.printStackTrace();
			try {
				server.close(); // ���� ����� ���� �ݾ�
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		
		
		
	}

}
