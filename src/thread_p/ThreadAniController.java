package thread_p;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Arc;

public class ThreadAniController implements Initializable {

	@FXML AnchorPane totalP;
	@FXML Pane pp, user;
	@FXML Arc pArc;
	
/////////////////////////////////////////////////////////////////////////////////////////	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		Timer timer = new Timer();
		timer.setDaemon(true);
		timer.start();
		
		////�̺�Ʈ ��� ---> Ű �Է� �̺�Ʈ (KEY_RELEASSED �� ���� ���� ���̾�)
		//focusTraversable="true" node�� focus�� �������� �ʰ� �����Ű�°�****
		//keyEvent�� ��ü�� ���� �ʵ��� ����**********************************
		totalP.addEventHandler(KeyEvent.KEY_PRESSED,
				new EventHandler<KeyEvent>() {
					@Override
					public void handle(KeyEvent key) {
						// TODO Auto-generated method stub
						System.out.println(key.getCode());
						double yy = user.getLayoutY();
						double xx = user.getLayoutX();
						
						switch (key.getCode()) {
							case UP:
								yy = user.getLayoutY()-10;
								if(yy<0) yy=0;
								user.setLayoutY(yy);
								break;
							case DOWN:
								yy = user.getLayoutY()+10;
								if(totalP.getPrefHeight()<yy+user.getPrefHeight()) 
									yy=totalP.getPrefHeight()-user.getPrefHeight();
								user.setLayoutY(yy);
								break;
							case LEFT:
								xx = user.getLayoutX()-10;
								if(xx<0) xx=0;
								user.setLayoutX(xx);
								break;
							case RIGHT:
								xx = user.getLayoutX()+10;
								if(totalP.getPrefWidth()<xx+user.getPrefWidth()) 
									xx=totalP.getPrefWidth()-user.getPrefWidth();
								user.setLayoutX(xx);
								break;
						}
					}
		});
		//new Timer().start();
	}
/////////////////////////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////	
	class Timer extends Thread {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			while(true) {
				try {
					//�÷��� �̰� �߿��ϴ�
					Platform.runLater( ()->init() );
					sleep(30);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
///////////////////////////////////////////////	
	int maxAngle = 70;
	int angle = 5;
	int disX = 5;
	int disY = 5;
	void init() {
		double xx = pp.getLayoutX()+disX;
		double yy = pp.getLayoutY()+disY;
		double aa = pArc.getStartAngle();
		if(totalP.getPrefWidth()< xx+pp.getPrefWidth() || xx<0 ) { //������ xx���� ũ�ٸ�?
			disX*=-1;
		}
			
		if(totalP.getPrefHeight()< yy+pp.getPrefHeight() || yy<0 ) { //������ xx���� ũ�ٸ�?
			disY*=-1;
		}
		
		aa+=angle;
		if(aa>=maxAngle || aa<0) {
			angle*=-1;
		} else if (aa<0) {
			aa=0;
		}
		pArc.setStartAngle(aa);
		pArc.setLength(359-(aa*2));
		pp.setLayoutX(xx);
		pp.setLayoutY(yy);
	}
	////////////////////////////////
	
	
	
	
}
