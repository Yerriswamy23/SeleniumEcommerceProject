package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductCatalougePage extends AbstractCommonMethods{

	WebDriver driver;
	

	public ProductCatalougePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	
	
	@FindBy(xpath ="//div[@class='card']//div[@class='card-body']//b" )
	List<WebElement> items;
	
	@FindBy(css = ".btn.btn-custom[routerlink='/dashboard/cart']")
	WebElement cart;
	
	public List<WebElement> allItems() {
		for (WebElement item : items) {
			System.out.println(item.getText());

		}
		return items;
	}
	
	public void addingItems(String item1, String item2)
	{
		for (int i = 0; i < items.size(); i++) {
			WebElement item = items.get(i);
			if (item.getText().equalsIgnoreCase(item1)//"Iphone 13 pro"
					|| item.getText().equalsIgnoreCase(item2)) //"ADIDAS ORIGINAL"
			{
				WebElement addtoCart = driver.findElement(By.xpath("//div[@class='row']//div[" + (i + 1) + "]//div[1]//div[1]//button[2]"));
				jsMethod(addtoCart);
			}

		}
		
	}
	public void clickCartbtn() {
		
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].click();", cart);
		jsMethod(cart);
	}
	
}
