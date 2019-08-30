import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutosugestiveDrop {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bartek\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://ksrtc.in/oprs-web/");
		
		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys("ben");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//input[@id='fromPlaceName']")).getText(); //can't identify hidden objecti
		
		//javascript executor - find hidden objects
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String script = "return document.getElementById(\"fromPlaceName\").value";
		String text = (String) js.executeScript(script);
		System.out.println(text);
		
		int i=0;
		while(!text.equals("BENGALURU AIRPORT")) {		
			i++;
			driver.findElement(By.xpath("//input[@id='fromPlaceName']")).sendKeys(Keys.ARROW_DOWN);
			
			text = (String) js.executeScript(script);
			System.out.println(text);
			
			if (i >= 10) {
				break;
			} else {
				System.out.println("Object not found");
			}
		}
		System.out.println("No jes");

	}

}
