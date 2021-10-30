/**
 * 
 */
package functionality;

import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.converter.NumberStringConverter;

/**
 * @author Chinamay Kasareddy, Saharsh Vedi
 *
 */
public class NotificationTimer {
  private Timer timer;
  private String notification;
  private TimerTask task;
  private Label timeRemaining;
  private Date timeToStopAt;
  private AnimationTimer animationTimer;
  private TextField hourField;
  private TextField minutesField;
  private TextField secondsField;
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
      timeRemaining.setText(hours + ":" + minutes + ":" + seconds);
      if (diff <= 0) {
        timeRemaining.setText("Time to take a break!");
        stop();
        timer.purge();
        timerSet = false;
      }
    }
  }

  public NotificationTimer() {
    task = new TimerTask() {
      public void run() {
        System.out.println("Time to take a break!");
      }
    };
    timer = new Timer("timer");
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
    int hours = Integer.parseInt(hourField.getText());
    int minutes = Integer.parseInt(minutesField.getText());
    int seconds = Integer.parseInt(secondsField.getText());

    setTimer(hours, minutes, seconds);
    animationTimer.start();
  }

  public Scene getScene() {
    VBox vbox = new VBox();
    vbox.setStyle("-fx-background-color: #d4cc79;");
    vbox.setSpacing(50);
    vbox.setPadding(new Insets(50, 50, 50, 50));
    HBox hbox = new HBox();
    hbox.setStyle("-fx-background-color: #d4cc79;");
    hbox.setSpacing(50);
    hbox.setPadding(new Insets(50, 50, 50, 50));

    animationTimer = new TimerMethod();

    hourField = new TextField("00");
    hourField.setTextFormatter(new TextFormatter<>(new NumberStringConverter()));
    minutesField = new TextField("00");
    minutesField.setTextFormatter(new TextFormatter<>(new NumberStringConverter()));
    secondsField = new TextField("00");
    secondsField.setTextFormatter(new TextFormatter<>(new NumberStringConverter()));
    Button startButton = new Button("Start Timer!");
    startButton.setPrefWidth(100);
    startButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent event) {
        startTimerHandler();
      }

    });
    timeRemaining = new Label(00 + ":" + 00 + ":" + 00);

    // Adding buttons to scene
    vbox.getChildren().add(hbox);
    hbox.getChildren().add(hourField);
    hbox.getChildren().add(minutesField);
    hbox.getChildren().add(secondsField);
    vbox.getChildren().add(startButton);
    vbox.getChildren().add(timeRemaining);
    vbox.setAlignment(Pos.CENTER);

    Scene scene = new Scene(vbox, 600, 600);

    return scene;

  }

  /**
   * @param args
   */
  public static void main(String[] args) {

  }
}
