package functionality;

/**
 * The Account class will be used for getting and setting the username 
 * and password.
 * 
 * @author 
 *
 */
public class Account
{
	private String username;
	private String password;
	
	/**
	 * @param args
	 */
	public String getUsername()
	{
		return username;
	}
	
	/**
	 * @param username - stores the user name of the user
	 */
	public void setUsername(String username)
	{
		this.username = username;
	}
	
	/**
	 * 
	 */
	public String getPassword()
	{
		return password;
	}
	
	/**
	 * @param password - stores the password of the person using it
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		// TODO Auto-generated method stub

	}
}
