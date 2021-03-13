package PomObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_lib.Base_test;

public class HomePage extends Base_test {
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//button[text()='✕']")
	private WebElement CancelButton;
	
	@FindBy(xpath="//input[@class='_3704LK']")
	private WebElement SearchBox;
	
	@FindBy(xpath="//button[@class='L0Z3Pu']")
	private WebElement SearchSubmiteButton;

	public WebElement getCancelButton() {
		return CancelButton;
	}

	public WebElement getSearchBox() {
		return SearchBox;
	}

	public WebElement getSearchSubmiteButton() {
		return SearchSubmiteButton;
	}
	
	public void Sreach_Options(String SearchDetails) throws Throwable
	{
		wLib.waitForHTMLDOM(driver);
		CancelButton.click();
		SearchBox.sendKeys(SearchDetails);
		SearchSubmiteButton.click();
		
		
	}
	}


