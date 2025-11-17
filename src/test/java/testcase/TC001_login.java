package testcase;

import org.testng.annotations.Test;

import base.Baserun;
import pageobject.Loginpage;

public class TC001_login extends Baserun{
		@Test
	public void start() throws InterruptedException  {
		System.out.println("test case 001");
		Thread.sleep(6000);
		//driver.findElement(By.id("#domain")).sendKeys("master");
		Loginpage lp = new Loginpage(driver);
		lp.entertenantid("master");
		lp.tenantsumbit();
		lp.enterEmail("superadmin@gmail.com");
		lp.enterPassword("123qwe3");
		lp.clickLogin();
		lp.dashbordscrn();
		String title = driver.getTitle();
		System.out.println("title is :"+ title);
	}
		@Test
		public void timesheet() {
			Loginpage lp = new Loginpage(driver);
			
		}

}
