package thread_p;

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
		chkMap.put(false, "в║");
		
		restartMap = new HashMap<>();
		restartMap.put(true, "бс");
		restartMap.put(false, "restart");
		
		numberGo = new NumberGo();
		numberGo.start();
		

		restart.setOnAction(ee->{
			
			if(!reChk) {
				
				numberGo = new NumberGo();
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
			
			while(reChk) {
				if(chk) {
					i++;
					Platform.runLater(()->label.setText(i+""));
				}
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}	
			}
		}		
	}

}
