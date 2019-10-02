import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class e2e {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bartek\\Documents\\chromedriver1.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://spicejet.com");
						
		//select dropdown menu - many variations selectBy
		Select s = new Select(driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']")));
		s.selectByValue("USD");
		s.selectByIndex(2);
		s.selectByVisibleText("INR");
		
		//button in dropdown menu
		driver.findElement(By.xpath("//*[@id=\"divpaxinfo\"]")).click();
		Thread.sleep(300); //dropdown needs some time to initiate
		for (int i=1;i<=2;i++) {
		driver.findElement(By.xpath("//span[@id='hrefIncAdt']")).click();
		}		
		driver.findElement(By.xpath("//*[@id=\"hrefIncInf\"]")).click();		
		driver.findElement(By.xpath("//*[@id=\"btnclosepaxoption\"]")).click();
		System.out.println(driver.findElement(By.xpath("//div[@id='divpaxinfo']")).getText());
		
		
		//dropdown menu for flights (dynamic dropdown)
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Bengaluru (BLR)')]")).click();
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR']//a[contains(text(),'Amritsar (ATQ)')]")).click();
		Thread.sleep(300);
		 
		//calendar
		driver.findElement(By.xpath("//a[contains(@class,'ui-state-default ui-state-highlight')]")).click();
				
		//checkboxes
		System.out.println("checkboxes:" + driver.findElements(By.xpath("//input[@type='checkbox']")).size());		
		System.out.println("selected checkbox:" + driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
		driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).click();
		System.out.println("selected checkbox:" + driver.findElement(By.id("ctl00_mainContent_chk_friendsandfamily")).isSelected());
		
		
		//checkboxes testNG
		System.out.println("checkboxes:" + driver.findElements(By.xpath("//input[@type='checkbox']")).size());		
		Assert.assertFalse(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());//java.lang.AssertionError: expected [false] but found [true]
		driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
		Assert.assertTrue(driver.findElement(By.id("ctl00_mainContent_chk_SeniorCitizenDiscount")).isSelected());
			
		
		//koleczka button + calendar + TestNG
		Assert.assertFalse(driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_1")).isSelected());
		driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_1")).click();
		driver.findElement(By.xpath("//div[@id='Div1']//button[contains(@class,'ui-datepicker-trigger')]")).click();
		driver.findElement(By.xpath("//a[contains(@class,'ui-state-default ui-state-active')]")).click();
		
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("1")) {
			System.out.println("its enabled");
			Assert.assertTrue(true);
		} else { Assert.assertTrue(false); } //bo roundtrip selected
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='ctl00_mainContent_btn_FindFlights']")));
		driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#taxAndFeeInclusiveDivHeader")));
		Assert.assertTrue(driver.findElement(By.id("taxAndFeeInclusiveDivHeader")).isDisplayed());
		
		driver.close();
	}

}
