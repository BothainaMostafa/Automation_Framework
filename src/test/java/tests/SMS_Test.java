package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import loginData.ExcelReader;
import pages.ChatPage;
import pages.UserLoginPage;

public class SMS_Test extends TestBase
{
	UserLoginPage userLoginObject;
	ChatPage chatObject;

	//user can login successfully
	@BeforeMethod
	public void userLogin() throws Exception
	{
		startChromeDriver();
		userLoginObject = new UserLoginPage(driver);
		ExcelReader.setExcelFile(System.getProperty("user.dir")+"//SMS_Test//Login Data.xlsx", "Login Data");
		userLoginObject.userLogin(ExcelReader.getCellData(1, 0), ExcelReader.getCellData(1, 1), ExcelReader.getCellData(1,2), ExcelReader.getCellData(1,3));
	}
	
	@Test (enabled = true, priority = 1)
	public void OTP_TC1() throws Exception
	{
		chatObject = new ChatPage(driver);
		chatObject.genericTestCase("//SMS_Test//", "OTP_TC1");
		Thread.sleep(3000);
	}
	
	@AfterMethod (enabled = false)
	public void userLogout()
	{
		quitDriver();
	}
}