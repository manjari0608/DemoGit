package Simple.SimpleTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelUtility {
	
	public static Object[][] readExcel(String SheetName) throws IOException {
		Object[][] obj = null;
		try {
			FileInputStream is = new FileInputStream("src/test/java/TestData/Test data.xlsx");
			XSSFWorkbook workbook = new XSSFWorkbook(is);
			//XSSFWorkbook workbook = XSSFWorkBook(is);
			XSSFSheet sheet = workbook.getSheet("SheetName");
			for(int i=1;i<=sheet.getLastRowNum();i++) {
				for(int j=0;j<sheet.getRow(i).getPhysicalNumberOfCells();j++) {
					System.out.print(sheet.getRow(i).getCell(j).getStringCellValue());
				}
				System.out.println();
			}
			workbook.close();
					
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
}

	
}