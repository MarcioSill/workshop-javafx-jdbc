package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;


public class Main extends Application {
	
	private static Scene mainScene; // declarando uma variavel statica para referenciar a sena
	
	@Override
	public void start(Stage primaryStage) {
		try {
			//estancia FXMLLoader loader passando o caminho da view
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));
			ScrollPane scrollPane = loader.load(); // carrega a view
			
			//para encaixe de janela, a janela encaixa no tamanho do paco
			scrollPane.setFitToHeight(true);
			scrollPane.setFitToWidth(true);
			
			mainScene = new Scene(scrollPane); // estancia a sena principal passando como argumento parent
			primaryStage.setScene(mainScene); // seta o pauco como sena principal
			primaryStage.setTitle("Sample JavaFX appication"); // titulo do pauco
			primaryStage.show();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Scene getMainScene() { //metodo para referenciar a sena
		return mainScene;
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
