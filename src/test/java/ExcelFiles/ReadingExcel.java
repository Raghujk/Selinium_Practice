package ExcelFiles;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadingExcel {

public static void main(String[] args) throws IOException {
	
	//Reading Format
	FileInputStream fis = new FileInputStream("C:\\Users\\admin\\eclipse-workspace\\TeamTesting38\\ExcellFiles\\ReadingFile.xlsx");
	//Selecting the WorkBook	
	XSSFWorkbook wb = new XSSFWorkbook(fis);
	//Selecting Sheet
	XSSFSheet sheet = wb.getSheet("Sheet1");
		
	//identify the Rows & cell
	int rows = sheet.getLastRowNum();
	int cell = sheet.getRow(1).getLastCellNum();
	//printig Table by using Loop	
	for(int i=0; i<= rows;i++) {
		XSSFRow row = sheet.getRow(i);
		for(int j= 0;j< cell;j++) {
			String value =row.getCell(j).toString();
			System.out.print(value+"  ");
			}
		System.out.println();
	}
}

}