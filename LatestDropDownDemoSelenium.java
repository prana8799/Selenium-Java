import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LatestDropDownDemo {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("Webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/#");
		
		driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_1")).click();
		
		Thread.sleep(2000L);
		
		for(int i=1;i<3;i++) {
			driver.findElement(By.cssSelector("#ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
		}
		Thread.sleep(2000L);

	
	for(int i=1;i>2;i++) {
		driver.findElement(By.cssSelector("#ctl00_mainContent_chk_SeniorCitizenDiscount")).click();
		
	}
	Thread.sleep(2000L);
	
	for(int i=0;i<1;i++) {
		driver.findElement(By.cssSelector("#autosuggest")).sendKeys("New Zealand");
		
	}
Thread.sleep(2000L);

driver.getCurrentUrl();
System.out.println("The Current URL is:" + driver.getCurrentUrl());
driver.close();
}
}
