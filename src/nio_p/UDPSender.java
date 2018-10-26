package nio_p;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardProtocolFamily;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.nio.charset.Charset;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class UDPSender extends Application implements Initializable{
	
	@FXML TextField tf_ip, tf_port, tf_msg;
	@FXML Button bt_send;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		bt_send.setOnAction(ss -> {
			try {												//IPv4 사용 - StandardProtocolFamily.INET
				DatagramChannel channel = DatagramChannel.open(StandardProtocolFamily.INET);
				
				System.out.println("data 전송 시작");
				
				Charset charset = Charset.defaultCharset();
				ByteBuffer buf = charset.encode(tf_msg.getText());
				
				//String ip = "192.168.0.2"; // UniCast 하나만 하는거
				//ip = "192.168.0.255"; // BroadCast 전체방송
				int cnt = channel.send(buf, new InetSocketAddress(tf_ip.getText(), Integer.parseInt(tf_port.getText())));
				//System.out.println(cnt); //5 출력 = 9 1바잍, o 1바잍, o 1바잍, d 1바잍 , " " 1바잍.
				
				System.out.println("data 전송 완료 : " + cnt);
				//TetxArea로 교체하고
				//파일전송까지 클리어해보자고
				channel.close();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent parent = FXMLLoader.load(getClass().getResource("udpsender.fxml"));
        Scene scene = new Scene(parent);
 
        primaryStage.setTitle("채팅이닷");
        primaryStage.setScene(scene);
        //primaryStage.setResizable(false); // 크기 변경 불가 명령어.
        
        primaryStage.show();
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}


}
