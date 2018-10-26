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
		
		transition.setToX(400);	//이동할 X좌표 (도착)
		transition.setToY(200);

		transition.setDuration(new Duration(3000)); //진행시간
		
		transition.setCycleCount(5);	//반복횟수
		transition.setAutoReverse(true);
		transition.setNode(arc);	//적용할 node
		
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
			transition.stop();	//정지하고 스타트하면 정지한좌표부터 출발함 근데 느려짐 왜느려짐?
			System.out.println(transition.getStatus());
		});
		
	}

}
