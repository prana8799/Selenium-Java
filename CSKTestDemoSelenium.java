import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.google.common.io.Files;

public class ChennaiSuperKingsTestDemo {

	public static void main(String[] args) throws InterruptedException {
		
		 System.setProperty("Webdriver.gecko.driver",
	                "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");

	        WebDriver driver = new FirefoxDriver();
	        
	        driver.get("https://www.chennaisuperkings.com/");
	        
	        driver.manage().window().maximize();
	        
	        Thread.sleep(2000L);
	        
	        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/div/div/ul[6]/li/a")).click();
	        
	        Thread.sleep(2000L);
	        
	        driver.findElement(By.cssSelector("body > app-root > app-team-page > app-player-card > div > div > div.Players.ng-star-inserted > div:nth-child(1) > div > div.row.CardsRow.cardBottom.ng-star-inserted > div > div > div > div:nth-child(2) > div.col-6.fontForSub.text-center.ng-star-inserted > div"))
	                   .click();
	        
	        File sch=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	        
	        try {
				Files.copy(sch, new File("D:\\Selenium Screenshots\\Thala Dhoni.jpeg"));
			} catch (IOException e) {
				
				e.printStackTrace();
			}
	        
	        Thread.sleep(2000L);
	        
	        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/div/div/ul[2]/li/a")).click();
	        
	        driver.getCurrentUrl();
	        
	        System.out.println(driver.getCurrentUrl());
	        
	        Thread.sleep(2000L);
	        
	        driver.findElement(By.xpath("//*[@id=\"header\"]/div[2]/div/div/div/div/ul[7]/li/a")).click();
	        
	        Thread.sleep(2000L);
	        
	        driver.findElement(By.xpath("//*[@id=\"navbarSupportedContent\"]/ul/li[4]/a")).click();
	        
	        Thread.sleep(2000L);
	        
	        driver.findElement(By.id("name")).sendKeys("Pranesh");
	        
	        Thread.sleep(2000L);
	        
	        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("KG");
	        
	        Thread.sleep(2000L);
	        
	        driver.findElement(By.cssSelector("#name")).sendKeys("pran87@yahoo.com");
	        
	        Thread.sleep(2000L);
	        
	        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("7358749725");
	        
	        Thread.sleep(2000L);
	        
	        driver.findElement(By.cssSelector("#name")).sendKeys("India");
	        
	        Thread.sleep(2000L);
	        
	        driver.findElement(By.id("name")).sendKeys("Tamil Nadu");
	        
	        Thread.sleep(2000L);
	        
	        driver.findElement(By.xpath("//*[@id=\"name\"]")).sendKeys("Coimbatore");
	        
	        Thread.sleep(2000L);
	        
	       driver.findElement(By.xpath("//*[@id=\"swiper-wrapper-460c35eb71ada9f4\"]/div[1]/div/form/div[8]")).click();
	        
	
	}

}
