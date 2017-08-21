package Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

public class DataProviderSource {
	
	public static WebDriver driver= null;
	public static XSSFWorkbook excelWorkbook = null;
	public static XSSFSheet excelSheet = null;
	public static XSSFRow row = null;
	public static XSSFCell cell = null;
	
	@DataProvider(name="CafeData") // supplying data for a test method.
	public static Object[][] getLocationData() throws IOException {
	FileInputStream fis = new FileInputStream("C:\\SeleniumFiles\\data\\datasource_CafeTown.xlsx"); // Your .xlsx file name along with path
	excelWorkbook = new XSSFWorkbook(fis);
	// Read sheet inside the workbook by its name
	//Refer sheet name here.
	String sheet = "CafeData";
	excelSheet = excelWorkbook.getSheet(sheet); //Your sheet name
	// Find number of rows in excel file
	System.out.println("First Row Number/index:"+ excelSheet.getFirstRowNum() + " *** Last Row Number/index:"
	+ excelSheet.getLastRowNum());
	int rowCount = excelSheet.getLastRowNum() - excelSheet.getFirstRowNum()+1;
	int colCount = excelSheet.getRow(0).getLastCellNum();
	System.out.println("Row Count is: " + rowCount
	+ " *** Column count is: " + colCount);
	Object data[][] = new Object[rowCount-1][colCount];
	for (int rNum = 2; rNum <= rowCount; rNum++) {
	for (int cNum = 0; cNum < colCount; cNum++) {
	System.out.print(getCellData(sheet, cNum, rNum) + " "); // Your sheet name
	data[rNum - 2][cNum] = getCellData(sheet, cNum, rNum); //Your sheet name
	}
	System.out.println();
	}
	//This part of code gets only those rows from excel with flag "Y".
	int j = 0; 
	int arrRowCount=0; 
	for (int i = 0; i < data.length; i++) { 
	    if((data[i][colCount-1]).equals("Y"))
	    { 
	        arrRowCount++; 

	        } 
	    }
	//Once we have row count with flag = "Y" then it gets data for that row and return in retData array
	       j=0;
	        Object[][] retData = new Object[arrRowCount][colCount]; 
	                for (int i = 0; i < data.length; i++) 
	                { 
	                    if ((data[i][colCount-1]).equals("Y")) {
	                        retData[j] = data[i]; j++; }
	                } 
	                return retData;
	}

	// Function will always used as below. It returns the data from a cell - No need to make any changes
	public static String getCellData(String sheetName, int colNum, int rowNum) {
	try {
	if (rowNum <= 0)
	return "";
	int index = excelWorkbook.getSheetIndex(sheetName);
	if (index == -1)
	return "";
	excelSheet = excelWorkbook.getSheetAt(index);
	row = excelSheet.getRow(rowNum - 1);
	if (row == null)
	return "";
	cell = row.getCell(colNum);
	if (cell == null)
	return "";
	if (cell.getCellType() == Cell.CELL_TYPE_STRING)
	return cell.getStringCellValue();
	else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC || cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
	String cellText = new BigDecimal(cell.getNumericCellValue()).toPlainString();
	return cellText;
	} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
	return "";
	else
	return String.valueOf(cell.getBooleanCellValue());
	} 
	catch (Exception e) 
	{
	 e.printStackTrace();
	 return "row " + rowNum + " or column " + colNum
	 + " does not exist in xls";
	}
	}
	
	public void writeDataFromExcel(int rowcount,int columncount,String filepath,String Sheetname,String value)
	{
	    try
	    {
	        FileInputStream input=new FileInputStream(filepath);
	        XSSFWorkbook wb=new XSSFWorkbook(input);
	        XSSFSheet sh=wb.getSheet(Sheetname);
	        XSSFRow row=sh.getRow(rowcount);
	        FileOutputStream webdata=new FileOutputStream(filepath);
	        row.createCell(columncount).setCellValue(value);
	        wb.write(webdata);

	    }
	    catch(Exception e)
	    {

	    }
	}

}
