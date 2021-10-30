/**
 * 
 */
package functionality;

/**
 * @author Chinamay Kasareddy
 *
 */
public class Timer
{
	private int timer;
	private String notification;

	public Timer()
	{

	}

	public int getTimer()
	{
		return timer;
	}

	public void setTimer(int timer)
	{
		this.timer = timer;
	}
	
	/**
	 * @param time - set the amount of time you want to work or rest
	 */
	public int timerLogic(int time)
	{
		return 0;
	}
	
	/**
	 * @param time - set the notification that will be displayed after the timer reaches 0.
	 */
	public String displayNotification(String message)
	{
		return message;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

	}
}
