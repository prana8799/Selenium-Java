package automation.selenium.java;

import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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

import io.github.bonigarcia.wdm.WebDriverManager;
import tech.grasshopper.excel.report.sheets.Sheet;

public class ElektraHealthTask {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wait = new WebDriverWait(driver, Duration.ofSeconds(60));
    }

    @SuppressWarnings("static-access")
	@Test
    public void testSchedulePage() throws InterruptedException {
        driver.get("https://schedule.yosicare.com/4fa0b9451c6bed737da10459f752aec7");
        
       
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@optval='Initial Clinical Visit']"))).click();
        
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Please select an option'])[1]"))).click();
        
        WebElement loc=
        		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//select[@class='select2 ques_search_select required_select select2-hidden-accessible'])[1]")));
        
 
        
        Select sl=new Select(loc);
        
        List<WebElement> options = sl.getOptions();
        
        for(WebElement option : options) {
            System.out.println("\n"+option.getText());
        }
        
      
        
     
        Actions actions=new Actions(driver);
        actions.moveToElement(loc).
        sendKeys("Connecticut").keyDown(Keys.ENTER).
        perform();
        
        
        
        WebElement ins=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Please select an option'])[1]")));
        ins.click();
        
        
        Actions ac=new Actions(driver);
        ac.moveToElement(ins).keyDown(Keys.SHIFT.DOWN).keyDown(Keys.ENTER).perform();
        
        
        WebElement providers=
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='View profile']")));
        providers.click();
        
        List<WebElement> aetnact = driver.findElements(By.xpath("//div[@class='flex flex-col left_block']"));
        System.out.println("\n \n \n \n \n Total no. of providers at Aetna CT: " + aetnact.size());
        
        if(aetnact.isEmpty()) {
        	System.out.println("\n \n No providers present in the selected location and insurance!");
        }
        
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Go back']"))).click();
       
       
       WebElement nxt=
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Please select an option'])[1]")));
       
       nxt.click();
       
       Actions a=new Actions(driver);
       
       a.moveToElement(nxt).sendKeys("Connecticare").keyDown(Keys.ENTER).perform();
       
       Thread.sleep(3000);
              
       
       List<WebElement> connproviders=driver.findElements(By.xpath("//div//div[@class='flex flex-col left_block']"));
       System.out.println("\n \n Total no. of providers at Connecticare: "+connproviders.size());
       
       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Go back']"))).click();

