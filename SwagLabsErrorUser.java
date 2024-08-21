package com.seleniummavenproject.selenium_maven_project;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.google.common.io.Files;

public class SauceDemoSelenium {

	public static void main(String[] args) throws InterruptedException, IOException  {
		
		System.setProperty("Webdriver.chrome.driver", 
				"D:\\Selenium\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("error_user");
		
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
		
		Thread.sleep(2000L);
		
		driver.findElement(By.id("login-button")).click();
		
		Thread.sleep(2000L);
		
		driver.findElement(By.partialLinkText("Backpack")).click();
		
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath("//button[@class='btn btn_primary btn_small btn_inventory']")).click();
		
		Thread.sleep(2000L);
		
		driver.findElement(By.linkText("1")).click();
		
		Thread.sleep(2000L);
		
		driver.findElement(By.id("checkout")).click();
		
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath("//input[@data-test='firstName']")).sendKeys("Pranesh");
		
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath("//input[@data-test='lastName']")).sendKeys("Balamurugan");
		
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath("//input[@name='postalCode']")).sendKeys("641035");
		
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath("//input[@id='continue']")).click();
		
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath("//button[@id='finish']")).click();
		
		System.out.println("The URL is: " + driver.getCurrentUrl());
		
		System.out.println("The Title is: " + driver.getTitle());
		
		File sch=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		Files.copy(sch, new File("D:\\Selenium Screenshots\\checkout.jpeg"));
		
                driver.getCurrentUrl();
		
		driver.getTitle();
		
		
		if(driver.getCurrentUrl().contains("https://www.saucedemo.com/checkout-step-two.html")
				&& driver.getTitle().contains("Swag Labs")) {
			System.out.println("Successfully purchased");
			
		}
		
		else
			System.out.println("Issue in purchase");
		
		driver.close();
	}
	
	}
	
