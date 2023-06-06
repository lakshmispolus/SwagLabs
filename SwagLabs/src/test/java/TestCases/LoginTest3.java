package TestCases;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import Pages.LoginPage;
import Utilies.WebDriverManager_Base_Class;



public class LoginTest3 {
	static WebDriver driver;
	WebDriverManager_Base_Class objmanager;
	static ExtentTest test;
	static ExtentReports extent;
	LoginPage page;
	String screenshotPath;
	
  @Test
  public void TestCase2Login() throws Exception {

	   objmanager = new WebDriverManager_Base_Class();
		driver = objmanager.getDriver();
		 page = new LoginPage(driver);
		 Throwable t = new Throwable();

		  test=objmanager.extent.createTest("Login  - Test Case 02", "Test");
  
	  String PageName = page.SwagLabsLogin("standard_user","secret_sauce");
      System.out.println(PageName);
		if (PageName.contains("Swag Labsss")) {
			Assert.assertTrue(true, "Login Successfully");	
			test.pass("Testing Passed - Login Successfully ");
			screenshotPath=objmanager.screenshot(driver,"TestCase2Login");
			test.log(Status.INFO, "Login Successfully as John Doe !!!");
			test.pass("Login Successfully", MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

		} else {
			test.fail("Testing Failed- login failed !! Try Again ");
			screenshotPath=objmanager.screenshot(driver,"TestCase2Login");
			test.fail(t,MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
			Assert.assertTrue(false, "Login Failed");
			
		}
  }

	
	@BeforeTest()
	@Parameters({ "Browser" })
	public void beforeTest(String Browser) throws Exception {
		objmanager = new WebDriverManager_Base_Class();
		extent = objmanager.extend();

		test = extent.createTest("Launch  - Test Case 01", "Launch the application");
		test.log(Status.INFO, "Laughing Browser");
		test.info("Laughing Browser");
		driver = objmanager.launchBrowser("https://www.saucedemo.com/");
		screenshotPath=objmanager.screenshot(driver,"Test Case 01Launch");
        test.info("Launch",MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

	}

	
	@AfterTest()
	public void afterTest() {
		driver.quit();
		objmanager.extent.flush();
		driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		// driver.close();
	}
}
