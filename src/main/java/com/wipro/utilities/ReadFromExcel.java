package com.wipro.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadFromExcel {

	static XSSFWorkbook workbook;

	public static String[][] getData() {
		String fileName = "src\\test\\resources\\testdata\\login.xlsx";
		try {
			FileInputStream fis = new FileInputStream(fileName);
			workbook = new XSSFWorkbook(fis);
		} catch (IOException io) {

		}
		XSSFSheet sheet = workbook.getSheet("Sheet1");
		String[][] data = new String[1][2];
		int rowCount = sheet.getLastRowNum();
		
		for (int rowNo = 1; rowNo <= rowCount; rowNo++) {
			int cellCount = sheet.getRow(rowNo).getLastCellNum();
			
			for (int cellNo = 0; cellNo < cellCount; cellNo++) {
				data[rowNo-1][cellNo] = sheet.getRow(rowNo).getCell(cellNo).getStringCellValue();
			}
			
		}
		return data;
	}
}
