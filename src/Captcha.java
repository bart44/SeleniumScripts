import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Captcha {

	public static int findFrame(WebDriver driver, By by) {
		driver.switchTo().defaultContent();
		int i = 0;
		int count = driver.findElements(By.tagName("iframe")).size();

		for (i = 0; i < count; i++) { // loop for all frames on page
			driver.switchTo().defaultContent();
			driver.switchTo().frame(i); // switch to each frame

			int count1 = driver.findElements(by).size(); // search for checkbox inside frame
			if (count1 > 0) {
				break;
			} else {
				System.out.println("countinue looping - wrong frame");
			}
 
		}
		driver.switchTo().defaultContent();
		return i;
	}

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bartek\\Documents\\chromedriver1.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.get("https://www.google.com/recaptcha/api2/demo");

		int number = findFrame(driver, By.xpath("//div[@class='recaptcha-checkbox-border']"));
		driver.switchTo().frame(number);
		driver.findElement(By.xpath("//div[@class='recaptcha-checkbox-border']")).click();

		Thread.sleep(1500);

		int number1 = findFrame(driver, By.xpath(".//*[@id='recaptcha-verify-button']"));

		if (number1 != -1) {
			driver.switchTo().frame(number1);
			String pomin = driver.findElement(By.xpath(".//*[@id='recaptcha-verify-button']")).getText();
			System.out.println(pomin);
			driver.findElement(By.xpath(".//*[@id='recaptcha-verify-button']")).click();
			while (!pomin.equals("ZWERYFIKUJ")) {
				driver.findElement(By.xpath(".//*[@id='recaptcha-verify-button']")).click();
				String err = driver.findElement(By.xpath("//*[@id=\"rc-imageselect\"]/div[2]/div[4]")).getText();
				System.out.println(err);
			}
		} else {
			System.out.println("ops");
		}

	}
}