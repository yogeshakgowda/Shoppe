package com.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	/**
	 * it gives the total number of rows present
	 * @param SheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */

public int getTotalRowCount(String SheetName) throws EncryptedDocumentException, IOException
{
	FileInputStream fi=new FileInputStream(IPathConstant.ExcelPath);
	Workbook wb = WorkbookFactory.create(fi);
	Sheet sh = wb.getSheet(SheetName);
	int rowCount = sh.getLastRowNum();
	return rowCount;
}

/**
 * it gives single value 
 * @param SheetName
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public String readDataFromExcel(String SheetName,int rowno,int cellNo) throws EncryptedDocumentException, IOException
{
	FileInputStream fi=new FileInputStream(IPathConstant.ExcelPath);
	Workbook wb = WorkbookFactory.create(fi);
	Sheet sh = wb.getSheet(SheetName);
	String value = sh.getRow(rowno).getCell(cellNo).getStringCellValue();
	return value;
}


/**
 * we can write data into excel
 * @param SheetName
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public void writeDataIntoExcel(String SheetName,int rowno,int cellNo,String data) throws EncryptedDocumentException, IOException
{
	FileInputStream fi=new FileInputStream(IPathConstant.ExcelPath);
	Workbook wb = WorkbookFactory.create(fi);
	Sheet sh = wb.getSheet(SheetName);
	sh.createRow(rowno).createCell(cellNo).setCellValue(data);
	FileOutputStream fout=new FileOutputStream(IPathConstant.ExcelPath);
	wb.write(fout);
	wb.close();
}

/**
 * we can fetch the multiple data from excel
 * @param SheetName
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
public HashMap<String, String> readMultipleData(String SheetName,int cellNo) throws EncryptedDocumentException, IOException
{
	FileInputStream fi=new FileInputStream(IPathConstant.ExcelPath);
	Workbook wb = WorkbookFactory.create(fi);
	Sheet sh = wb.getSheet(SheetName);
	int rawCount = sh.getLastRowNum();
	
	HashMap<String, String> map=new HashMap<String, String>();
	for(int i=0;i<=rawCount;i++)
	{
		String key = sh.getRow(i).getCell(cellNo).getStringCellValue();
		String value = sh.getRow(i).getCell(cellNo+1).getStringCellValue();
		map.put(key, value);
	}
	return map;
}
}
