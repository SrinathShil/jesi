package jesi;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void f() throws IOException {
	  System.out.println("hello1ss");
	  URL url= new URL("http://localhost:8089/rest");
HttpURLConnection con=  (HttpURLConnection) url.openConnection();
con.setRequestMethod("POST");
System.out.println("END ofconnection");

try {
    
    FileInputStream file = new FileInputStream(new File("C:\\test.xls"));
     
    //Get the workbook instance for XLS file 
    HSSFWorkbook workbook = new HSSFWorkbook(file);
 
    //Get first sheet from the workbook
    HSSFSheet sheet = workbook.getSheetAt(0);
     
    HSSFWorkbook wb = new HSSFWorkbook(file);
    HSSFSheet ws = wb.getSheet("Input");

    int rowNum = ws.getLastRowNum()+1;
    int colNum = ws.getRow(0).getLastCellNum();
    String[][] data = new String[rowNum][colNum];
    //Iterate through each rows from first sheet
    Iterator<Row> rowIterator = sheet.iterator();
    while(rowIterator.hasNext()) {
        Row row = (Row) rowIterator.next();
         
        //For each row, iterate through each columns
        Iterator<Cell> cellIterator = row.cellIterator();
        while(cellIterator.hasNext()) {
             
            Cell cell = cellIterator.next();
             
            switch(cell.getCellType()) {
                case Cell.CELL_TYPE_BOOLEAN:
                    System.out.print(cell.getBooleanCellValue() + "\t\t");
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    System.out.print(cell.getNumericCellValue() + "\t\t");
                    break;
                case Cell.CELL_TYPE_STRING:
                    System.out.print(cell.getStringCellValue() + "\t\t");
                    break;
            }
        }
        System.out.println("");
    }
    file.close();
    FileOutputStream out = 
        new FileOutputStream(new File("C:\\test.xls"));
    workbook.write(out);
    out.close();
     
} catch (FileNotFoundException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}

}
}
