import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class FramesTest {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bartek\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		//driver.switchTo().frame(0);
		//driver.switchTo().frame("dupa");
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@class='demo-frame']")));
		driver.findElement(By.id("draggable")).click();
		
		//Action class birth
		Actions actions = new Actions(driver);
		
		//elements that will be dragged and dropped
		WebElement drag = driver.findElement(By.id("draggable"));
		WebElement drop = driver.findElement(By.id("droppable"));
		
		//build.perform
		actions.dragAndDrop(drag, drop).build().perform();
		
		//switch back to default content
		driver.switchTo().defaultContent();
	}

}