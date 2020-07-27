package pages;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
//import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import chatData.*;
import pages.SMS;

public class ChatPage extends PageBase
{
	public ChatPage(WebDriver driver)
	{
		super(driver);
	}

	@FindBy (xpath = "//textarea")
	WebElement txtArea;
	
	@FindBy (xpath = "//button[@type='submit']")
	WebElement submitButton;

	@FindBy (xpath = "//div[@class='Lightbox-header']/h6")
	WebElement pdfName;

	@FindBy (xpath = "//div//span[@class='Icon--close']")
	WebElement closePDFButton;

	@FindBy (xpath = "//img[@class='present-image']")
	WebElement imageSayLemma;

	@FindBy (xpath = "//div[@class='ChatNote_container']//div[@class='MarkUp__wrapper']")
	WebElement rightHandPane;

	@FindBy (xpath = "//a[@href='https://myitshop.internal.vodafone.com/citrix']//div[@class='MarkUp__wrapper']")
	WebElement hyperLink;

	@FindBy (xpath = "//div[@class='Messages__container']")
	WebElement messageBody;

	@FindBy (xpath = "//div[@class='ChatInput__helper powered-by-amelia']")
	WebElement disclaimerMessage;

	public void assertAmeliaSayLemma(WebElement actualSayLemma, String expectedSaylemma, int i) throws Exception
	{
		wait.until(ExpectedConditions.visibilityOf(txtArea));
		wait.until(ExpectedConditions.visibilityOf(actualSayLemma));

		if (actualSayLemma.getText().equals("Loading PDF…") || expectedSaylemma.contains("pdf"))
		{	
			String xpathGeneric = "//div[@class='message-chat transition-done message-chat--amelia'][%s]//button[@class='preview']";
			String xpath = String.format(xpathGeneric, i);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
			WebElement previewButton = driver.findElement(By.xpath(xpath));
			Thread.sleep(3000);
			Actions act = new Actions (driver);
			act.moveToElement(previewButton).click().perform();
			previewButton.click();
			wait.until(ExpectedConditions.visibilityOf(pdfName));
			Assert.assertEquals(pdfName.getText(), expectedSaylemma);
			closePDFButton.click();
		}

		else if (driver.findElements(By.xpath("//img[@class='present-image']")).size() != 0 && expectedSaylemma.contains(".png"))
		{
			String xpathGeneric = "//div[@class='message-chat transition-done message-chat--amelia'][%s]//button[@class='preview']";
			String xpath = String.format(xpathGeneric, i);
			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
			WebElement previewButton = driver.findElement(By.xpath(xpath));
			Thread.sleep(3000);
			Actions act = new Actions (driver);
			act.moveToElement(previewButton).click().perform();
			previewButton.click();
			wait.until(ExpectedConditions.visibilityOf(pdfName));
			Assert.assertEquals(pdfName.getText(), expectedSaylemma);
			closePDFButton.click();
		}

		else
		{
			//Assert.assertEquals(actualSayLemma.getText(), expectedSaylemma);
			Assert.assertTrue(actualSayLemma.getText().contains(expectedSaylemma));

		}
	}

	public void checkRegex(String ticketSayLemma) throws Exception 
	{
		String regex = "(INC[0-9]+|REQ[0-9]+)";

		Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
		Matcher matcher = pattern.matcher(ticketSayLemma);
		if (matcher.find())
		{
			ExcelReader.writeDataInCell(matcher.group(0));
		}
	}

	public void genericTestCase (String filePath, String excelFileName) throws Exception
	{	
		ExcelReader.setExcelFile(System.getProperty("user.dir") + filePath + String.format("/%s.xlsx", excelFileName), "Sheet1");
		for (int i = 1; i <= ExcelReader.getExcelSize()-1 ; i ++)
		{
			System.out.println(i);
			String xpathGeneric = "//div[@class='message-chat transition-done message-chat--amelia'][%s]/div[1]";
			String xpath = String.format(xpathGeneric, i);

			wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
			WebElement actualSayLemma = driver.findElement(By.xpath(xpath));


			//If Condition that manages TOBi's Column in the Excel Sheet
			if (ExcelReader.getCellData(i, 2).contains("incident_id"))
			{
				checkRegex (actualSayLemma.getText());
				ExcelReader.setExcelFile(System.getProperty("user.dir")+ filePath + String.format("/%s.xlsx", excelFileName), "Sheet1");
			}
			else
			{
				assertAmeliaSayLemma(actualSayLemma, ExcelReader.getCellData(i, 2), i);
			}


			//If Condition that manages hint message in text box
			if (ExcelReader.getCellData(i, 5) == "")
			{
				//Cell in the Excel Sheet will be skipped	
			} 

			else
			{
				Assert.assertEquals(driver.findElement(By.xpath("//textarea[@placeholder]")).getAttribute("placeholder"), ExcelReader.getCellData(i, 5));
			}	


			//If Condition that manages User's Column in the Excel Sheet
			if (ExcelReader.getCellData(i, 1) == "")
			{
				//Cell in the Excel Sheet will be skipped
			}	

			else if (ExcelReader.getCellData(i, 1).contains("Button"))
			{
				String buttonGeneric = ExcelReader.getCellData(i, 1);
				String [] buttonParts = buttonGeneric.split("_");

				String buttonIdGeneric = "name-%s";
				String buttonId = String.format(buttonIdGeneric, buttonParts[1]);
				WebElement button = driver.findElement(By.id(buttonId));
				wait.until(ExpectedConditions.elementToBeClickable(button));
				button.click();
				
				//String buttonIdGeneric = "//input[@value='%s']";
				//String buttonId = String.format(buttonIdGeneric, buttonParts[1]);
				//WebElement button = driver.findElement(By.xpath(buttonId));
				//wait.until(ExpectedConditions.elementToBeClickable(button));
				//button.click();
			}
			
			else if(ExcelReader.getCellData(i, 1).contains("OTP"))
			{
				SMS OTP = new SMS(driver);
				OTP.OTP();
			}

			else
			{
				txtArea.isEnabled();
				txtArea.clear();
				txtArea.sendKeys(ExcelReader.getCellData(i, 1));
				//wait.until(ExpectedConditions.textToBePresentInElementValue(txtArea, ExcelReader.getCellData(i, 1)));
				//wait.until(ExpectedConditions.elementToBeClickable(submitButton));
				//txtArea.sendKeys(Keys.ENTER);
				submitButton.click();
			}


			//If Condition that manages RHS Column in the Excel Sheet
			if (ExcelReader.getCellData(i, 3) == "")
			{
				//Cell in the Excel Sheet will be skipped
			}

			else
			{
				Thread.sleep(1000);
				Assert.assertEquals(rightHandPane.getText(), ExcelReader.getCellData(i, 3));
			}


			//If condition that manages the Links column in the Excel Sheet
			if (ExcelReader.getCellData(i, 4) == "")
			{
				//Cell in the Excel Sheet will be skipped
			}

			else
			{
				//$('input[name*="username"]').length;
				Assert.assertEquals(driver.findElement(By.xpath(xpath + "//a")).getAttribute("href"), ExcelReader.getCellData(i, 4));
			}	
		}

		DocReader doc = new DocReader();
		doc.newWordDoc(filePath, excelFileName, messageBody.getText());
	}
}