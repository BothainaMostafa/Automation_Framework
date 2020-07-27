package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import loginData.ExcelReader;
import pages.ChatPage;
import pages.UserLoginPage;

public class Epic_M_German extends TestBase
{
	UserLoginPage userLoginObject;
	ChatPage chatObject;

	//user can login successfully
	@BeforeMethod
	public void userLogin() throws Exception
	{
		startFirefoxDriver();
		userLoginObject = new UserLoginPage(driver);
		ExcelReader.setExcelFile(System.getProperty("user.dir")+"//Epic_M_German//Login Data.xlsx", "Login Data");
		userLoginObject.userLogin(ExcelReader.getCellData(1, 0), ExcelReader.getCellData(1, 1), ExcelReader.getCellData(1,2), ExcelReader.getCellData(1,3));
	}

	@Test (enabled = true, priority = 1)
	public void epicM_German() throws Exception
	{
		chatObject = new ChatPage(driver);
		chatObject.genericTestCase("//Epic_M_German//", "Epic_M TC1");
		Thread.sleep(3000);
	}
	
	
	@AfterMethod (enabled = false)
	public void userLogout()
	{
		quitDriver();
	}
}
