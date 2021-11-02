package control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.IOException;

/**
 * LoginController 
 * 
 * This class will serve as the login controller class which will function as an account creation class.
 * It will be responsible for users setting thier username and password.
 * 
 * @author Chinamay Kasareddy
 */
public class LoginController extends MainController
{
	@FXML Button loginButtonID;
	
	/**
	 * loginButton()
	 * 
	 * This will call the method from the MainController.java.
	 * It is and Action event that is hooked up to the button named "Launch App".
	 * 
	 * @param event - this is the event that will be responsible for changing scenes.
	 */
	public void loginButton(ActionEvent event) throws IOException
	{
		goToTimerPage();
	}
}
