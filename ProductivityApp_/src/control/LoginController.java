package control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
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
    @FXML Button loginButtonID;
    @FXML Text quotesText;

    /**
     * loginButton()
     * 
     * This will call the method from the MainController.java. It is and Action
     * event that is hooked up to the button named "Launch App".
     * 
     * @param event - this is the event that will be responsible for changing
     *              scenes.
     */
    public void loginButton(ActionEvent event) throws IOException
    {
    	goToTimerPage();
    }
    
    /**
     * initialize()
     * 
     * This method will ....
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
    
    public void quitApplicationButton(ActionEvent event) throws IOException
    {
    	quitApplication();
    }
}
