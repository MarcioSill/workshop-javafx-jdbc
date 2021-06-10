package gui;

import java.net.URL;
import java.util.ResourceBundle;

import gui.util.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Department;

public class DepartmentFormController implements Initializable {
	
	private Department entity;
	
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
	
	public void setDepartment(Department entitys) {
		this.entity = entitys;
	}
	
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
		initializeNodes(); // chama o metodo para as restinçoes
	}
	
	private void initializeNodes() { // metodo para as restrinçoes
		Constraints.setTextFieldInteger(txtId); //só  ira aceitar mumero inteiro
		Constraints.setTextFieldMaxLength(txtName, 30); // só irá aceitar nomes com no maximo  caracter
	}
	
	public void updateFormDate() {
		if(entity == null) {
			throw new IllegalStateException("entity was null"); // defencivo caso entity esteja nullo
		}
		txtId.setText(String.valueOf(entity.getId()));
		txtName.setText(entity.getName());
	}
}
