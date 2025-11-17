package base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;

import utils.ConfigReader;

public class Baserun {

	public static WebDriver driver;
	public static Properties prop;

	@BeforeMethod
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
	}
	@AfterClass
	public void tearout() {
		if (driver != null) {
			driver.quit();
		}
	}

}
