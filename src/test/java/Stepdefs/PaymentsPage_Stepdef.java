package Stepdefs;

import java.util.Map;

import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.PageFactory;

import Pages.BasePage;
import Pages.PaymentPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PaymentsPage_Stepdef extends BasePage {
	
	PaymentPage paymentpage = PageFactory.initElements(driver, PaymentPage.class);
	

    @Given("I navigate to {string}")
    public void i_navigate_to(String url) {
    	driver.get(url);
	    driver.manage().deleteAllCookies();
}

@And("click on {string} under payment Authorisation")
public void click_on_under_payment_authorisation(String paymentMethod) throws InterruptedException {
	paymentpage.selectThePaymentMethod(paymentMethod);
}

@When("enter invalid card details")
public void enter_invalid_card_details(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	Map<String, String> data = dataTable.asMap(String.class, String.class);
	paymentpage.enterCardHoldersName(data.get("cardholders name"));
	paymentpage.enterinvalidCardNumber(data.get("card"));
	paymentpage.enterAddressLine1(data.get("Line1"));
	
}

@Then("error message saying invalid card details must be displayed")
public void error_message_saying_invalid_card_details_must_be_displayed() {
	paymentpage.validateErrorMessage();
}

@When("enter valid card details")
public void enter_valid_card_details(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {
	Map<String, String> data = dataTable.asMap(String.class, String.class);
	paymentpage.enterCardHoldersName(data.get("cardholders name"));
	paymentpage.entervalidCardNumber(data.get("card"));
	paymentpage.enterExpiryDate(data.get("CardExpiry"));
	paymentpage.enterCvcNumber(data.get("CVCNumber"));
	paymentpage.enterAddressLine1(data.get("Line1"));
	paymentpage.enterAddressLine2(data.get("Line2"));
	paymentpage.enterCity(data.get("City/Town"));
	paymentpage.enterState(data.get("State/Province/Region"));
	paymentpage.enterPostal(data.get("Postal/ZipCode"));
	paymentpage.enterCountry(data.get("Country"));
}

@Then("card added succesfully message should be displayed")
public void card_added_succesfully_message_should_be_displayed() throws Exception {
	paymentpage.clickOnAddCard();
	paymentpage.validateCardAddedSucceesfully();
	
      
}
}