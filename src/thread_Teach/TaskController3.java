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
		chkMap.put(false, "��");
		
		restartMap = new HashMap<>();
		restartMap.put(true, "��");
		restartMap.put(false, "restart");
		
		numberGo = new NumberGo();
		numberGo.start();
		
		
		
		
		restart.setOnAction(ee->{
			
			///reChk ::: > true -> ������
			if(reChk) {
				numberGo.cancel();	// ���߱� , ���θ޼ҵ�
			}else {
				numberGo.restart();	// �ٽý���, ���θ޼ҵ�
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
							System.out.println("���´�");
							//label.setText(i+"");  ���� gui ��ü ���� �Ұ�!!!!
							
							updateMessage(i+"");  ///Task ���� �޼ҵ�� ������ ����
						}
						Thread.sleep(1000);
						
						/*if(!reChk)
							break;
						*/
						/////numberGo.cancel() ; �� �޼ҵ�� ��������
					}
					//return null;
				}
			};
			
			label.textProperty().bind(task.messageProperty());
			///label �� task�� �����ش�
			
			return task;
		}
		
	}

}
