package control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

import org.json.simple.parser.ParseException;

/**
 * LoginController 
 * 
 * This class will serve as the login controller class which will function as an account creation class.
 * It will be responsible for users setting their user name and password.
 * 
 * @reference source code team-00-01
 * @author Chinamay Kasareddy
 */
public class LoginController extends MainController
{
	// Variables for account creation
	@FXML Button 		createAccountButtonID;
	@FXML Button		confirmButtonID;
	@FXML private Label badUserPassLabel;
	@FXML TextField 	usernameCreateID;
	@FXML TextField 	passwordCreateID;
	private String 		username = "";
	private String 		password = "";
	
	// Variables for login
	@FXML Button 			loginButtonID;
	@FXML private TextField usernameLoginID;
	@FXML private TextField passwordLoginID;
	
	// Variables for quitting the application
	
	
	Stage createNewAccStage = null;
	
	/**
	 * 1] CREATE ACCOUNT
	 * 
	 * createAccountButton()
	 * 
	 * This will call the method from the MainController.java.
	 * It is and Action event that is hooked up to the button named "Create Account"
	 * 
	 * @param event - this is the event that will be responsible for changing scenes.
	 */
	public void createAccountButton(ActionEvent event) throws IOException
	{
		AnchorPane accountPane = (AnchorPane)FXMLLoader.load(getClass().getResource("../view/AccountCreation.fxml"));
		Scene accountScene = new Scene(accountPane,550,340);
		accountScene.getStylesheets().add(getClass().getResource("../application/application.css").toExternalForm());
		
		if(createNewAccStage == null || !createNewAccStage.isShowing())
		{
			createNewAccStage = new Stage();
			createNewAccStage.setScene(accountScene);
			createNewAccStage.show();
		}
		else
		{
			createNewAccStage.toFront();
		}
	}
	
	// Records new user name set by the user
	public void getUsername()
	{
		username = usernameCreateID.getText();
	}
	
	// Records new password set by the user
	public void getPassword()
	{
		password = passwordCreateID.getText();
	}
	
	
	/**
	 * 2] CHECK IF ACCOUNT CREATION IS SUCCESFULL
	 * 
	 * isSuccessfulLogin()
	 * 
	 * This method will check if the user has successfully logged in.
	 * @throws ParseException 
	 */
	public boolean isSuccessfulLogin() throws ParseException
	{
		return false;
	}
	
	// Ensures that the user name and password are not blank, checks if they are legal
	public boolean userpass_isLegal()
	{
		getUsername();
		getPassword();
		
		if(username.length() < 1 || password.length() < 1)
		{
			badUserPassLabel.setOpacity(1);
			return false;
		}
		badUserPassLabel.setOpacity(0);
		return true;
	}
	
	// Allows user to confirm their password and user name
	public void confirmButton(ActionEvent event) throws ParseException
	{
	
	}
	
	/**
	 * 3] LOGIN AND LAUNCH THE APP
	 * loginButton()
	 * 
	 * This will call the method from the MainController.java.
	 * It is and Action event that is hooked up to the button named "Launch App".
	 * 
	 * @param event - this is the event that will be responsible for changing scenes.
	 * @throws ParseException 
	 */
	public void loginButton(ActionEvent event) throws IOException, ParseException
	{
		// If the login is successful then you can login, otherwise do nothing
		if(isSuccessfulLogin())
		{
			goToTimerPage();
		}
	}
}