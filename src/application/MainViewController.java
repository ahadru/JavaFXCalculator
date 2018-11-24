package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

enum Operation{
	ADD,SUB,MUL,DIV,NULL;
}

public class MainViewController {
	
	//For false -> push to back 
		//else clear and push
	private boolean downLabelStatus = false;
	
	//dot status
	private boolean dotStatus = false;
	
	//result field
	private double result = 0;
	
	private Operation operation = Operation.NULL;
	
	//For false -> push to back 
			//else clear and push
	//upper label arithmatic symbol adding staus ..
		//is symbol added before or not
		//upLabelStatus[upLabelSetRemoveStatus][ulLastTextStatus]
	private boolean[] upLabelStatus = {false, false};
	
	@FXML
	private Label upLabel;
	@FXML
	private Label downLabel;
	@FXML
	private Button but1;
	@FXML
	private Button but2;
	@FXML
	private Button but3;
	@FXML
	private Button but4;
	@FXML
	private Button but5;
	@FXML
	private Button but6;
	@FXML
	private Button but7;
	@FXML
	private Button but8;
	@FXML
	private Button but9;
	@FXML
	private Button but0;
	@FXML
	private Button butDot;
	@FXML
	private Button butEqual;
	@FXML
	private Button butAdd;
	@FXML
	private Button butMul;
	@FXML
	private Button butSub;
	@FXML
	private Button butDiv;
	@FXML
	private Button butSqrt;
	@FXML
	private Button butMod;
	@FXML
	private Button butClear;
	@FXML
	private Button butX;
	
	public void buttonControl(ActionEvent event) {
		if(event.getSource() == but1 ) {
			textControl(but1);
		}
		else if(event.getSource() == but2 ) {
			textControl(but2);
		}
		else if(event.getSource() == but3 ) {
			textControl(but3);
		}
		else if(event.getSource() == but4 ) {
			textControl(but4);
		}
		else if(event.getSource() == but5 ) {
			textControl(but5);
		}
		else if(event.getSource() == but6 ) {
			textControl(but6);
		}
		else if(event.getSource() == but7 ) {
			textControl(but7);
		}
		else if(event.getSource() == but8 ) {
			textControl(but8);
		}
		else if(event.getSource() == but9 ) {
			textControl(but9);
		}
		else if(event.getSource() == but0 ) {
			textControl(but0);
		}
		
		else if(event.getSource() == butDot ) {
			textControl(butDot);
		}
		else if(event.getSource() == butEqual ) {
			if(result == (int)result) {
				downLabel.setText(Integer.toString((int)result));
			}
			else {
				downLabel.setText(Double.toString(result));
			}
			if(upLabelStatus[0] == false) {
				upLabel.setText(upLabel.getText().substring(0,upLabel.getText().length()-1) + " = " + downLabel.getText());
			}
			upLabelStatus[0] = true;
		}
		else if(event.getSource() == butAdd ) {
			arithmaticOperation(butAdd);
		}
		else if(event.getSource() == butSub) {
			arithmaticOperation(butSub);
		}
		else if(event.getSource() == butMul ) {
			arithmaticOperation(butMul);
		}
		else if(event.getSource() == butDiv) {
			arithmaticOperation(butDiv);
		}
		else if(event.getSource() == butX) {
			if(downLabelStatus == false && downLabel.getText().length()>0) {
				downLabel.setText(downLabel.getText().substring(0,downLabel.getText().length()-1));
			}
			else {
				downLabel.setText(null);
			}
		}
		else if(event.getSource() == butClear) {
			if(downLabelStatus == false && downLabel.getText().length()>0) {
				downLabel.setText(downLabel.getText().substring(0,downLabel.getText().length()-1));
			}
			else {
				downLabel.setText("");
				downLabelStatus = true;
			}
			
			upLabel.setText("");
			upLabelStatus[0] = true;
		}
		else if(event.getSource() == butSqrt) {
			String value = downLabel.getText();
			int sqrtValue = Integer.parseInt(value)*Integer.parseInt(value);
			downLabel.setText(Integer.toString(sqrtValue));
			downLabelStatus = true;
		}
		else if(event.getSource() == butMod) {
			
		}
		else {
			downLabel.setText("Opps.. Wrong Keyword");
		}
	}
	
