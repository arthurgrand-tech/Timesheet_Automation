package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoardPage extends Basetest{

	public DashBoardPage(WebDriver driver) {
		super(driver);
	}
	
	By dashboard_roll = By.className("css-1wy0on6");
	By profileicon = By.xpath("//li[@class='cursor-pointer ms-1']");
	By logout = By.xpath("//button[@class='signout-item']");
	
	
	public void selectelement() {
	
	}
	public void clicklogout()  {
		
		action.clickElement(profileicon);
		action.clickElement(logout);
	}


}
