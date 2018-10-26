package thread_Teach;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class TaskController implements Initializable {
	
	@FXML Label label;
	@FXML Button restart, suspend;
	
	NumberGo numberGo;
	
	boolean chk = true, reChk = true;

	HashMap<Boolean, String>chkMap, restartMap;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

		chkMap = new HashMap<>();
		chkMap.put(true, "||");
		chkMap.put(false, "▶");
		
		restartMap = new HashMap<>();
		restartMap.put(true, "■");
		restartMap.put(false, "restart");
		
		numberGo = new NumberGo();
		numberGo.start();
		
		restart.setOnAction(ee->{
			/*if(reChk) {
				numberGo.stop(); //이건 객체가 죽어버림
			}else {	//그래서 다시 시작하려면 다시 생성해줘야됨
				numberGo = new NumberGo();	// 다시시작, 내부메소드
				numberGo.start();
			}*/
			if(!reChk) {
				numberGo = new NumberGo();	// 다시시작, 내부메소드
				numberGo.start();
			}
			
			reChk = !reChk;
			restart.setText(restartMap.get(reChk));
		});
		
		suspend.setOnAction(ee->{
			chk = !chk;
			suspend.setText(chkMap.get(chk));
		});
	}
	
	
	class NumberGo extends Thread{
	
		int i =0;
		
		@Override
		public void run() {
			// TODO Auto-generated method stub		
			
			
			while(true) {
				if(chk) {
					i++;
					/*Platform.runLater(new Runnable() {
						@Override public void run() {
							// TODO Auto-generated method stub
							label.setText(i+"");
						}
					});*/
					Platform.runLater( () -> label.setText(i+""));
					//label.setText(i+"");  //직접 gui 객체 변경 불가!!!!
					
				}
				
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
				
				if(!reChk)
					break;
			}
		}		
	}

}
