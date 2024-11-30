package endtoendOrder;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckoutPage;
import pages.ConfirmationPage;
import pages.LoginPage;
import pages.OrdersPage;
import pages.ProductCatalougePage;

//import pages.LoginPage;
public class ErrorValidation extends BaseTest {
	String item1 = "ADIDAS ORIGINAL";
	String item2 = "Iphone 13 pro";
	LoginPage loginpage = new LoginPage(driver);
	
	@Test()
	public void verifyErrormessage() throws InterruptedException {
		loginpage=new LoginPage(driver);
	    loginpage.login("swamy@test.com", "123");
	String errormsg=loginpage.errorLogin();
		Assert.assertEquals("Incorrect email  password.", errormsg);
	}
	@Test()
	 public void errorProductValidation() throws InterruptedException {
		 LoginPage loginpage = new LoginPage(driver);
			loginpage.login("swamy@test.com", "Virat@183");
		OrdersPage orders = new OrdersPage(driver);
		
			boolean match =orders.VerifyorderedItemsPage("RedMI");
			Assert.assertTrue(match);
	 }
}