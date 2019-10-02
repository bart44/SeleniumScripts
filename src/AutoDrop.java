import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoDrop {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bartek\\Documents\\chromedriver1.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.qaclickacademy.com/practice.php");

		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys("unit");
		Thread.sleep(1000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		String script = "return document.getElementById(\"autocomplete\").value";
		String text = (String) js.executeScript(script);

		while (!text.equals("United States")) { //search for united states ...
			int i = 0, count = 10;
			driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys(Keys.ARROW_DOWN);
			text = (String) js.executeScript(script);
					
			if (i>count) {
				break;
			} else {
				i++;
				System.out.println("Not found");
			}
		}
		System.out.println("Found");
		driver.findElement(By.xpath("//input[@id='autocomplete']")).sendKeys(Keys.ENTER); // ... and click it
	}

}
