package layout_p;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

public class ListViewController implements Initializable{
	
	@FXML Label label;
	@FXML Button btn, btn2, btn3;
	@FXML ListView<String> list, list2; 
	ObservableList<String> items, items2; //선택항목
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		//list.setItems(FXCollections.observableArrayList());
			// 위에 코드는 쌔삥으로 만들경우임. 생략하면 기존에것에 추가한다.
		list.getItems().add("냉면");
		list.getItems().add("칭따오");
		list.getItems().add("마파두부");
		
		list2.getItems().add("면냉");
		list2.getItems().add("오따칭");
		list2.getItems().add("부두파마");
		
		
		///-------------싱글처리 SINGLE
		//list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE); //기본 SINGLE,, MULTIPLE는 다중선택가능(슆프트)
		/*list.setOnMouseClicked(mm -> {
			Object obj = list.getSelectionModel().getSelectedItem();
			label.setText(obj.toString());
		});*/
		
		/*list.getSelectionModel().selectedItemProperty()
		.addListener(
				(obb, oldV, newV)-> {
					if(oldV==null)
						oldV="";
					label.setText(oldV + "->" + newV);
				});*/
		
		///////////////////////////////////////////////////
		///-------------멀티처리 MULTIPLE
		list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		list2.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		list.setOnMouseClicked(mm -> {
					items = list.getSelectionModel().getSelectedItems();
			for (String str : items) {
				System.out.println(str);
				//list.getItems().remove(str); 선택삭제
			}
		});
		list2.setOnMouseClicked(mm -> {
			items2 = list2.getSelectionModel().getSelectedItems();
			for (String str : items2) {
				System.out.println(str);
			}
		});
		
		
		//삭제
		btn.setOnAction(ee -> {
			if(items!=null) { //아템즈가 널이 아닐때만
				for (String str : items) {
					
					list.getItems().remove(str);
					//list2.getItems().remove(str);
				}
			}
			if(items2!=null) { //아템즈가 널이 아닐때만
				for (String str : items2) {
					
					list2.getItems().remove(str);
					//list2.getItems().remove(str);
				}
			}
			
		});

		//오른쪽옮김
		btn2.setOnAction(rr -> {
			if(items!=null) {
				for (String str : items) {
					list.getItems().remove(str);
					//list2.getItems().removeAll(str);
					list2.getItems().add(str);
				}	
			}
		});
		//왼쪽옮김
		btn3.setOnAction(ll -> {
			if(items2!=null) {
				for (String str : items2) {
					list2.getItems().removeAll(items2);
					list.getItems().add(str);
				}
			}
		});
		
		//클릭시 라벨에 출력
		/*list.setOnMouseClicked(mm -> {
			Object obj = list.getSelectionModel().getSelectedItems();
			label.setText(obj.toString());
		}); //이건 라벨에 뜨는거임
		/*list2.setOnMouseClicked(mm -> {
			Object obj = list2.getSelectionModel().getSelectedItems();
			label.setText(obj.toString());
		});*/ //이건 라벨에 뜨는거임/
		
		
	}

}
