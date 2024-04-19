package com.GenericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	/**
	 * step1 register driver
	 * step2 get connection for database
	 * create statement
	 * execute query/update query
	 * close database
	 * @throws SQLException 
	 */
	Connection con=null;
	public void connectToDB() throws SQLException 
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection con = DriverManager.getConnection(IPathConstant.DBURL,IPathConstant.DBUsername,IPathConstant.DBPassword);
	}
	
	
	public void executeAndGetdata(String query,int cellNo,String expected) throws SQLException
	{
		//step 3:create Statement
		Statement state = con.createStatement();
		ResultSet result = state.executeQuery(query); 
		boolean flag=false;
		while(result.next())
		{
			String actual = result.getString(cellNo);
			if(actual.contains(expected))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println("----data is matching-----");
		}
		else
		{
			System.out.println("-----datas are not matching-----");
		}
	}
	
	/**
     * write data into database
     * @param query
     * @return
     * @throws SQLException
     */
    public int updateData(String query) throws SQLException {
        Statement state = con.createStatement();
        int i = state.executeUpdate(query);
        return i;
    }
	
	public void closeDB() throws SQLException
	{
		con.close();
	}
}
