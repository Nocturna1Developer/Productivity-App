package application;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class Main extends Application 
{
	private final static String title = "Productivity!!!";
	@Override
	public void start(Stage primaryStage)
	{
		try
		{
			HBox hbox = new HBox();
			hbox.setStyle("-fx-background-color: #d4cc79;");
			hbox.setSpacing(50);
			hbox.setPadding(new Insets(50,50,50,50));
			
			// Enter name text
			Label nameTitle = new Label("Enter Name: ");
			nameTitle.setFont(new Font("Arial", 15));
			
			// Login Button logic
			Button loginButton = new Button("Login!");
			loginButton.setPrefWidth(75);
			
			// Music button logic
			Button musicButton = new Button("Play Music!");
			musicButton.setPrefWidth(75);
			
			
			
			// Adding buttons to scene
			hbox.getChildren().add(nameTitle);
			hbox.getChildren().add(loginButton);
			hbox.getChildren().add(musicButton);
			
			Scene scene = new Scene(hbox, 400, 400);
			primaryStage.setScene(scene);
			primaryStage.setTitle(title);
			primaryStage.show();
			
		} 
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args)
	{
		launch(args);
	}
}
