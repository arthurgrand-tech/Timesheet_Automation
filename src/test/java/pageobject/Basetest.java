package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import utils.CommonActions;

public class Basetest {
	WebDriver driver;
	CommonActions action;
	WebDriverWait wait;

	public Basetest(WebDriver driver) {
		this.driver = driver;
		action = new CommonActions(driver);
		PageFactory.initElements(driver, this);
	}
	



}
