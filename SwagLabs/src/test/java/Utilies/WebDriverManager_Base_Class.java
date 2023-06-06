package Utilies;



import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;


import io.github.bonigarcia.wdm.WebDriverManager;



public class WebDriverManager_Base_Class {

	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;


	
	public WebDriver launchBrowser (String url) throws InterruptedException  {

		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\eclipse-workspace\\SwagLabs\\src\\test\\resources\\Drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		Thread.sleep(1000);
		return driver;
		
	}
	public  WebDriver getDriver() {
		return driver;
	}

	public  ExtentReports extend() {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("SwagLabs Report.html");
		// create ExtentReports and attach reporter(s)
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		return extent;
	}
	
		public String screenshot(WebDriver driver,String testname)throws Exception{
			//TakesScreenshot scrShot =((TakesScreenshot)driver);
		//	File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
			//File DestFile=new File("C:\\Users\\HP\\eclipse-workspace\\SwagLabs\\src\\test\\resources\\Screenshots\\Test "+timestamp() +".png");
			//Files.copy(SrcFile, DestFile);
			
			File Screenshotfile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File DestFile=new File("C:\\Users\\HP\\eclipse-workspace\\SwagLabs\\src\\test\\resources\\Screenshots\\"+testname +timestamp() +".png");
			FileUtils.copyFile(Screenshotfile,(DestFile));
            return DestFile.getAbsolutePath();
		}
		public static String timestamp() {
			return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
		}
}
	