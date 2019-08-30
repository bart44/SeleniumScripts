import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SiblingExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bartek\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.qaclickacademy.com/interview");
		/*//relative path and following siblings of it
		driver.findElement(By.xpath("//li[contains(@id,'tablist1')]")).click();
		driver.findElement(By.xpath("//li[contains(@id,'tablist1')]/following-sibling::li[1]")).click();
		driver.findElement(By.xpath("//li[contains(@id,'tablist1')]/following-sibling::li[2]")).click();
		driver.findElement(By.xpath("//li[contains(@id,'tablist1')]/following-sibling::li[3]")).click();
		*/
		
		
		//find by text
		driver.findElement(By.xpath("//*[text()=' Appium ']")).click();
		driver.findElement(By.xpath("//*[text()=' Selenium ']")).click();
		driver.findElement(By.xpath("//*[text()=' Soap UI ']")).click();
		driver.findElement(By.xpath("//*[text()=' Testing ']")).click();
	
	}

}
