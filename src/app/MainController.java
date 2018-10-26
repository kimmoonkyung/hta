package app;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController implements Initializable{

	@FXML private Label result; // ?��?��?��?�� �?
	String val = ""; // 받아?��?�� ?��?���?
	boolean flag = true; // ?��?�� ?��?��?�� ?��?��?��?���? ?��?��?���? ?��?�� �??��

	double target1 = 0; // ?��?��?��?��1
	double target2 = 0; // ?��?��?��?��2
	String oper = "";     // ?��?��?��
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	// ?��?��?�� ?��?�� 경우 Action Event�? ?��?��값으�? 주워진다.(?��?�� �??��)
	public void procNum(ActionEvent e) {
		if(flag) {
			// ?��?�� ?�� ?��번만 "" ?��?���? ?��?��?�� 0?�� ?��?��?��.
			result.setText("");
		}
		flag = false;
		val = ((Button)e.getSource()).getText();
		result.setText(result.getText() + val);
	}

	public void operator(ActionEvent e) {
		if(!flag) { // ?��?���? ?��?�� ?��?��?��?���? ?��?��?���? 기능?�� ?�� ?�� ?��?���?
			val = ((Button)e.getSource()).getText();
			if(!val.equals("=")) { // = ?�� ?��?�� 경우
				oper = val;
				target1 = Double.parseDouble(result.getText());
				result.setText(oper);
			}else { // = ?�� 경우
				target2 = Double.parseDouble(result.getText());
				Model model = new Model();
				double dap = model.calc(target1, oper, target2);
				result.setText(String.valueOf(dap));
			}
			flag = true; // ?��?��?���? ?��?��?���? ?��?�� ?��?��?�� ?��?��
		}
	}
}
