package com.seleniummavenproject.selenium_maven_project;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.When;

public class GreenKart {

	@When("Opening the first page")
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("Webdriver.chrome.driver", "D:\\Selenium\\chromedriver-win64\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		driver.manage().window().maximize();

		WebElement brocolli = driver.findElement(By.xpath("//input[@value='1']"));

		brocolli.clear();

		brocolli.sendKeys("8");

		Thread.sleep(3000L);

		List<WebElement> veggies = driver.findElements(By.xpath("//h4[@class='product-name']"));

		for (int i = 0; i <= 25; i++) {

			String v = veggies.get(i).getText();
			if (v.contains("Mushroom")) {

				driver.findElement(By.xpath("//button[text()='ADD TO CART']")).click();

				System.out.println(v+ "is in:" + i + "th index");
			

			}
		}

		Thread.sleep(3000L);

		driver.findElement(By.xpath("//img[@alt='Cart']")).click();

		Thread.sleep(3000L);

		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@class='promoCode']")).sendKeys("ABC");

		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		
		WebElement countries=driver.findElement(By.xpath("//select[@style='width: 200px;']"));
		
		Select cnt=new Select(countries);
		cnt.selectByVisibleText("India");
		System.out.println(cnt.getFirstSelectedOption().getText());
		
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		
//		driver.findElement(By.linkText("Terms & Conditions")).click();
//		
//		driver.findElement(By.xpath("//a[contains(text(),'Home']")).click();
		
		driver.findElement(By.xpath("//button[contains(text(),'Proceed')]")).click();
		
        
		
		driver.navigate().to("https://rahulshettyacademy.com/dropdownsPractise/");
        
		
		driver.findElement(By.xpath("//input[@name='ctl00$mainContent$chk_StudentDiscount']")).click();

		Thread.sleep(2000L);

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

		List<WebElement> departurecity = driver.findElements(By.xpath("//a[@value='CJB']"));

		for (WebElement dc : departurecity) {

			dc.getText().equalsIgnoreCase("Coimbatore");
			dc.click();
			break;

		}

		WebElement arrival = wait.until
				(ExpectedConditions.elementToBeClickable(By.cssSelector("#ctl00_mainContent_ddl_destinationStation1_CTXT")));
		arrival.click();
		
		
try {
	List<WebElement> arrivalcity = driver.findElements(By.xpath("//a[@value='COK']"));

	for (WebElement ac : arrivalcity) {

		ac.getText().equalsIgnoreCase("Kochi");
		ac.click();
		break;
	}
} catch (ElementNotInteractableException e) {
	e.getCause();
	System.out.println(e.getCause());
	
	System.out.println("Element not interceptable exception");
	
}
		
try {
	
	driver.findElement(By.id("ctl00_mainContent_view_date1")).click();
//	driver.findElement(By.xpath("//td[@data-month='8']")).click();
//	driver.findElement(By.xpath("//a[text()='28']"));

	
} catch (ElementNotInteractableException e) {
	
	System.out.println("Catch the ENI Exception");
}
			
		

		WebElement currency = driver.findElement(By.xpath("//select[@id='ctl00_mainContent_DropDownListCurrency']"));

		Select curr = new Select(currency);
		curr.selectByVisibleText("INR");
//		curr.selectByIndex(1);
		System.out.println(curr.getFirstSelectedOption().getText());

		Thread.sleep(2000L);

	
	driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();
	
} 
	

		
	}


