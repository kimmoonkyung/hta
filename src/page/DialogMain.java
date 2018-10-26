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
		info.setTitle("�˸�â");
		info.setHeaderText("�˸�â ����");
		info.setContentText("�˸�â ����");
		info.show();
		
		Alert error = new Alert(AlertType.ERROR);
		error.setTitle("����â ���");
		error.setHeaderText("����â ����");
		error.setContentText("����");
		error.show();
		
		Alert warn = new Alert(AlertType.WARNING);
		warn.setTitle("���â �߿�");
		warn.setHeaderText("���â ����");
		warn.setContentText("��������ߴ�");
		warn.show();
		
		//////////////////////////////////////////////////////////////////////
		Alert custom = new Alert(AlertType.WARNING);
		custom.setTitle("Ŀ���� ���");
		custom.setHeaderText("Ŀ���� ���â ����");
		custom.setContentText("Ŀ���� ��������ߴ�");
		
		Label label = new Label("Ŀ���� ��� ���� ����");
		TextArea textarea = new TextArea("��� ��� ����");
		textarea.setEditable(false);
		textarea.setWrapText(true);
		
		textarea.setMaxHeight(Double.MAX_VALUE);
		textarea.setMaxWidth(Double.MAX_VALUE);
		
		GridPane gridPane = new GridPane();
		GridPane.setVgrow(textarea, Priority.ALWAYS); //�������� �׻� �ѵα� / �ٵ� �ȵǳ� ��
		gridPane.setMaxWidth(Double.MAX_VALUE);
		gridPane.add(label, 0, 0);
		gridPane.add(textarea, 0, 1);
		
		custom.getDialogPane().setExpandableContent(gridPane);
		custom.show();
		
///////////////////////////////////////////////////////////////		
		Alert confi = new Alert(AlertType.CONFIRMATION);
		confi.setTitle("����â");
		confi.setHeaderText("����â ����");
		confi.setContentText("����� "); //��ҵ� �ֳ�
		
		Optional<ButtonType>res = confi.showAndWait();
		if(res.get()==ButtonType.OK) {
			System.out.println("Ȯ�� Ŭ���ߴ�?");
		} else {
			System.out.println("��� Ŭ���ߴ�?");
		}
		//confi.show(); //show()
		
		TextInputDialog textD = new TextInputDialog();
		textD.setTitle("�Է�â");
		textD.setHeaderText("�Է�â ����");
		textD.setContentText("�Է� : ");
		Optional<String>res2 = textD.showAndWait();
		res2.ifPresent(str -> System.out.println("�Է�â ���� : " + str));
		
		//////////////////////////////////////////////////////////////////
		FileChooser fc = new FileChooser();	// ���� ��������
		fc.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("img", "*.jpg","*.png","*.gif","*.bmp"));
		
									//���� ������Ʈ�� ����̺갡 root�� ex) E:\
		fc.setInitialDirectory(new File("\\��Ȱ�ڵ�\\guiProj\\ppp"));
				
		File res3 = fc.showOpenDialog(primaryStage);
				
		if(res3!=null) {
			System.out.println(res3.getName());
		}
		
		DirectoryChooser dc = new DirectoryChooser(); // ���� ��������
							//���� ������Ʈ�� ����̺갡 root�� ex) E:\
		dc.setInitialDirectory(new File("\\��Ȱ�ڵ�\\guiProj\\ppp"));
		
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
