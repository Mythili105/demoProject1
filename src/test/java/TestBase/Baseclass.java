package TestBase;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class Baseclass {
 
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentSparkReporter SparkReporter;
	public static ExtentTest test;
	
	@BeforeTest
	public void setupreport() {

	String reportPath = "C:\\Frameworks\\Reports\\ExtentReport.html";
	ExtentSparkReporter SparkReporter = new ExtentSparkReporter(reportPath);
	SparkReporter.config().setDocumentTitle("Automation Test Report");
	SparkReporter.config().setReportName("Functional Testing");
	SparkReporter.config().setTheme(Theme.DARK);
	
	extent = new ExtentReports();
    extent.attachReporter(SparkReporter);
    extent.setSystemInfo("Host Name", "Localhost");
    extent.setSystemInfo("Environment", "QA");
    extent.setSystemInfo("User Name", "Mythili");

	}
    @BeforeMethod
    public void beforeMethod() {
        // Initialize the test object before each test method
        //test = extent.createTest(getClass().getName());
    }
    @AfterMethod
    public void tearDownMethod(ITestResult result) {
        // Log test results to Extent Report
        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail("Test Case Failed: " + result.getName());
            test.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Case Passed: " + result.getName());
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.skip("Test Case Skipped: " + result.getName());
        }
    }
	@AfterTest
	
	public void aftertest() {
		  extent.flush();
	}
		 
		 @BeforeClass
		    public void setup(@Optional("chrome") String browser) {
		       
		        System.out.println("Browser parameter: " + browser);
		        // Logic to initialize the WebDriver based on the browser parameter
		        if (browser.equalsIgnoreCase("chrome")) {
		        	driver= new ChromeDriver();
		        } else if (browser.equalsIgnoreCase("firefox")) {
		        	driver= new FirefoxDriver();
		        } else {
		            // Initialize default WebDriver
		        }
	 
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		  System.out.println("Navigated to browser");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		System.out.println("Browser launched and navigated to the login page.");
		 }
	
		  public void takeScreenshot(String testName) {
		        // Take the screenshot and store it in a file
		        
			  
			  File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		        
		        String destPath = "C:\\Frameworks\\Screenshots\\" + testName + ".png"; // Modify path as neededFile screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		        try {
		        	FileUtils.copyFile(srcFile, new File(destPath));
		            System.out.println("Screenshot saved: " + destPath);
		        } catch (IOException e) {
		            System.out.println("Failed to capture screenshot: " + e.getMessage());
		        }
		    }
			  

	 
	 @AfterClass
		public void teardown() {
			driver.quit();
		}
	 }
	
	
	

