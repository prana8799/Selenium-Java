package com.seleniummavenproject.selenium_maven_project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class IFrameDemo {

	public static void main(String[] args) {
		
		System.setProperty("Webdriver.gecko.driver", 
				"D:\\Selenium\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver=new EdgeDriver();
		
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		driver.manage().window().maximize();
		
		driver.switchTo().frame(0);
		
		WebElement ifr=driver.findElement(By.xpath("//a[@class='btn btn-theme btn-sm btn-min-block']"));
		
		ifr.click();
		
        driver.getCurrentUrl();
		
		System.out.println(driver.getCurrentUrl());
		
		driver.switchTo().defaultContent();
		
		driver.getCurrentUrl();
		
		System.out.println(driver.getCurrentUrl());

	}

}
