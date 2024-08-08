import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDownDemo {

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("Webdriver.gecko.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver=new FirefoxDriver();
		
		driver.get("https://selectorshub.com/xpath-practice-page/");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("#shub93")).sendKeys("Pranesh");
		
		Thread.sleep(3000L);
		
		driver.findElement(By.id("pass")).sendKeys("thala87");
		
		Thread.sleep(3000L);
		
		driver.findElement(By.name("company")).sendKeys("KGISL");
		
		Thread.sleep(3000L);
		
		driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/section[2]/div/div[1]/div/div[1]/div/div/div[1]/div/div/div/input[2]"))
		     .sendKeys("7358749725");
		
		Thread.sleep(3000L);
		
		driver.findElement(By.xpath("//button[@value='submit']")).click();
		
		Thread.sleep(3000L);
		
		WebElement StaticDropdown=driver.findElement(By.cssSelector("#cars"));
		
		Select sdd=new Select(StaticDropdown);
		
		sdd.selectByVisibleText("audi");
		
		sdd.selectByValue("au");
		
		sdd.selectByIndex(8);
		
		System.out.println(sdd.getFirstSelectedOption().getText());

	}

}
