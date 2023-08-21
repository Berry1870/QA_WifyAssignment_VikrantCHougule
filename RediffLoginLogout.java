package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
/*
 * Scenario: 
 * 1.Go to url https://www.rediff.com/
 * 2.click on signin link
 * 3.enter valid username
 * 4.enter valid password
 * 5.click on signin button
 * 6.validate for inbox page
 * 7.click on logout link
 * 
 */
public class RediffLoginLogout {
public static void main(String[] args) {
		
		//launch browser
		WebDriver driver = new ChromeDriver();
		
		//maximize browser window
		driver.manage().window().maximize();
		
		//go to given url
		driver.get("https://mail.rediff.com/cgi-bin/login.cgi");
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//enter valid username
		WebElement usernameTF = driver.findElement(By.name("login"));
		usernameTF.sendKeys("vikrant.qa");
		
		//enter valid password
		WebElement pwdTF = driver.findElement(By.id("password"));
		pwdTF.sendKeys("Kiran@8789");
		
		//click on signin button
		driver.findElement(By.name("proceed")).click();
		
		//You will proceed to inbox page of the rediffmail
		
		//validation for inbox page
		WebElement inboxText = driver.findElement(By.xpath("//a[text()='Vikrant Chougule']"));
		
		//click on logout link on page
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		
		//validate for successful logout
		WebElement logoutSucessful = driver.findElement(By.xpath("//p[text()='You have successfully signed out of Rediffmail.']"));
		System.out.println("----Login and Logout actions are performed successfully------------");
	
		driver.quit();
	}
}
