package graphic_p;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class CanvasMain extends Application implements Initializable {

	@FXML Canvas canvas;
	GraphicsContext gc;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(getClass().getResource("canvas.fxml"));
		
		Scene scene = new Scene(root);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub // 450 570 650 520 / 470 400 
		gc = canvas.getGraphicsContext2D();
		
		gc.setFill(Color.RED);
		gc.fillRect(100, 20, 130, 70); //사각형 (x, y =위치 / w, h = 
		
		gc.setStroke(Color.BLUE);
		gc.strokeOval(50, 10, 200, 50); //원이다
		//gc.setStroke(new Color(red, green, blue, opacity));
		gc.setStroke(new Color(0, 0, 1, 0.5));
		gc.setFill(new Color(0, 0, 1, 0.5));
		
		gc.setStroke(Color.GREEN);
		gc.strokeRect(50, 70, 100, 100);
	
		gc.setFill(Color.PINK);
		gc.fillRoundRect(50, 180, 200, 200, 50, 100);
		
		gc.setFill(Color.AQUA);
		gc.fillArc(400, 20, 100, 100, 0, 90, ArcType.CHORD); //
		gc.fillArc(500, 20, 100, 100, 0, 90, ArcType.OPEN);
		gc.fillArc(600, 20, 100, 100, 0, 90, ArcType.ROUND);
		gc.fillArc(400, 150, 100, 100, 45, 90, ArcType.ROUND); //45= 시작각도, arcExtent, ArcType closure
		
		gc.setStroke(Color.RED);
		gc.strokeArc(400,200,100,100,0,90,ArcType.CHORD);
		gc.strokeArc(500,200,100,100,0,90,ArcType.OPEN);
		gc.strokeArc(600,200,100,100,0,90,ArcType.ROUND);
		gc.strokeArc(400,250,100,100,45,90,ArcType.ROUND);
	
		gc.fillPolygon(new double [] {450, 570, 650, 520}, 
				new double [] {470, 400, 560, 540}, 
				4);
		gc.strokePolygon(new double [] {450, 570, 650, 520}, 
				new double [] {470, 400, 560, 540}, 
				4);
		
		Image img;
		//img = new Image("file:ppp/roka.png");
		img = new Image("file:ppp/roka.png", 300, 150, true, false);
		gc.drawImage(img, 50, 500);
		
	}

}
