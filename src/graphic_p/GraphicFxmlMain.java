package graphic_p;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.shape.Arc;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class GraphicFxmlMain extends Application implements Initializable {

	@FXML Rectangle rec;
	@FXML Button btnRec;
	
	@FXML Arc arc, arc1;
	@FXML Button btnArc;
	
	@FXML Circle cir;
	@FXML Line line;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(getClass().getResource("graphic.fxml"));
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	int maxAngle = 45;
	int oneAngle = 15;
	
	int maxLay = 600;
	int oneLay = 100;
	int maxYlay = 300;
	int oneYlay = 100;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		btnRec.setOnAction(ee -> {
			System.out.println("»ç°¢ÇüÈ¸Àü");
			rec.setRotate(rec.getRotate()*-1);
		});
		
		btnArc.setOnAction(ee -> {
			double startAngle = arc.getStartAngle();
			startAngle+=oneAngle;
			if(startAngle>=maxAngle || startAngle<0) {
				oneAngle*=-1;
				if(startAngle>=maxAngle) {
					startAngle=maxAngle;
				} else if(startAngle<0) {
					startAngle=0;
				}
				//arc.setRotate(90);
			}
			double startLay = arc.getLayoutX();
			double startYlay = arc.getLayoutY();
			startLay+=oneLay;
			//startYlay+=oneYlay;
			if(startLay>=maxLay || startLay<100) {
				oneLay*=-1;
				if(startLay>=maxLay) {
					startLay=maxLay;
					System.out.println("¾Æ·¡·Î ¸Ô¾î");
					arc.setRotate(90);
					
					if(startLay==maxLay) {
						//oneYlay*=-1;
						oneYlay+=100;
						System.out.println("³»·Á°¡¶ó");
						arc.setLayoutY(oneYlay);
						System.out.println("¿ÞÂÊ ¾Ã¾î");
						arc.setRotate(180);
					}
					
				} /*else if(startLay<150) {
					startLay=150;
				}*/
				
			}
			
			System.out.println("ÆÑ¸Ç");
			arc.setStartAngle(startAngle);
			arc.setLength(359-(startAngle*2));
			
			arc.setLayoutX(startLay);
		});
		
	}

}
