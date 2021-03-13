package Generic_lib;

import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.google.common.io.Files;

public class WebDriverCommomLib 
{
	WebDriver driver;
	
	public String getpagetitile( WebDriver driver)
	{
		return driver.getTitle();
	}
	public void verify(String actual,String expected,String value)
	{
		Assert.assertEquals(actual, expected);
		Reporter.log(value+"is displayed", true);
	}
	
	public void selectoption(WebElement element,int index)
	{
		Select s1 = new Select(element);
		s1.selectByIndex(index);
	}
	public void selectoption(WebElement element,String value)
	{
		Select s1 = new Select(element);
		s1.selectByValue(value);
	}
	
	public void selectoption(String text,WebElement element)
	{
		Select s1 = new Select(element);
		s1.selectByVisibleText(text);
	}
	
	
	
	public void switchtoframe( WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
		
	}
	
	public void switchtoframe( WebDriver driver,String attribute)
	{
		driver.switchTo().frame(attribute);
	}
	
	
	public void switchtoframe( WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	public void waitForHTMLDOM(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	public void waitforpage( WebDriver driver, String tittle)
	{
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.titleContains(tittle));
	}
	
	public void mouseover( WebDriver driver,WebElement element)
	
	{
		Actions ac = new Actions(driver);
		
		ac.moveToElement(element).perform();
	}
	 public void takepagescreenshort( WebDriver driver,String name) throws Throwable
	 {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File scr = ts.getScreenshotAs(OutputType.FILE);
		
		File dist = new File("./screenshort/"+name+".png");
		Files.copy(scr, dist);
	 }
		public void waitforelement( WebElement element) throws Throwable {
			  int count = 0;
		        while(count < 40) {
				   try {
					   element.isDisplayed();
				     break;
				   }catch (Throwable e) {
					Thread.sleep(500);
					count++;
				   }
		        }
		}
	 public void waitforelement(WebElement element, WebDriver driver)
		{
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		
		public void waitforelementtovisibil(WebElement element, WebDriver driver)
		{
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		
		public void switchToWindow(String partialwindowtitle)
		{
			  /*get all window session ID*/
			   Set<String> set = driver.getWindowHandles();
			   Iterator<String> it = set.iterator();
			    
			   while(it.hasNext()) {
				   String winID = it.next();
				   driver.switchTo().window(winID);
				   String actTitle = driver.getTitle();
				   if(actTitle.contains(partialwindowtitle)) {
					   System.out.println("swicthed to actual winow");
					   break;
				   }
			   }
		}
		
		
		public void alertaccept( WebDriver driver)
		{
			driver.switchTo().alert().accept();
		}
		
		public void alertdismis( WebDriver driver)
		{
			driver.switchTo().alert().dismiss();
		}
		
	 
	
	

}
