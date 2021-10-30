package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import java.io.IOException;

public class LoginController extends MainController
{
	@FXML Button loginButtonID;
	public void loginButton(ActionEvent event) throws IOException
	{
		goToTimerPage();
	}
}
