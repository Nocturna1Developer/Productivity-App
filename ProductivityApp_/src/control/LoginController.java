package control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * LoginController
 * 
 * This class will serve as the login controller class which will function as an
 * account creation class. It will be responsible for users setting their user
 * name and password.
 * 
 * @reference source code team-00-01
 * @author Chinamay Kasareddy, Sarash Vedi
 */
public class LoginController extends MainController implements Initializable
{
    @FXML Button 			loginButtonID;
    @FXML private TextField userID;
    @FXML Text 				quotesText;
	@FXML private Label 	badUserNameLabel;
	private String 			username = "";
	
	public void getUsername()
	{
		username = userID.getText();
	}
	
	// Makes sure that the user name is not blank
	public boolean isLegal()
	{
		getUsername();
		badUserNameLabel.setOpacity(0);
		if(username.length() < 1)
		{
			badUserNameLabel.setOpacity(1);
			return false;
		}
		return true;
	}
    /**
     * loginButton()
     * 
     * This will call the method from the MainController.java. It is and Action
     * event that is hooked up to the button named "Launch App". It will go to
     * the next page if the user name is appropriate.
     * 
     * @param event - this is the event that will be responsible for changing
     *              scenes.
     */
    public void loginButton(ActionEvent event) throws IOException
    {
    	if(isLegal())
    	{
    		goToTimerPage();
    	}
    }
    
    /**
     * initialize()
     * 
     * This method will initialize the quotes and set the text of them in the main application.
     * 
     * @param arg0
     * @param arg1 
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) 
    {
		QuoteController quoteController = getQuoteController();
		quotesText.setText(quoteController.getQuote());
		quoteController.addText(quotesText);
    }
}
