import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args)  {
		//Create driver object
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bartek\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://google.com");
		System.out.println(driver.getTitle()); 
		
		//check if url is correct (not hacked xd)
		System.out.println(driver.getCurrentUrl());
		
		//print page source
		//System.out.println(driver.getPageSource());
		
		driver.get("http://yahoo.com");
		driver.navigate().back();
		driver.close(); //close single browser
		//driver.quit(); //close all browsers
		

	}

}
