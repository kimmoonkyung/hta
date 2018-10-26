package page;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SubController implements Initializable {

	//Stage primaryStage;
	
	@FXML Button subBtn;
	@FXML TextField msg;
	@FXML Label label;
	@FXML AnchorPane subLayout; //subLayout가져오기.
	
	MainController main;
	
	String data;
	
	/*public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}*/

	public void subClose() {
		
		AnchorPane root = (AnchorPane) subBtn.getScene().getRoot(); //기존 Parent 인 AnchorPane(layout)을 가져옴.

		main.label.setText("From sub: " + msg.getText());
		
		root.getChildren().remove(subLayout); //기존 layout에서 subLayout 제거
		
		/*try {
			
			Popup ppp = new Popup(); 	//새로운 Stage 생성
			
			Parent root = FXMLLoader.load(
					getClass().getResource("main.fxml"));
			
			ppp.getContent().add(root);
			//ppp.show(primaryStage);
			
			//Stage stage = (Stage) btn.getScene().getWindow(); //윈도우는 스테이지로 형변환 가능
			//ppp.show(stage);
			ppp.show(btn.getScene().getWindow());
			//Stage ppp = new Stage(StageStyle.DECORATED);
			
			Stage newStage = new Stage(StageStyle.DECORATED); //일반적인 새로운 창 생성
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"),
					new ResourceBundle() {

						@Override
						protected Object handleGetObject(String key) {
							// TODO Auto-generated method stub
							return msg.getText();
						}

						@Override
						public Enumeration<String> getKeys() {
							// TODO Auto-generated method stub
							return null;
						}
				
			});
			
			Parent root = FXMLLoader.load(
					getClass().getResource("main.fxml"),
					new ResourceBundle() {
						
						@Override
						protected Object handleGetObject(String key) {
							// TODO Auto-generated method stub
							return msg.getText();
						}
						
						@Override
						public Enumeration<String> getKeys() {
							// TODO Auto-generated method stub
							return null;
						}
			});
			
			Scene scene = new Scene(root);
			
			newStage.setScene(scene);
			newStage.show();
			Stage oldstage = (Stage) subBtn.getScene().getWindow();
			oldstage.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		System.out.println(resources.getObject("hi"));
		
		main = (MainController) resources.getObject("main");
		label.setText("From Main : " + main.msg.getText());
		
		/*data = resources.getObject("data").toString();
		System.out.println(data);
		label.setText("From Main : " + data);*/
	}

}
