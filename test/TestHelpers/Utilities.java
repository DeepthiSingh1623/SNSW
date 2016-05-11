
package TestHelpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author dev
 *
 */
public class Utilities {
	
	public static  String[] getXLDataLatestByRow(String location, String sheetname, int rowNo) throws IOException
	  {
		File excel = new File (location);
	    FileInputStream fis = new FileInputStream(excel);

	    XSSFWorkbook wb = new XSSFWorkbook(fis);
	    XSSFSheet ws = wb.getSheet(sheetname);

	    int rowNum = ws.getLastRowNum()+1;
	    System.out.println("Number of rows:" + rowNum);
	    int colNum = ws.getRow(0).getLastCellNum();
	    System.out.println("Number of columns:" + colNum);
	    String[] data = new String[colNum];
	    //This code is for complete excel reading. 
	    /*for (int i=0; i<rowNum; i++){
	        XSSFRow row = ws.getRow(i);
	            for (int j=0; j<colNum; j++){
	                XSSFCell cell = row.getCell(j);
	                String value = cellToString(cell);
	                data[i][j] = value;
	                System.out.println("The value is" + value);

	            }
	    	} */
	    	XSSFRow row = ws.getRow(rowNo);
	    	 for (int j=0; j<colNum; j++){
	                XSSFCell cell = row.getCell(j);
	               
	                String value="";
	                     // System.out.println(cell);
	                	  
	                try{
	                	cell.setCellType(Cell.CELL_TYPE_STRING);
	                	value =cell.getStringCellValue();
	                }
	                catch(NullPointerException e){
	                	
	                }
	                	  
	                	  data[j] = value;
	                                
	               //System.out.println("The value is" + value);
	              // System.out.println("The data value is" + data[j]);
	    	 }
	    	return  data;
	    }

}
