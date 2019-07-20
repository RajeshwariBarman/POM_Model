package Main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class TestBase {

	public static   WebDriver driver;
	public static ExtentHtmlReporter htmlreport;
	public static ExtentReports extent;
	public  static ExtentTest test;
	public  static ExtentTest childTest;
	static Properties properties;
	
	public static String destination;
	
	
	public static String getScreenShot(WebDriver driver) throws IOException{
		try{
		String datename=new SimpleDateFormat("yyyymmddhhmmss").format(new Date());
	/*	UUID uuid=UUID.randomUUID(); */
		TakesScreenshot f1=(TakesScreenshot) driver;
		File src=f1.getScreenshotAs(OutputType.FILE);
		destination = System.getProperty("user.dir") + "/Report/Screenshots/" + datename + ".png";
		File  finaldestination = new File(destination);
		FileUtils.copyFile(src, finaldestination);
		}
		catch(Exception e){
			test.log(Status.FAIL, "Unable to take/get the screenshot");
		}
		return destination;
	}
	
	public static String getDateAndTime(){
		String str = null;
		try {
			DateFormat dateformat = new SimpleDateFormat("DD/MM/YYYY HH:MM:SS:SSS");
			Date date = new Date();
			str=dateformat.format(date);
			str=str.replace( " ", " ").replaceAll("/", " " ).replaceAll(":", " ");
		} catch (Exception e) {
			// TODO: handle exception
		}
		return str;
	}
	
	public static  void LoadData() throws IOException{
		properties = new Properties();
		File src=new File("C:\\Users\\badigmo1\\Desktop\\ws\\MDM\\OR.properties");
		FileReader fr=new FileReader(src);
		properties.load(fr);
		
	}
	
	public static  String getObject(String Data) throws IOException{
		LoadData();
		String data=properties.getProperty(Data);
		return data;
	}
	

}
