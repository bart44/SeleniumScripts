import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoITExample {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bartek\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://txt-na-pdf.konwerter-online.pl/");
		
		driver.findElement(By.xpath("//span[@class='btn btn-primary btn-lg btn-file']")).click();
		Thread.sleep(3000);
		
		Runtime.getRuntime().exec("C:\\Users\\Bartek\\Desktop\\fileUpload.exe");

	}

}
