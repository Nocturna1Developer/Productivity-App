package control;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.io.IOException;

import application.Main;

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
		StackPane loginPage = (StackPane)FXMLLoader.load(getClass().getResource("../view/TimerPage.fxml"));
		Scene loginPageScene = new Scene(loginPage,1080,630);
		
		primaryStage.setScene(loginPageScene);
		primaryStage.show();
	}
	
	/**
	 * goToMusicPage() - This method will change the scene from the LoginPage to the MusicPage.
	 * 
	 */
	public void goToMusicPage() throws IOException
	{
		StackPane loginPage = (StackPane)FXMLLoader.load(getClass().getResource("../view/MusicPage.fxml"));
		Scene loginPageScene = new Scene(loginPage,1080,630);
		
		primaryStage.setScene(loginPageScene);
		primaryStage.show();
	}
}
