package com.seleniummavenproject.selenium_maven_project;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRMDemo {

	public static void main(String[] args) throws InterruptedException {
		

		System.setProperty("Webdriver.chrome.driver", 
				"D:\\Selenium\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		Thread.sleep(2000L);
		
     	driver.findElement(By.linkText("Upgrade")).click();
		
//		driver.findElement(By.xpath("//button[@size='large']")).click();
		
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath("//a[@class='btn btn-ohrm']")).click();
		
	//	driver.findElement(By.linkText("Book a Free Demo")).click();
	
		Thread.sleep(3000L);
		
		driver.findElement(By.xpath("//input[@placeholder='Your Full Name*']")).sendKeys("Prana");
		
		driver.findElement(By.xpath("//input[@placeholder='Phone Number*']")).sendKeys("7358749725");
		
		driver.findElement(By.xpath("//input[@placeholder='Email*']")).sendKeys("prana@gmail.com");
		
		driver.findElement(By.xpath("//input[@placeholder='Company Name*']")).sendKeys("Yosicare");
		
		System.out.println(driver.getCurrentUrl());
		
		System.out.println(driver.getTitle());
		
		Thread.sleep(2000L);
		
		List<WebElement> countries=driver.findElements(By.xpath("//select[@name='Country']"));
		
		for(WebElement c:countries) {
			c.getText().equalsIgnoreCase("India");
			c.click();
			break;
		
		
			}
			
		
		
		driver.close();
		
		

	}

}