	void arithmaticOperation(Button x) {
		String value = downLabel.getText();
		if(upLabelStatus[0] == false) {
			if(upLabelStatus[1] == false) {
				upLabel.setText(upLabel.getText() + " " + value+ " " +x.getText());
				upLabelStatus[1] = true;
			}
			else {
				String tmpString = upLabel.getText();
				tmpString = tmpString.substring(0, tmpString.length()-1);
				upLabel.setText(tmpString + " " + x.getText());
			}
			upLabelStatus[0] = false;
		}
		else {
			upLabel.setText(value+ " " +x.getText());
			upLabelStatus[1] = true;
		}
		
		if(downLabelStatus == false) {
			if(operation == Operation.NULL) {
				result = Double.parseDouble(value);
				if(result == (int)result) {
					downLabel.setText(Integer.toString((int)result));
				}
				else {
					downLabel.setText(Double.toString(result));
				}
			}
			else if(operation == Operation.ADD) {
				result = result + Double.parseDouble(value);
				if(result == (int)result) {
					downLabel.setText(Integer.toString((int)result));
				}
				else {
					downLabel.setText(Double.toString(result));
				}
			}
			else if(operation == Operation.SUB) {
				result = result - Double.parseDouble(value);
				if(result == (int)result) {
					downLabel.setText(Integer.toString((int)result));
				}
				else {
					downLabel.setText(Double.toString(result));
				}
			}
			else if(operation == Operation.MUL) {
				result = result * Double.parseDouble(value);
				if(result == (int)result) {
					downLabel.setText(Integer.toString((int)result));
				}
				else {
					downLabel.setText(Double.toString(result));
				}
			}
			else if(operation == Operation.DIV) {
				result = result / Double.parseDouble(value);
				if(result == (int)result) {
					downLabel.setText(Integer.toString((int)result));
				}
				else {
					downLabel.setText(Double.toString(result));
				}
			}
			else {
				downLabel.setText("Invalid");
			}
			downLabelStatus = true;
		}
		
		if(x == butAdd) {
			operation = Operation.ADD;
		}
		else if(x == butSub) {
			operation = Operation.SUB;
		}
		else if(x == butMul) {
			operation = Operation.MUL;
		}
		else if(x == butDiv) {
			operation = Operation.DIV;
		}
		else{
			downLabel.setText("Invalid");
		}
			
	}
	
	void textControl(Button x) { 
		upLabelStatus[1] = false;
		//this for down label
		if(x == butDot) {
			if(downLabelStatus == false) {
				if(dotStatus == false) {
					String string = downLabel.getText();
					String string2 = x.getText();
					downLabel.setText(string + string2);
					
					dotStatus = true;
				}
			}
			else{
				String string = x.getText();
				downLabel.setText(string);
				
				downLabelStatus = false;
			}
		}
		else {
			if(downLabelStatus == false) {
				String string = downLabel.getText();
				String string2 = x.getText();
				downLabel.setText(string + string2);
			}
			else {
				String string2 = x.getText();
				downLabel.setText(string2);
				
				downLabelStatus = false;
			}
		}
		
		//this upper label
//		if(x == butDot) {
//			if(upLabelStatus == false) {
//				if(dotStatus == false) {
//					String string = upLabel.getText();
//					String string2 = x.getText();
//					upLabel.setText(string + string2);
//					
//					dotStatus = true;
//				}
//			}
//			else{
//				String string = x.getText();
//				upLabel.setText(string);
//				
//				upLabelStatus = false;
//			}
//		}
//		else {
//			if(upLabelStatus == false) {
//				String string = upLabel.getText();
//				String string2 = x.getText();
//				upLabel.setText(string + string2);
//			}
//			else {
//				String string2 = x.getText();
//				upLabel.setText(string2);
//				
//				upLabelStatus = false; 
//			}
//		}
	}
	
}
