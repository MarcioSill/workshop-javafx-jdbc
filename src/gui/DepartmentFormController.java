package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class DepartmentFormController implements Initializable {
	
	@FXML
	private TextField txtId;
	
	@FXML
	private TextField txtName;
	
	@FXML
	private Label labelErrorName;
	
	@FXML
	private Button btSave;
	
	@FXML
	private Button btCancel;
	
	@FXML
	public void onBtSalveAction() {
		System.out.println("onBtSalveAction");
	}
	
	@FXML
	public void onBtCancelAction() {
		System.out.println("onBtCancelAction");
	}	

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		initializeNodes(); // chama o metodo para as restin�oes
	}
	
	private void initializeNodes() { // metodo para as restrin�oes
		Constraints.setTextFieldInteger(txtId); //s�  ira aceitar mumero inteiro
		Constraints.setTextFieldMaxLength(txtName, 30); // s� ir� aceitar nomes com no maximo  caracter
	}	
}
