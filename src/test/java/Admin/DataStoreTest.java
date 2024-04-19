package Admin;

import org.testng.annotations.DataProvider;

public class DataStoreTest {
	@DataProvider(name="login")
	public Object[][] data()
	{
		Object[][] obj=new Object[3][2];
		
		obj[0][0]="admin1";
		obj[0][1]="Test@123";
		
		
		obj[1][0]="admin";
		obj[1][1]="Test@1234";
	
		
		obj[2][0]="admin";
		obj[2][1]="Test@123";
		
		
		return obj;
	}

}
