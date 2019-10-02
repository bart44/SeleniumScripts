import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bartek\\Documents\\chromedriver1.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com");
		driver.findElement(By.xpath("//a[contains(text(),'Nested Frames')]")).click();
		
		//how many frames on that level
		System.out.println(driver.findElements(By.tagName("frame")).size());		
		//switch to top-frame
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-top']")));
		//how many frames on that level
		System.out.println(driver.findElements(By.tagName("frame")).size());
		//switch to middle-frame
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@name='frame-middle']")));
		//print text from that frame
		System.out.println(driver.findElement(By.id("content")).getText());
		//switch to default
		driver.switchTo().defaultContent();
		driver.close();

	}

}
