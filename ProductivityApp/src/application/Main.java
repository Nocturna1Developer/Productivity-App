package application;

import java.awt.Button;
import java.awt.Insets;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

public class Main extends Application 
{
	private final static String title = "Productivity!!!";
	@Override
	public void start(Stage primaryStage)
	{
		try
		{
			VBox hbox = new VBox();
			hbox.setStyle(" fx background color: #d4cc79; ");
			hbox.setSpacing(50);
			//hbox.setPadding(new Insets(50,50,50,50));
			
			Button loginButton = new Button("Login!");
			Button testButton = new Button("Test!");
			//loginButton.setPrefWidth(75);
			
			//hbox.getChildren().addAll(testButton, loginButton);
			
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
