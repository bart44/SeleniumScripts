import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MoveToOtherTab {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bartek\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://accounts.google.com/signup");
		
		driver.findElement(By.xpath("//a[contains(text(),'Pomoc')]")).click();
		System.out.println(driver.getTitle()); //Tworzenie konta Google

		//Set of windows that are displayed
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> iterator = ids.iterator();
		String parentid = iterator.next(); //Tworzenie konta
		String childid = iterator.next(); //Pomoc
		
		//move to child tab
		driver.switchTo().window(childid);
		System.out.println(driver.getTitle());
		
		//move back to parent tab
		driver.switchTo().window(parentid);
		System.out.println(driver.getTitle());

	}

}
