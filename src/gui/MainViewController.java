package gui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;

public class MainViewController implements Initializable {
	
	@FXML
	private MenuItem menuItemSeller; // declara os menus 
	@FXML
	private MenuItem menuItemDepartment;
	@FXML
	private MenuItem menuItemAbout;
	
	@FXML
	public void onMenuItemSellerAction() { // ativa a função Seller
		System.out.println("onMenuItemSellerAction");		
	}
	
	@FXML
	public void onMenuItemDepartmentAction() { // ativa a função Seller
		System.out.println("onMenuItemDepartmentAction");		
	}
	
	@FXML
	public void onMenuItemAboutAction() { // ativa a função Seller
		System.out.println("onMenuItemAboutAction");
		}	

	@Override
	public void initialize(URL uri, ResourceBundle rb) {
		// TODO Auto-generated method stub
		
	}

}
