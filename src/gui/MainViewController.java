package gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Consumer;

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
import model.services.DepartmentServices;
import model.services.SellerServices;

public class MainViewController implements Initializable {
	
	@FXML
	private MenuItem menuItemSeller; // declara os menus 
	@FXML
	private MenuItem menuItemDepartment;
	@FXML
	private MenuItem menuItemAbout;
	
	@FXML
	public void onMenuItemSellerAction() { // ativa a função Seller
		loadView("/gui/SellerList.fxml", (SellerListController controller) -> {
			controller.setSellerService(new SellerServices());
			controller.updateTableView();
		});			
	}
	
	@FXML
	public void onMenuItemDepartmentAction() { // ativa a função Department
		loadView("/gui/DepartmentList.fxml", (DepartmentListController controller) -> {
			controller.setDepartmentService(new DepartmentServices());
			controller.updateTableView();
		});		
	}
	
	@FXML
	public void onMenuItemAboutAction() { // ativa a função About
		loadView("/gui/About.fxml", x ->{});
		}	

	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}
	//sicroniza todo projeto
	private synchronized <T> void loadView(String absoluteName, Consumer<T> initializingAction) { 
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(absoluteName));//carregar a tela
			VBox newVbox = loader.load();
			
			Scene mainScene = Main.getMainScene(); // referencia para a sena
			VBox mainVBox = (VBox)((ScrollPane) mainScene.getRoot()).getContent();
			Node mainMenu = mainVBox.getChildren().get(0);
			mainVBox.getChildren().clear();
			mainVBox.getChildren().add(mainMenu);
			mainVBox.getChildren().addAll(newVbox.getChildren());
			
			T controller = loader.getController();
			initializingAction.accept(controller);
		}
		catch (IOException e) {
			Alerts.showAlert("IO Exceptio", "Error loading view", e.getMessage(), AlertType.ERROR);
		}
	}
	
}
