package com.seleniummavenproject.selenium_maven_project;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import com.google.common.io.Files;

public class JPetStoreDemo {
	
	public static void main(String args[]) throws InterruptedException, IOException {
		System.setProperty("Webdriver.chrome.driver", 
				"D:\\Selenium\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://petstore.octoperf.com/actions/Catalog.action");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//img[@src='../images/dogs_icon.gif']")).click();
		
		Thread.sleep(2000L);
		
		driver.findElement(By.linkText("K9-RT-01")).click();
		
		Thread.sleep(2000L);
		
		driver.findElement(By.linkText("EST-28")).click();
		
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath("//a[@class='Button']")).click();
		
		Thread.sleep(2000L);
		
		WebElement quantity=driver.findElement(By.xpath("//input[@name='EST-28']"));
		
		quantity.clear();
		
		quantity.sendKeys("8");
		
		Thread.sleep(2000L);
		
		driver.findElement(By.name("updateCartQuantities")).click();
		
		Thread.sleep(2000L);
		
		driver.findElement(By.linkText("Proceed to Checkout")).click();
		
		File sch=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		Files.copy(sch, new File("D:\\Selenium Screenshots\\Dog.png"));
		
		driver.getTitle();
		
		driver.getCurrentUrl();
		
		System.out.println(driver.getTitle());
		
		System.out.println(driver.getCurrentUrl());
		
		if(driver.getTitle().contains("JPetStore Demo") && driver.getCurrentUrl().contains("https://petstore.octoperf.com/actions/Order.action?newOrderForm=")){
			System.out.println("The pet purchased successfully!");
		}
		else {
			System.out.println("The pet purchase failed!");
		}
		
		driver.close();
		
	}

}
