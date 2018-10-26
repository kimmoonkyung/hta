package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	public Main() {	//2@@@
		System.out.println("������"); //2������ ����
	} //������ ������ ��
	
	@Override
	public void init() throws Exception { //3@@@
		System.out.println("�ʱ�ȭ��init"); //3��° ����
	} //������ ������ ��
	
	@Override
	public void start(Stage primaryStage) { //4@@@
		try {
			System.out.println("start��"); //4��° ����
			//primaryStage > scene > root
			//primaryStage �� scene�� ����ְ� �� �ȿ� root�� ��� �ִ�.?
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("�� �����̴�");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void stop() throws Exception {	//5@@@
		System.out.println("�״´�stop"); //5��° ���� //fxâ? ����â? ���� �ܼ�â�� ��.
		
		Sub.main(new String [] {});
	
	} //ex) ��� �����鼭 ��� ���� ��.))
	
	public static void main(String[] args) { //1@@@
		//���θ޼ҵ� -> ������ -> �ʱ�ȭ -> start -> stop
		System.out.println("main �޼ҵ��̴�"); 
		launch(args); // �갡 start �޼ҵ带 ����.
	}
}
