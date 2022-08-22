package dashboards;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataSheetprovider {
	@DataProvider(name="Signin")
	public String[][] getData() throws IOException 
	{
		String path =".\\ExcelSheet\\Sheet.xlsx";
		ExcelUtility excelutil = new ExcelUtility(path);
		int totalrows=excelutil.getRowCount("Sheet1");
		int totalcols=excelutil.getCellCount("Sheet1",1);
		String signin[][] = new String[totalrows][totalcols];
		for(int i=1;i<=totalrows;i++)
		{
		for(int j=0;j<totalcols;j++)
		{
		    signin[i-1][j]=excelutil.getCellData("Sheet1",i,j);
		}
		}
		return signin;
	}
	@DataProvider(name="Daterange")
	public String[][] getData1() throws IOException{
		String path =".\\ExcelSheet\\Sheet.xlsx";
		ExcelUtility excelutil = new ExcelUtility(path);
        int totalrows=excelutil.getRowCount("Sheet2");
		int totalcols=excelutil.getCellCount("Sheet2",1);
		String daterange[][] = new String[totalrows][totalcols];
		for(int i=1;i<=totalrows;i++)
		{
		for(int j=0;j<totalcols;j++)
		{
		    daterange[i-1][j]=excelutil.getCellData("Sheet2",i,j);
		}
		}
		return daterange;
		}
	@DataProvider(name="Supplier")
	public String[][] getData2() throws IOException{
		String path =".\\ExcelSheet\\Sheet.xlsx";
		ExcelUtility excelutil = new ExcelUtility(path);
        int totalrows=excelutil.getRowCount("Sheet3");
		int totalcols=excelutil.getCellCount("Sheet3",1);
		String supplier[][] = new String[totalrows][totalcols];
		for(int i=1;i<=totalrows;i++)
		{
		for(int j=0;j<totalcols;j++)
		{
		    supplier[i-1][j]=excelutil.getCellData("Sheet3",i,j);
		}
		}
		return supplier;
	}
	@DataProvider(name="Orderno")
	public String[][] getData3() throws IOException{
		String path =".\\ExcelSheet\\Sheet.xlsx";
		ExcelUtility excelutil = new ExcelUtility(path);
        int totalrows=excelutil.getRowCount("Sheet4");
		int totalcols=excelutil.getCellCount("Sheet4",1);
		String order[][] = new String[totalrows][totalcols];
		for(int i=1;i<=totalrows;i++)
		{
		for(int j=0;j<totalcols;j++)
		{
		    order[i-1][j]=excelutil.getCellData("Sheet4",i,j);
		}
		}
		return order;
	}
	@DataProvider(name="Datepicker")
	public String[][] getData4() throws IOException{
		String path =".\\ExcelSheet\\Sheet.xlsx";
		ExcelUtility excelutil = new ExcelUtility(path);
        int totalrows=excelutil.getRowCount("Sheet6");
		int totalcols=excelutil.getCellCount("Sheet6",1);
		String daterange1[][] = new String[totalrows][totalcols];
		for(int i=1;i<=totalrows;i++)
		{
		for(int j=0;j<totalcols;j++)
		{
		    daterange1[i-1][j]=excelutil.getCellData("Sheet6",i,j);
		}
		}
		return daterange1;
		}
		


	
 
	
}
