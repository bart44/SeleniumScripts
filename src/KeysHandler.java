import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KeysHandler {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bartek\\Documents\\chromedriver1.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("http://makemytrip.com");
		
		driver.findElement(By.xpath("//div[contains(@class,'fsw_inputBox searchCity inactiveWidget')]//label")).click();
		driver.findElement(By.xpath("//input[contains(@placeholder,'From')]")).sendKeys("mum");
		Thread.sleep(666);
		driver.findElement(By.xpath("//input[contains(@placeholder,'From')]")).sendKeys(Keys.ARROW_DOWN);
		driver.findElement(By.xpath("//input[contains(@placeholder,'From')]")).sendKeys(Keys.ENTER);
		Thread.sleep(666);
	
		driver.findElement(By.xpath("//input[contains(@placeholder,'To')]")).sendKeys("my");
		for(int i=1;i<=3;i++) {
		driver.findElement(By.xpath("//input[contains(@placeholder,'To')]")).sendKeys(Keys.ARROW_DOWN);
		}
		driver.findElement(By.xpath("//input[contains(@placeholder,'To')]")).sendKeys(Keys.ENTER);
		

	}

}
