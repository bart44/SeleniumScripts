import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test6 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bartek\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://login.salesforce.com");
		driver.findElement(By.cssSelector("#username")).sendKeys("dasd");
		driver.findElement(By.cssSelector("input[id=password]")).sendKeys("qwerty");
		driver.findElement(By.xpath("//input[@id=\"Login\"]")).click();
		

	}

}
