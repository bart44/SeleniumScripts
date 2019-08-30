import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class getAttribute {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bartek\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.get("http://echoecho.com/htmlforms10.htm");
		//by xpath
		driver.findElement(By.xpath("//input[@value='Cheese']")).click();
		
		//when no attribute is unique
		int count = driver.findElements(By.xpath("//input[@name='group1']")).size();		
		for (int i=0; i<count; i++) {
			//System.out.println(driver.findElements(By.xpath("//input[@name='group1']")).get(i).getAttribute("value"));
			String txt = driver.findElements(By.xpath("//input[@name='group1']")).get(i).getAttribute("value");		
			if(txt.equals("Milk")) {
			driver.findElements(By.xpath("//input[@name='group1']")).get(i).click(); //click on the current one in for loop
			}
		}

	}

}
