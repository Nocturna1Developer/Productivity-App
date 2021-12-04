package control;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MusicController extends MainController
{
    // Peaceful tracks
    @FXML Button playMusicTrackID_Jazz;
    @FXML Button playMusicTrackID_Blues;
    @FXML Button playMusicTrackID_Piano;
    @FXML Button playMusicTrackID_Violin;

    // Up beat Tracks
    @FXML Button playMusicTrackID_Pop;
    @FXML Button playMusicTrackID_Funk;
    @FXML Button playMusicTrackID_Rock;
    @FXML Button playMusicTrackID_Hiphop;

    // Instance variables for playing random music
    private String 		filePath = "src\\control\\never_late_smooth_jazz_piano_soft.mp3";
    private Media 		media;
    private MediaPlayer mediaPlayer;

    /**
     * Plays a simple music file.
     * 
     * @param - the event that plays a music file.
     */
    public void playMusicButton(ActionEvent event)
    {
    	System.out.println("Playing Music File!");
		media = new Media(new File(filePath).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.play();
    }
    /**
     * Plays a simple music file, makes sure that two music tracks can't be played at once.
     */
	public void playMusicTrackID_Jazz() {
		System.out.println("In the Jazz!");
		if(mediaPlayer != null)
		{
			mediaPlayer.stop();
		}
		filePath = "src\\control\\never_late_smooth_jazz_piano_soft.mp3";
		media = new Media(new File(filePath).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.play();
	}
    /**
     * Plays a simple music file, makes sure that two music tracks can't be played at once.
     */
	public void playMusicTrackID_Blues() {
		System.out.println("In the Blues!");
		if(mediaPlayer != null)
		{
			mediaPlayer.stop();
		}
		filePath = "src\\control\\blues.mp3";
		media = new Media(new File(filePath).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.play();
	}
    /**
     * Plays a simple music file, makes sure that two music tracks can't be played at once.
     */
	public void playMusicTrackID_Piano()
	{
		System.out.println("In the Piano");
		if(mediaPlayer != null)
		{
			mediaPlayer.stop();
		}
		filePath = "src\\control\\piano.mp3";
		media = new Media(new File(filePath).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.play();	
	}
    /**
     * Plays a simple music file, makes sure that two music tracks can't be played at once.
     */
	public void playMusicTrackID_Violin()
	{
		System.out.println("In the Violin");
		if(mediaPlayer != null)
		{
			mediaPlayer.stop();
		}
		filePath = "src\\control\\violin.mp3";
		media = new Media(new File(filePath).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.play();	
	}
	
    /**
     * Plays a simple music file, makes sure that two music tracks can't be played at once.
     */
	public void playMusicTrackID_Pop()
	{
		System.out.println("In the Pop");
		if(mediaPlayer != null)
		{
			mediaPlayer.pause();
		}
		filePath = "src\\control\\pop.mp3";
		media = new Media(new File(filePath).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.play();	
	}
    /**
     * Plays a simple music file, makes sure that two music tracks can't be played at once.
     */
	public void playMusicTrackID_Funk() 
	{
		System.out.println("In the Funk");
		if(mediaPlayer != null)
		{
			mediaPlayer.pause();
		}
		filePath = "src\\control\\funk.mp3";
		media = new Media(new File(filePath).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.play();	
	}
    /**
     * Plays a simple music file, makes sure that two music tracks can't be played at once.
     */
	public void playMusicTrackID_Rock()
	{
		System.out.println("In the Rap");
		if(mediaPlayer != null)
		{
			mediaPlayer.stop();
		}
		filePath = "src\\control\\rock.mp3";
		media = new Media(new File(filePath).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.play();	
	}
    /**
     * Plays a simple music file, makes sure that two music tracks can't be played at once.
     */
	public void playMusicTrackID_Hiphop()
	{
		System.out.println("in the Hip-hop");
		if(mediaPlayer != null)
		{
			mediaPlayer.stop();
		}
		filePath = "src\\control\\hiphip.mp3";
		media = new Media(new File(filePath).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.play();
	}
    /**
     * @param musicFile - the music file that you want to pause
     */
    public void pauseMusic()
    {
		if(mediaPlayer != null)
		{
			mediaPlayer.pause();
		}
    }
    /**
     * goToBackToTimerPageButton()
     * 
     * This will call the method from the MainController.java. It is and Action
     * event that is hooked up to the button named "go back to timer page"
     * 
     * @param event - this is the event that will be responsible for changing
     *              scenes.
     */
    public void goToBackToTimerPageButton(ActionEvent event) throws IOException
    {
		goBackToTimerPage();
    }
}
