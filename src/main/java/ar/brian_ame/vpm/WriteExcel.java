package ar.brian_ame.vpm;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcel 
{
    @SuppressWarnings({ "resource", "rawtypes", "unchecked" })
	public static void main(ArrayList<ArrayList<String>> Lista_Campañas) 
    {
    	   //Blank workbook
		//XSSFWorkbook workbook = new XSSFWorkbook(); 
		HSSFWorkbook workbook = new HSSFWorkbook(); 
         
        //Create a blank sheet
        HSSFSheet sheet = workbook.createSheet("Detalle de campañas");
        //Campañas campa2 = new Campañas("prueba", "2 charters", TestUtils.toDateWithTime("09/03/2015"), TestUtils.toDateWithTime("04/03/2015"), TestUtils.toDateWithTime("27/03/2015"), TestUtils.toDateWithTime("03/03/2015 16:00"), TestUtils.toDateWithTime(""), TestUtils.toDateWithTime("03/03/2015"), TestUtils.toDateWithTime("04/03/2015"), TestUtils.toDateWithTime("09/03/2015"), TestUtils.toDateWithTime(""), TestUtils.toDateWithTime("11/03/2015"), TestUtils.toDateWithTime("21/03/2015"), TestUtils.toDateWithTime(""));
        //This data needs to be written (Object[])
        ArrayList<String> titulo = new ArrayList<String>(Arrays.asList("Campaña", "Formato y cantidad", "Fecha de Inicio", "Fecha óptima (arte)", "Llegada Arte", "Fecha óptima (PC)", "Pedido prueba color", "OK Prueba Color", "Llegada Arte c/ajustes", "Fecha óptima (OC)", "Aprobación OC", "Envío OC", "Fecha óptima (entrega)", "1ra Entrega Proveedor", "2da Entrega Proveedor","Fecha óptima inicio", "Inicio Instalación", "Fecha óptima fin", "Fin Instalación", "Envío de cierre", "Llegada Arte", "Pedido de prueba", "OK Color", "Aprobación OC", "Orden de Compra", "1ra Entrega", "Entrega Final", "Inicio colocación", "Fin colocación", "Envío cierre", "ARTE", "OK Real", "OK Ideal"));
		Map<Integer, ArrayList> data = new TreeMap<Integer, ArrayList>();
		data.put(1,  titulo);
		int i = 2;
		Iterator itr = Lista_Campañas.iterator(); 
		while(itr.hasNext()) { 
			ArrayList<String> element = (ArrayList<String>) itr.next();
			//System.out.println(estado);
			data.put(i, element);
			i++;
        //Iterate over data and write to sheet
			Set<Integer> keyset = data.keySet();
			int rownum = 0;
        for (Integer key : keyset)
        { 
            Row row = sheet.createRow(rownum++);
            ArrayList objArr = data.get(key);
            int cellnum = 0;
            for (Object obj : objArr)
            {
               Cell cell = row.createCell(cellnum++);
               if(obj instanceof String)
                    cell.setCellValue((String)obj);
                else if(obj instanceof Integer)
                    cell.setCellValue((Integer)obj);
            }
           
        }
    }
        try
        {
            //Write the workbook in file system
           FileOutputStream out = new FileOutputStream(new File("Campaña.xls"));
           workbook.write(out);
           out.close();
           System.out.println("Se guardó el archivo Campaña.xlsx de forma exitosa.");
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }

    }
}