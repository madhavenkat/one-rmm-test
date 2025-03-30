/*
 * Test cases pacakage defines the tests
 * 
 */

package testcase;

import java.io.IOException;

import java.time.Duration;
import org.jboss.aerogear.security.otp.Totp;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.Test;

import Base.BaseTest;
import utilities.ReadConfigProperties;

//@Listeners(utilities.TestNGListener.class)

public class NinjaRMM_LoginTest extends BaseTest{
	
	
	
	/*
	 * Validate all the page elements available in the login page
	 */
	@Test
	public static void LoginPageElementsTest() throws IOException, InterruptedException {
		
		System.out.println("LoginPageElementsTest Started...");
		Reporter.log("LoginPageElementsTest Started...");
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(loct.getProperty("email"))));
		Assert.assertTrue(element.isDisplayed());
		
		WebInspectionbyid(loct.getProperty("email"));
		
		WebInspectionbyid(loct.getProperty("pass"));
		
		WebInspectionbyxpath(loct.getProperty("signin_btn"));
		
		WebInspectionbyxpath(loct.getProperty("forgot_password_link"));
		
		WebInspectionbyxpath(loct.getProperty("ninjaone_llc"));
		
		WebInspectionbyxpath(loct.getProperty("do_not_have_account_link"));
		
	}
		

	/*
	 * Test to login to the NinjaRMM page
	 * Get the OTP code and login to the home page. 
	 */
	@Test
	public static void LoginTest() throws IOException, InterruptedException {
		
		System.out.println("LoginTest Started...");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(loct.getProperty("email"))));
		Assert.assertTrue(element.isDisplayed());
		
		Thread.sleep(2000);
		WebInspectionbyid(loct.getProperty("email")).click();
		WebInspectionbyid(loct.getProperty("email")).sendKeys(prop.getProperty("user"));
		
		WebInspectionbyid(loct.getProperty("pass")).click();
		System.out.println(prop.getProperty("password"));
		
		WebInspectionbyid(loct.getProperty("pass")).sendKeys(prop.getProperty("password"));
		WebInspectionbyxpath(loct.getProperty("signin_btn")).click();

		WebElement element1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(loct.getProperty("mfacode"))));
		Assert.assertTrue(element1.isDisplayed());
		
		WebInspectionbyxpath(loct.getProperty("mfa"));
		
		String secret = ReadConfigProperties.Base64decodeString(prop.getProperty("secret"));
		Totp totp = new Totp(secret);
		String currentOTP = totp.now();
	
		WebInspectionbyname(loct.getProperty("mfacode")).sendKeys(currentOTP);
		WebInspectionbyxpath(loct.getProperty("submit_btn")).click();
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(loct.getProperty("welcome"))));
		WebInspectionbyxpath(loct.getProperty("welcome"));
		System.out.println("NinjaOne Login Successful");
			
	}
}
