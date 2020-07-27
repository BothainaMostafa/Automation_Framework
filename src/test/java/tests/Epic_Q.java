package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import loginData.ExcelReader;
import pages.ChatPage;
import pages.UserLoginPage;

public class Epic_Q extends TestBase
{
	UserLoginPage userLoginObject;
	ChatPage chatObject;

	//user can login successfully
	@BeforeMethod
	public void userLogin() throws Exception
	{
		startFirefoxDriver();
		userLoginObject = new UserLoginPage(driver);
		ExcelReader.setExcelFile(System.getProperty("user.dir")+"//Epic_Q//Login Data.xlsx", "Login Data");
		userLoginObject.userLogin(ExcelReader.getCellData(1, 0), ExcelReader.getCellData(1, 1), ExcelReader.getCellData(1,2), ExcelReader.getCellData(1,3));
	}

	@Test (enabled = true, priority = 1)
	public void epicQ_TC1() throws Exception
	{
		chatObject =  new ChatPage(driver);
		chatObject.genericTestCase("//Epic_Q//1. Citrix Request//", "Epic Q_TC1");
		Thread.sleep(3000);
	}
	
	@Test (enabled = true, priority = 2)
	public void epicQ_TC2() throws Exception
	{
		chatObject =  new ChatPage(driver);
		chatObject.genericTestCase("//Epic_Q//1. Citrix Request//", "Epic Q_TC2");
		Thread.sleep(3000);
	}
	
	@Test (enabled = true, priority = 3)
	public void epicQ_TC3() throws Exception
	{
		chatObject =  new ChatPage(driver);
		chatObject.genericTestCase("//Epic_Q//1. Citrix Request//", "Epic Q_TC3");
		Thread.sleep(3000);
	}
	
	@Test (enabled = true, priority = 4)
	public void epicQ_TC4() throws Exception
	{
		chatObject =  new ChatPage(driver);
		chatObject.genericTestCase("//Epic_Q//1. Citrix Request//", "Epic Q_TC4");
		Thread.sleep(3000);
	}
	
	@Test (enabled = true, priority = 5)
	public void epicQ_TC5() throws Exception
	{
		chatObject =  new ChatPage(driver);
		chatObject.genericTestCase("//Epic_Q//1. Citrix Request//", "Epic Q_TC5");
		Thread.sleep(3000);
	}
	
	@Test (enabled = true, priority = 6)
	public void epicQ_TC6() throws Exception
	{
		chatObject =  new ChatPage(driver);
		chatObject.genericTestCase("//Epic_Q//1. Citrix Request//", "Epic Q_TC6");
		Thread.sleep(3000);
	}
	
	@Test (enabled = true, priority = 7)
	public void epicQ_TC7() throws Exception
	{
		chatObject =  new ChatPage(driver);
		chatObject.genericTestCase("//Epic_Q//1. Citrix Request//", "Epic Q_TC7");
		Thread.sleep(3000);
	}
	
	@Test (enabled = true, priority = 8)
	public void epicQ_TC8() throws Exception
	{
		chatObject =  new ChatPage(driver);
		chatObject.genericTestCase("//Epic_Q//1. Citrix Request//", "Epic Q_TC8");
		Thread.sleep(3000);
	}
	
	@Test (enabled = true, priority = 9)
	public void epicQ_TC9() throws Exception
	{
		chatObject =  new ChatPage(driver);
		chatObject.genericTestCase("//Epic_Q//1. Citrix Request//", "Epic Q_TC9");
		Thread.sleep(3000);
	}
	
	@Test (enabled = true, priority = 10)
	public void epicQ_TC10() throws Exception
	{
		chatObject =  new ChatPage(driver);
		chatObject.genericTestCase("//Epic_Q//1. Citrix Request//", "Epic Q_TC10");
		Thread.sleep(3000);
	}
	
	@Test (enabled = true, priority = 11)
	public void epicQ_TC11() throws Exception
	{
		chatObject =  new ChatPage(driver);
		chatObject.genericTestCase("//Epic_Q//1. Citrix Request//", "Epic Q_TC11");
		Thread.sleep(3000);
	}
	
