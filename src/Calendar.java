import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bartek\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.path2usa.com/travel-companions");
		
		//pick up date
		driver.findElement(By.xpath("//input[@id='travel_date']")).click();
		
		//loop and click next until it's April
		while (!driver.findElement(By.xpath("//div[@class='datepicker-days']//thead//tr[1]")).getText().contains("April")) {
			driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='next'][contains(text(),'»')]")).click();
		}
		
		//list of days in selected month
		List<WebElement> date = driver.findElements(By.className("day"));
		System.out.println(date);
		int count = driver.findElements(By.className("day")).size();
		
		for (int i=0;i<count;i++) {
			String text = driver.findElements(By.className("day")).get(i).getText();
			if(text.equalsIgnoreCase("23")) {
				driver.findElements(By.className("day")).get(i).click();
				break;
			}
		}
		

	}

}