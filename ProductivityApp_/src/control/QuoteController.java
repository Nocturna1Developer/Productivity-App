/**
 * 
 */
package control;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

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
	    "Simplicity is the ultimate sophistication. ~Leonardo Da Vinci" };
    private String currentQuote;
    private ArrayList<Text> textBoxes;

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

    public void startChangingQuotes() {
	new Timer().schedule(new TimerTask() {

	    @Override
	    public void run() {
		changeCurrentQuote();
	    }
	}, 0, 10000);
    }

    /**
     * This method will change the current quote to a random quote.
     * 
     */
    public void changeCurrentQuote() {
	int count = (int) (Math.random() * QUOTES.length);
	System.out.println(count);
	this.currentQuote = QUOTES[count];
	for (Text text : textBoxes) {
	    text.setText(this.currentQuote);
	}
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

    }
}
