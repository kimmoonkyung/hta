package thread_Teach;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class TaskController3 implements Initializable {
	
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
			
			///reChk ::: > true -> 진행중
			if(reChk) {
				numberGo.cancel();	// 멈추기 , 내부메소드
			}else {
				numberGo.restart();	// 다시시작, 내부메소드
			}
			
			reChk = !reChk;
			restart.setText(restartMap.get(reChk));
			
			
		});
		
		suspend.setOnAction(ee->{
			chk = !chk;
			suspend.setText(chkMap.get(chk));
		});
	}
	
	
	
	

	
	class NumberGo extends Service<Void>{

		@Override
		protected Task<Void> createTask() {
			// TODO Auto-generated method stub
			
			Task<Void> task = new Task<Void>() {

				@Override
				protected Void call() throws Exception {
					// TODO Auto-generated method stub
					
					int i =0;
					
					while(true) {
						if(chk) {
							i++;
							System.out.println("들어온다");
							//label.setText(i+"");  직접 gui 객체 변경 불가!!!!
							
							updateMessage(i+"");  ///Task 내부 메소드로 가지고 나감
						}
						Thread.sleep(1000);
						
						/*if(!reChk)
							break;
						*/
						/////numberGo.cancel() ; 이 메소드로 빠져나감
					}
					//return null;
				}
			};
			
			label.textProperty().bind(task.messageProperty());
			///label 과 task를 묶어준다
			
			return task;
		}
		
	}

}
