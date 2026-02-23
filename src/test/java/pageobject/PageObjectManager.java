package pageobject;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	private WebDriver driver;

	private Customer customer;
	private DashBoardPage dashboard;
	private Loginpage login;

	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	public Customer getcustomer() {
		if(customer == null) {
			customer = new Customer(driver);
		}
		return customer;
	}
	public DashBoardPage getdashboard() {
		if(dashboard == null) {
			dashboard = new DashBoardPage(driver);
		}
		return dashboard;
	}
}
