import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MySQLTestingSelenium {

	public static void main(String[] args) throws InterruptedException   {
		
		String username=null;
		
		String userpassword=null;
		
		try {

			Connection conn=DriverManager
					.getConnection("jdbc:mysql://localhost:3306/userdetails", "root", "johnwick88");
			
			Statement st=conn.createStatement();
			
			ResultSet rst=st.executeQuery("SELECT * FROM USERDETAILS");
			
			while(rst.next()) {
				
				username=rst.getString("username");
				
				userpassword=rst.getString("userpassword");
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		System.out.println("username:"+username);
		
		System.out.println("userpassword:"+userpassword);
		

		
		System.getProperty("Webdriver.gecko.driver", "D:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		
		WebDriver driver=new FirefoxDriver();
		
		driver.get("https://www.instagram.com/?hl=en");
		
		Thread.sleep(2000L);
		
		driver.manage().window().maximize();
		
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath("//input[@aria-label='Phone number, username, or email']"))
		                       .sendKeys("");
		
		Thread.sleep(2000L);
		
		driver.findElement(By.xpath("//input[@aria-label='Password']"))
		                        .sendKeys("");
		
		Thread.sleep(2000L);
		
//		driver.findElement(By.xpath("//button[@class=' _acan _acap _acas _aj1- _ap30']"))
//		                         .click();
		
		driver.findElement(By.cssSelector("#loginForm > div > div:nth-child(3)")).click();
	}
	
	
 
}
