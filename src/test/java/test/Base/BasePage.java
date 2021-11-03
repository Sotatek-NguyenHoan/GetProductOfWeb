package test.Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BasePage {

	public void click(WebElement element) {
		element.click();
	}
	public void sendKey( WebElement element, String text) {element.sendKeys(text);
	}
	public void clear(WebElement element) {
		element.clear();
	}

	public String getText(WebElement element) {
		return element.getText();
	}


	private WebDriver driver;

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}

	public static void visibility(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static void elementToBeClickable(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
