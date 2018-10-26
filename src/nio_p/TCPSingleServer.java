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
			//현재 보내는 컴퓨터의 IP로 이름 설정. 걍 우리 이름으로 해도 되는거 아님?
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		// TODO 보내는 애
		Charset charset = Charset.defaultCharset();
		//병신같대 이게 왜 병신같냐면 스캐너를 써서?
		Scanner sc = new Scanner(System.in); // 이거를 텍스트 필드로 바꾸고 
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
		// TODO 받는 애
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
		// TODO 메인메쏟
		ServerSocketChannel server = null;
		try {
			server = ServerSocketChannel.open();
		
			server.configureBlocking(true);
			server.bind(new InetSocketAddress(9501));
			
			System.out.println("서버 대기대기 김대기");
			
			SocketChannel client = server.accept();
			
			new TCPSingleSender(client).start();
			new TCPSingleReciever(client).start();
		
		} catch (IOException e) {
			e.printStackTrace();
			try {
				server.close(); // 문제 생기면 서버 닫아
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			
		}
		
		
		
		
	}

}
