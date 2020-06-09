package test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import java.util.ArrayList;
import java.util.List;

import javax.swing.text.html.HTMLDocument.Iterator;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckInfor {
	WebDriver driver;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFSheet ExcelWSheet;

	public class NgheNghiep {
		String address;
		String job;
		int number;

		public NgheNghiep(String address, String job, int number) {
			this.address=address;
			this.job=job;
			this.number=number;

		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String addess) {
			this.address=address;
		}
		public String getJob() {
			return job;
		}
		public int getNumber() {
			return number;
		}
	}
	@Test
	public void CheckData() throws IOException {
		//mo trang web
		driver.get("https://www.seleniumeasy.com/test/table-data-download-demo.html");

		//Get number of columns
		List<WebElement> cols=driver.findElements(By.xpath("//*[@id=\"example\"]/thead/tr/th"));
		int numberColsBrowser=cols.size();
		
		//Get number of rows
		List<WebElement> rows=driver.findElements(By.xpath("//*[@id=\"example\"]/tbody/tr"));
		int numberRowsBrowser=rows.size();
		
		//doc file Excel
		//To get current working directory:
		Path path = FileSystems.getDefault().getPath("").toAbsolutePath();

		//Locating the Test data excel file
		File excelPath =new File(path+ "\\data\\Position.xlsx");

		FileInputStream fis=new FileInputStream(excelPath);
		System.out.println("Doc file Excel");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		XSSFSheet sheet = workbook.getSheetAt(0);

		//Find number of rows in excel file

		int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum()+1;
		System.out.println("So dong trong bang Excel: "+rowCount);
		//khai bao mang Nghe Nghiep
		ArrayList<NgheNghiep> alNghe=new ArrayList<NgheNghiep>();
		//Create a loop over all the rows of excel file to read it
		for (int i=0;i<rowCount;i++) {
			Row row=sheet.getRow(i);
			//create a loop to print cell value in a row
			//for (int j=0;i<row.getLastCellNum();j++) {
			//tim address va gan vao mang
			String CellAddress=row.getCell(0).getStringCellValue();
			System.out.println(CellAddress);

			//tim job va gan vao mang
			String CellJob=row.getCell(1).getStringCellValue();
			System.out.println(CellJob);

			//tim so luong va gan vao mang
			int CellNumber=(int) row.getCell(2).getNumericCellValue();
			System.out.println(CellNumber);
			NgheNghiep nn=new  NgheNghiep(CellAddress, CellJob, CellNumber);
			alNghe.add(nn);
			
			int count=0;
			//Doc du lieu tren table
			for (int j=1; j<=numberRowsBrowser; j++) {
				String textAddress=SelectTableContent(j, 3);
				
				String textJob=SelectTableContent(j, 2);
	
				if (textAddress.equals(CellAddress) && textJob.equals(CellJob)) {
					count++;
					}
			}
			System.out.println("so phan tu dem duoc tren Browser "+count);
			if (count==CellNumber) {
				
				System.out.println("Du lieu giong nhau");
			}
			else {
				System.out.println("Du lieu khong giong nhau");
			}
			
		}
		java.util.Iterator<NgheNghiep> itr=alNghe.iterator();
		while(itr.hasNext()) {
			NgheNghiep nghe=(NgheNghiep)itr.next();
			System.out.println(nghe.address+"  "+nghe.job+"   "+nghe.number);
		}
}



		public static void readExcel(String filePath, String sheetName) throws Exception{
		try {
			//Open the Excel file
			FileInputStream ExcelFile =new FileInputStream(filePath);

			//Access the excel data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(sheetName);
		} catch (Exception e) {

			throw (e);
		}
	}

	public static String[][] getTestInfor(String tableName){
		String[][] testData=null;
		try {
			//Handle  number and stringss
			DataFormatter formatter = new DataFormatter();
			XSSFCell [] boundaryCells= findCells(tableName);
			XSSFCell startCell= boundaryCells[0];

			XSSFCell endCell = boundaryCells[1];

			int startRow = startCell.getRowIndex()+1;
			int endRow = endCell.getRowIndex()-1;
			int startCol = startCell.getColumnIndex()+1;
			int endCol = endCell.getColumnIndex()- 1;

			testData= new String[endRow- startRow+1][endCol-startCol+1];

			for( int i= startRow; i<endRow+1; i++) {
				for (int j= startCol; j<endCol+1; j++) {
					Cell cell= ExcelWSheet.getRow(i).getCell(j);
					testData[i-startRow][j-startCol]=formatter.formatCellValue(cell);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return testData;
	}

	public static  XSSFCell[] findCells(String tableName) {
		DataFormatter formatter = new DataFormatter();
		String pos ="begin";
		XSSFCell[] cells = new XSSFCell[2];

		for (Row row:ExcelWSheet) {
			for (Cell cell : row) {
				if (tableName.equals(formatter.formatCellValue(cell))) {
					cells[0]= (XSSFCell) cell;
					pos = "end";
				} else {
					cells[1]= (XSSFCell) cell;
				}
			}
		}


		return cells;
	}


	public String SelectTableContent(int row, int column) {
		String content=driver.findElement((By.xpath(("//*[@id=\"example\"]/tbody/tr["+row+"]/td["+column+"]")))).getText();
		return content;

	}

	@BeforeMethod
	public void beforeMethod() {
		System.setProperty("webdriver.chrome.driver", "C://Setup//chromedriver_win32/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
}