//1st one
       
       
       WebElement nxt1=
    	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Please select an option'])[1]")));
    	       
    	       nxt1.click();
    	       
    	       Actions at=new Actions(driver);
    	       
    	       at.moveToElement(nxt1).sendKeys("anthem bcbs ct").keyDown(Keys.ENTER).perform();
    	       
    	       Thread.sleep(3000);
    	       
    	       List<WebElement> anthect =driver.findElements(By.xpath("//div[@class='ws_provider_slot_details']"));
    	       System.out.println("\n \n Total no. of providers at Anthem BCBS CT: "+anthect.size());
       
    	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Go back']"))).click();
    	       
    	//2nd  one       
    	       
    	       
    	       WebElement nxt2=
    	    	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Please select an option'])[1]")));
    	    	       
    	    	       nxt2.click();
    	    	       
    	    	       Actions a1=new Actions(driver);
    	    	       
    	    	       a1.moveToElement(nxt2).sendKeys("anthem bcbs ny").keyDown(Keys.ENTER).perform();
    	    	       
    	    	       Thread.sleep(3000);
    	    	       
    	    	       List<WebElement> antheny =driver.findElements(By.xpath("//h2[@class='Heading-module_heading Heading-module_small Heading-module_weight500 mb-2']"));
    	    	       System.out.println("\n \n Total no. of providers at Anthem BCBS NY: "+antheny.size());
    	    	       
    	    	       
    	    	       
    	    	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Go back']"))).click();
    	    	    
    	    	       
    	    //3rd one	       
    	    	       
    	    	       WebElement nxt3=
    	    	    	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Please select an option'])[1]")));
    	    	    	       
    	    	    	       nxt3.click();
    	    	    	       
    	    	    	       Actions a2=new Actions(driver);
    	    	    	       
    	    	    	       a2.moveToElement(nxt3).sendKeys("healthfirst").keyDown(Keys.ENTER).perform();
    	    	    	       
    	    	    	       Thread.sleep(3000);
    	    	    	       
    	    	    	       List<WebElement> hf =driver.findElements(By.xpath("//h2[@class='Heading-module_heading Heading-module_small Heading-module_weight500 mb-2']"));
    	    	    	       System.out.println("\n \n Total no. of providers at Healthfirst: "+hf.size());
    	    	    	       
    	    	    	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Go back']"))).click();
    	    	    	       
    	    	
    	    	    	       
    	    	    	       //4th one
    	    	    	       
    	    	    	       WebElement nxt5=
    	    	    	    	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Please select an option'])[1]")));
    	    	    	    	       
    	    	    	    	       nxt5.click();
    	    	    	    	       
    	    	    	    	       Actions a3=new Actions(driver);
    	    	    	    	       
    	    	    	    	       a3.moveToElement(nxt5).sendKeys("Emblemhealth").keyDown(Keys.ENTER).perform();
    	    	    	    	       
    	    	    	    	       Thread.sleep(3000);
    	    	    	    	       
    	    	    	    	       List<WebElement> emb =driver.findElements(By.xpath("//h2[@class='Heading-module_heading Heading-module_small Heading-module_weight500 mb-2']"));
    	    	    	    	       System.out.println("\n \n Total no. of providers at Emblemhealth: "+emb.size());
    	    	    	    	       
    	    	    	    	       
    	    	    	    	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Go back']"))).click();

    	    	    	 //5th one   
    	    	    	    	       
    	    	    	    	       
    	    	    	       WebElement nxt4=
    	    	    	    	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Please select an option'])[1]")));
    	    	    	    	       
    	    	    	    	       nxt4.click();
    	    	    	    	       
    	    	    	    	       Actions a4=new Actions(driver);
    	    	    	    	       
    	    	    	    	       a4.moveToElement(nxt4).sendKeys("my insurance").keyDown(Keys.ENTER).perform();
    	    	    	    	       
    	    	    	    	       if(driver.findElement(By.xpath("//div[contains(text(), 'If your insurance')]")) != null) {
    	    	    	    	    	   System.out.println("\n \n Verified that our insurance is not listed!");
    	    	    	    	    	   
    	    	    	    	    	   wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//span[@class and text()='Continue'])[1]")))).click();
    	    	    	    	    	   
    	    	    	    	    List<WebElement>	  noinsurance= 
    	    	    	    	    	   
    	    	    	    	    	   driver.findElements
    	    	    	    	    			   (By.xpath("//h2[@class='Heading-module_heading Heading-module_small Heading-module_weight500 mb-2']"));
    	    	    	    	    
    	    	    	    	    
    	    	    	    	    System.out.println("\n \n Total no. of providers without insurance:"+noinsurance.size());
    	    	    	    	    
    	    	    	    	    
    	    	    	    	    WebElement btn=
 	    	    	    	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Go back']")));
    	    	    	    	    
    	    	    	    	    JavascriptExecutor js = (JavascriptExecutor) driver;
    	    	    	    	    js.executeScript("arguments[0].click();", btn);
 	    	    	    	       
 	    	    	    	       Thread.sleep(3000);

    	    	    	    	    	  
    	    	    	    	       }

      //6th one
       
    	    	    	    	       WebElement nxt6=
    	    	    	    	    	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span[text()='Please select an option'])[1]")));
    	    	    	    	    	       
    	    	    	    	       JavascriptExecutor js = (JavascriptExecutor)driver;
    	    	    	    	       js.executeScript("arguments[0].click();", nxt6);
    	    	    	    	    	       
    	    	    	    	    	       Actions a5=new Actions(driver);
    	    	    	    	    	       
    	    	    	    	    	       a5.moveToElement(nxt6).sendKeys("cigna ny").keyDown(Keys.ENTER).perform();
    	    	    	    	    	       
    	    	    	    	    	      
    	    	    	    	    	    List<WebElement> cg= 
    	    	    	    	    	    	   
    	    	    	    	    	    	   driver.findElements
    	    	    	    	    	    			   (By.xpath("//h2[@class='Heading-module_heading Heading-module_small Heading-module_weight500 mb-2']"));
    	    	    	    	    	    
    	    	    	    	    	    
    	    	    	    	    	    System.out.println("\n \n Total no. of providers at Cigna NY:"+cg.size());
    	    	    	    	    	    
    	    	    	    	    	    WebElement btn1=
    	    	  	    	    	    	       wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Go back']")));
    	    	     	    	    	    	    
    	    	     	    	    	    	    JavascriptExecutor j= (JavascriptExecutor) driver;
    	    	     	    	    	    	    j.executeScript("arguments[0].click();", btn1);
    }
    	    	    	    	    	    
    	    	    	    	   //7th one
    	    	    	    	    	    
    	    	     	    	    	    	
    @Test
    public void exportResults() {
        Map<String, String> providerData = new LinkedHashMap<>();
        providerData.put("Aetna CT", "6");
        providerData.put("Connecticare", "7");
        providerData.put("Anthem BCBS CT", "7");
        providerData.put("Anthem BCBS NY", "5");
        providerData.put("Healthfirst", "4");
        providerData.put("Emblemhealth", "7");
        providerData.put("Not listed", "7");
        providerData.put("Cigna NY", "7");
        
        exportToExcel(providerData);
    }

    private void exportToExcel(Map<String, String> data) {
        String filePath = "C:\\Users\\Dell\\Downloads\\Untitled spreadsheet.xlsx"; 
        
      
        
        try (XSSFWorkbook workbook = new XSSFWorkbook();
             FileOutputStream outputStream = new FileOutputStream(filePath)) {
            
            XSSFSheet sheet = workbook.createSheet("Provider Data");
            
            // Create header row
            XSSFRow headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Provider Name");
            headerRow.createCell(1).setCellValue("Value");
            
            // Add data rows
            int rowNum = 1;
            for (Map.Entry<String, String> entry : data.entrySet()) {
                XSSFRow row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(entry.getKey());
                row.createCell(1).setCellValue(entry.getValue());
            }
            
            // Auto-size columns
            for (int i = 0; i < 2; i++) {
                sheet.autoSizeColumn(i);
            }
            
            workbook.write(outputStream);
            System.out.println("Excel file saved to: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    } 	       
    	    
       

   
       

        
        
    

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
           System.out.println("\n \n \n Test achieved successfully!");
           
           driver.quit();    
        }
           
    }
}
