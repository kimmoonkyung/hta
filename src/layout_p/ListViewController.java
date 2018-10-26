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
	ObservableList<String> items, items2; //�����׸�
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		//list.setItems(FXCollections.observableArrayList());
			// ���� �ڵ�� �ػ����� ��������. �����ϸ� �������Ϳ� �߰��Ѵ�.
		list.getItems().add("�ø�");
		list.getItems().add("Ī����");
		list.getItems().add("���ĵκ�");
		
		list2.getItems().add("���");
		list2.getItems().add("����Ī");
		list2.getItems().add("�ε��ĸ�");
		
		
		///-------------�̱�ó�� SINGLE
		//list.getSelectionModel().setSelectionMode(SelectionMode.SINGLE); //�⺻ SINGLE,, MULTIPLE�� ���߼��ð���(����Ʈ)
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
		///-------------��Ƽó�� MULTIPLE
		list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		list2.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		
		list.setOnMouseClicked(mm -> {
					items = list.getSelectionModel().getSelectedItems();
			for (String str : items) {
				System.out.println(str);
				//list.getItems().remove(str); ���û���
			}
		});
		list2.setOnMouseClicked(mm -> {
			items2 = list2.getSelectionModel().getSelectedItems();
			for (String str : items2) {
				System.out.println(str);
			}
		});
		
		
		//����
		btn.setOnAction(ee -> {
			if(items!=null) { //����� ���� �ƴҶ���
				for (String str : items) {
					
					list.getItems().remove(str);
					//list2.getItems().remove(str);
				}
			}
			if(items2!=null) { //����� ���� �ƴҶ���
				for (String str : items2) {
					
					list2.getItems().remove(str);
					//list2.getItems().remove(str);
				}
			}
			
		});

		//�����ʿű�
		btn2.setOnAction(rr -> {
			if(items!=null) {
				for (String str : items) {
					list.getItems().remove(str);
					//list2.getItems().removeAll(str);
					list2.getItems().add(str);
				}	
			}
		});
		//���ʿű�
		btn3.setOnAction(ll -> {
			if(items2!=null) {
				for (String str : items2) {
					list2.getItems().removeAll(items2);
					list.getItems().add(str);
				}
			}
		});
		
		//Ŭ���� �󺧿� ���
		/*list.setOnMouseClicked(mm -> {
			Object obj = list.getSelectionModel().getSelectedItems();
			label.setText(obj.toString());
		}); //�̰� �󺧿� �ߴ°���
		/*list2.setOnMouseClicked(mm -> {
			Object obj = list2.getSelectionModel().getSelectedItems();
			label.setText(obj.toString());
		});*/ //�̰� �󺧿� �ߴ°���/
		
		
	}

}
