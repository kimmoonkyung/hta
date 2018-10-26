package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Slider;
import javafx.stage.Stage;

public class ControlMain extends Application implements Initializable {

	@FXML CheckBox checkBox;
	@FXML RadioButton genM, genF;
	@FXML ComboBox<String> email;
	@FXML Slider zoom;
	
	javafx.collections.FXCollections fx;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) { 
		//인이탈라이즈?? 얘가 fxml의 fx 보다 우선순위가 높다.
		//ComboBox cbox = new ComboBox<>();
//체크박스-----------------------------------------------------------------------------------
		checkBox.setSelected(false);
		checkBox.setOnAction(ee-> {
			
			CheckBox box = (CheckBox) ee.getSource();
			
			System.out.println("쳌박쓰 : " + checkBox.isSelected() + ", " + box.getText() );
		});
		
//라디오버튼---------------------------------------------------------------------------------------------
		
		EventHandler handler = ee-> {
			
			RadioButton rb = (RadioButton) ee.getSource();
			
			System.out.println("성별 : " + rb.getText() );
		};
		
		genM.setOnAction(handler);
		genF.setOnAction(handler);
		
//콤보박스------------------------------------------------------------------------------------------
		ObservableList<String> emailData = 
				FXCollections.observableArrayList("구글", "네이버", "다음");
		email.setItems(emailData);
		
		email.setValue(emailData.get(1));
/*		email.setOnAction(ee -> {
			
			System.out.println("email 이벤트 : " + email.getValue());
		});*/
		
		email.getSelectionModel().
		selectedItemProperty().addListener((
					observable, oldValue, newValue) -> {
				System.out.println("email : " + oldValue+" -> "+newValue);
		});

		/*email.getSelectionModel()
		.selectedItemProperty()
		.addListener(new ChangeListener<String>() {
			@Override
			public void changed(
					ObservableValue<? extends String> observable, 
					String oldValue, 
					String newValue) {
				// TODO Auto-generated method stub
				System.out.println(oldValue + " : " + newValue );
			}
		});*/
		
//slider----------------------------------------------------
		zoom.valueProperty().addListener((
				observable, oldValue, newValue) -> {
				System.out.println("zoom : " + oldValue+" -> "+newValue);
		});
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent parent = FXMLLoader.load(getClass().getResource("control.fxml"));
		Scene scene = new Scene(parent);
		
		/*VBox vBox = (VBox)parent;sddddddddddd
		vBox.getChildren().add(vBox);*/
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
