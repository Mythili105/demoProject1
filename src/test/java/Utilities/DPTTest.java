package Utilities;


import java.io.IOException;

import org.testng.annotations.DataProvider;

public class  DPTTest {
	
 
 @DataProvider(name = "logindata")
 public Object[][] getData() throws IOException {
	 String path= ".\\testdata\\OrangeHRM-Data set.xlsx";
	 ExcelUtilities Ut= new ExcelUtilities(path);
 int totalrows= Ut.getRowsCount("data");
 int totalcolumns= Ut.getcellcount("data", 1);
 //System.out.println("Total Rows: " + totalrows);
 //System.out.println("Total Columns: " + totalcolumns);
 
   String logindata[][]= new String [totalrows][totalcolumns];
   for( int i=1; i<=totalrows; i++) {
	   for( int j=0; j<totalcolumns; j++) {
		  logindata[i-1][j]=Ut.celldata("data", i, j);
		   //System.out.println("Data [" + (i-1) + "][" + j + "]: " + logindata[i-1][j]);
       
	   }
	   
}
return logindata;

 }}


