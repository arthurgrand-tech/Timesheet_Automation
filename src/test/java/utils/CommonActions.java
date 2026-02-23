package utils;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonActions {

	WebDriver driver;
	WebDriverWait wait;
	Actions actions;

	public CommonActions(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		actions = new Actions(driver);
	}

	// ✅ Click element safely
	public void clickElement(By locator) {
		waitForToastToDisappear();
		wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	}

	// ✅ Send keys
	public void enterText(By locator, String text) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).clear();
		driver.findElement(locator).sendKeys(text);
	}

	// ✅ Get text
	public String getText(By locator) {
		return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
	}

	// ✅ Wait for element visible
	public void waitForVisible(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	// ✅ Dropdown select by visible text
	public void selectDropdown(By locator, String visibleText) {
		WebElement dropdown = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		Select select = new Select(dropdown);
		select.selectByVisibleText(visibleText);
	}

	// ✅ Mouse hover
	public void hoverOver(By locator) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		actions.moveToElement(element).perform();
	}

	// ✅ Scroll into view
	public void scrollToElement(By locator) {
		WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	// ✅ Screenshot (optional)
	public void takeScreenshot(String fileName) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		byte[] src = ts.getScreenshotAs(OutputType.BYTES);
		// You can save to path using FileUtils (Apache Commons IO) if needed
		System.out.println("Screenshot captured for: " + fileName);
	}
	
	public void waitForToastToDisappear() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(
	    		 By.cssSelector(".Toastify__toast-container")
	    ));
	}
}
