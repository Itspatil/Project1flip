package listnerclasses;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import baseclasses.Base1;

public class Listnerclass1 implements ITestListener {
	ExtentTest extentTest;
	
	public void onTestStart(ITestResult result) {
		extentTest=Base1.getalreadyexist();
		extentTest.log(Status.INFO,"test : stared "+result.getName());
	  System.out.println("Test started "+result.getName()+" from listner");
	  }
	
	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.INFO,"test : passesd "+result.getName());
		System.out.println("Test passed "+result.getName()+"  from listner");    
		  }
	  
	public void onTestFailure(ITestResult result) {
		extentTest.log(Status.INFO,"test : failed "+result.getName());
		System.out.println("Test fail "+result.getName()+" from listner");   
		  }
	  
	public void onTestSkipped(ITestResult result) {
		extentTest.log(Status.INFO,"test : skipped "+result.getName());
		System.out.println("Test skipped "+result.getName()+" from listner");   
		  }

}
