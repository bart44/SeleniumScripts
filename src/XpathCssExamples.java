import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathCssExamples {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bartek\\Documents\\chromedriver1.exe");
		WebDriver driver = new ChromeDriver();
		
		/*
		//xpath - //TagName[@atr='value']	
		driver.get("http://login.salesforce.com");
		driver.findElement(By.xpath("//input[@name=\"username\"]")).sendKeys("own xpath");
		driver.findElement(By.xpath("//input[@name=\"pw\"]")).sendKeys("1234wdsa");
		driver.findElement(By.xpath("//input[@value=\"Log In\"]")).click();*/
		
		/*
		//css - TagName[atr='val'] or TagName#id (you can skip TagName) - only ID or TagName.classname
		driver.get("http://login.salesforce.com");
		driver.findElement(By.cssSelector("input[name='username']")).sendKeys("own css"); 
		driver.findElement(By.cssSelector("input#password")).sendKeys("passwd1233");
		driver.findElement(By.cssSelector("input[value='Log In']")).click(); //when 
		*/
		
		//changing xpath and css on website
		driver.get("http://rediff.com");
		driver.findElement(By.cssSelector("a[title*='Sign in']")).click(); //when attribute changes - attribute*=notFullVal
		driver.findElement(By.xpath("//input[contains(@id,'login')]")).sendKeys("lagin123"); //when attribute changes - contains(@attribute,notFullVal)
		driver.findElement(By.cssSelector("input#password")).sendKeys("passwdxdxd123");
		driver.findElement(By.xpath("//input[@value='Go']")).click();
	
	}
}
