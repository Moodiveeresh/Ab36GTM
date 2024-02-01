package links;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Url2 {

	public static void main(String[] args) throws IOException 
	{
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.amazon.in/");
List<WebElement> l1=driver.findElements(By.tagName("a"));
int count=l1.size();
System.out.println(count);

for(int i=0; i<count; i++)
{
	WebElement link=l1.get(i);
	String url =link.getAttribute("href");
	System.out.println(url);
	verify_the_link(url);
}
	}
	static void verify_the_link(String eachurl) throws IOException
	{
		try
		{
		URL u1=new URL(eachurl);
	HttpURLConnection w1=(HttpURLConnection) u1.openConnection();
		w1.connect();
		if(w1.getResponseCode()==200)
		{
			System.out.println("URL is Valid "+ w1.getResponseCode()+ w1.getResponseMessage());
		}
		else
		{
			
		}
		}
		catch(java.net.MalformedURLException a1)
		{
			System.out.println("i have handled this because some href's have null");
		}
	}
	

}
