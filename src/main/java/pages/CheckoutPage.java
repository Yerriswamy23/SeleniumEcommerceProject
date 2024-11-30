package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutPage extends AbstractCommonMethods {

	WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement selectCountry;

	@FindBy(xpath = "//section[@class='ta-results list-group ng-star-inserted']//button//span[@class='ng-star-inserted']")
	List<WebElement> countries;

	@FindBy(xpath = "//a[normalize-space()='Place Order']")
	WebElement orderbutton;

	

	public void countrySelect() throws InterruptedException {
		selectCountry.sendKeys("ind");
		Thread.sleep(2000);
		for (WebElement country : countries) {
			System.out.println(country.getText());
			String india = country.getText();
			if (india.equalsIgnoreCase("India")) {
				country.click();
				break;
			}

		}
	}

	public void placingOrder() throws InterruptedException {
//			JavascriptExecutor orderbtn = (JavascriptExecutor) driver;
//			orderbtn.executeScript("arguments[0].click();", orderbutton);
		jsMethod(orderbutton);
		Thread.sleep(3000);

		

	}

}
