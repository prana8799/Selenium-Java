package automation.selenium.java;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Dashboard_Preprod {
    
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    
    @BeforeClass
    public void setUp() {
    	 WebDriverManager.chromedriver().clearDriverCache();
         
         ChromeOptions options = new ChromeOptions();
         options.addArguments("--remote-allow-origins=*");
         options.addArguments("--disable-blink-features=AutomationControlled");
         options.addArguments("--start-maximized");
         options.addArguments("--no-sandbox");
         options.addArguments("--disable-dev-shm-usage");
         
         driver = new ChromeDriver(options);
         wait = new WebDriverWait(driver, Duration.ofSeconds(20));
         js = (JavascriptExecutor) driver;
         
         // Implicit wait
         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
    }
    
    @Test(priority = 1)
    public void testLogin() {
        driver.get("https://preprodportal.yosicare.com/");
        
        // Login
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='email']"))).sendKeys("777800qa@yopmail.com");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='password']"))).sendKeys("YosiDec2025$");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='submit']"))).click();
    }
    
    @Test(priority = 2, dependsOnMethods = "testLogin")
    public void testSkipAndSelectLocation() {
        // Skip
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Skip']"))).click();
        
        driver.findElement(By.xpath("(//div//span[contains(text(),'Select Your Location')])[2]")).click();
        driver.findElement(By.xpath("(//ul//li[@data-value='2'])[2]")).click();
    }
    
    @Test(priority = 3, dependsOnMethods = "testSkipAndSelectLocation")
    public void testInvitePatients() {
        driver.findElement(By.xpath("//a[text()='Invite Patients']")).click();
        
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[text()='Single Invitation'])[1]"))).click();
    }
    
    @Test(priority = 4, dependsOnMethods = "testInvitePatients")
    public void testFillPatientDetails() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='First Name']"))).sendKeys("Natalie");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Last Name']"))).sendKeys("Testpatient");
        driver.findElement(By.xpath("//*[@id='dob_datepicker']")).sendKeys("07/08/1999");
        
        Thread.sleep(4000);
        
        WebElement gender = driver.findElement(By.xpath("//div//span[text()='Gender']"));
        js.executeScript("arguments[0].click();", gender);
        
        WebElement female = driver.findElement(By.xpath("//li[text()='Female']"));
        js.executeScript("arguments[0].click();", female);
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Phone Number']"))).sendKeys("9174360311");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email"))).sendKeys("praneshbalamurugan.m@yosicare.com");
        
        WebElement datetime = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Appt.Date']")));
        datetime.clear();
        datetime.sendKeys("03/04/2026 11:00 PM");
        datetime.click();
    }
    
    @Test(priority = 5, dependsOnMethods = "testFillPatientDetails")
    public void testSelectAppointmentType() {
        driver.findElement(By.xpath("//div//span[text()='Appointment Type']")).click();
        driver.findElement(By.xpath("//*[@data-value='182']")).click();
    }
    
    @Test(priority = 6, dependsOnMethods = "testSelectAppointmentType")
    public void testDebugProviderElement() {
        // Debug provider element
        List<WebElement> elements = driver.findElements(By.xpath("//*[text()='1-Chris Bulkley (27)']/preceding::li[contains(text(),'Provider')]"));
        System.out.println("Number of elements found: " + elements.size());
        
        if (elements.size() > 0) {
            System.out.println("Element text: '" + elements.get(0).getText() + "'");
            System.out.println("Element displayed: " + elements.get(0).isDisplayed());
            System.out.println("Element enabled: " + elements.get(0).isEnabled());
        }
    }
    
    @Test(priority = 7, dependsOnMethods = "testDebugProviderElement")
    public void testSelectProvider() {
        WebElement providerElement = wait.until(ExpectedConditions.presenceOfElementLocated(
            By.xpath("//li[contains(text(),'Provider')]")));
        js.executeScript("arguments[0].click();", providerElement);
    }
    
    @Test(priority = 8, dependsOnMethods = "testSelectProvider")
    public void testSelectSpecificProvider() {
        wait.until(ExpectedConditions.elementToBeClickable(
            By.xpath("//li[text()='1-Chris Bulkley (27)']/following-sibling::li[text()='AbiramiSelvaraj (144)']"))).click();
    }
    
    @Test(priority = 9, dependsOnMethods = "testSelectSpecificProvider")
    public void testSelectLocation() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div//span[text()='Location']")).click();
        driver.findElement(By.xpath("(//li[@data-value='777801'])")).click();
    }
    
    @Test(priority = 10, dependsOnMethods = "testSelectLocation")
    public void testSendSMS() throws InterruptedException {
        Thread.sleep(4000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@value='Send SMS']"))).click();
        Thread.sleep(10000);
    }
    
    @AfterClass
    public void tearDown() {
        // Close browser
        if (driver != null) {
            driver.quit();
        }
    }
}
