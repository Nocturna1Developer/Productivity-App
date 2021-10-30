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

public abstract class MainController
{
	//public Stage primaryStage = application.Main.window;
	
	public void goToTimerPage() throws IOException
	{
		VBox root = (VBox)FXMLLoader.load(getClass().getResource("TimerPage.fxml"));
		Scene timerScene = new Scene(root, 1080, 630);
		
		//primaryStage.setScene(timerScene);
		//primaryStage.show();
	}
}
