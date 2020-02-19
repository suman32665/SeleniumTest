package SeleniumSupport;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Helper extends Locators{
	WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor jsx;
	public Helper(WebDriver d) {
		driver = d;
		wait = new WebDriverWait(driver, 10);
		jsx = (JavascriptExecutor) driver;
	}
	
	public void Click_JavaScriptAlerts() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(JavaScriptAlerts))).click();
	}

	public void Click_JSConfirm() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(JSConfirm))).click();		
	}
	
	public void Click_OK() {
		driver.switchTo().alert().accept();
	}
	
	public void Check_Result(String ExpectedText) {
		String ActualText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(Result))).getText();
		Assert.assertEquals(ActualText, ExpectedText);
	}
}
