package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase 
{
	//create general webdriver
	protected WebDriver driver;
	public WebDriverWait wait;
	
	//create constructor
	@SuppressWarnings("deprecation")
	public PageBase (WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, 60);
	}
}