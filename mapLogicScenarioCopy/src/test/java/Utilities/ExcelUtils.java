package Utilities;

import org.apache.poi.hpsf.Date;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebElement;

import java.io.*;
import java.sql.Timestamp;


public class ExcelUtils {
	XSSFWorkbook wb;
	XSSFWorkbook wbk = null;
	XSSFSheet sheet;
	XSSFSheet sht = null;
	 XSSFRow row;
	 XSSFCell cell;
	FileOutputStream out = null;
	 FileInputStream fis;
	 public ExcelUtils(String fileName,String writeFileName){
		 try {
			 fis = new FileInputStream(fileName);
			 out = new FileOutputStream(writeFileName);
		 } catch (FileNotFoundException e) {
			 throw new RuntimeException(e);
		 }
		 try {
			 wb =new XSSFWorkbook(fis);
		 } catch (IOException e) {
			 throw new RuntimeException(e);
		 }
	 }
		public void getExcelSheet (int sheetNumber) {
		 sheet =wb.getSheetAt(sheetNumber);
		}
		public String getExcelCellValue (int rowNum,int cellNum) {
			wbk = new XSSFWorkbook();
			row =sheet.getRow(rowNum);
			cell =row.getCell(cellNum);
			String value =cell.getStringCellValue();
			return value;
		}
	public String getExcelCellNumericValue (int rowNum,int cellNum) {
		row = sheet.getRow(rowNum);
		cell = row.getCell(cellNum);
		String value = String.valueOf(cell.getNumericCellValue());
		return value;
	}
	public void Excel_Write() {
		wbk = new XSSFWorkbook();
	}
	public void cellCreationAndWrite(int rowNumber, int cellNumber,WebElement webElement) {
		sht = wbk.createSheet();
		row = sht.createRow(rowNumber);
		cell = row.createCell(cellNumber);
		cell.getLocalDateTimeCellValue();
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		cell.setCellValue(webElement.getText()+"   "+timestamp);

		sht.autoSizeColumn(cell.getColumnIndex());
	}




	public void fileCreation(String filePath) {
		try {
			out = new FileOutputStream(filePath);
			wbk.write(out);
			out.close();

		}
		catch(IOException e) {

			throw new RuntimeException("Unable to create Excel file");
		}
	}
}

			
			
