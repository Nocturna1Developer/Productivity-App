package control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.IOException;

public class MusicController extends MainController
{
	
	@FXML Button playMusicTrack_1_ButtonID;
	
	/**
	 * loginButton()
	 * 
	 * This will call the method from the MainController.java.
	 * It is and Action event that is hooked up to the button named "Launch App".
	 * 
	 * @param event - this is the event that will be responsible for changing scenes.
	 */
	public void goToMusicPageButton(ActionEvent event) throws IOException
	{
		goToMusicPage();
	}

}
