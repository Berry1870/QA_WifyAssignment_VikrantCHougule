package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
/*
 * NOTE: To keep things simple and understandable, I have written script for valid inputs only
 * and captcha and OTP verification cannot be automated, so i have handled it MANUALLY
 * 
 */
public class RediffSignupScript {

	public static void main(String[] args) throws InterruptedException {
		
		//launch browser
		WebDriver driver = new ChromeDriver();
		
		//maximize browser window
		driver.manage().window().maximize();
		
		//go to given url
		driver.get("https://register.rediff.com/register/register.php?FormName=user_details");
		
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		//enter valid username
		WebElement FN = driver.findElement(By.xpath("//td[text()='Full Name']/..//input[@onblur='fieldTrack(this);']"));
		FN.sendKeys("Vikrant Chougule");
		
		//enter valid email id
		WebElement emailID = driver.findElement(By.xpath("//td[text()='Choose a Rediffmail ID']/..//input[@onblur='fieldTrack(this);']"));
		emailID.sendKeys("vikrant.qa");
		
		//click on check availability button
		WebElement checkBtn = driver.findElement(By.xpath("//input[@value='Check availability']"));
		checkBtn.click();

		System.out.println("Entered Email ID is avaialble");

		//assume that password is Kiran@8789
		String PWD = "Kiran@8789";
		
		//enter the password
		WebElement pwd = driver.findElement(By.id("newpasswd"));
		pwd.sendKeys(PWD);
		
		//confirm the entered password
		WebElement confirmPwd = driver.findElement(By.xpath("//td[text()='Retype password']/..//input[@type='password']"));
		confirmPwd.sendKeys(PWD);
		
		//enter alternative email id
		WebElement alterEmailID = driver.findElement(By.xpath("//td[text()='Alternate Email Address']/..//input[@type='text']"));
		alterEmailID.sendKeys("vikrantchougule71@gmail.com");
		
		//enter mobile number
		WebElement mobileNo = driver.findElement(By.id("mobno"));
		mobileNo.sendKeys("9370523445");
			
		//assume that DOB is 20th August, 2002
		WebElement day = driver.findElement(By.xpath("(//td[text()='Date of Birth']/..//select[@onchange='fieldTrack(this);'])[1]"));
		Select s1 = new Select(day);
		s1.selectByValue("20");
		
		WebElement month = driver.findElement(By.xpath("(//td[text()='Date of Birth']/..//select[@onchange='fieldTrack(this);'])[2]"));
		Select s2 = new Select(month);
		s2.selectByValue("08");
		
		WebElement year = driver.findElement(By.xpath("(//td[text()='Date of Birth']/..//select[@onchange='fieldTrack(this);'])[3]"));
		Select s3 = new Select(year);
		s3.selectByValue("2002");
		
		//assume that city is Mumbai
		WebElement city = driver.findElement(By.xpath("//td[@align='right']/..//select[@onchange='showothcity();fieldTrack(this);']"));
		Select s4 = new Select(city);
		s4.selectByValue("Mumbai");
		
		System.out.println("Entered all mandatory fields except captcha which will be handled MANUALLY");
		
		//NOTE: captcha cannot be automated hence I am entering given captcha manually.
		//and then clicking on "Enter my account" button manually.
		//then it re-directed to OTP verification and further actions which we cannot automate, so its done via MANUALLY
	
		Thread.sleep(60000);
		driver.quit();
	}
}
