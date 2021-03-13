package PomObjectRepo;




import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import Generic_lib.Base_test;

public class Product_page extends Base_test {
	
	public Product_page(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//div[@class='_1YAKP4']/descendant::select[@class='_2YxCDZ']")
	private WebElement dropDown;
	
	
	
	public WebElement getDropDown() {
		return dropDown;
	}

	public void Product_Page()
	{
		wLib.waitForHTMLDOM(driver);
		wLib.selectoption(dropDown, "10000");
		driver.navigate().refresh();
		
	List<WebElement> phones = driver.findElements(By.xpath("//div[@class='_4rR01T']"));
		
		Set<String> st = new TreeSet<String>();
		
		for(WebElement elemnt:phones)
		{
			String text = elemnt.getText();
			st.add(text);
		}
		for(String texts:st)
		{
			System.out.println(texts);
		}
	}

}
