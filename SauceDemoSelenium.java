import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

public class SauceDemo {

	public static void main(String[] args) throws InterruptedException, WebDriverException, IOException {
		
		
		System.setProperty("Webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/v1/");
		
		Thread.sleep(2000L);
		
		driver.manage().window().maximize();
		
		Thread.sleep(3000L);
		
		driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
		
		Thread.sleep(3000L);
		
		driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
		
		Thread.sleep(3000L);
		
		driver.findElement(By.cssSelector("#login-button")).click();
		
		Thread.sleep(3000L);
		
		driver.findElement(By.cssSelector("#item_1_title_link > div")).click();
		
		Thread.sleep(3000L);
		
		driver.findElement(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div/button")).click();
		
		Thread.sleep(3000L);
		
		driver.findElement(By.cssSelector("#shopping_cart_container > a > svg > path")).click();
		
		Thread.sleep(3000L);
		
		driver.findElement(By.xpath("//*[@id=\"cart_contents_container\"]/div/div[2]/a[2]")).click();
		
		Thread.sleep(2000L);
		
		driver.findElement(By.cssSelector("#first-name")).sendKeys("Pranesh");
		
		 Thread.sleep(2000L);
		
		driver.findElement(By.cssSelector("#last-name")).sendKeys("Bala");
		
		 Thread.sleep(2000L);
	        
		driver.findElement(By.cssSelector("#postal-code")).sendKeys("641035");
		
		 Thread.sleep(2000L);
	        
		driver.findElement(By.xpath("//*[@id=\"checkout_info_container\"]/div/form/div[2]/input")).click();
		
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath("//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]/a[2]")).click();
		
		Thread.sleep(2000L);
		
		File screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		Files.copy(screenshot, new File("C:\\Users\\Praneshbala\\Downloads\\Selenium Screenshots\\SauceDemo.jpeg"));
		
		System.out.println("The Screenshot of order placed:" + screenshot);
		
		driver.getPageSource();
		
//		System.out.println(driver.getPageSource());
		
		driver.getCurrentUrl();
		
		System.out.println(driver.getCurrentUrl());
		
		if(driver.getCurrentUrl().contains("https://www.saucedemo.com/v1/checkout-complete.html")) {
			System.out.println("Hurray!The order placed successfully!");
			
		}else
				System.out.println("Oops!There's some bug!");
		
		 Thread.sleep(2000L);
		
		driver.navigate().to("https://www.saucedemo.com/v1/");
		
		 Thread.sleep(2000L);
		
		driver.findElement(By.cssSelector("#user-name")).sendKeys("performance_glitch_user");
		
		 Thread.sleep(2000L);
		
		driver.findElement(By.cssSelector("#password")).sendKeys("secret_sauce");
		
		Thread.sleep(3000L);
		
		driver.findElement(By.cssSelector("#login-button")).click();
		
		Thread.sleep(3000L);
		
		driver.findElement(By.xpath("//*[@id=\"item_1_title_link\"]/div")).click();
		
		Thread.sleep(3000L);
		
        driver.findElement(By.xpath("//*[@id=\"inventory_item_container\"]/div/div/div/button")).click();
        
        Thread.sleep(2000L);
        
        driver.getTitle();
        
        driver.getCurrentUrl();
        
        System.out.println(driver.getCurrentUrl());
        
        System.out.println(driver.getTitle());
        
        if(driver.getCurrentUrl().contains("https://www.saucedemo.com/v1/inventory-item.html?id=1")) {
        	System.out.println("Bravo!Item added to the cart!");
        }
        else
        	System.out.println("Sorry dear!Item is not added to the cart!Try after sometimes!");
        
        Thread.sleep(2000L);
        
        driver.findElement(By.xpath("//*[@id=\"menu_button_container\"]/div/div[3]/div/button")).click();
        
        Thread.sleep(2000L);
        
        driver.findElement(By.cssSelector("#logout_sidebar_link")).click();
		}
	
		
	}






    

