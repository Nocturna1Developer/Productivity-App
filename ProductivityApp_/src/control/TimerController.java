package control;

import java.io.File;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import org.controlsfx.control.Notifications;

import javafx.animation.AnimationTimer;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * Timer Controller
 * 
 * This class will serve as the timer controller class which will allow users to
 * set a timer.
 * 
 * @author Saharsh Vedi
 */
public class TimerController {
    @FXML
    Button startTimerButton;
    @FXML
    TextField hourText;
    @FXML
    TextField minutesText;
    @FXML
    TextField secondsText;
    @FXML
    Label timerLabel;
    private Timer timer;
    private TimerTask task;
    private Date timeToStopAt;
    private AnimationTimer animationTimer;
    private boolean timerSet;
    
    private File musicFile = new File("../ProductivityApp_/src/control/background.mp3") ;
    private Media media;
    private MediaPlayer mediaPlayer;
    
    
    public void pickAnyMusic()
    {		
    	System.out.println("In the play music method");
		media = new Media(musicFile.toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.play();
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
	    // call the method
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
     * @param time - set the amount of time you want to work or rest
     */
    public int timerLogic(int time) {
	return 0;
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
	timer = new Timer("timer");
	int hours = Integer.parseInt(hourText.getText());
	int minutes = Integer.parseInt(minutesText.getText());
	int seconds = Integer.parseInt(secondsText.getText());

	setTimer(hours, minutes, seconds);
	animationTimer = new TimerMethod();
	animationTimer.start();
    }

}
