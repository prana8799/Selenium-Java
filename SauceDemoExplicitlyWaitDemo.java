import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SauceDemoExplicitlyWait {

	public static void main(String[] args) {
		
System.setProperty("Webdriver.gecko.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver=new EdgeDriver();
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(4));
		
		driver.get("https://www.saucedemo.com/v1/");
		
		driver.manage().window().maximize();
		
		WebElement username=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#user-name")));
		
		username.sendKeys("standard_user");
		
		WebElement password=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#password")));
		
		password.sendKeys("secret_sauce");
		
		WebElement loginbutton=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#login-button")));
		
		loginbutton.click();
		
		WebElement title=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#item_1_title_link > div")));
		
		title.click();
		
		WebElement container=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\\\"inventory_item_container\\\"]/div/div/div/button")));
		
		container.click();
		
		WebElement shopping_cart=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#shopping_cart_container > a > svg > path")));
		
		shopping_cart.click();
		
		WebElement container_cart=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\\\"cart_contents_container\\\"]/div/div[2]/a[2]")));
		
		container_cart.click();
		
		WebElement firstname=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#first-name")));
		
		firstname.sendKeys("Pranesh");
		
		WebElement lastname=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#last-name")));
		
		lastname.sendKeys("Bala");
		
		
		WebElement postalcode=wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#postal-code")));
		
		postalcode.sendKeys("641035");
		
		WebElement checkoutbutton=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\\\"checkout_info_container\\\"]/div/form/div[2]/input")));
		
		checkoutbutton.click();
		
		WebElement addtocart=wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\\\"checkout_summary_container\\\"]/div/div[2]/div[8]/a[2]")));
		
		addtocart.click();
		
		driver.getCurrentUrl();
		
		System.out.println(driver.getCurrentUrl());
		
		}

}