	@Test (enabled = true, priority = 12)
	public void epicQ_TC12() throws Exception
	{
		chatObject =  new ChatPage(driver);
		chatObject.genericTestCase("//Epic_Q//1. Citrix Request//", "Epic Q_TC12");
		Thread.sleep(3000);
	}
	
	@Test (enabled = true, priority = 13)
	public void epicQ_TC13() throws Exception
	{
		chatObject =  new ChatPage(driver);
		chatObject.genericTestCase("//Epic_Q//1. Citrix Request//", "Epic Q_TC13");
		Thread.sleep(3000);
	}
	
	@Test (enabled = true, priority = 14)
	public void epicQ_TC14() throws Exception
	{
		chatObject =  new ChatPage(driver);
		chatObject.genericTestCase("//Epic_Q//1. Citrix Request//", "Epic Q_TC14");
		Thread.sleep(3000);
	}

	@Test (enabled = true, priority = 15)
	public void epicQ_TC15() throws Exception
	{
		chatObject =  new ChatPage(driver);
		chatObject.genericTestCase("//Epic_Q//2. Citrix Issues//", "Epic Q_TC15");
		Thread.sleep(3000);
	}
	
	@Test (enabled = true, priority = 16)
	public void epicQ_TC16() throws Exception
	{
		chatObject =  new ChatPage(driver);
		chatObject.genericTestCase("//Epic_Q//2. Citrix Issues//", "Epic Q_TC16");
		Thread.sleep(3000);
	}
	
	@Test (enabled = true, priority = 17)
	public void epicQ_TC17() throws Exception
	{
		chatObject =  new ChatPage(driver);
		chatObject.genericTestCase("//Epic_Q//2. Citrix Issues//", "Epic Q_TC17");
		Thread.sleep(3000);
	}
	
	@Test (enabled = true, priority = 18)
	public void epicQ_TC18() throws Exception
	{
		chatObject =  new ChatPage(driver);
		chatObject.genericTestCase("//Epic_Q//2. Citrix Issues//", "Epic Q_TC18");
		Thread.sleep(3000);
	}
	
	@Test (enabled = true, priority = 19)
	public void epicQ_TC19() throws Exception
	{
		chatObject =  new ChatPage(driver);
		chatObject.genericTestCase("//Epic_Q//2. Citrix Issues//", "Epic Q_TC19");
		Thread.sleep(3000);
	}
	
	@Test (enabled = true, priority = 20)
	public void epicQ_TC20() throws Exception
	{
		chatObject =  new ChatPage(driver);
		chatObject.genericTestCase("//Epic_Q//2. Citrix Issues//", "Epic Q_TC20");
		Thread.sleep(3000);
	}
	
	@Test (enabled = true, priority = 21)
	public void epicQ_TC21() throws Exception
	{
		chatObject =  new ChatPage(driver);
		chatObject.genericTestCase("//Epic_Q//2. Citrix Issues//", "Epic Q_TC21");
		Thread.sleep(3000);
	}
	
	@Test (enabled = true, priority = 22)
	public void epicQ_TC22() throws Exception
	{
		chatObject =  new ChatPage(driver);
		chatObject.genericTestCase("//Epic_Q//2. Citrix Issues//", "Epic Q_TC22");
		Thread.sleep(3000);
	}
	
	@Test (enabled = true, priority = 23)
	public void epicQ_TC23() throws Exception
	{
		chatObject =  new ChatPage(driver);
		chatObject.genericTestCase("//Epic_Q//2. Citrix Issues//", "Epic Q_TC23");
		Thread.sleep(3000);
	}
	
	@Test (enabled = true, priority = 24)
	public void epicQ_TC24() throws Exception
	{
		chatObject =  new ChatPage(driver);
		chatObject.genericTestCase("//Epic_Q//2. Citrix Issues//", "Epic Q_TC24");
		Thread.sleep(3000);
	}
	
	@Test (enabled = true, priority = 25)
	public void epicQ_TC25() throws Exception
	{
		chatObject =  new ChatPage(driver);
		chatObject.genericTestCase("//Epic_Q//2. Citrix Issues//", "Epic Q_TC25");
		Thread.sleep(3000);
	}
	
	@AfterMethod (enabled = false)
	public void closeDriver()
	{
		quitDriver();
	}
}
