package com.gmail.eulertech.smcs2022.invitedstudentopenhousescheduler;

import java.io.File;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class ExcelReader {
	XSSFWorkbook wb;

	public ExcelReader(String fs) {
		try {
			this.wb = new XSSFWorkbook(new File(fs));
		} catch (IOException | InvalidFormatException e) {
			e.printStackTrace();
		}
	}
	
	public String getString(int s, int r, int c) {
		XSSFSheet sheet = wb.getSheetAt(s);
		XSSFRow row = sheet.getRow(r);
		XSSFCell cell = row.getCell(c);
		
		if(cell != null) {
			return cell.getStringCellValue();
		}
		return "";
	}
	
	public int getInt(int s, int r, int c) {
		XSSFSheet sheet = wb.getSheetAt(s);
		XSSFRow row = sheet.getRow(r);
		XSSFCell cell = row.getCell(c);
		
		if(cell != null) {
			return (int) cell.getNumericCellValue();
		}
		return 0;
	}
	
	public int getRowCount(int s) {
		XSSFSheet sheet = wb.getSheetAt(s);
		return sheet.getPhysicalNumberOfRows();
	}
}
