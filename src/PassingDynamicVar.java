import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class PassingDynamicVar {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bartek\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://qaclickacademy.com/practice.php");

		// 1. select checkbox
		driver.findElement(By.xpath("//input[@id='checkBoxOption3']")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("#checkBoxOption3")).isSelected());

		// 2. text in the selected checkbox
		String option3 = driver.findElement(By.xpath("//div[@id='checkbox-example']//label[3]")).getText();

		// 3. Select dropdown with 2.
		Select s = new Select(driver.findElement(By.id("dropdown-class-example")));
		s.selectByVisibleText(option3);

		// 4. Input 2. in editbox && click Alert && validate
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys(option3);
		driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
		System.out.println(driver.switchTo().alert().getText());

		if (driver.switchTo().alert().getText().contains(option3)) {
			System.out.println("Validation successful");
		} else {
			System.out.println("Validation failed");
		}
	}
}
