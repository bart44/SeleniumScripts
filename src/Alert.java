import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alert {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bartek\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.tizag.com/javascriptT/javascriptalert.php");
		driver.findElement(By.xpath(" //div[@class='display']//form//input")).click();
		System.out.println(driver.switchTo().alert().getText());
		driver.switchTo().alert().accept();
		
	}

}
