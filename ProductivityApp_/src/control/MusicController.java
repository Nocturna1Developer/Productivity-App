package control;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.io.File;
import java.io.IOException;

public class MusicController extends MainController
{
	
	@FXML Button playMusicTrack_1_ButtonID;
	private File musicFile;
	
	/**
	 * goToMusicPageButton()
	 * 
	 * This will call the method from the MainController.java.
	 * It is and Action event that is hooked up to the button named "go To Music Page"
	 * 
	 * @param event - this is the event that will be responsible for changing scenes.
	 */
	public void goToMusicPageButton(ActionEvent event) throws IOException
	{
		goToMusicPage();
	}
	
	

	public File getMusicFile()
	{
		return musicFile;
	}

	public void setMusicFile(File musicFile)
	{
		this.musicFile = musicFile;
	}
	
	/**
	 * @param musicFile - the music file that you want to play
	 */
	public void playMusic(File musicFile)
	{
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{


	}

}
