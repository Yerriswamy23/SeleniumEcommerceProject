package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrdersPage extends AbstractCommonMethods {
   WebDriver driver;
	public OrdersPage(WebDriver driver) {
		super(driver);
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//tbody//tr//td[2]")
	List<WebElement> orders;
	public boolean VerifyorderedItemsPage(String productName) throws InterruptedException {
		// TODO Auto-generated method stub
		ordersPage();
		Thread.sleep(2000);
		return orders.stream().anyMatch(orderedProduct -> orderedProduct.getText().equalsIgnoreCase(productName));
	}
	
//	public boolean VerifyorderedItemsPage(String productname) {
//		ordersPage();
//		
//		for(WebElement orderdProduct : orders ) {
//			
//			if(orderdProduct.getText().equalsIgnoreCase(productname)) {
//				return true;
//			}
//			}
//		return false;
//		}
	
		
	
}
