package ar.brian_ame.vpm;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

public class ReadExcel {

	public static ArrayList<ArrayList<String>> main(String[] args) {
		ArrayList<ArrayList<String>> arrayDeCampañas = new ArrayList<ArrayList<String>>();
		ArrayList<String> campa = new ArrayList<String>();

		try {
			FileInputStream file = new FileInputStream(new File("Campaña.xls"));

			// Create Workbook instance holding reference to .xlsx file
			// XSSFWorkbook workbook = new XSSFWorkbook(file);
			// Get first/desired sheet from the workbook
			// XSSFSheet sheet = workbook.getSheetAt(0);

			// Create Workbook instance holding reference to .xls file
			HSSFWorkbook workbook = new HSSFWorkbook(file);
			// Get first/desired sheet from the workbook
			HSSFSheet sheet = workbook.getSheetAt(0);

			// Iterate through each rows one by one

			Iterator<Row> rowIterator = sheet.iterator();
			// le asigno el siguiente para sacar los titulos
			Row row = rowIterator.next();

			while (rowIterator.hasNext()) {
				row = rowIterator.next();
				// For each row, iterate through all the columns
				Iterator<Cell> cellIterator = row.cellIterator();
				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					switch (cell.getCellType()) {
					case Cell.CELL_TYPE_STRING:
						// System.out.println(cell.getColumnIndex());
						campa.add(cell.getStringCellValue());
						break;
					case Cell.CELL_TYPE_ERROR:
						campa.add("");
						break;
					case Cell.CELL_TYPE_BLANK:
						campa.add("");
						break;

					}
				}
				arrayDeCampañas.add(campa);
				campa = new ArrayList<String>();
				// System.out.println("");
			}
			file.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		Iterator<ArrayList<String>> it = arrayDeCampañas.iterator();

		while (it.hasNext()) {
			System.out.println(it.next());
		}

		return arrayDeCampañas;
	}
}
