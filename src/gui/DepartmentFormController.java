package gui;

import java.net.URL;
import java.util.ResourceBundle;

import db.DbException;
import gui.util.Alerts;
import gui.util.Constraints;
import gui.util.Utils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.entities.Department;
import model.services.DepartmentServices;

public class DepartmentFormController implements Initializable {
	
	private Department entity;
	
	private DepartmentServices service;
	
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
	
	public void setDepartmentService(DepartmentServices service) {
		this.service = service;
	}
	
	@FXML
	public void onBtSalveAction(ActionEvent event) {
		if(entity == null) {
			throw new IllegalStateException("Entity was null");
		}
		if(service == null) {
			throw new IllegalStateException("Service was null");
		}
		try {
			entity = getFormDate();
			service.saveOrUpdate(entity);
			Utils.currentStage(event).close();
		}
		catch(DbException e) {
			Alerts.showAlert("Error saving object", null, e.getMessage(), AlertType.ERROR);
		}
	}
	
	private Department getFormDate() {
		Department obj = new Department();
		obj.setId(Utils.tryParseToInt(txtId.getText()));
		obj.setName(txtName.getText());
		return obj;
	}

	@FXML
	public void onBtCancelAction(ActionEvent event) {
		Utils.currentStage(event).close();
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
