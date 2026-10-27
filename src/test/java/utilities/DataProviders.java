package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	public String[] [] getdata() throws IOException
	{
		String path = ".//testData//Opencart_LoginData (1).xlsx";
		ExcelUtility utility=new ExcelUtility(path);
		int rowcount=utility.getRowCount("Sheet1");
		int cellcount=utility.getCellCount("Sheet1", 1);
		String Logindata[] []= new String[rowcount][cellcount];
		for (int i=1; i<=rowcount; i++)
		{
			for(int j=0; j<cellcount; j++)			{
				Logindata[i-1] [j]=utility.getCellData("Sheet1", i, j);
			}
		}
		return Logindata;
	}
}
