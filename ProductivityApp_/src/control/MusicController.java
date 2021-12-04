package control;

import java.io.File;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class MusicController extends MainController {
    // Peaceful tracks
    @FXML
    Button playMusicTrackID_Jazz;
    @FXML
    Button playMusicTrackID_Blues;
    @FXML
    Button playMusicTrackID_Piano;
    @FXML
    Button playMusicTrackID_Violin;

    // Up beat Tracks
    @FXML
    Button playMusicTrackID_Pop;
    @FXML
    Button playMusicTrackID_Funk;
    @FXML
    Button playMusicTrackID_Rock;
    @FXML
    Button playMusicTrackID_Hiphop;

    // Instance variables for playing random music
    private String filePath = "src\\control\\never_late_smooth_jazz_piano_soft.mp3";

    // TODO: Add more file paths here

    private Media media;
    private MediaPlayer mediaPlayer;

    /**
     * Plays a simple music file..
     */
    public void playMusicButton(ActionEvent event) {
		System.out.println("Playing Music File!");
		media = new Media(new File(filePath).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaPlayer.play();
	    }
    
    // Peaceful tracks
	public void playMusicTrackID_Jazz() {
		System.out.println("in the jazz");
		filePath = "src\\control\\never_late_smooth_jazz_piano_soft.mp3";
	}
    // Peaceful tracks
	public void playMusicTrackID_Blues() {
		System.out.println("in the blues");
		filePath = "src\\control\\blues.mp3";


	}
    // Peaceful tracks
	public void playMusicTrackID_Piano() {
		System.out.println("in the piano");
		filePath = "src\\control\\piano.mp3";


		
	}
    // Peaceful tracks
	public void playMusicTrackID_Violin() {
		System.out.println("in the violin");
		filePath = "src\\control\\violin.mp3";


		
	}
	
    // Peaceful tracks
	public void playMusicTrackID_Pop() {
		System.out.println("in the pop");
		filePath = "src\\control\\pop.mp3";


		
	}
    // Peaceful tracks
	public void playMusicTrackID_Funk() {
		System.out.println("in the funk");
		filePath = "src\\control\\funk.mp3";


		
	}
    // Peaceful tracks
	public void playMusicTrackID_Rock() {
		System.out.println("in the rap");
		filePath = "src\\control\\rock.mp3";


		
	}
    // Peaceful tracks
	public void playMusicTrackID_Hiphop() {
		System.out.println("in the hiphop");
		filePath = "src\\control\\hiphop.mp3";
	}

    // TODO: Be able to pause the music file here...
    /**
     * @param musicFile - the music file that you want to pause
     */
    public void pauseMusic() {
		mediaPlayer.pause();
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
    public void goToBackToTimerPageButton(ActionEvent event) throws IOException {
    	System.out.println("go back");
		goBackToTimerPage();
    }

}
