package Pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utils.UIActions;

public class PaymentPage extends BasePage {

	@FindBy(css = "main[data-testid='main'] > div span > span > span")
	public List<WebElement> debitCardPayment;

	@FindBy(css = "input[data-testid='cardForm.name.input']")
	public WebElement cardholdersNameField;
	
	@FindBy(css = "div[class='__PrivateStripeElement']")
	public WebElement iframeParent;
	
	@FindBy(css = "div[class='__PrivateStripeElement'] iframe")
	public WebElement frameName;

	@FindBy(css = "input[data-elements-stable-field-name='cardNumber']")
	public WebElement cardNumberField;
	
	@FindBy(css = "input[data-elements-stable-field-name='cardExpiry']")
	public WebElement cardExpiryField;
	
	@FindBy(css = "input[data-elements-stable-field-name='cardCvc']")
	public WebElement cvcField;

	@FindBy(css = "input[data-testid='cardForm.line1.input']")
	public WebElement addressLine1Field;
	
	@FindBy(css = "input[data-testid='cardForm.line2.input']")
	public WebElement addressLine2Field;
	
	@FindBy(css = "input[data-testid='cardForm.cityOrTown.input']")
	public WebElement cityField;
	
	@FindBy(css = "input[data-testid='cardForm.region.input']")
	public WebElement stateField;
	
	@FindBy(css = "input[data-testid='cardForm.postcode.input']")
	public WebElement postalField;
	
	@FindBy(css = "select[data-testid='cardForm.country.input'] option")
	public List<WebElement> CountryField;
	
	@FindBy(css = "form[data-testid='cardForm'] > fieldset:nth-child(1) > p")
	public WebElement errorMessage;
	
	@FindBy(css = "button[data-testid='cardForm.submit']")
	public WebElement addCardButton;
	
	@FindBy(css = "p[data-testid='paymentAuthorisation.selectedPaymentMethod.supportingText']")
	public WebElement cardPaymentAuthoriseBox;
	
	
	public void selectThePaymentMethod(String paymentMethod) throws InterruptedException {
		for(WebElement ele : debitCardPayment) {
			if(ele.getText().equals(paymentMethod)) {
				waitForElementToAppear(ele, 10);
				UIActions.clickWebElementUsingActions(ele, driver);
			}
		}
	}
	
	protected void waitForElementToAppear(WebElement ele, int TimeOutInSeconds) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", ele);
		Thread.sleep(2000);
    }
	
	public void enterCardHoldersName(String name) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(cardholdersNameField));
		cardholdersNameField.sendKeys(name);
	}
	
	public void enterinvalidCardNumber(String cardNumber) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('__PrivateStripeElement')[0].style.display='block';");
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("document.getElementsByName('__privateStripeFrame7735')[0]");
		driver.switchTo().frame(frameName);
		//UIActions.typeUsingActions(cardNumberField, getDriver(), cardNumber);
		cardNumberField.sendKeys("1111111111111111");
	}
	
	public void entervalidCardNumber(String cardNumber) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("document.getElementsByClassName('__PrivateStripeElement')[0].style.display='block';");
		Thread.sleep(3000);
		((JavascriptExecutor) driver).executeScript("document.getElementsByName('__privateStripeFrame7735')[0]");
		driver.switchTo().frame(frameName);
		//UIActions.typeUsingActions(cardNumberField, getDriver(), cardNumber);
		cardNumberField.sendKeys("4111111111111111");
	}
	
	public void enterExpiryDate(String expiryNumber) {
		cardExpiryField.sendKeys(expiryNumber);
	}
	
	public void enterCvcNumber(String cVCNumber) {
		cvcField.sendKeys(cVCNumber);
	}
	
	public void enterAddressLine1(String address1) {
		driver.switchTo().defaultContent();
		addressLine1Field.sendKeys(address1);
	}
	
	public void enterAddressLine2(String address2) {
		addressLine2Field.sendKeys(address2);
	}
	
	public void enterCity(String city) {
		cityField.sendKeys(city);
	}
	
	public void enterState(String state) {
		stateField.sendKeys(state);
	}

	public void enterPostal(String postal) {
		postalField.sendKeys(postal);
	}
	
	public void enterCountry(String postal) throws InterruptedException {
		for(WebElement ele : CountryField) {
			if(ele.getText().equals(postal)) {
				waitForElementToAppear(ele, 10);
				UIActions.clickWebElementUsingActions(ele, driver);
			}
	}
	}
	
	public void clickOnAddCard() throws InterruptedException {
		waitForElementToAppear(addCardButton, 10);
		UIActions.clickWebElementUsingActions(addCardButton, driver);
	}
	
	public void validateErrorMessage() {
		Assert.assertTrue(errorMessage.isDisplayed());
	}
	
	public void validateCardAddedSucceesfully() throws Exception {
		waitForElementToAppear(cardPaymentAuthoriseBox, 10);
		Assert.assertTrue(cardPaymentAuthoriseBox.isDisplayed());
	}
	
}
