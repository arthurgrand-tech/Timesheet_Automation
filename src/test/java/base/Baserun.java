package base;

import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import pageobject.Loginpage;
import pageobject.PageObjectManager;
import utils.ConfigReader;
import utils.ExtentManager;
import utils.ScreenshotUtil;

public class Baserun {

	public  WebDriver driver;
	public static Properties prop;
	ConfigReader config = new ConfigReader();
	protected static ExtentReports extent;
	protected ExtentTest test;
	protected PageObjectManager pageManager;
	//exten report setup before suit
	@BeforeSuite
	public void startReport() {
		extent = ExtentManager.getInstance();
	}

	@BeforeClass
	public void setUp() {
		ConfigReader.loadProperties();
		String browser = ConfigReader.getProperty("browser");
		String url = ConfigReader.getProperty("url");

		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		} else {
			throw new RuntimeException("Browser not supported: " + browser);
		}

		driver.manage().window().maximize();
		driver.get(url);
		pageManager = new PageObjectManager(driver);
	}

	//  THIS IS THE METHOD YOU ASKED ABOUT
	public void loginAs(String role) {
		// role = "admin" or "user" or "supervisor"

		String username = ConfigReader.getProperty(role + ".username");
		String password = ConfigReader.getProperty(role + ".password");

		Loginpage lp = new Loginpage(driver);

		lp.entertenantid("master");
		lp.tenantsumbit();
		lp.enterEmail(username);
		lp.enterPassword(password);
		lp.clickLogin();

		System.out.println("Logged in as: " + role);
	}

	@BeforeMethod
	public void createTest(Method method) {
		test = extent.createTest(method.getName());
	}

	@AfterMethod
	public void captureResult(ITestResult result) {

		if (result.getStatus() == ITestResult.FAILURE) {

			String path = ScreenshotUtil.captureScreenshot(driver, result.getName());

			test.fail(result.getThrowable());
			test.addScreenCaptureFromPath(path);
		}
		else if (result.getStatus() == ITestResult.SUCCESS) {
			test.pass("Test Passed");
		}
		else if (result.getStatus() == ITestResult.SKIP) {
			test.skip("Test Skipped");
		}
	}



	@AfterClass
	public void tearout() {
		if (driver != null) {
			driver.quit();
		}
	}
	@AfterSuite
	public void endReport() {
		extent.flush();
	}

}
