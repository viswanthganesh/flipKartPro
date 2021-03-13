package Generic_lib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;





public class Base_test  implements IAnnotation
{
	public static WebDriver driver;

	public	Excellutills eLib = new Excellutills();

	public PropertyFileUtils pLib = new PropertyFileUtils();
	public WebDriverCommomLib wLib =new WebDriverCommomLib();
	@BeforeSuite
public void connect_to_Database()
{
	System.out.println("used to connect to data base");
}
	@BeforeTest
public void test_runner()
{
	System.out.println("get ready the custom report");
}
	@BeforeClass
public void Open_theBrowser() throws Throwable
{
	String Browser = pLib.getPropertykeyValue(PRO_path, "browser");
	if(Browser.equals("firefox"))
			{
		driver = new FirefoxDriver();
		
			}else if(Browser.equals("chrome")) {
				driver = new ChromeDriver();
			}else{
				driver = new InternetExplorerDriver();
			}
			wLib.waitForHTMLDOM(driver);
			String appUrl = pLib.getPropertykeyValue(PRO_path, "url");
			driver.get(appUrl);
}
	@BeforeMethod
public void EnterTheUserDetails()
{
	System.out.println("Enter the user details");
}
	@AfterMethod
public void configAm()
{
	System.out.println("used to logout from app");
}
	@AfterClass
public void configAc()
{
	System.out.println("used to close the browser");
	
	driver.quit();
}
	@AfterTest
public void configAt()
{
	System.out.println("used to fluse the reports");
}
	@AfterSuite
	public void configAs()
	{
		System.out.println("used to disconnect from db");
	}
}
