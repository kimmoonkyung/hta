package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Sub extends Application {
	
		@Override
		public void start(Stage primaryStage) throws Exception {
			
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,700,700);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("øÕ Sub¿Ã¥Ÿ");
			primaryStage.show();
			
		}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
