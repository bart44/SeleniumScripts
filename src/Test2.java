import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test2 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bartek\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://login.salesforce.com");
		//driver.findElement(By.id("username")).sendKeys("siki weroniki");
		driver.findElement(By.cssSelector("#username")).sendKeys("siki weroniki"); //the same ^
		driver.findElement(By.id("password")).sendKeys("siki weroniki pass");
		//driver.findElement(By.className("button r4 wide primary")).click(); //className compound must not have spaces!!!!
		/*
		driver.findElement(By.xpath("//*[@id=\"Login\"]")).click();
		*/
		driver.findElement(By.xpath("//input[@value='Log In']")).click(); //generated xpath ^
		
		System.out.println(driver.findElement(By.cssSelector("#error")).getText()); //text from website
		//driver.findElement(By.xpath("//*[@id=\"forgot_password_link\"]")).click();

	}

}
