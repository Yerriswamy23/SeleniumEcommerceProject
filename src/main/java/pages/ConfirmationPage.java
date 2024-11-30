package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage extends AbstractCommonMethods{

	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath = "//h1[normalize-space()='Thankyou for the order.']")
	WebElement successMessage;
	@FindBy(css = "body > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(6) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(5) > button:nth-child(1)")
	WebElement excelbtn;
	
	public Boolean displaySuccessMessage() {
		Boolean status = successMessage.isDisplayed();
		return status;
	}
	public void downloadExcel() throws InterruptedException {
		jsMethod(excelbtn);
		Thread.sleep(6000);
	}

}
