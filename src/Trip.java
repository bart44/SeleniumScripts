import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Trip {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bartek\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("https://www.cleartrip.com/");
		
		//current date
		driver.findElement(By.cssSelector("#DepartDate")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[contains(@class,'ui-state-default ui-state-highlight ui-state-active')]")).click();
		
		//select adults, children, infants
		Select s0 = new Select(driver.findElement(By.cssSelector("#Adults")));
		s0.selectByValue("2");
		
		Select s1 = new Select(driver.findElement(By.cssSelector("#Childrens")));
		s1.selectByIndex(1);
		
		Select s2 = new Select(driver.findElement(By.cssSelector("#Infants")));
		s2.selectByVisibleText("1");
		
		//more options click
		driver.findElement(By.cssSelector("#MoreOptionsLink")).click();
		driver.findElement(By.cssSelector("#AirlineAutocomplete")).click();
		driver.findElement(By.cssSelector("#AirlineAutocomplete")).sendKeys("Lot");
		Thread.sleep(4000);
		for(int i=0;i<=2;i++) { // autosugestive select
		driver.findElement(By.cssSelector("#AirlineAutocomplete")).sendKeys(Keys.ARROW_DOWN);
		}
		driver.findElement(By.cssSelector("#AirlineAutocomplete")).sendKeys(Keys.ENTER);
		
		//search for flights
		driver.findElement(By.cssSelector("#SearchBtn")).click();
		Thread.sleep(1000);
		
		//handle error message
		System.out.println(driver.findElement(By.cssSelector("#homeErrorMessage")).getText());
			
	}

}
