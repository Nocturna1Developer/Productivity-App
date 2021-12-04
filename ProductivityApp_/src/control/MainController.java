package control;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * MainController
 * 
 * This class will serve as the main controller class in which every
 * "Controller" class will extend. It will be responsible for changing all of
 * the scenes.
 * 
 * @reference source code that was provided
 * 
 * @author Chinamay Kasareddy, Saharsh Vedi
 */
public abstract class MainController
{
    public Stage primaryStage = application.Main.window;
    private QuoteController quoteController = new QuoteController();

    /**
     * goToTimerPage() - This method will change the scene from the LoginPage to the
     * TimerPage.
     * 
     */
    public void goToTimerPage() throws IOException
    {
		StackPane loginPage = (StackPane) FXMLLoader.load(getClass().getResource("../view/TimerPage.fxml"));
		Scene loginPageScene = new Scene(loginPage, 1005, 670);
	
		primaryStage.setScene(loginPageScene);
		primaryStage.show();
    }
    
    /**
     * getQuoteController() - This method will get allow the application to display inspirational quotes
     * 
     */
    public QuoteController getQuoteController()
    {
		return quoteController;
    }

    /**
     * goToMusicPage() - This method will change the scene from the LoginPage to the
     * MusicPage.
     * 
     */
    public void goToMusicPage() throws IOException
    {
		StackPane loginPage = (StackPane) FXMLLoader.load(getClass().getResource("../view/MusicPage.fxml"));
		Scene loginPageScene = new Scene(loginPage, 1005, 670);
	
		primaryStage.setScene(loginPageScene);
		primaryStage.show();
    }
    
    /**
     * goBackToTimerPage() - This method will change the scene from the music page back to the
     * timer page.
     * 
     */
    public void goBackToTimerPage() throws IOException
    {
		StackPane loginPage = (StackPane) FXMLLoader.load(getClass().getResource("../view/TimerPage.fxml"));
		Scene loginPageScene = new Scene(loginPage, 1005, 670);
	
		primaryStage.setScene(loginPageScene);
		primaryStage.show();
    }
}
