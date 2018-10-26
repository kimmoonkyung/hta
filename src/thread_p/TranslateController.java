package thread_p;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.shape.Arc;
import javafx.util.Duration;

public class TranslateController implements Initializable {

	@FXML Arc arc;
	@FXML Button pause;
	@FXML Button start, stop;
	
	
	TranslateTransition transition;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		transition = new TranslateTransition();
		
		transition.setToX(400);	//�̵��� X��ǥ (����)
		transition.setToY(200);

		transition.setDuration(new Duration(3000)); //����ð�
		
		transition.setCycleCount(5);	//�ݺ�Ƚ��
		transition.setAutoReverse(true);
		transition.setNode(arc);	//������ node
		
		transition.play();
		
		pause.setOnAction(pp -> {
			transition.pause();
			System.out.println(transition.getStatus());
		});
		
		start.setOnAction(ss -> {
			transition.play();
			System.out.println(transition.getStatus());
		});
		
		stop.setOnAction(ss -> {
			transition.stop();	//�����ϰ� ��ŸƮ�ϸ� ��������ǥ���� ����� �ٵ� ������ �ִ�����?
			System.out.println(transition.getStatus());
		});
		
	}

}
