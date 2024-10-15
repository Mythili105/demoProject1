package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
   public ExcelUtilities(String path) {
	   this.path=path;
	   
   }
	
//public File file;
public FileInputStream fis;
public FileOutputStream fos;
public XSSFWorkbook wb;
public XSSFSheet sheet;
public XSSFRow row;
public XSSFCell cell;
String path;
 
public int getRowsCount(String sheetname) throws IOException{
	 
	  //file= new File(path);
	  fis= new FileInputStream(path);
	  wb= new XSSFWorkbook(fis);
	  sheet= wb.getSheet(sheetname);
	  
	  if (sheet == null) {
          wb.close();
          fis.close();
          return 0;
      }
	  int rowcount= sheet.getLastRowNum();
	  wb.close();
	  fis.close();
	  return rowcount;
 }
public int getcellcount( String sheetname, int rownum) throws IOException {
	
	//file= new File(path);
	fis= new FileInputStream(path);
	wb= new XSSFWorkbook(fis);
	sheet= wb.getSheet(sheetname);
	 // Null checks for sheet and row
    if (sheet == null || sheet.getRow(rownum) == null) {
        wb.close();
        fis.close();
        return 0;
    }

	 row= sheet.getRow(rownum);
	 int cellcount= row.getLastCellNum();
	 wb.close();
	 fis.close();
	 return cellcount;
	
}
public String celldata( String sheetname, int rownum, int colnum) throws IOException {
	
	//file= new File(path);
	fis= new FileInputStream(path);
	wb= new XSSFWorkbook(fis);
	sheet=wb.getSheet(sheetname);
	// Null checks for sheet, row, and cell
    if (sheet == null || sheet.getRow(rownum) == null || sheet.getRow(rownum).getCell(colnum) == null) {
        wb.close();
        fis.close();
        return "";
    }
	row= sheet.getRow(rownum);
	cell= row.getCell(colnum);
	String data;
	data= cell.toString();
	wb.close();
	fis.close();
	return data;
	
}


}
