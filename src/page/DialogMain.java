package page;

import java.io.File;
import java.util.Optional;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class DialogMain extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Alert info = new Alert(AlertType.INFORMATION);
		info.setTitle("알림창");
		info.setHeaderText("알림창 제목");
		info.setContentText("알림창 내용");
		info.show();
		
		Alert error = new Alert(AlertType.ERROR);
		error.setTitle("에러창 띠용");
		error.setHeaderText("에러창 제목");
		error.setContentText("꺼져");
		error.show();
		
		Alert warn = new Alert(AlertType.WARNING);
		warn.setTitle("경고창 삐용");
		warn.setHeaderText("경고창 제목");
		warn.setContentText("꺼지라고했다");
		warn.show();
		
		//////////////////////////////////////////////////////////////////////
		Alert custom = new Alert(AlertType.WARNING);
		custom.setTitle("커스텀 경고");
		custom.setHeaderText("커스텀 경고창 제목");
		custom.setContentText("커스텀 꺼지라고했다");
		
		Label label = new Label("커스텀 경고 오류 내용");
		TextArea textarea = new TextArea("경고 경고 꺼져");
		textarea.setEditable(false);
		textarea.setWrapText(true);
		
		textarea.setMaxHeight(Double.MAX_VALUE);
		textarea.setMaxWidth(Double.MAX_VALUE);
		
		GridPane gridPane = new GridPane();
		GridPane.setVgrow(textarea, Priority.ALWAYS); //세부정보 항상 켜두기 / 근데 안되네 싮
		gridPane.setMaxWidth(Double.MAX_VALUE);
		gridPane.add(label, 0, 0);
		gridPane.add(textarea, 0, 1);
		
		custom.getDialogPane().setExpandableContent(gridPane);
		custom.show();
		
///////////////////////////////////////////////////////////////		
		Alert confi = new Alert(AlertType.CONFIRMATION);
		confi.setTitle("선택창");
		confi.setHeaderText("선택창 제목");
		confi.setContentText("골라골라 "); //취소도 있네
		
		Optional<ButtonType>res = confi.showAndWait();
		if(res.get()==ButtonType.OK) {
			System.out.println("확인 클릭했니?");
		} else {
			System.out.println("취소 클릭했니?");
		}
		//confi.show(); //show()
		
		TextInputDialog textD = new TextInputDialog();
		textD.setTitle("입력창");
		textD.setHeaderText("입력창 제목");
		textD.setContentText("입력 : ");
		Optional<String>res2 = textD.showAndWait();
		res2.ifPresent(str -> System.out.println("입력창 내용 : " + str));
		
		//////////////////////////////////////////////////////////////////
		FileChooser fc = new FileChooser();	// 파일 가져오기
		fc.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("img", "*.jpg","*.png","*.gif","*.bmp"));
		
									//현재 프로젝트의 드라이브가 root임 ex) E:\
		fc.setInitialDirectory(new File("\\생활코딩\\guiProj\\ppp"));
				
		File res3 = fc.showOpenDialog(primaryStage);
				
		if(res3!=null) {
			System.out.println(res3.getName());
		}
		
		DirectoryChooser dc = new DirectoryChooser(); // 폴더 가져오기
							//현재 프로젝트의 드라이브가 root임 ex) E:\
		dc.setInitialDirectory(new File("\\생활코딩\\guiProj\\ppp"));
		
		File res4 = dc.showDialog(primaryStage);
		
		if(res4!=null) {
			System.out.println(res4.getName());
		}
		/////////////////////////////////////////////////////////////////
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

}
