package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import chatData.ExcelReader;

public class UserLoginPage extends PageBase
{	
	public UserLoginPage(WebDriver driver) 
	{
		super(driver);
	}
	
	@FindBy (xpath = "//input[@name='username']")
	WebElement emailTextBoxStage;
	
	@FindBy (xpath = "//input[@name='password']")
	WebElement passwordTextBoxStage;
	
	@FindBy (xpath = "//button[@type='submit']")
	WebElement submitButtonStage;
	
	@FindBy (xpath = "//input[@id='userNameInput']")
	WebElement emailTextBoxProd;
	
	@FindBy (xpath = "//input[@id='passwordInput']")
	WebElement passwordTextBoxProd;
	
	@FindBy (xpath = "//span[@id='submitButton']")
	WebElement submitButtonProd;
	
	@FindBy (xpath = "//input[@class='DomainList-search']")
	WebElement searchDomainName;
	
	public void userLogin (String emailAddress, String password, String environment, String domainName) throws Exception
	{
		ExcelReader.setExcelFile(System.getProperty("user.dir")+"/TOBi Data.xlsx", "TOBi URLs");
		
		if (environment.equalsIgnoreCase("Stage"))
		{
		//function enables user to login through TOBi Stage
		driver.navigate().to(ExcelReader.getCellData(0, 1));
		wait.until(ExpectedConditions.visibilityOf(emailTextBoxStage));
		emailTextBoxStage.sendKeys(emailAddress);
		passwordTextBoxStage.sendKeys(password);
		submitButtonStage.click();
		
		//navigate to new TOBi UI
		Thread.sleep(2000);
		wait.until(ExpectedConditions.visibilityOf(searchDomainName));
		driver.navigate().to(ExcelReader.getCellData(1, 1));
		}
		
		else if (environment.equalsIgnoreCase("UAT"))
		{
			//function enables user to login through TOBi UAT
			driver.navigate().to(ExcelReader.getCellData(2, 1));
			wait.until(ExpectedConditions.visibilityOf(emailTextBoxProd));
			emailTextBoxProd.sendKeys(emailAddress);
			passwordTextBoxProd.sendKeys(password);
			submitButtonProd.click();
		}
		
		else if (environment.equalsIgnoreCase("Prod"))
		{
			//function enables user to login through TOBi UAT
			driver.navigate().to(ExcelReader.getCellData(3, 1));
			wait.until(ExpectedConditions.visibilityOf(emailTextBoxProd));
			emailTextBoxProd.sendKeys(emailAddress);
			passwordTextBoxProd.sendKeys(password);
			submitButtonProd.click();
		}
		
		else
		{
			System.out.print("Please Enter Domain Name: Stage, UAT, Prod");
		}
				
		//function that selects the domain
		wait.until(ExpectedConditions.visibilityOf(searchDomainName));
		String domainNameXpathGeneric = "//*[contains(text(), '%s')]";
		String domainNameXpath = String.format(domainNameXpathGeneric, domainName);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(domainNameXpath))).click();
	}
}