/**
 * 
 */
package control;

/**
 * @author 
 *
 */
public class QuoteController
{
	private String quote;

	public QuoteController()
	{

	}

	public String getQuote()
	{
		return quote;
	}

	public void setQuote(String quote)
	{
		this.quote = quote;
	}
	
	/**
	 * This method will display random quotes before the timer, during the duration of the timer, 
	 * and after the timer
	 * 
	 */
	public String displayRandomQuotes()
	{
		return quote;
		
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{

	}
}
