package pageobject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage extends Basetest {
	public Loginpage(WebDriver driver) {
		super(driver);
	}
	By tenantid = By.xpath("//input[@id='domain']");
	By tenansumbittbtn = By.xpath("//button[normalize-space()='Continue']");
	By signinaccount = By.xpath("//h1[normalize-space()='Sign in to your account']");
	By emailid = By.xpath("//input[@id='email']");
	By password = By.xpath("//input[@id='password']");
	By sumbit = By.xpath("//button[normalize-space()='Login']");
	By dashboard = By.xpath("//h5[normalize-space()='Dashboard']");

	//actions

	public void entertenantid(String tenant) {
		action.enterText(tenantid, tenant);
	}
	public void tenantsumbit() {
		action.clickElement(tenansumbittbtn);
	}
	public void enterEmail(String email) {

		action.enterText(emailid, email);
	}

	public void enterPassword(String pass) {

		action.enterText(password,pass);
	}

	public void clickLogin() {
		action.clickElement(sumbit);
	}

	// Combined method (optional)
	public void login(String email, String password) {
		enterEmail(email);
		enterPassword(password);
		clickLogin();
	}

	/*
	 * public void waitforelement() { wait = new WebDriverWait(driver,
	 * Duration.ofSeconds(3000));
	 * wait.until(ExpectedConditions.visibilityOf(signinaccount)); }
	 */
	public void dashbordscrn() {
		action.waitForVisible(dashboard);
	}

}