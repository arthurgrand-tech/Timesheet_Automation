package testcase;

import org.testng.annotations.Test;

import base.Baserun;
import pageobject.DashBoardPage;

public class TC001_login extends Baserun{

	@Test(priority = 1)
	public void logintoadmin() {
		System.out.println("login to admin role");
		loginAs("admin");

	}
	@Test(priority = 2)
	public void addcustomer() throws InterruptedException {
		System.out.println("customer page");

		DashBoardPage	dashboard = new DashBoardPage(driver);
		System.out.println("navigate to customer page and ading to customer");
		pageManager.getcustomer().clickcustomerbtn();
		System.out.println(" customer page navigated successfully:" + pageManager.getcustomer().customerheaderdisplay());
		dashboard.clicklogout();

	}

}
