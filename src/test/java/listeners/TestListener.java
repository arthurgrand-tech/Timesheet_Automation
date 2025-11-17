package listeners;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

import base.Baserun;

public class TestListener extends Baserun implements ITestListener{
	
	public void onTestStart(ITestResult result) {
		System.out.println("STARTED: " + result.getName());
	    
	  }
	public void onTestSuccess(ITestResult result) {
		 System.out.println("PASSED: " + result.getName());
	  }
	 @Override
	    public void onTestFailure(ITestResult result) {
	        System.out.println("FAILED: " + result.getName());
	        takeScreenshot(result.getName());
	    }

	    @Override
	    public void onTestSkipped(ITestResult result) {
	        System.out.println("SKIPPED: " + result.getName());
	    }

	    public void takeScreenshot(String testName) {
	        try {
	            TakesScreenshot ts = (TakesScreenshot) driver;
	            File source = ts.getScreenshotAs(OutputType.FILE);
	            String path = "./screenshots/" + testName + ".png";
	            FileUtils.copyFile(source, new File(path));
	            System.out.println("Screenshot saved at: " + path);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	
}
	