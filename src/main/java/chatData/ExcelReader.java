package chatData;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader 
{
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	public static XSSFCell Cell;

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
			if (Cell.getCellType() == CellType.STRING)
			{
				String cellData = Cell.getStringCellValue();
				return cellData;
			}
			else
			{
				return "";
			}
		}

		catch(Exception e)
		{
			return "";
		}
	}

	public static int getExcelSize ()
	{
		return ExcelWSheet.getLastRowNum()+1;
	}

	public static void writeDataInCell(String data) throws Exception
	{
		String excelFilePath = System.getProperty("user.dir") + "/Tickets.xlsx";
		setExcelFile(excelFilePath, "Sheet1");
		Row row = ExcelWSheet.createRow(getExcelSize());
		Cell = (XSSFCell) row.createCell(0, CellType.STRING);
		
		Cell.setCellValue(data);
		FileOutputStream fos = new FileOutputStream(excelFilePath);
		ExcelWBook.write(fos);
		fos.close();
	}


	public FileInputStream getFileInputStream (String excelFileName) 
	{
		String excelFileNameFull = String.format("/%s.xlsx", excelFileName); 
		String filePath = System.getProperty("user.dir")+excelFileNameFull; 
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
}