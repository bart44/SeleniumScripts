import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wakacje {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bartek\\Documents\\chromedriver1.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.wakacje.pl/");
		
		Thread.sleep(1000);
		//destination
		driver.findElement(By.xpath("//span[@id='countrySelectBoxIt']")).click();
		Thread.sleep(1000);
		//select country ...
		driver.findElement(By.xpath("//label[contains(@class,'customCheckboxLabel')][contains(text(),'Grecja')]")).click();
		//... and regions
		driver.findElement(By.xpath("//label[contains(text(),'Kreta')]")).click();
		driver.findElement(By.xpath("//label[contains(text(),'Itaka')]")).click();
		for(int i=1;i<=50;i++) { driver.findElement(By.xpath("//div[@id='mCSB_2']")).sendKeys(Keys.ARROW_DOWN); } //scroll down
		driver.findElement(By.xpath("//label[contains(text(),'Santorini')]")).click();
		
		driver.findElement(By.cssSelector("a[id='directionsLbClose']")).click();
		
		//choose departure from date
		driver.findElement(By.xpath("//input[@id='departureDate']")).click();
		driver.findElement(By.xpath("//a[contains(@class,'ui-state-default ui-state-highlight ui-state-active ui-state-hover')]")).click();
		Thread.sleep(1000);
		
		//choose back from date
		driver.findElement(By.xpath("//input[@id='arrivalDate']")).click();
		driver.findElement(By.xpath("//a[contains(@class,'ui-state-default')][contains(text(),'30')]")).click(); //apr. last day of month
		

		//wyjazd z...
		driver.findElement(By.xpath("//span[@id='departureSelectBoxIt']")).click();
		driver.findElement(By.xpath("//div[contains(@class,'item clearfix plane current')]//li[12]//label[1]")).click();
		driver.findElement(By.xpath("//label[contains(text(),'Warszawa - Modlin')]")).click(); //uncheck modlin
		driver.findElement(By.xpath("//a[@id='departuresLbClose']")).click(); 
		
		//search
		driver.findElement(By.xpath("//a[@id='submitSearchBox']")).click(); 
		
		
		//sort
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='sort_ceny']")).click(); //cena
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Tanie Wczasy')]")));
		
		driver.findElement(By.xpath("//input[@id='service1']")).click(); //all inc
		driver.findElement(By.xpath("//input[@id='service2']")).click(); //HB
		driver.findElement(By.xpath("//a[@class='button buttonFilter btnYellow17']")).click();
		
		driver.close();


	}

}