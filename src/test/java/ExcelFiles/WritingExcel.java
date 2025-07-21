package ExcelFiles;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingExcel {
	public static void main(String[] args) throws IOException {
		
		FileOutputStream fos = new FileOutputStream("C:\\Users\\admin\\eclipse-workspace\\TeamTesting38\\ExcellFiles\\WritingFile.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet();
		 
		Scanner sc = new Scanner(System.in);
		for(int q = 0; q<=2;q++) {  //it represents the ROWS
			XSSFRow row = sheet.createRow(q);
			for(int t=0; t<2;t++) {
				System.out.println("Enter Value :-");
				String value = sc.next();
				row.createCell(t).setCellValue(value);
			}
		}
		
		wb.write(fos);
		wb.close();
		fos.close();
		System.out.println("The Writing the data is Done!");
		
	}

}