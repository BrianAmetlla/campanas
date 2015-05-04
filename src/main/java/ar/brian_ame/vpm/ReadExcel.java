package ar.brian_ame.vpm;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

    public static ArrayList<ArrayList<String>> main(String[] args)
    {
    	ArrayList<ArrayList<String>> arrayDeCampañas = new ArrayList<ArrayList<String>> ();
    	ArrayList<String> campa = new ArrayList<String>();
    	
        try
        {
            FileInputStream file = new FileInputStream(new File("Campaña.xlsx"));
            
            //Create Workbook instance holding reference to .xlsx file
            XSSFWorkbook workbook = new XSSFWorkbook(file);
 
            //Get first/desired sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);
            

            
 
            //Iterate through each rows one by one
            
            Iterator<Row> rowIterator = sheet.iterator();
            //le asigno el siguiente para sacar los titulos
            Row row = rowIterator.next();
            
            while (rowIterator.hasNext())
            {
                 row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext())
                {
                    Cell cell = cellIterator.next();
                    campa.add(cell.getStringCellValue());
                }
                arrayDeCampañas.add(campa);
                campa = new ArrayList<String>();
                //System.out.println("");
            }
            file.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        
        
		Iterator<ArrayList<String>> it = arrayDeCampañas.iterator();

	    while(it.hasNext())
	        {
 	         System.out.println(it.next());
	        }

	  return arrayDeCampañas;  
    }
}
