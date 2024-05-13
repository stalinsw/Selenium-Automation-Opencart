package utilities;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneralUtility {

	WebDriver driver;
	private WebElement WebElement;

	public void refreshpage() {
		driver.navigate().refresh();
	}

	public void moveToElementActionsContextClick(WebElement target) {
		Actions actions = new Actions(driver);

		actions.moveToElement(target).contextClick().build().perform();
	}

	public void moveToElementActionsDoubleClick(WebElement target) {
		Actions actions = new Actions(driver);

		actions.doubleClick(target).build().perform();
		;
	}
	
	public void ExplicitWaitPresenceOfElement(By locator) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public void ExplicitWaitVisibilityOfElement() {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.visibilityOf(WebElement));
	}

	public void moveToElementActionsDragAndDrop(WebDriver driver, WebElement target) {
		Actions actions = new Actions(driver);

		actions.moveToElement(target).dragAndDrop(target, target).build().perform();
	}

	public void ExplicitWait(By locator, String attribute, String value) {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(10));
		w.until(ExpectedConditions.attributeToBe(locator, attribute, value));

	}

	public void ExplicitWaitelementToBeClickable() {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(20));

		w.until(ExpectedConditions.elementToBeClickable(WebElement));
	}

	public void ExplicitWaitAlertIsPresent() {
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(20));

		w.until(ExpectedConditions.alertIsPresent());

	}

	public void forwardpage() {
		driver.navigate().forward();
	}

	public void backwardpage() {
		driver.navigate().back();
	}

	public void alertAccept() {
		Alert objectalert = driver.switchTo().alert();
		objectalert.accept();
	}

	public void utilityRefreshCommand() {
		driver.navigate().refresh();
	}

	public String alertGetText() {
		Alert objectalert = driver.switchTo().alert();
		String alertText = objectalert.getText();
		return (alertText);
	}

	public void dismissAlert() {
		Alert objectalert = driver.switchTo().alert();
		objectalert.dismiss();
	}

	public void scrollMethod(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView()", element);
	}

	public void scrollByPixels(int x, int y) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(x,y)");
	}

	public void utilityfullPageScroll() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
	}

}
