package Main;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellType;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.Status;

public class ReadXLSFile extends TestBase{
	
	private static HSSFWorkbook workbook;
	private static HSSFSheet worksheet;
	private static HSSFCell username;
	private static HSSFCell password;
	private static HSSFRow row;
	public Object[][] data;
	
	@DataProvider(name = "dpTestData")
	public Object[][] getTableArray() throws IOException, IOException{
		
		try{
		FileInputStream fis=new FileInputStream(getObject("TestDataXLS"));
		workbook = new HSSFWorkbook(fis);
		worksheet = workbook.getSheet("Sheet1");
		int rowCount = worksheet.getPhysicalNumberOfRows();
		data = new Object[rowCount][2];
		
		for(int i=1;i<rowCount;i++){
			row=worksheet.getRow(i);
			username = row.getCell(0);
			password = row.getCell(1);
			
			if(username ==null){
				data[i][0]="";
			}
			else{
			//	username.setCellType(CellType.STRING);
				data[i][0]=username.getStringCellValue();
			}
			
			if(password==null){
				data[i][1]="";
				
			}else
			{
			//	password.setCellType(CellType.STRING);
				data[i][1]=password.getStringCellValue();
			}
			
		}
		
		
		}
		catch(Exception e){
			test.log(Status.FAIL, "Unable to execute data provider method");
		}
		return data;
		
	
	}

}
