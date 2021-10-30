package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {
  private final static String title = "Productivity!!!";

  @Override
  public void start(Stage primaryStage) {
    try {
      HBox hbox = new HBox();
      hbox.setStyle("-fx-background-color: #d4cc79;");
      hbox.setSpacing(50);
      hbox.setPadding(new Insets(50, 50, 50, 50));

      /*
       * Once you open the application you will be prompted to create an account, a password and
       * user name.
       */
      Button createAccountButton = new Button("Create Account!");
      createAccountButton.setPrefWidth(75);

      Label createNameTitle = new Label("Create Name!");
      createNameTitle.setFont(new Font("Arial", 15));

      // TODO: Logic for entering name in input field

      Label createPasswordTitle = new Label("Create Password!");
      createPasswordTitle.setFont(new Font("Arial", 15));

      // TODO: Logic for entering password in input field


      /*
       * Once you login to your account you will be able to type in the name and password that you
       * previously created.
       */
      Button loginButton = new Button("Login!");
      loginButton.setPrefWidth(75);

      Label nameTitle = new Label("Enter Name!");
      nameTitle.setFont(new Font("Arial", 15));

      // TODO: Logic for entering AND saving name in input field

      Label passwordTitle = new Label("Enter Password!");
      passwordTitle.setFont(new Font("Arial", 15));

      // TODO: Logic for entering AND saving password in input field

      /*
       * After accesing your account you will be able to play calming music at random.
       */
      Button musicButton = new Button("Play Music!");
      musicButton.setPrefWidth(75);


      // Adding buttons to scene
      hbox.getChildren().add(nameTitle);
      hbox.getChildren().add(loginButton);
      hbox.getChildren().add(musicButton);

      Scene scene = new Scene(hbox, 600, 600);
      NotificationTimer nt = new NotificationTimer();
      primaryStage.setScene(nt.getScene());
      primaryStage.setTitle(title);
      primaryStage.show();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}
