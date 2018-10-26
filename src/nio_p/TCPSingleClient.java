package nio_p;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URL;
import java.nio.channels.SocketChannel;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TCPSingleClient extends Application implements Initializable {
	
	@FXML Button send, bt_msg;
	@FXML TextField tf_ip, tf_port, tf_msg;
	@FXML Label lb_msg;
	
	SocketChannel socket = null;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
		send.setOnAction(ss -> {
			try {
				socket = SocketChannel.open();
				socket.configureBlocking(true);
				
				socket.connect(new InetSocketAddress(tf_ip.getText(), Integer.parseInt(tf_port.getText())));
				//socket.connect(new InetSocketAddress("192.168.0.61", 7777));
				
				new TCPMulSender(socket).start();
				new TCPMulReciever(socket).start();
				
				
			} catch (IOException e) {
				e.printStackTrace();
				try {
					socket.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		
	}


	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		Parent parent = FXMLLoader.load(getClass().getResource("tcpserver.fxml"));
		Scene scene = new Scene(parent);

		primaryStage.setTitle("TCP 클라");
		primaryStage.setScene(scene);
		//primaryStage.setResizable(false); // 크기 변경 불가 명령어.
		
		primaryStage.show();
		
	}
	
	
	public static void main(String[] args) {
		// TODO 메인 메쏟
		launch(args);
		
		
	}



	

}
