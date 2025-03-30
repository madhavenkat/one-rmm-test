/*
 * Base Test class includes the Setup and tear down methods @before and @after test
 * 
 */

package Base;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties prop = new Properties();
	public static Properties loct = new Properties();
	public static FileReader reader;
	
	
	public static ExtentReports extent;
    public static ExtentTest test;
    
    @BeforeSuite
    public void setupReport() {
        ExtentSparkReporter spark = new ExtentSparkReporter("test-output/ExtentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }
    
	/*
	 * Setup function, initiate the chrome driver session and open the browser 
	 */
	@BeforeTest
	public void Setup() throws IOException {
		
		if(driver==null) {
			
			String currentDir = System.getProperty("user.dir");
			FileReader reader = new FileReader(currentDir + "/src/test/resources/configfiles/config.properties");
			FileReader readloct = new FileReader(currentDir + "/src/test/resources/configfiles/locators.properties");

			prop.load(reader);
			loct.load(readloct);
			
			ChromeOptions options = new ChromeOptions();
	        options.addArguments("--headless=new");  // New headless mode
	        options.addArguments("--disable-gpu");   // Disable GPU acceleration
	        options.addArguments("--window-size=1920,1080"); // Set resolution
	        options.addArguments("--no-sandbox");    // Bypass OS security model
	        options.addArguments("--disable-dev-shm-usage"); // Overcome limited resources
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
			driver.get(prop.getProperty("url"));
		}
	}
	
	/*
	 * Tear down function. It closes the browser after completion of the test execution 
	 */
	
	@AfterTest
	public void tearDown() {
		driver.close();
		System.out.println("tear down executed successfully");
	}
	
	
	@AfterSuite
    public void flushReport() {
        extent.flush(); // Save the report
    }
	
	/*
	 * Validates the Web Element by id if its available and asserts if not visible
	 */
			
	public static WebElement WebInspectionbyid(String locator) {
		//System.out.println(locator);
		WebElement element = driver.findElement(By.id(locator));
		Assert.assertTrue(element.isDisplayed(), "Element is not visible");
		return element;
	}
	
	 /* 
	  * Validates the Web Element by name if its available and asserts if not visible
	  */

	public static WebElement WebInspectionbyname(String locator) {
		//System.out.println(locator);
		WebElement element = driver.findElement(By.name(locator));
		Assert.assertTrue(element.isDisplayed(), "Element is not visible");
		return element;
	}
	
	/* 
	  * Validates the Web Element by xpath if its available and asserts if not visible
	  */
	public static WebElement WebInspectionbyxpath(String locator) {
		//System.out.println(locator);
		WebElement element = driver.findElement(By.xpath(locator));
		Assert.assertTrue(element.isDisplayed(), "Element is not visible");
		return element;
	}
	
}
