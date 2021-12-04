/**
 * 
 */
package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javafx.event.ActionEvent;
import javafx.scene.text.Text;

/**
 * @author
 *
 */
public class QuoteController {

    private final String[] QUOTES = new String[] { "Stay Hungry. Stay Foolish. ~Steve Jobs",
	    "Good Artists Copy, Great Artists Steal. ~Pablo Picasso",
	    "Argue with idiots, and you become an idiot. ~Paul Graham",
	    "Be yourself; everyone else is already taken. ~Oscar Wilde",
	    "Simplicity is the ultimate sophistication. ~Leonardo Da Vinci",
	    "Be the change that you wish to see in the world. ~Mahatma Gandhi",
	    "Darkness cannot drive out darkness: only light can do that. Hate cannot drive out hate: only love can do that. ~Martin Luther King Jr",
	    "Imperfection is beauty, madness is genius and it's better to be absolutely ridiculous than absolutely boring ~Marilyn Monroe" };

    private String currentQuote;
    private ArrayList<Text> textBoxes;

    /**
     * This method will serve as the constructor for the class. It will call the
     * method startChangingQuotes() to change the quotes on the screen periodically.
     * 
     */
    public QuoteController() {
	currentQuote = QUOTES[0];
	textBoxes = new ArrayList<Text>();
	startChangingQuotes();
    }

    public String getQuote() {
	return currentQuote;
    }

    public void addText(Text text) {
	textBoxes.add(text);
    }

    /**
     * This method use change the quotes based on a timer schedule.
     * 
     */
    public void startChangingQuotes() {
	new Timer().schedule(new TimerTask() {
	    @Override
	    public void run() {
		changeCurrentQuote();
	    }
	}, 0, 10000);
    }

    /**
     * This method will change the current quote to a random quote by using the
     * array list
     * 
     */
    public void changeCurrentQuote() {
	int count = (int) (Math.random() * QUOTES.length);
	this.currentQuote = QUOTES[count];
	for (Text text : textBoxes) {
	    text.setText(this.currentQuote);
	}
    }

    public void quitApplicationButton(ActionEvent event) throws IOException {
	// quitApplication();
    }
}
