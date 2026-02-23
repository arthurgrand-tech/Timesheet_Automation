package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Customer extends Basetest{

	public Customer(WebDriver driver) {
		super(driver);
	}
	By cutomerbutton = By.xpath("//a[contains(@class,'sidebar-link') and contains(@href,'customers')]");

	By customerheading = By.xpath("//h5[@class='fw-semibold mt-3 ms-3 sidebar_selected_label']");
	By createcustomerutton = By.xpath("//button[contains(.,'Create')]");
	By customername = By.xpath("//input[@id='name']");
	By customeremail = By.xpath("//input[@id='email']");
	By customernumber = By.xpath("//input[@name='contactNumber']");
	By customersavebtn = By.xpath("//button[text()='Add']");

	public void clickcustomerbtn() {
		action.clickElement(cutomerbutton);
	}
	public boolean customerheaderdisplay() {
		return driver.findElement(customerheading).isDisplayed();
	}
	public void clickcustomercreatebutton() {
		action.clickElement(createcustomerutton);
	}
	public void addcustomer(String name,String email, String contactno) {
		action.enterText(customername, name);
		action.enterText(customeremail, email);
		action.enterText(customernumber, contactno);
		action.clickElement(customersavebtn);

	}

}
