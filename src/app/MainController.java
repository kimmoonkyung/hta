package app;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController implements Initializable{

	@FXML private Label result; // ?‘œ?˜„?˜?Š” ê³?
	String val = ""; // ë°›ì•„?˜¤?Š” ?…? ¥ê°?
	boolean flag = true; // ?ˆ«? ?…? ¥?´ ?‹œ?‘?•˜?Š”ì§? ?Œ?‹¨?•˜ê¸? ?œ„?•œ ë³??ˆ˜

	double target1 = 0; // ?”¼?—°?‚°?1
	double target2 = 0; // ?”¼?—°?‚°?2
	String oper = "";     // ?—°?‚°?
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

	// ?•¡?…˜?´ ?ˆ?„ ê²½ìš° Action Eventê°? ?¸?ê°’ìœ¼ë¡? ì£¼ì›Œì§„ë‹¤.(?ƒ?µ ê°??Š¥)
	public void procNum(ActionEvent e) {
		if(flag) {
			// ?‹œ?‘ ?‹œ ?•œë²ˆë§Œ "" ?˜•?ƒœë¡? ?‘?–´?„œ 0?„ ?—†?•¤?‹¤.
			result.setText("");
		}
		flag = false;
		val = ((Button)e.getSource()).getText();
		result.setText(result.getText() + val);
	}

	public void operator(ActionEvent e) {
		if(!flag) { // ?ˆ«?ê°? ?…? ¥ ?˜?—ˆ?„?•Œë§? ?—°?‚°?ê°? ê¸°ëŠ¥?„ ?•  ?ˆ˜ ?ˆ?„ë¡?
			val = ((Button)e.getSource()).getText();
			if(!val.equals("=")) { // = ?´ ?•„?‹Œ ê²½ìš°
				oper = val;
				target1 = Double.parseDouble(result.getText());
				result.setText(oper);
			}else { // = ?¸ ê²½ìš°
				target2 = Double.parseDouble(result.getText());
				Model model = new Model();
				double dap = model.calc(target1, oper, target2);
				result.setText(String.valueOf(dap));
			}
			flag = true; // ?—°?‚°?ë¥? ?‚­? œ?•˜ê³? ?ˆ«? ?…? ¥?„ ?œ„?•´
		}
	}
}
