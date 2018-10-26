package net_p;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try {
			ServerSocket server = new ServerSocket(7777); //7777 포트번호
			
			while(true) {
				System.out.println("연결대기");
				Socket client = server.accept(); //<-얘가 없으면 연결대기 무한루프
				
				OutputStream os = client.getOutputStream();
				
				DataOutputStream dos = new DataOutputStream(os);
				
				dos.writeUTF("ㅁㄱㅅㅂ");
				
				
				dos.close();
				os.close();
				client.close(); //열어놓은것 역순으로 닫는다.
				
				System.out.println("전송완료");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
