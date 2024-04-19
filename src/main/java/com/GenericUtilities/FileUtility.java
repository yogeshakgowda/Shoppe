package com.GenericUtilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUtility {
	/**
	 * This Method is Used to read data from property file
	 * author yogesha k
	 * @param Key
	 * @return
	 * @throws IOException
	 */
public String readDataFromPropertyFile(String Key) throws IOException
{
	FileInputStream fis=new FileInputStream(IPathConstant.FilePath);
	Properties pObj=new Properties();
	pObj.load(fis);
	String value=pObj.getProperty(Key);
	return value;
}
}
