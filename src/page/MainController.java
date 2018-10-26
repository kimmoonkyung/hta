package page;

import java.io.IOException;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
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
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MainController implements Initializable {

	//Stage primaryStage;
	
	@FXML Button mainBtn;
	@FXML TextField msg;
	@FXML Label label;
	MainController me ;
	
	/*public Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}*/
	
	public void subGo() {
		
		try {
			
			//Popup ppp = new Popup(); 	//새로운 Stage 생성
			//ppp.getContent().add(root);
			//ppp.show(primaryStage);
			
			//Stage stage = (Stage) btn.getScene().getWindow(); //윈도우는 스테이지로 형변환 가능
			//ppp.show(stage);
			//ppp.show(btn.getScene().getWindow());
			
			//Stage newStage = new Stage(StageStyle.DECORATED); //일반적인 새로운 창 생성
															//UNDECORATED, TRANSPARENT 이거는 위에 주석친것처럼 뜸
															//UNIFIED 백색창뜸 //UTILITY X는 뜸
			/*FXMLLoader loader = new FXMLLoader(getClass().getResource("sub.fxml"),
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
				
			});*/ 
			
			/*Stage oldStage = (Stage) mainBtn.getScene().getWindow(); //btn이 가지고있는 Scene에 window창을 가져옴
			//기존스테이지 사용*/ //이걸 또 아래 걸로 바꿈 씨팔
			AnchorPane root = (AnchorPane) mainBtn.getScene().getRoot(); //기존 Parent 인 AnchorPane(layout)을 가져옴.
			//Parent root = loader.load();
			//아래 패런트 루트로 시작하는거랑 똑같음
			//sub layout
			
			me = this;
			
			Parent sub = FXMLLoader.load(
					getClass().getResource("sub.fxml"),
					new ResourceBundle() {
						
						@Override
						protected Object handleGetObject(String key) {
							// TODO 원래한거
							//return msg.getText(); 
							//TODO 밑은 새로 한거
							HashMap<String, Object>map = new HashMap<>();
							//map.put("data", msg.getText());
							map.put("hi", "석태진 확 그냥");
							map.put("main", me);
							
							return map.get(key);  ///key에 해당하는 value return
						}
						
						@Override
						public Enumeration<String> getKeys() {
							// TODO Auto-generated method stub
							return null;
						}
			});
					
			
			
			//SubController subc= loader.getController();
			//subc.data = msg.getText();
//			Parent root = FXMLLoader.load(
//					getClass().getResource("sub.fxml"));
			
			
			/*Scene scene = new Scene(root);
			oldStage.setScene(scene); 				//앤코어패인으로 바꾸면서 주석처리. 아래 걸로 대체
			//oldstage.show(); //사용 안해도 나옴*/
			root.getChildren().add(sub); //기존 layout의 하위로 sub_layout을 요소로 추가 
			
			//newStage.setScene(scene);
			//newStage.show();
			//Stage oldstage = (Stage) mainBtn.getScene().getWindow(); //btn이 가지고있는 Scene에 window창을 가져옴 //위로올린다
			//oldstage.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		if(resources!=null)
		label.setText("From Sub : " + resources.getObject("").toString());
	}
	

}
