package Generic;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Ulitity_Excel {
	public static String select_Excel(String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream Excel = new FileInputStream("./src/test/resources/TestDataOnlineShoppee.xlsx");
		Workbook work = WorkbookFactory.create(Excel);
		Sheet sheet = work.getSheet("Admin");
		int x = sheet.getLastRowNum();
		for (int i = 0; i < x; i++) {
			String value= sheet.getRow(i).getCell(0).toString();
			if(value.equalsIgnoreCase(data))
			{
				String value1= sheet.getRow(i).getCell(1).toString();
				return value1;
			}
		}
		return data;
	}
	
	public static String select_Excel1(String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream Excel = new FileInputStream("./src/test/resources/TestDataOnlineShoppee.xlsx");
		Workbook work = WorkbookFactory.create(Excel);
		Sheet sheet = work.getSheet("User");
		int x = sheet.getLastRowNum();
		for (int i = 0; i < x; i++) {
			String value= sheet.getRow(i).getCell(0).toString();
			if(value.equalsIgnoreCase(data))
			{
				String value1= sheet.getRow(i).getCell(1).toString();
				return value1;
			}
		}
		return data;
	}
}
