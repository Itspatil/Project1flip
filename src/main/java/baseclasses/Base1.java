package baseclasses;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base1 {
	
	static WebDriver driver;
	static ExtentHtmlReporter htmlreport;
	static ExtentReports reports;
	static ExtentTest extentTest;

	public static WebDriver getdriver(String browser) {
		
		if(driver==null) {
		
			if(browser.equals("Chrome")) {
				WebDriverManager.chromedriver().setup();
				//System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\browsers\\chromedriver.exe");
				 driver = new ChromeDriver();
				 
				}else {
					
					WebDriverManager.firefoxdriver().setup();	
				//System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\browsers\\geckodriver.exe");
				driver = new FirefoxDriver();
					 
					}
			
			   driver.get("https://www.flipkart.com/");
			   driver.manage().window().maximize();
			   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	           }
			
	      return driver;
		
		}
	
	public static void unloaddriver() {
		driver=null;
	}
	
	public static ExtentHtmlReporter gethtmlreporter() {
		if (htmlreport== null) {
			htmlreport = new ExtentHtmlReporter("extentreports\\report.html");
		}
		return htmlreport;
	} 

	public static ExtentReports getextentreports() {
		if (reports== null) {
	    reports= new ExtentReports();
		reports.attachReporter(htmlreport);
		}
		return reports;
	}
	
	public static ExtentTest gettest(String testname) {
		
			extentTest = reports.createTest(testname);
	
		return extentTest;
	} 
	
	public static ExtentTest getalreadyexist() {
		return extentTest;
	}
}



