package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class SMS extends PageBase
{
	public SMS (WebDriver driver)
	{
		super (driver);
	}
	
	public void OTP() throws Exception 
	{
		String	firefoxPath = System.getProperty("user.dir") + "\\resources\\geckodriver.exe"; 
		System.setProperty("webdriver.gecko.driver", firefoxPath); 

		WebDriver driver2 = new FirefoxDriver();

		driver2.navigate().to("https://outlook.office365.com/owa/");

	
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='i0116']")));

		WebElement outlook_sign = driver2.findElement(By.xpath("//*[@id='i0116']"));

		outlook_sign.sendKeys("uk.viewer@vodafone.com");

		driver2.findElement(By.xpath("//*[@id=\"idSIButton9\"]")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"passwordArea\"]")));
		WebElement outlook_pass= driver2.findElement(By.xpath("//*[@id=\"passwordInput\"]") );
		outlook_pass.sendKeys("Tobi@CT01");
		WebElement outlook_sign1 = driver2.findElement(By.xpath("//*[@id=\"submitButton\"]"));
		outlook_sign1.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"idSIButton9\"]")));
		WebElement outlook_yes = driver2.findElement(By.xpath("//*[@id=\"idSIButton9\"]"));
		outlook_yes.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div[3]/div[2]/div/div[1]/div[2]/div/div/div/div/div/div/div[1]/div/div/div/div[2]/div[2]/div")));
		WebElement firstEMAIL = driver2.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div[3]/div[2]/div/div[1]/div[2]/div/div/div/div/div/div/div[1]/div/div/div/div[2]/div[2]/div"));
		firstEMAIL.click();
		//WebElement firstEMAIL_TITLE = driver2.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div[3]/div[2]/div/div[1]/div[2]/div/div/div/div/div/div/div[1]/div/div/div/div[2]/div[3]/div/div/span"));
		WebElement OTP = driver2.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/div/div[3]/div[2]/div/div[3]/div/div/div/div/div[2]/div/div[1]/div/div/div/div[2]/div[1]/div/div/div/div[2]"));
		OTP.click();
		String OTP_NUMBER =  OTP.getText();
		System.out.print(OTP_NUMBER);
	}
}



