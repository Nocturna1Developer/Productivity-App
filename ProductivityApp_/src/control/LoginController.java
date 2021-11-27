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
 * @author Chinamay Kasareddy
 */
public class LoginController extends MainController implements Initializable {
    @FXML
    Button loginButtonID;
    @FXML
    Button musicButtonID;
    @FXML
    Text quotesText;

    /**
     * loginButton()
     * 
     * This will call the method from the MainController.java. It is and Action
     * event that is hooked up to the button named "Launch App".
     * 
     * @param event - this is the event that will be responsible for changing
     *              scenes.
     */
    public void loginButton(ActionEvent event) throws IOException {
	goToTimerPage();
    }

    public void goToMusicPageButton(ActionEvent event) throws IOException {
	goToMusicPage();
    }

    public String createUsername() {
	return null;
    }

    public String createPassword() {
	return null;
    }

    public void accessAccount() {
    }

    public static void main(String[] args) {
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
	// TODO Auto-generated method stub
	QuoteController quoteController = getQuoteController();
	quotesText.setText(quoteController.getQuote());
	quoteController.addText(quotesText);
    }
}
