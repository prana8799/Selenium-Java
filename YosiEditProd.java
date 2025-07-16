package automation.selenium.java;

import java.time.Duration;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EditProd {
    
    WebDriver driver;
    WebDriverWait wait;

    @BeforeMethod
    public void driverSetup() {
		System.setProperty("Webdriver.chrome.driver", "C:\\Selenium\\chromedriver-win64\\chromedriver.exe");
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
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//*[text()='MODIFY EXISTING PRACTICE']"))).click();
        
        WebElement practiceid = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//*[@id='search_practice']")));
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
        
        for(String handle : allWindowHandles) {
            if(!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                break;
            }
        }
        
        WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.xpath("//div[@class='col-md-10 text-center']")));
        
        if(logo.isDisplayed()) {
            System.out.println("Logo displayed");
        } else {
            System.out.println("Logo not displayed");
        }
        
        WebElement pname=driver.findElement(By.xpath("//*[@id='practice_name']"));
        
        System.out.println(pname.getAttribute("value"));
        
        WebElement pwebsite = driver.findElement(By.xpath("//*[@id='practice_website']"));
        
        System.out.println(pwebsite.getAttribute("Value"));
        
        WebElement pphone=driver.findElement(By.xpath("//*[@id='practice_phone']"));
        
        System.out.println(pphone.getAttribute("value"));
        
        WebElement paddress1=driver.findElement(By.xpath("//*[@id='practice_address1']"));
        
        System.out.println(paddress1.getAttribute("value"));
        
        WebElement paddress2=driver.findElement(By.xpath("//*[@id='practice_address2']"));
        
        
        String fieldValue = paddress2.getAttribute("value");

     
     if (fieldValue.isEmpty()) {
         System.out.println("The practice_address2 field is empty");
     } else {
         System.out.println("The practice_address2 field contains: " + fieldValue);
     }
        
        
        WebElement pzip=driver.findElement(By.xpath("//*[@id='practice_zip']"));
        
        System.out.println(pzip.getAttribute("value"));
        
        WebElement pcity=driver.findElement(By.xpath("//*[@id='practice_city']"));
        
        System.out.println(pcity.getAttribute("value"));
        
        WebElement pstate=driver.findElement(By.xpath("//*[@id='practice_state']"));
        
        System.out.println(pstate.getAttribute("value"));
        
        WebElement pbandappid=driver.findElement(By.xpath("//*[@id='bandwidth_app_id']"));
        
        System.out.println(pbandappid.getAttribute("value"));
        
        WebElement pbandfromno=driver.findElement(By.xpath("//*[@id='bandwidth_from_no']"));
        
        System.out.println(pbandfromno.getAttribute("value"));
        
        WebElement platitude=driver.findElement(By.xpath("//*[@id='practice_latitude']"));
        
        System.out.println(platitude.getAttribute("value"));
        
        WebElement plongitude=driver.findElement(By.xpath("//*[@id='practice_longitude']"));
        
        System.out.println(plongitude.getAttribute("value"));
        
        WebElement ptzid=driver.findElement(By.xpath("//*[@id='select2-practice_timezone_id-container']"));
        
        System.out.println(ptzid.getAttribute("title"));
        
        WebElement ptz=driver.findElement(By.xpath("//*[@id='practice_timezone_name']"));
        
        System.out.println(ptz.getAttribute("value"));
        
        WebElement emrpid=driver.findElement(By.xpath("//*[@id='emr_practice_id']"));
        
        System.out.println(emrpid.getAttribute("value"));
        
        WebElement emrdepid=driver.findElement(By.xpath("//*[@id='emr_department_id']"));
        
        System.out.println(emrdepid.getAttribute("value"));
        
        
        
        
        
        
        
        
        
        
        
        
    }
        @AfterMethod
        public void driverClose() {
        
        driver.quit();
    }
}
