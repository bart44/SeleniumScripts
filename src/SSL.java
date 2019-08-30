import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SSL {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bartek\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/disappearing_elements");
		//driver.findElement(By.xpath("//a[contains(text(),'Nested Frames')]")).click();
		
		//how many frames on that level
		System.out.println(driver.findElements(By.tagName("li")).size());

	}

}
