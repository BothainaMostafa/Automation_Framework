package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import loginData.ExcelReader;
import pages.ChatPage;
import pages.UserLoginPage;

public class Epic_M extends TestBase
{
	UserLoginPage userLoginObject;
	ChatPage chatObject;

	//user can login successfully
	@BeforeMethod
	public void userLogin() throws Exception
	{
		startFirefoxDriver();
		userLoginObject = new UserLoginPage(driver);
		ExcelReader.setExcelFile(System.getProperty("user.dir")+"//Epic_M//Login Data.xlsx", "Login Data");
		userLoginObject.userLogin(ExcelReader.getCellData(1, 0), ExcelReader.getCellData(1, 1), ExcelReader.getCellData(1,2), ExcelReader.getCellData(1,3));
	}

	@Test (enabled = false, priority = 1)
	public void epicM_TC1() throws Exception
	{
		chatObject = new ChatPage(driver);
		chatObject.genericTestCase("//Epic_M//1. Connectivity//", "Epic_M TC1.1");
		Thread.sleep(3000);
	}
	
	@Test (enabled = false, priority = 2)
	public void epicM_TC2() throws Exception
	{
		chatObject = new ChatPage(driver);
		chatObject.genericTestCase("//Epic_M//1. Connectivity//", "Epic_M TC1.2");
		Thread.sleep(3000);
	}
	
	@Test (enabled = false, priority = 3)
	public void epicM_TC3() throws Exception
	{
		chatObject = new ChatPage(driver);
		chatObject.genericTestCase("//Epic_M//1. Connectivity//", "Epic_M TC1.3");
		Thread.sleep(3000);
	}
	
	@Test (enabled = false, priority = 4)
	public void epicM_TC4() throws Exception
	{
		chatObject = new ChatPage(driver);
		chatObject.genericTestCase("//Epic_M//1. Connectivity//", "Epic_M TC1.4");
		Thread.sleep(3000);
	}
	
	@Test (enabled = false, priority = 5)
	public void epicM_TC5() throws Exception
	{
		chatObject = new ChatPage(driver);
		chatObject.genericTestCase("//Epic_M//1. Connectivity//", "Epic_M TC1.5");
		Thread.sleep(3000);
	}
	
	@Test (enabled = false, priority = 6)
	public void epicM_TC6() throws Exception
	{
		chatObject = new ChatPage(driver);
		chatObject.genericTestCase("//Epic_M//1. Connectivity//", "Epic_M TC1.6.1");
		Thread.sleep(3000);
	}
	
	@Test (enabled = false, priority = 7)
	public void epicM_TC7() throws Exception
	{
		chatObject = new ChatPage(driver);
		chatObject.genericTestCase("//Epic_M//1. Connectivity//", "Epic_M TC1.6");
		Thread.sleep(3000);
	}
	
	@Test (enabled = false, priority = 8)
	public void epicM_TC8() throws Exception
	{
		chatObject = new ChatPage(driver);
		chatObject.genericTestCase("//Epic_M//1. Connectivity//", "Epic_M TC1.7");
		Thread.sleep(3000);
	}
	
	@Test (enabled = false, priority = 9)
	public void epicM_TC9() throws Exception
	{
		chatObject = new ChatPage(driver);
		chatObject.genericTestCase("//Epic_M//1. Connectivity//", "Epic_M TC1.8.1");
		Thread.sleep(3000);
	}
	
	@Test (enabled = false, priority = 10)
	public void epicM_TC10() throws Exception
	{
		chatObject = new ChatPage(driver);
		chatObject.genericTestCase("//Epic_M//1. Connectivity//", "Epic_M TC1.8");
		Thread.sleep(3000);
	}
	
	@Test (enabled = false, priority = 11)
	public void epicM_TC11() throws Exception
	{
		chatObject = new ChatPage(driver);
		chatObject.genericTestCase("//Epic_M//1. Connectivity//", "Epic_M TC1.9.1");
		Thread.sleep(3000);
	}
	
