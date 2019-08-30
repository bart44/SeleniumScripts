import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Wakacje {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bartek\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.wakacje.pl/");
		
		Thread.sleep(1000);
		//destination
		driver.findElement(By.xpath("//span[@id='countrySelectBoxIt']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[contains(@class,'skiLi roundTripLi')]//label[contains(@class,'customCheckboxLabel')][contains(text(),'Grecja')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//ul[@class='sc-1q6hgkc-2 fgGPaJ']//li[12]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//ul[@class='sc-1q6hgkc-2 fgGPaJ']//li[16]")).click();
		driver.findElement(By.xpath("//label[contains(text(),'Zakynthos')]")).click();
		driver.findElement(By.cssSelector("a[data-area='directionsLbClose']")).click();
		//driver.findElement(By.xpath(" //button[@class='klrijf-3 iJVyEd']")).click();
		
		//choose departure from date
		driver.findElement(By.xpath("//div[@class='sc-8xxjc9-3 iXhqzt']/div[2]/div[1]/div[2]/div[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@data-area='arrowRight']")).click();
		driver.findElement(By.xpath("//div[@data-area='selectDay_1']")).click();
		
		//choose departure to date
		driver.findElement(By.xpath("//div[@class='sc-8xxjc9-3 iXhqzt']/div[3]/div[1]/div[2]/div[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@data-area='selectDay_30']")).click();
		
		//wyjazd z...
		driver.findElement(By.xpath("//div[@class='ur928r-0 juhURJ']//div//div[@class='sc-1wozwni-6 gWrtSF']")).click();
		driver.findElement(By.xpath("//div[@class='sc-1ut6auo-0 kvLnHP']//li[12]//label[1]")).click();
		driver.findElement(By.xpath("//a[@class='sc-1k5fw92-0 iTwccG']")).click();
		driver.findElement(By.xpath("//a[@class='k5q3iu-0 bYWzdO']")).click(); //search
		
		
		//sort
		Thread.sleep(5000);
		driver.findElement(By.cssSelector("input[value='tanio']")).click();
		driver.findElement(By.xpath("//input[@name='HB - œniadania i obiadokolacje']")).click();
		driver.findElement(By.xpath("//button[@data-area='changeResult']")).click();
		
		driver.close();


	}

}