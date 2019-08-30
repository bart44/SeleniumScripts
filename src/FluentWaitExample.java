import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.google.common.base.Function;

public class FluentWaitExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bartek\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

		driver.findElement(By.cssSelector("#start button")).click();

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

		wait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver driver) {
				if (driver.findElement(By.cssSelector("#finish")).isDisplayed()) {
					return driver.findElement(By.cssSelector("#finish"));
				} else
					return null;
			}
		});
		System.out.println(driver.findElement(By.cssSelector("#finish")).getText());
	}

}
