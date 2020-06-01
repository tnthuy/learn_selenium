package test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckInfor {
	WebDriver driver;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFSheet ExcelWSheet;

	@Test
	public void CheckData() throws IOException {
		//mo trang
		driver.get("https://www.seleniumeasy.com/test/table-data-download-demo.html");
		//To get current working directory:
		Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
		
		System.out.println(path);
		//Locating the Test data excel file
		String excelPath =path+ "\\scr\\test\\java\\data\\Position.xlsx";
		System.out.println(excelPath);
		FileInputStream fis=new FileInputStream(excelPath);
		
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(Sheet1);
		
		//I have added test data in the cell A1 as "SoftwareTestingMaterial.com"
		//Cell A1 = row 0 and column 0. It reads first row as 0 and Column A as 0.
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		System.out.println(cell);
		System.out.println(sheet.getRow(0).getCell(0));
		//String cellval = cell.getStringCellValue();
		//System.out.println(cellval);
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
	//	
	//
	//		//Tao mot doi tuong cua lop File de mo xlsx file
	//		File file= new File(filePath+"\\+")
	//
	//				//Mo trinh duyet
	//				driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
	//		//tim va dien gia tri a
	//		driver.findElement(By.xpath("//*[@id=\"sum1\"]")).sendKeys(String.valueOf(a));
	//		//tim va dien gia tri b
	//		driver.findElement(By.xpath("//*[@id=\"sum2\"]")).sendKeys(String.valueOf(b));
	//		//Click to tinh kq
	//		driver.findElement(By.xpath("//*[@id=\"gettotal\"]/button")).click();
	//
	//	}
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