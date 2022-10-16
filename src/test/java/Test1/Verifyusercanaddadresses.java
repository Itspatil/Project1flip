package Test1;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
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
import pomclasess.Profilepage;


@Listeners(Listnerclass1.class)
public class Verifyusercanaddadresses {
	
	static WebDriver driver;
	ExtentHtmlReporter htmlreport;
	ExtentReports reports;
	ExtentTest extentTest;
	Loginpage lp;
	Homepage hp;
	Profilepage ad;
	
	@BeforeClass
	@Parameters("browser")
	public void beforeclass(String browser) {
		htmlreport=	Base1.gethtmlreporter();
		reports = Base1.getextentreports();
		extentTest=Base1.gettest("Verifyusercanaddadresses"); 
		//htmlreport= new ExtentHtmlReporter("extentreports\\report.html");
		 //reports= new ExtentReports();
		//reports.attachReporter(htmlreport);
		//extentTest = reports.createTest("Verifyusercanlogin");
		
		driver=Base1.getdriver(browser);	
	}
	
	@BeforeMethod
	public void beforemethod() {
		 lp = new Loginpage(driver);
		 hp = new Homepage(driver);
		 ad = new Profilepage(driver);
		
	}
	
	@Test(priority=1)
	public void verifyuseropenloginpag(){
		
		hp.hoveronprofile();  //hover on profile name
		
		hp.clickonmyprofile(); //click on profile name
		
		boolean onpage =ad.verifyenterinprofile(); //verify page

		Assert.assertTrue(onpage);
		
	}
	
	@DataProvider(name="addressData")
	public Object[][]getdata() {
		
		Object[][] k= {{"Mann","9960123654","425107","near busstop","32 shivajinagar"},{"shubha","8668951223","400002","near seveass","56lord colony"}};
		return k;
	}
	
	@Test(priority=2,dataProvider="addressData")
	public void verifyadresspageopen(String name,String mobno,String pincode,String locality,String address) {
	   ad.openmanageadress();
	  // System.out.println(name1);
	   List<String> addressdetails = Arrays.asList(name,mobno,pincode,locality,address);
	   ad.addnewadress(addressdetails);
	   
	   
	   
	}
	
	@AfterMethod
	public void aftermethod(ITestResult result) throws IOException {
		if(result.getStatus()==ITestResult.SUCCESS) {
			extentTest.log(Status.PASS,result.getName());
			
			}else if(result.getStatus()==ITestResult.FAILURE){
				String path=ad.getscreenshot(driver, result.getName());
				extentTest.log(Status.FAIL,result.getName() , MediaEntityBuilder.createScreenCaptureFromPath(path).build());
				
				}else if(result.getStatus()==ITestResult.SKIP) {
					extentTest.log(Status.SKIP,result.getName());
				}
		
		
	}
	
	@AfterClass
	public void afterclass() {
		Base1.unloaddriver();
		reports.flush();
		
	}


}
