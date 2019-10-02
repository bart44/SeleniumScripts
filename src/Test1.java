import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test1 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bartek\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://facebook.com");
		driver.findElement(By.name("email")).sendKeys("w@wp.pl");
		driver.findElement(By.name("pass")).sendKeys("pass");
		driver.findElement(By.linkText("Nie pamiêtasz nazwy konta?")).click();
		
		//driver.close();

	}

}
