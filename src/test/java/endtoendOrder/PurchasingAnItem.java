package endtoendOrder;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckoutPage;
import pages.ConfirmationPage;
import pages.LoginPage;
import pages.OrdersPage;
import pages.ProductCatalougePage;

public class PurchasingAnItem extends BaseTest {
	//LoginPage loginpage = new LoginPage(driver);
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	String item1 = "ADIDAS ORIGINAL";
	String item2 = "Iphone 13 pro";

	//@Test(dataProvider= "getData",groups= {"purchase"})
	@Test(dataProvider= "getData")
	//public void puchaseItem(HashMap<String,String> input) throws InterruptedException {
	public void puchaseItem(String email, String pwd, String prd, String prd2) throws InterruptedException {
		//Login
		LoginPage loginpage = new LoginPage(driver);
		//loginpage.login(input.get("email"),input.get("pwd"));
		loginpage.login(email,pwd);
		
		// productcat.allItems();
		ProductCatalougePage productcat = new ProductCatalougePage(driver);
	//	productcat.addingItems(input.get("prd"),input.get("prd2"));
		productcat.addingItems(prd,prd2);
		Thread.sleep(3000);
		productcat.clickCartbtn();
		// Validation Cart Items and their Prices
		CartPage cartitems = new CartPage(driver);
		cartitems.validateCartItems();
		cartitems.validateTotalAmount();
		cartitems.checkoutbtn();
		// Filling necessary details placing the order
		
		CheckoutPage checkout = new CheckoutPage(driver);
		checkout.countrySelect();
		checkout.placingOrder();

		// Checking the COnfirmation message and downloading orders excel file
		ConfirmationPage confirm = new ConfirmationPage(driver);
		confirm.displaySuccessMessage();
		Assert.assertTrue(confirm.displaySuccessMessage());
		confirm.downloadExcel();		

}
	@Test(dependsOnMethods= {"puchaseItem"})
	public void verifyOrederedItems() throws InterruptedException {
		LoginPage loginpage = new LoginPage(driver);
		loginpage.login("swamy@test.com", "Virat@183");
	OrdersPage orders = new OrdersPage(driver);
		boolean match =orders.VerifyorderedItemsPage(item1);
		Assert.assertTrue(match);
	}


	
	@DataProvider
	public Object[][] getData() throws IOException {
		//List<HashMap<String, String>> data2 = readData(System.getProperty(("user.dir")+"\\src\\test\\java\\dataUtitlity\\PurchaseData.json "));
	//	System.out.println("Data from DataProvier: "+ data);
	//	return new Object[][] { {data2.get(0)}, {data2.get(1)}};
		
		return new Object[][] { {"swamy@test.com", "Virat@183" ,"ADIDAS ORIGINAL","Iphone 13 pro"}, {"swamy@test.com", "Virat@183", "ADIDAS ORIGINAL","ZARA COAT 3"}};
}
}
//List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"//src//test//java//rahulshettyacademy//data//PurchaseOrder.json");
//return new Object[][]  {{data.get(0)}, {data.get(1) } };


