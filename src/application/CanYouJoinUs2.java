/*package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ChangeListener;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

public class CanYouJoinUs2 extends Application implements Initializable {

	@FXML RadioButton genM;
	@FXML RadioButton genF;
	@FXML ComboBox<String> yy;
	
	javafx.collections.FXCollections fx;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
//TODO 입력 ------------------------------------------------------
//TODO 생년월일 ---------------------------------------------------
		
		ObservableList<String> yyData = 
				FXCollections.observableArrayList("1990", "1991", "1992", "1993", "1994");
		
		yy.setItems(yyData);
		yy.setValue(yyData.get(0));
		
//TODO 버튼	중복확인 남녀 휴대폰 인증
		EventHandler handler = gg -> {
			RadioButton rb = (RadioButton) gg.getSource();
			System.out.println("성별 : "+rb.getText());
		};
		
		genM.setOnAction(handler);
		genF.setOnAction(handler);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent parent = FXMLLoader.load(getClass().getResource("join2.fxml"));
		Scene scene = new Scene(parent);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
*/