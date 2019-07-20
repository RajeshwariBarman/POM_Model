package Main;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;


public class ExcelDataReader extends TestBase{
	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Username;
	private static XSSFCell Password;
	private static XSSFRow Row;
	
	@DataProvider(name = "DPtestdata")
	public static Object[][] testdata() throws Exception{
				System.out.println(getObject("TestData_Excel"));
			//	File f=new File(getObject("TestData_EXCEL"));		
				FileInputStream fis= new FileInputStream(getObject("TestData_Excel"));
				ExcelWBook = new XSSFWorkbook(fis);
				ExcelWSheet = ExcelWBook.getSheetAt(0);
				int rowcount = ExcelWSheet.getPhysicalNumberOfRows();
				Object [][] data = new Object[2][2];
				
				for(int i=1; i<rowcount;i++){
					Row = ExcelWSheet.getRow(i);
					Username = Row.getCell(0);
					if(Username==null){
					data[i][0]="";}
					else{
						Username.setCellType(CellType.STRING);
						data[i][0]=Username.getStringCellValue();
					}
					Password=Row.getCell(1);
					data[i][1] = Password.getStringCellValue();
				
				}
				
		return data;
	}}
