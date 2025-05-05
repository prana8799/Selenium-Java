package Java;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EditLive {
	
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void driverSetup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }
    
    @Test
    public void edit() {
        driver.get("https://internalnew.yosicare.com/onboard/index.php");
        
        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("abirami.s@yosicare.com");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("Yosi1234$");
        driver.findElement(By.xpath("//button[contains(.,' Login ')]")).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='MODIFY EXISTING PRACTICE']"))).click();
        
        WebElement practiceid = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='search_practice']")));
        practiceid.click();

        Actions ac = new Actions(driver);
        ac.moveToElement(practiceid)
          .sendKeys("136109").pause(2000)
          .keyDown(Keys.ARROW_DOWN)  
          .sendKeys(Keys.ENTER)      
          .perform();
        
        String mainWindowHandle = driver.getWindowHandle();
        driver.findElement(By.xpath("//a[contains(.,'Edit')]")).click();
        
        Set<String> allWindowHandles = driver.getWindowHandles();
        String newWindowHandle = "";
        
        for(String handle : allWindowHandles) {
            if(!handle.equals(mainWindowHandle)) {
                newWindowHandle = handle;
                driver.switchTo().window(handle);
                break;
            }
        }
        
        WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//div[@class='col-md-10 text-center']")));
        
        if(logo.isDisplayed()) {
            System.out.println("\n \n Logo displayed");
        } else {
            System.out.println("\n \n Logo not displayed");
        }
        
        verifyFieldValue("Practice name", "//*[@id='practice_name']", "AdvancedMD Test-02 (94)");
        verifyFieldValue("Practice website", "//*[@name='practice_website']", "https://www.yosicare.com");
        verifyFieldValue("Phone number", "//*[@id='practice_phone']", "9176699765");
        verifyFieldValue("Address1", "//*[@name='practice_address1']", "109 Lex Ave");
        verifyFieldValue("Zipcode", "//*[@name='practice_zip']", "10109");
        verifyFieldValue("City", "//input[@id='practice_city']", "New York");
        verifyFieldValue("State", "//input[@name='practice_state']", "NY");
        verifyFieldValue("Bandwidth application ID", "//input[@name='bandwidth_app_id']", "1");
        verifyFieldValue("Bandwidth from number", "//input[@id='bandwidth_from_no']", "1");
        verifyFieldValue("Latitude", "//*[@name='practice_latitude']", "40.76487000");
        verifyFieldValue("Longitude", "//*[@id='practice_longitude']", "-73.48911000");
        verifyFieldValue("Timezone", "//*[@name='practice_timezone_name']", "Eastern Standard Time");
        verifyFieldValue("Office Key", "//*[@name='emr_practice_id']", "991569");
        verifyFieldValue("Department ID", "//*[@name='emr_department_id']", "94");
        
        Select stt = new Select(driver.findElement(By.xpath("//select[@name='practice_timezone_id']")));
        stt.selectByVisibleText("America/New_York");
        String tzcity = stt.getFirstSelectedOption().getText();
        System.out.println("\n \n Practice time zone ID: " + tzcity);
        
        driver.switchTo().window(mainWindowHandle);
        
    }
    
    private void verifyFieldValue(String fieldName, String xpath, String expectedValue) {
        WebElement element = driver.findElement(By.xpath(xpath));
        String actualValue = element.getAttribute("value");
        
        if(expectedValue.equals(actualValue)) {
            System.out.println("\n \n " + fieldName + " verified successfully");
        } else {
            System.out.println("\n \n " + fieldName + " mismatched. Expected: " + expectedValue + ", Actual: " + actualValue);
        }
    }
    
    @AfterMethod
    public void driverClose() {
        driver.quit();
    }
}
