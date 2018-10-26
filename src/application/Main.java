package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
	public Main() {	//2@@@
		System.out.println("생성자"); //2번쨰로 실행
	} //데이터 받을때 씀
	
	@Override
	public void init() throws Exception { //3@@@
		System.out.println("초기화다init"); //3번째 실행
	} //데이터 받을때 씀
	
	@Override
	public void start(Stage primaryStage) { //4@@@
		try {
			System.out.println("start다"); //4번째 실행
			//primaryStage > scene > root
			//primaryStage 에 scene이 들어있고 그 안에 root가 들어 있다.?
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.setTitle("와 제목이당");
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void stop() throws Exception {	//5@@@
		System.out.println("죽는다stop"); //5번째 실행 //fx창? 실행창? 끄면 콘솔창에 뜸.
		
		Sub.main(new String [] {});
	
	} //ex) 국어가 죽으면서 영어를 열때 씀.))
	
	public static void main(String[] args) { //1@@@
		//메인메소드 -> 생성자 -> 초기화 -> start -> stop
		System.out.println("main 메소드이다"); 
		launch(args); // 얘가 start 메소드를 띄운다.
	}
}
