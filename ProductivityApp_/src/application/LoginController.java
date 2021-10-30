package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LoginController extends MainController
{
	@FXML Button loginButtonID;
	public void loginButton(ActionEvent event) throws IOException
	{
		goToTimerPage();
	}
}
