package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import loginData.ExcelReader;
import pages.ChatPage;
import pages.UserLoginPage;

public class EVO_Epics extends TestBase
{
	UserLoginPage userLoginObject;
	ChatPage chatObject;

	//user can login successfully
	@BeforeMethod
	public void userLogin() throws Exception
	{
		startChromeDriver();
		userLoginObject = new UserLoginPage(driver);
		ExcelReader.setExcelFile(System.getProperty("user.dir")+"//EVO Epics//Login Data.xlsx", "Login Data");
		userLoginObject.userLogin(ExcelReader.getCellData(1, 0), ExcelReader.getCellData(1, 1), ExcelReader.getCellData(1,2), ExcelReader.getCellData(1,3));
	}

	@Test (enabled = true, priority = 1)
	public void evoEpics_TC1() throws Exception
	{
		chatObject = new ChatPage(driver);
		chatObject.genericTestCase("//EVO Epics//", "EVO_TC1");
		Thread.sleep(3000);
	}
	
	@Test (enabled = true, priority = 2)
	public void evoEpics_TC2() throws Exception
	{
		chatObject = new ChatPage(driver);
		chatObject.genericTestCase("//EVO Epics//", "EVO_TC2");
		Thread.sleep(3000);
	}
	
	@Test (enabled = true, priority = 3)
	public void evoEpics_TC3() throws Exception
	{
		chatObject = new ChatPage(driver);
		chatObject.genericTestCase("//EVO Epics//", "EVO_TC3");
		Thread.sleep(3000);
	}
	
	@Test (enabled = true, priority = 4)
	public void evoEpics_TC4() throws Exception
	{
		chatObject = new ChatPage(driver);
		chatObject.genericTestCase("//EVO Epics//", "EVO_TC4");
		Thread.sleep(3000);
	}
	
	@Test (enabled = true, priority = 5)
	public void evoEpics_TC5() throws Exception
	{
		chatObject = new ChatPage(driver);
		chatObject.genericTestCase("//EVO Epics//", "EVO_TC5");
		Thread.sleep(3000);
	}
	
	@Test (enabled = true, priority = 6)
	public void evoEpics_TC6() throws Exception
	{
		chatObject = new ChatPage(driver);
		chatObject.genericTestCase("//EVO Epics//", "EVO_TC6");
		Thread.sleep(3000);
	}
	
	@Test (enabled = true, priority = 7)
	public void evoEpics_TC7() throws Exception
	{
		chatObject = new ChatPage(driver);
		chatObject.genericTestCase("//EVO Epics//", "EVO_TC7");
		Thread.sleep(3000);
	}
	
	@AfterMethod (enabled = true)
	public void userLogout()
	{
		quitDriver();
	}
}
