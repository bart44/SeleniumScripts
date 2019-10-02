import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsDemo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bartek\\Documents\\chromedriver1.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://amazon.com");
		
		//Action class invoke
		Actions actions = new Actions(driver);
		
		//capital letters to searchbox and select it
		actions.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello").doubleClick().build().perform();
		
		//move to element (not clicking) and right click to show context menu
		WebElement move = driver.findElement(By.id("nav-link-accountList"));
		actions.moveToElement(move).contextClick().build().perform();
				
	}

}