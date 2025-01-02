package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	//DataProvider 1
	
	@DataProvider(name="loginData")
	public String[][] getData() throws IOException
	{
		String path=".\\testData\\Opencart_Logindata.xlsx";  // taking xl file from testData
		ExcelUtility  xlutil= new ExcelUtility (path);   //creating an object for XLUtility
		int totalrows= xlutil.getRowCount("Sheet1");
		int totalcols= xlutil.getCellCount("Sheet1",1);
		String logindata[][]= new String[totalrows][totalcols]; // created two demeisional array which can store 
		for(int i=1;i<totalrows;i++)  // read data from xl storing in two deminsional array
		{
			for(int j=0;j<totalcols;j++) 
			{ 
				logindata[i-1][j]=xlutil.getCellData("Sheet1", i, j);
				}
		}
		return logindata ;
	}
}
