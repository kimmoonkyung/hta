package application;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class BtnMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
		VBox vBox = new VBox();
		vBox.setPrefWidth(700);
		vBox.setPrefHeight(400);
		vBox.setAlignment(Pos.CENTER); // 버튼 위치 잡기 setAlignment 
		
		Button button = new Button("눌러보아요"); // 버튼 만듦
		
		Alert alert = new Alert(AlertType.CONFIRMATION); //CONFIRMATION 확인창?
		alert.setTitle("CONFIRMATION 알림창.");
		alert.setContentText("java FX를 배우는 중."); //내용
		alert.setHeaderText("메시지"); //제목
		//alert.show();

		button.setOnAction(ee -> {
			System.out.println("눌렀읍니다.");
			alert.show(); // 이렇게 하면 눌렀을때 ?	반응형?으로 alert.쇼() 나옴
		
		});
		/*button.setOnAction(new EventHandler<ActionEvent>() 
		{
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				System.out.println("눌렀읍니다.");
			}
		});*/
		
		vBox.getChildren().add(button); // vBox의 자식으로 버튼을 가져옴

		Label lb = new Label("라벨ㅇ오");
		Font font = new Font(50);
		lb.setFont(font);
		
		Slider slider = new Slider();

		vBox.getChildren().add(lb);
		vBox.getChildren().add(slider);
		
		slider.valueProperty().addListener(
				(ObservableValue<? extends Number> observable,
				Number oldValue, 
				Number newValue) -> {
					lb.setText(newValue+"");
					lb.setFont(new Font(newValue.doubleValue()));
					
					//System.out.println(newValue);
				});
		/*slider.valueProperty().addListener(new ChangeListener<Number>() {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				// TODO Auto-generated method stub
				System.out.println(newValue);
			}
		});*/
		
		Scene scene = new Scene(vBox);

		primaryStage.setTitle("얘는 박스");
		primaryStage.setScene(scene);
		primaryStage.show(); //눈에 보이게 하겠다
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
