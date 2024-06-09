import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FB_FORGET_PASSWORD_VALIDATION {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("Webdriver.chrome.driver", "D:\\Selenium\\chromedriver_win32");
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.facebook.com/");
		
		driver.manage().window().maximize();
		
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
		
		driver.findElement(By.xpath("//input[@aria-label='Email address or phone number']"))
		
		                 .sendKeys("7358749725");
		
		Thread.sleep(2000L);
		
		driver.findElement(By.id("pass")).sendKeys("8888");
		
		Thread.sleep(2000L);
		
//     	driver.findElement(By.xpath("//button[@value='1']")).click();
	
		
//		driver.findElement(By.xpath("//*[@id=\"login_link\"]/div/a")).click();
		
		driver.findElement(By.linkText("Forgotten password?")).click();
		
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath("//input[@aria-label='Email address or mobile number']"))
		          .sendKeys("7358749725");
		
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath("//button[@value='1']")).click();
		
		Thread.sleep(2000L);
		
		driver.getTitle();
		
		System.out.println(driver.getTitle());
		
		driver.getCurrentUrl();
		
		System.out.println(driver.getCurrentUrl());
		
		if(driver.getTitle().contains("Forgotten Password | Can't Log In | Facebook")) {
			
			System.out.println("We're in the right page");
		
		       if(driver.getCurrentUrl()
		    		 .contains("https://www.facebook.com/login/identify/?ctx=recover&ars=facebook_login&from_login_screen=0"))
		{
			System.out.println("Able to find the account");
		}
		
		else
			
			System.out.println("Unable to find the account");
		
	}
		else
			
			System.out.println("we're in the wrong page");
}
}
