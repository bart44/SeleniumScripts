import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TabsExchange {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bartek\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/windows");

		driver.findElement(By.xpath("//a[contains(text(),'Click Here')]")).click();

		// Set of tabs that are displayed
		Set<String> tabs = driver.getWindowHandles();
		Iterator<String> iterator = tabs.iterator();
		String parentid = iterator.next(); 
		String childid = iterator.next(); 
		
		//move to child tab and print text to console
		driver.switchTo().window(childid);
		System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'New Window')]")).getText());
		
		//move back to parent tab and print text to console
		driver.switchTo().window(parentid);
		System.out.println(driver.findElement(By.xpath("//h3[contains(text(),'Opening a new window')]")).getText());


	}

}