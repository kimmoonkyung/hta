package app;

public class Model {
	public double calc(double target1, String oper, double targer2) {
		double result = 0;
		
		switch (oper) {
		case "+":
			result = target1 + targer2;
			break;
		case "-":
			result = target1 - targer2;
			break;
		case "*":
			result = target1 * targer2;
			break;
		case "/":
			result = target1 / targer2;
			break;
		case "=":

			break;
		}
		return result;
	}
}
