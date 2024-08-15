import java.util.List;
import java.util.Set;

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
		
		System.out.println(driver.getPageSource());
		
		if(driver.getPageSource().contains("IE=edge")) {
			System.out.println("PHP");
		}
		
		else
			System.out.println("!");
		
     	driver.findElement(By.linkText("Upgrade")).click();
		
//		driver.findElement(By.xpath("//button[@size='large']")).click();
		
		Thread.sleep(5000L);
		
		
		Set<String> windowHandles = driver.getWindowHandles();
        String newWindowHandle = null;
        for (String handle : windowHandles) {
            if (!handle.equals(driver.getWindowHandle())) {
                newWindowHandle = handle;
                break;
            }
        }
        if (newWindowHandle != null) {
            driver.switchTo().window(newWindowHandle);
        }
		
	    driver.findElement(By.linkText("Book a Free Demo")).click();
	
		Thread.sleep(3000L);
		
		driver.findElement(By.xpath("//input[@placeholder='Your Full Name*']")).sendKeys("Prana");
		
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath("//input[@placeholder='Phone Number*']")).sendKeys("7358749725");
		
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath("//input[@placeholder='Email*']")).sendKeys("prana@gmail.com");
		
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath("//input[@placeholder='Company Name*']")).sendKeys("Yosicare");
		
		Thread.sleep(2000L);
		
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
