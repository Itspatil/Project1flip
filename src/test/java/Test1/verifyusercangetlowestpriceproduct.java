package Test1;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import baseclasses.Base1;
import listnerclasses.Listnerclass1;
import pomclasess.Homepage;
import pomclasess.Loginpage;

@Listeners(Listnerclass1.class)
public class verifyusercangetlowestpriceproduct {
	static WebDriver driver;
	ExtentHtmlReporter htmlreport;
	ExtentReports reports;
	ExtentTest extentTest;
	Loginpage lp;
	Homepage hp;
	
	@BeforeClass
	@Parameters("browser")
	public void beforeclass(String browser) {
		htmlreport=	Base1.gethtmlreporter();
		reports = Base1.getextentreports();
		extentTest=Base1.gettest("verifyusercangetlowestpriceproduct");
		// htmlreport= new ExtentHtmlReporter("extentreports\\report.html");
		 //reports= new ExtentReports();
		//reports.attachReporter(htmlreport);
		//extentTest = reports.createTest("Verifyusercanlogin");
		
		driver = Base1.getdriver(browser);	
	}
	
	@BeforeMethod
	public void beforemethod() {
		 lp = new Loginpage(driver);
		 hp = new Homepage(driver);
		
	}
	
	@Test(priority=1)
	public void verifyusercansearchproduct()  {
		hp.serachproduct();
		hp = new Homepage(driver);
		
		String actualwholetext = hp.getvalidtext();
		Assert.assertTrue(actualwholetext.contains("Showing"));
		
		
	}
	
	@Test(priority=2)
	public void verifyfindlowestprice() {
		
		//List<Integer> lowprice5pages = new ArrayList<>();
		Map<Integer,Integer> lowprices1= new HashMap<>(); //map sysytem is used
			for(int i=1;i<=6;i++) {
				
				if(i!=1) {
					hp.switchtopage(i);
					
				}
				hp = new Homepage(driver);
				//lowprice5pages.add(hp.findlowestprice());
				lowprices1.put(i, hp.findlowestprice());
				
				 }
			System.out.println(lowprices1);	
		
	}
	
	@Test(priority=3)
	public void test3() {
		System.out.println("test3");
		
	}
	
	@Test(priority=4)
	public void test4() {
		System.out.println("test4");
		
	}
	
	@AfterMethod
	public void aftermethod(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.SUCCESS) {
			extentTest.log(Status.PASS,result.getName());
			
			}else if(result.getStatus()==ITestResult.FAILURE){
				String path=hp.getscreenshot(driver, result.getName());
				extentTest.log(Status.FAIL,result.getName() , MediaEntityBuilder.createScreenCaptureFromPath(path).build());
				
				}else if(result.getStatus()==ITestResult.SKIP) {
					extentTest.log(Status.SKIP,result.getName());
				}
		
		
	}
	
	@AfterClass
	public void afterclass() {
		reports.flush();
		
	}
	


}
