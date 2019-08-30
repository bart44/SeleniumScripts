import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class AssersExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bartek\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://qaclickacademy.com/practice.php");
		
		driver.findElement(By.cssSelector("#checkBoxOption1")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("#checkBoxOption1")).isSelected());
		driver.findElement(By.cssSelector("#checkBoxOption1")).click();
		Assert.assertFalse(driver.findElement(By.cssSelector("#checkBoxOption1")).isSelected());
		
		System.out.println(driver.findElements(By.xpath("//input[@type='checkbox']")).size());
		

	}

}
