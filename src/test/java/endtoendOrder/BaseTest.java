package endtoendOrder;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import pages.LoginPage;

public class BaseTest {
public static WebDriver driver;
//public LoginPage loginpage;
String url = "https://rahulshettyacademy.com/client/";
	public  void browserSetup() {
	 driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	
//	loginpage.openurl();
	//return driver;
	}
	public List<HashMap<String, String>> readData(String filePath) throws IOException {
		// converting json data to string
		System.out.println("File Path:"+ System.getProperty("user.dir")+"\\src\\test\\java\\dataUtitlity\\PurchaseData.json");
		File file = new File(filePath);
		if(!file.exists()) {
			System.out.println("File does not exist at path: " +filePath);
			return null;
		}
	String jsonData=	FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
	//System.out.println("json data content: "+jsonData);
		
		// converting string data to Hashmap
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String, String>> data=	mapper.readValue(jsonData, new TypeReference<List<HashMap<String, String>>>(){
			
		});
	//	System.out.println("Parsed Data: " +data);

		return data;
}
	public static String getScreenshot(String testcaseName, WebDriver driver) {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir")+"\\screenshots\\"+testcaseName+".png");
		src.renameTo(dest);
		return System.getProperty("user.dir")+"\\screenshots\\"+testcaseName+".png";
		
	}
	public void openURL() {
		
			driver.get(url);
		
	}
	@BeforeMethod (alwaysRun=true)
	public void loginApp() {
	browserSetup();
      openURL();
        
		
	}
	@AfterMethod(alwaysRun=true)
	public void closeBrowser() {
		driver.quit();
	}
}