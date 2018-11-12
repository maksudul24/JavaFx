package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class MainController {
	@FXML
	private Label result;
	private long number1=0;
	private String operator="";
	private boolean start= true;
	private Model model = new Model();
	@FXML
	public void processNumbers(ActionEvent event) {
		if(start) {
			result.setText("");
			start=false;
		}
		String value=((Button)event.getSource()).getText();
		result.setText(result.getText()+value);
		
	}
	@FXML
	public void processOperators(ActionEvent event) {
		float dec;
		char ch;
		boolean sw = true;
		String temp;
		String value=((Button)event.getSource()).getText();
		if(!value.equals("=")) {
			if(!operator.isEmpty()) return;
			operator=value;
			sw=true;
			number1 = Long.parseLong(result.getText());
		/*	temp= new String(result.getText());
			number1=0;
			dec=(float) 0.1;
			for(int i=0;i<temp.length();i++) {
				ch=temp.charAt(i);
				if(ch=='.'){
					sw=false;
					continue;
				}
				if(sw==true) {
					number1=(number1*10)+(ch-'0');
				}
				else {
					number1=number1+(dec*(ch-'0'));
					dec=(float)(dec/10);
					
				}
			} */
			
			result.setText("");
		}
		else {
			if(operator.isEmpty()) return;
			long number2=Long.parseLong(result.getText());
		/*	float number2=0;
			temp= new String(result.getText());
			dec=(float) 0.1;
			for(int i=0;i<temp.length();i++) {
				ch=temp.charAt(i);
				if(ch=='.'){
					sw=false;
					continue;
				}
				if(sw == true) {
					number1=(number1*10)+(ch-'0');
				}
				else {
					number1=number1+(dec*(ch-'0'));
					dec=(float)(dec/10);
					
				}
			} */
			float output = model.calculate(number1, number2, value);
			result.setText(String.valueOf(output));
		}
	}
}
