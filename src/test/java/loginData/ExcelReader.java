package loginData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFFormulaEvaluator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader 
{
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;

	public FileInputStream fis = null;

	//This method is to set the File path and to open the Excel file, Pass Excel Path and Sheetname as Arguments to this method

	public static void setExcelFile(String path,String sheetName) throws Exception 
	{
		try 
		{
			FileInputStream ExcelFile = new FileInputStream(path);
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(sheetName);
		}
		
		catch(Exception e)
		{
			throw (e);
		}
	}

	//This method is to read the test data from the Excel cell, in this we are passing parameters as rowNum and colNum

    public static String getCellData (int rowNum, int colNum) throws Exception
    {
    	try
    	{
		Cell = ExcelWSheet.getRow(rowNum).getCell(colNum);
		String cellData = Cell.getStringCellValue();
    	return cellData;
    	}
    	
    	catch(Exception e)
		{
			throw (e);
		} 
    }    
    
    public FileInputStream getFileInputStream ()
	{
		String filePath = System.getProperty("user.dir")+"/Epic D.xlsx";
		File testData = new File(filePath);

		try 
		{
			fis = new FileInputStream(testData);
		} 
		catch (FileNotFoundException e) 
		{
			System.out.println("Error Occurred" + e.getMessage());
			System.exit(0);
		}

		return fis;	
	}

	public Object [][] getExcelData () throws IOException
	{
		fis = getFileInputStream();
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFFormulaEvaluator.evaluateAllFormulaCells(wb);
		XSSFSheet sheet = wb.getSheet("Login Data");

		int totalNumberOfRows = sheet.getLastRowNum()+1;
		int totalNumberOfColumns = 2;

		String[][] arrayExcelData = new String [totalNumberOfRows][totalNumberOfColumns];

		for (int row = 0; row <totalNumberOfRows; row++)
		{
			for (int column = 0; column < totalNumberOfColumns; column++)
			{
				XSSFRow numberOfRow = sheet.getRow(row);
				arrayExcelData [row][column] = numberOfRow.getCell(column).toString();
			}	
		}	
		wb.close();
		return arrayExcelData;
	}

	public String getCellData(Object excelData [][],int row,int column) throws IOException
	{
		excelData = getExcelData();
		return excelData[row][column].toString();
	}
}
