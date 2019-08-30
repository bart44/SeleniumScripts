import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TablesExercise {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Bartek\\Documents\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.cricbuzz.com/live-cricket-scorecard/20714/eng-vs-ire-only-test-ireland-tour-of-england-only-test-2019");
		
		WebElement table = driver.findElement(By.xpath("//body/div[@class='page']/div[@id='page-wrapper']/div[@class='cb-col cb-col-100 cb-bg-white']/div[@class='cb-col cb-col-67 cb-scrd-lft-col html-refresh ng-isolate-scope']/div[@id='innings_1']/div[1]"));
		int size = table.findElements(By.cssSelector("div.page:nth-child(5) div.container:nth-child(2) div.cb-col.cb-col-100.cb-bg-white:nth-child(6) div.cb-col.cb-col-67.cb-scrd-lft-col.html-refresh.ng-isolate-scope:nth-child(2) div.ng-scope:nth-child(2) div.cb-col.cb-col-100.cb-ltst-wgt-hdr:nth-child(1) div.cb-col.cb-col-100.cb-scrd-itms:nth-child(3) > div.cb-col.cb-col-8.text-right.text-bold:nth-child(3)")).size();
		System.out.println(size);
		
		int sum = 0;
		for (int i=0;i<size-1;i++) {
			String tot = table.findElements(By.cssSelector("div.page:nth-child(5) div.container:nth-child(2) div.cb-col.cb-col-100.cb-bg-white:nth-child(6) div.cb-col.cb-col-67.cb-scrd-lft-col.html-refresh.ng-isolate-scope:nth-child(2) div.ng-scope:nth-child(2) div.cb-col.cb-col-100.cb-ltst-wgt-hdr:nth-child(1) div.cb-col.cb-col-100.cb-scrd-itms:nth-child(3) > div.cb-col.cb-col-8.text-right.text-bold:nth-child(3)")).get(i).getText();
			int total = Integer.parseInt(tot);
			sum=sum+total;
			
		}
		System.out.println(sum);
		
	}

}
