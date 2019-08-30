import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableExcercise {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bartek\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.qaclickacademy.com/practice.php");
		
		WebElement table = driver.findElement(By.id("product"));
		int row = table.findElements(By.tagName("tr")).size();
		System.out.println(row);
		int col = table.findElements(By.tagName("th")).size();
		System.out.println(col);
		
		WebElement row2 = driver.findElement(By.xpath("//body//tr[3]"));
		int count = row2.findElements(By.tagName("td")).size();
		
		for (int i=0;i<count;i++ ) {
			System.out.println(row2.findElements(By.tagName("td")).get(i).getText());
		}
	}
}
