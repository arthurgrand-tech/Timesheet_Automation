package testcase;

import org.testng.annotations.Test;

import base.Baserun;
import pageobject.Customer;
import pageobject.DashBoardPage;
import utils.DataProviders;
import utils.WaitUtil;

public class TC002_CustomerTest extends Baserun {

	@Test(dataProvider = "customerData",
			dataProviderClass = DataProviders.class)
	public void addcustomer(String name,
			String email,
			String phone) {
		loginAs("admin");
		WaitUtil.pause(2);
		//assign to pagemanager.getcustomer() object 
		Customer customer = pageManager.getcustomer();
		DashBoardPage dashboard = pageManager.getdashboard();
		customer.clickcustomerbtn();
		WaitUtil.pause(2);
		customer.clickcustomercreatebutton();
		WaitUtil.pause(2);
		customer.addcustomer(name, email, phone);
		WaitUtil.pause(2);
		dashboard.clicklogout();
		test.info("Customer created: " + name);
		test.pass("Customer creation completed");



	}

}
