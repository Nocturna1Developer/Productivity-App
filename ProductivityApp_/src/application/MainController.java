package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * MainController 
 * 
 * This class will serve as the main controller class in which every "Controller" class will extend.
 * It will be responsible for changing all of the scenes.
 * 
 * @author Chinamay Kasareddy
 */
public abstract class MainController
{
	public Stage primaryStage = application.Main.window;
	
	/**
	 * goToTimerPage() - This method will change the scene from the LoginPage to the TimerPage.
	 * 
	 */
	public void goToTimerPage() throws IOException
	{
		VBox timerRoot = (VBox)FXMLLoader.load(getClass().getResource("TimerPage.fxml"));
		Scene timerScene = new Scene(timerRoot, 1080, 630);
		
		primaryStage.setScene(timerScene);
		primaryStage.show();
	}
}
