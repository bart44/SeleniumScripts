import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWait {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bartek\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://alaskatrips.poweredbygps.com/g/pt/hotels?MDPCID=ALASKA-US.TPS.BRAND.hotels.HOTEL");
		
		driver.findElement(By.id("FH-origin")).sendKeys("nyc");
		driver.findElement(By.id("FH-origin")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.id("FH-origin")).sendKeys(Keys.TAB);
		driver.findElement(By.id("FH-fromDate")).sendKeys(Keys.ENTER);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='resultsContainer']/section/article[1]\"")));
		
		driver.findElement(By.xpath("//div[@id='resultsContainer']/section/article[1]")).click();	

	}

}
