package control;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;

import org.controlsfx.control.Notifications;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;

/**
 * Timer Controller
 * 
 * This class will serve as the timer controller class which will allow users to
 * set a timer.
 * 
 * @reference (Playing Sound):
 *            https://www.youtube.com/watch?v=fV5zUq-tVug&ab_channel=ChannelAi
 * @reference (Using Timer): https://www.educba.com/javafx-animationtimer/
 * 
 * @author Saharsh Vedi, Chinamay Kasareddy
 */
public class TimerController extends MainController implements Initializable {
    @FXML
    Button startTimerButton;
    @FXML
    Button playMusicButtonID;

    @FXML
    TextField hourText;
    @FXML
    TextField minutesText;
    @FXML
    TextField secondsText;
    @FXML
    Label timerLabel;
    @FXML
    Text quotesText;
    @FXML
    Label timerErrorLabel;

    // Instance Variables for the timer behavior
    private Timer timer;
    private TimerTask task;
    private Date timeToStopAt;
    private AnimationTimer animationTimer;
    private boolean timerSet;

    // Instance variables for playing random music (this is here so users have
    // quick access to music)
    private String filePath = "src\\control\\never_late_smooth_jazz_piano_soft.mp3";
    private Media media;
    private MediaPlayer mediaPlayer;

    /**
     * Plays a simple music file.
     */
    public void playMusicButton(ActionEvent event) {
//		System.out.println("Playing Music File!");
		media = new Media(new File(filePath).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.play();
    }

    /**
     * goToMusicPageButton()
     * 
     * This will call the method from the MainController.java. It is and Action
     * event that is hooked up to the button named "Go To Music Page"
     * 
     * @param event - this is the event that will be responsible for changing
     *              scenes.
     */
    public void goToMusicPageButton(ActionEvent event) throws IOException {
	goToMusicPage();
    }

    /**
     * Inner Class that calls the handle method in every frame.
     * 
     * @author Saharsh Vedi
     *
     */
    private class TimerMethod extends AnimationTimer {
	@Override
	public void handle(long now) {
	    handlee();
	}

	/**
	 * Calculates the time remaining on the timer and sets the label.
	 */
	private void handlee() {
	    long diff = timeToStopAt.getTime() - Calendar.getInstance().getTimeInMillis();
	    int seconds = (int) (diff / 1000) % 60;
	    int minutes = (int) ((diff / (1000 * 60)) % 60);
	    int hours = (int) ((diff / (1000 * 60 * 60)) % 24);
	    timerLabel.setText(hours + ":" + minutes + ":" + seconds);
	    if (diff <= 0) {
		timerLabel.setText("Time to take a break!");
		stop();
		timer.purge();
		timerSet = false;
	    }
	}
    }

    /**
     * Converts the given time to a Date object.
     * 
     * @param hours
     * @param minutes
     * @param seconds
     * @return
     */
    public Date timeToDate(int hours, int minutes, int seconds) {
	Calendar date = Calendar.getInstance();
	long timeInSecs = date.getTimeInMillis();
	return new Date(timeInSecs + (hours * 60 * 60 * 1000) + (minutes * 60 * 1000) + (seconds * 1000));
    }

    /**
     * Sets and starts the timer.
     * 
     * @param hours
     * @param minutes
     * @param seconds
     */
    public void setTimer(int hours, int minutes, int seconds) {
	if (timerSet) {
	    timer.cancel();
	    timer.purge();
	}
	timeToStopAt = timeToDate(hours, minutes, seconds);
	timer.schedule(task, timeToStopAt);
	timerSet = true;
    }

    /**
     * Checks if the time given is valid or not.
     * 
     * @param time - the time you want to check if it is legal.
     */
    private boolean timeIsLegal(String time) {
	if (!time.matches(".*[a-zA-Z]+.*")) {
	    if (Integer.parseInt(time) >= 0) {
		return true;
	    }
	}
	return false;
    }

    /**
     * Starts the timer when the user clicks the Start Timer Button.
     */
    public void startTimerHandler() {
	task = new TimerTask() {
	    public void run() {
		Platform.runLater(new Runnable() {

		    @Override
		    public void run() {
			Notifications.create().title("Break!").text("Time to take a break!").show();
		    }
		});
	    }
	};

	// Sets the parameters in the text boxes in the .fxml file
	timerErrorLabel.setOpacity(0);
	timer = new Timer("timer");
	String hoursString = hourText.getText();
	String minutesString = minutesText.getText();
	String secondsString = secondsText.getText();
	if (timeIsLegal(hoursString) && timeIsLegal(minutesString) && timeIsLegal(secondsString)) {
	    timerErrorLabel.setOpacity(0);
	    int hours = Integer.parseInt(hoursString);
	    int minutes = Integer.parseInt(minutesString);
	    int seconds = Integer.parseInt(secondsString);
	    setTimer(hours, minutes, seconds);
	    animationTimer = new TimerMethod();
	    animationTimer.start();
	} else {
	    timerErrorLabel.setOpacity(1);
	}

    }

    /**
     * Initializes the Quotes Text
     */
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
	// TODO Auto-generated method stub
	QuoteController quoteController = getQuoteController();
	quotesText.setText(quoteController.getQuote());
	quoteController.addText(quotesText);
    }
}