	@Test (enabled = false, priority = 12)
	public void epicM_TC12() throws Exception
	{
		chatObject = new ChatPage(driver);
		chatObject.genericTestCase("//Epic_M//1. Connectivity//", "Epic_M TC1.9");
		Thread.sleep(3000);
	}
	
	@Test (enabled = false, priority = 13)
	public void epicM_TC13() throws Exception
	{
		chatObject = new ChatPage(driver);
		chatObject.genericTestCase("//Epic_M//2. Common Webmail Validation//", "Epic_M TC2.1");
		Thread.sleep(3000);
	}
	
	@Test (enabled = false, priority = 14)
	public void epicM_TC14() throws Exception
	{
		chatObject = new ChatPage(driver);
		chatObject.genericTestCase("//Epic_M//2. Common Webmail Validation//", "Epic_M TC2.2");
		Thread.sleep(3000);
	}
	
	@Test (enabled = false, priority = 15)
	public void epicM_TC15() throws Exception
	{
		chatObject = new ChatPage(driver);
		chatObject.genericTestCase("//Epic_M//2. Common Webmail Validation//", "Epic_M TC2.3");
		Thread.sleep(3000);
	}
	
	@Test (enabled = false, priority = 16)
	public void epicM_TC16() throws Exception
	{
		chatObject = new ChatPage(driver);
		chatObject.genericTestCase("//Epic_M//2. Common Webmail Validation//", "Epic_M TC2.4");
		Thread.sleep(3000);
	}
	
	@Test (enabled = false, priority = 17)
	public void epicM_TC17() throws Exception
	{
		chatObject = new ChatPage(driver);
		chatObject.genericTestCase("//Epic_M//2. Common Webmail Validation//", "Epic_M TC2.5");
		Thread.sleep(3000);
	}
	
	@Test (enabled = false, priority = 18)
	public void epicM_TC18() throws Exception
	{
		chatObject = new ChatPage(driver);
		chatObject.genericTestCase("//Epic_M//2. Common Webmail Validation//", "Epic_M TC2.6");
		Thread.sleep(3000);
	}
	
	@Test (enabled = false, priority = 19)
	public void epicM_TC19() throws Exception
	{
		chatObject = new ChatPage(driver);
		chatObject.genericTestCase("//Epic_M//2. Common Webmail Validation//", "Epic_M TC2.7");
		Thread.sleep(3000);
	}
	
	@Test (enabled = false, priority = 20)
	public void epicM_TC20() throws Exception
	{
		chatObject = new ChatPage(driver);
		chatObject.genericTestCase("//Epic_M//3. Launch//", "Epic_M TC3.1");
		Thread.sleep(3000);
	}
	
	@Test (enabled = false, priority = 21)
	public void epicM_TC21() throws Exception
	{
		chatObject = new ChatPage(driver);
		chatObject.genericTestCase("//Epic_M//3. Launch//", "Epic_M TC3.2");
		Thread.sleep(3000);
	}
	
	@Test (enabled = false, priority = 22)
	public void epicM_TC22() throws Exception
	{
		chatObject = new ChatPage(driver);
		chatObject.genericTestCase("//Epic_M//3. Launch//", "Epic_M TC3.3");
		Thread.sleep(3000);
	}
	
	@Test (enabled = false, priority = 23)
	public void epicM_TC23() throws Exception
	{
		chatObject = new ChatPage(driver);
		chatObject.genericTestCase("//Epic_M//3. Launch//", "Epic_M TC3.3.1");
		Thread.sleep(3000);
	}
	
	@Test (enabled = true, priority = 24)
	public void epicM_TC24() throws Exception
	{
		chatObject = new ChatPage(driver);
		chatObject.genericTestCase("//Epic_M//3. Launch//", "Epic_M TC3.4");
		Thread.sleep(3000);
	}
	
	@Test (enabled = false, priority = 25)
	public void epicM_TC25() throws Exception
	{
		chatObject = new ChatPage(driver);
		chatObject.genericTestCase("//Epic_M//3. Launch//", "Epic_M TC3.4.1");
		Thread.sleep(3000);
	}
	
	@AfterMethod (enabled = false)
	public void userLogout()
	{
		quitDriver();
	}
}