package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
 
    @FindBy(xpath = "//input[@id='userEmail']")
    private	WebElement email;
	@FindBy(xpath = "//input[@id='userPassword']")
	private WebElement pwd;
	@FindBy(xpath="//input[@id='login']")
	WebElement loginbtn;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errormessage;
	
	
	
	public void login(String useremail, String userpwd) {
		email.sendKeys(useremail);
		pwd.sendKeys(userpwd);
		loginbtn.click();
//		String pageTitle = driver.getTitle();
//		System.out.println(pageTitle);
	}
	public String errorLogin() throws InterruptedException {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	wait.until(ExpectedConditions.visibilityOf(errormessage));
	return errormessage.getText();
		
		//return errormsg;
	 }
	
	
}


 