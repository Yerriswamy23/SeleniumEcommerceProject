package pages;

import static org.testng.AssertJUnit.assertEquals;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;



public class CartPage extends AbstractCommonMethods{

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	
	@FindBy(xpath = "//div[@class='cartSection']/following::div[@class='prodTotal cartSection']//p")
	List<WebElement> itemsPrice;
	@FindBy(xpath = "//div[@class='cartSection']//h3")
	List<WebElement> itemsName;
	@FindBy(xpath="//li[1]//span[2]")
	WebElement actualDollorPriceEle;
	@FindBy(xpath="//button[normalize-space()='Checkout']")
	WebElement chkbtn;
	
	
	public void validateCartItems() {
		
		System.out.println(" *************************");
		System.out.println(" Items in the cart are :");
		for (int i = 0; i < itemsPrice.size(); i++) {
			String itemName = itemsName.get(i).getText();
			String itemPrice = itemsPrice.get(i).getText();
			

			System.out.println(itemName + "\t" + itemPrice);
		}
		
	}
	
	public void validateTotalAmount() {
		int expPrice = 0;
		System.out.println(" *************************");
		System.out.println("Prices are :");
		for (WebElement itemPrice : itemsPrice) {
			String priceDollor = itemPrice.getText();
			String price = priceDollor.substring(2);
			int priceNum = Integer.parseInt(price);
			System.out.println(priceNum);
			expPrice = expPrice + priceNum;

		}
		System.out.println("Total Expected Price: " + expPrice);

		String actualDollorPrice = actualDollorPriceEle.getText();
		String actPrice = actualDollorPrice.substring(1);
		int actPriceNum = Integer.parseInt(actPrice);
		System.out.println("Total Actaul Price :" + actPriceNum);
		Assert.assertEquals(expPrice, actPriceNum);
	
	}
	
	public void checkoutbtn() {
//		JavascriptExecutor checkbtn = (JavascriptExecutor) driver;
//		checkbtn.executeScript("arguments[0].click();", chkbtn);
		jsMethod(chkbtn);
	}
	
}
