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
			
			//Popup ppp = new Popup(); 	//���ο� Stage ����
			//ppp.getContent().add(root);
			//ppp.show(primaryStage);
			
			//Stage stage = (Stage) btn.getScene().getWindow(); //������� ���������� ����ȯ ����
			//ppp.show(stage);
			//ppp.show(btn.getScene().getWindow());
			
			//Stage newStage = new Stage(StageStyle.DECORATED); //�Ϲ����� ���ο� â ����
															//UNDECORATED, TRANSPARENT �̰Ŵ� ���� �ּ�ģ��ó�� ��
															//UNIFIED ���â�� //UTILITY X�� ��
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
			
			/*Stage oldStage = (Stage) mainBtn.getScene().getWindow(); //btn�� �������ִ� Scene�� windowâ�� ������
			//������������ ���*/ //�̰� �� �Ʒ� �ɷ� �ٲ� ����
			AnchorPane root = (AnchorPane) mainBtn.getScene().getRoot(); //���� Parent �� AnchorPane(layout)�� ������.
			//Parent root = loader.load();
			//�Ʒ� �з�Ʈ ��Ʈ�� �����ϴ°Ŷ� �Ȱ���
			//sub layout
			
			me = this;
			
			Parent sub = FXMLLoader.load(
					getClass().getResource("sub.fxml"),
					new ResourceBundle() {
						
						@Override
						protected Object handleGetObject(String key) {
							// TODO �����Ѱ�
							//return msg.getText(); 
							//TODO ���� ���� �Ѱ�
							HashMap<String, Object>map = new HashMap<>();
							//map.put("data", msg.getText());
							map.put("hi", "������ Ȯ �׳�");
							map.put("main", me);
							
							return map.get(key);  ///key�� �ش��ϴ� value return
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
			oldStage.setScene(scene); 				//���ھ��������� �ٲٸ鼭 �ּ�ó��. �Ʒ� �ɷ� ��ü
			//oldstage.show(); //��� ���ص� ����*/
			root.getChildren().add(sub); //���� layout�� ������ sub_layout�� ��ҷ� �߰� 
			
			//newStage.setScene(scene);
			//newStage.show();
			//Stage oldstage = (Stage) mainBtn.getScene().getWindow(); //btn�� �������ִ� Scene�� windowâ�� ������ //���οø���
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
