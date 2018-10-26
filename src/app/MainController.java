package app;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController implements Initializable{

	@FXML private Label result; // ???? κ³?
	String val = ""; // λ°μ?€? ?? ₯κ°?
	boolean flag = true; // ?«? ?? ₯?΄ ????μ§? ??¨?κΈ? ?? λ³??

	double target1 = 0; // ?Ό?°?°?1
	double target2 = 0; // ?Ό?°?°?2
	String oper = "";     // ?°?°?
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	// ?‘??΄ ?? κ²½μ° Action Eventκ°? ?Έ?κ°μΌλ‘? μ£Όμμ§λ€.(??΅ κ°??₯)
	public void procNum(ActionEvent e) {
		if(flag) {
			// ?? ? ?λ²λ§ "" ??λ‘? ??΄? 0? ??€?€.
			result.setText("");
		}
		flag = false;
		val = ((Button)e.getSource()).getText();
		result.setText(result.getText() + val);
	}

	public void operator(ActionEvent e) {
		if(!flag) { // ?«?κ°? ?? ₯ ????λ§? ?°?°?κ°? κΈ°λ₯? ?  ? ??λ‘?
			val = ((Button)e.getSource()).getText();
			if(!val.equals("=")) { // = ?΄ ?? κ²½μ°
				oper = val;
				target1 = Double.parseDouble(result.getText());
				result.setText(oper);
			}else { // = ?Έ κ²½μ°
				target2 = Double.parseDouble(result.getText());
				Model model = new Model();
				double dap = model.calc(target1, oper, target2);
				result.setText(String.valueOf(dap));
			}
			flag = true; // ?°?°?λ₯? ?­? ?κ³? ?«? ?? ₯? ??΄
		}
	}
}
