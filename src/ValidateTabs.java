import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ValidateTabs {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bartek\\Documents\\chromedriver1.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		// driver.get("http://webcache.googleusercontent.com/search?q=cache:https://qaclickacademy.com/practice.php");

		// get count links
		System.out.println(driver.findElements(By.tagName("a")).size());

		// create subsection of driver for footer section and ^
		WebElement footer = driver.findElement(By.id("gf-BIG"));
		System.out.println(footer.findElements(By.tagName("a")).size());

		// count link in 1st column in footer
		WebElement footerCol1 = footer.findElement(By.xpath("//td[1]/ul"));
		int size = footerCol1.findElements(By.tagName("a")).size();
		System.out.println(size);

		// click on each link in Col1 and check if the pages are opening
		for (int i = 1; i < size; i++) {
			String clickOnLink = Keys.chord(Keys.CONTROL, Keys.ENTER);
			footerCol1.findElements(By.tagName("a")).get(i).sendKeys(clickOnLink);
			Thread.sleep(2000);
		}
		
		Set<String> tabs = driver.getWindowHandles();
		Iterator<String> iterator = tabs.iterator();

		while (iterator.hasNext()) {
			driver.switchTo().window(iterator.next());
			System.out.println(driver.getTitle());
		}

	}

}
