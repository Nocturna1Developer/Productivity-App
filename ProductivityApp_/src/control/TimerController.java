package control;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * Timer Controller
 * 
 * This class will serve as the timer controller class which will allow users to set a timer.
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
  private String notification;
  private TimerTask task;
  private Date timeToStopAt;
  private AnimationTimer animationTimer;
  private boolean timerSet;


  private class TimerMethod extends AnimationTimer {

    @Override
    public void handle(long now) {
      // call the method
      handlee();
    }

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

  public Date timeToDate(int hours, int minutes, int seconds) {
    Calendar date = Calendar.getInstance();
    long timeInSecs = date.getTimeInMillis();
    return new Date(
        timeInSecs + (hours * 60 * 60 * 1000) + (minutes * 60 * 1000) + (seconds * 1000));
  }

  public Timer getTimer() {
    return timer;
  }

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
   * @param time - set the notification that will be displayed after the timer reaches 0.
   */
  public String displayNotification(String message) {
    return message;
  }

  public void startTimerHandler() {
    task = new TimerTask() {
      public void run() {
        System.out.println("Time to take a break!");
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
