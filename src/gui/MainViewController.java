package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.Main;
import gui.util.Alerts;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class MainViewController implements Initializable {
	
	@FXML
	private MenuItem menuItemSeller; // declara os menus 
	@FXML
	private MenuItem menuItemDepartment;
	@FXML
	private MenuItem menuItemAbout;
	
	@FXML
	public void onMenuItemSellerAction() { // ativa a fun��o Seller
		System.out.println("onMenuItemSellerAction");		
	}
	
	@FXML
	public void onMenuItemDepartmentAction() { // ativa a fun��o Department
		loadView("/gui/DepartmentList.fxml");		
	}
	
	@FXML
	public void onMenuItemAboutAction() { // ativa a fun��o About
		loadView("/gui/About.fxml");
		}	

	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}
	//sicroniza todo projeto
	private synchronized void loadView(String absoluteName) { 
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));//carregar a tela
			VBox newVbox = loader.load();
			
			Scene mainScene = Main.getMainScene(); // referencia para a sena
			VBox mainVBox = (VBox)((ScrollPane) mainScene.getRoot()).getContent();
			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVbox.getChildren());
		}
		catch (IOException e) {
			Alerts.showAlert("IO Exceptio", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}
}
