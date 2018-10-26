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

public class ShapeExam extends Application implements Initializable {
	@FXML Canvas shapeCanvas;
	GraphicsContext gc;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(getClass().getResource("shape.fxml"));
		
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
		// TODO Auto-generated method stub
		gc = shapeCanvas.getGraphicsContext2D();
		
		Image img;
		img = new Image("file:ppp/sample.jpg", 300, 300, true, false);
		gc.drawImage(img, 100, 100);
		Image img2;
		img2 = new Image("file:ppp/sample2.jpg", 300, 300, true, false);
		gc.drawImage(img2, 350, 350);
		
		gc.setFill(Color.PINK);
		gc.setStroke(Color.PINK);
		gc.strokeOval(450, 200, 100, 100);
		gc.fillOval(450, 200, 100, 100);
		
		gc.setFill(Color.BLACK);
		gc.setStroke(Color.BLACK);
		gc.fillRoundRect(450, 200, 80, 80, 450, 200);
	}

}
