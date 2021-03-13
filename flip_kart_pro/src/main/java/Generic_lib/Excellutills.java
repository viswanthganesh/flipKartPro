package Generic_lib;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excellutills 
{
	
	public String  getExcellData(String excellpath,String sheetname,int row,int col) throws Throwable
	{
		FileInputStream fil = new FileInputStream(excellpath);
		Workbook wb = WorkbookFactory.create(fil);
		String cellvalue = wb.getSheet(sheetname).getRow(row).getCell(col).toString();
		return cellvalue;
	}
	
	public int getLastRowCount(String excellpath,String sheetname) throws Throwable
	{
		FileInputStream fil = new FileInputStream(excellpath);
		
		Workbook wb = WorkbookFactory.create(fil);
		int rc = wb.getSheet(sheetname).getLastRowNum();
		return rc;
	}
	
	public void setCellValue(String excellpath,String Sheet,String data,int row,int col) throws Throwable
	{
		FileInputStream fil = new FileInputStream(excellpath);
		Workbook wb = WorkbookFactory.create(fil);
		wb.getSheet(Sheet).getRow(row).createCell(row).setCellValue(data);
		
		FileOutputStream fos = new FileOutputStream(excellpath);
		wb.write(fos);
		
		
	}
	
	public String getExcellData(String excellpath,String sheetName , String expTestID , String expColHEader) throws Throwable {
		
		int expTestRow = 0;
		int expHeader = 0;
		FileInputStream fis = new FileInputStream(excellpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetName);
		int rowCount = sh.getLastRowNum();
	    
    for(int i=0; i<rowCount ; i++) {		
		Row row = sh.getRow(i);
		String zeroColData= row.getCell(0).getStringCellValue();
        if(expTestID.contentEquals(zeroColData)) {
        	//System.out.println("test is availbale");
        	expTestRow = i;
        	break;
        }
    }
    
    int expColHeader = expTestRow-1;
    
        int colCount = sh.getRow(expColHeader).getLastCellNum();
         for(int j=0 ; j <colCount ; j++) {
        	   String actColHeader = sh.getRow(expColHeader).getCell(j).getStringCellValue();
        	   if(actColHeader.equals(expColHEader)) {
        		        //System.out.println("header is avibale ");
        		        expHeader = j;
        		        break;
        	   }
         }
         
return sh.getRow(expTestRow).getCell(expHeader).getStringCellValue();
		
}


}
