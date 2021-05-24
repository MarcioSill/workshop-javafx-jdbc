package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			//estancia FXMLLoader loader passando o caminho da view
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/gui/MainView.fxml"));
			Parent parent = loader.load(); // carrega a view
			Scene mainScene = new Scene(parent); // estancia a sena principal passando como argumento parent
			primaryStage.setScene(mainScene); // seta o pauco como sena principal
			primaryStage.setTitle("Sample JavaFX appication"); // titulo do pauco
			primaryStage.show();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
