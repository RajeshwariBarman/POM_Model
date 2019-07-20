package Main;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.xml.transform.Result;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.Status;



public class Web extends TestBase{
//	WebDriver driver;
//	
//	public Web(){
//		driver = TestBase.driver;
//	}
	
	 
	
	public static void BrowserInitialization() throws IOException{
		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("useAutomationExtension", false);
		System.setProperty("webdriver.chrome.driver", getObject("Driver_Path"));
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(getObject("GDD_Application_URL"));
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public static void launchApplication(String url) throws IOException {
		 String screenshotPath = TestBase.getScreenShot(driver);
		try {
			driver.get(url);
			test.log(Status.INFO,  "URL opened successfully ");
//		
		} catch (Exception e) {
			test.log(Status.ERROR, "Failed to launch the applicaiton").addScreenCaptureFromPath(getScreenShot(driver));
		}
			
		
	}
	
	public static void click(By locator, String btnName) throws Exception{
		try {
			driver.findElement(locator).click();
			test.log(Status.INFO, " Clicked on " + btnName);
			
		} catch (Exception e) {
			
			test.log(Status.ERROR, "Failed to click on "+ btnName).addScreenCaptureFromPath(getScreenShot(driver));
		
		}
		
	}
	
	public static void type(By locator, String valueToSet, String TxtBoxName) throws IOException{
		try {
			driver.findElement(locator).sendKeys(valueToSet);
			test.pass("Value " +valueToSet + " inserted in into " + TxtBoxName + "Textbox");
			
		} catch (Exception e) {
			test.fail(valueToSet + " Failed to inserted  into " + locator + "Textbox");
		}
		
	}
	
	public static  void mouseHover(By locator) throws Throwable{
		try {
			Actions a = new Actions(driver);
			WebElement wb = driver.findElement(locator);
			a.moveToElement(wb).build().perform();
	
		} catch (Exception e) {
		test.fail("Failed to move hover on " + locator);
		}
		
	}
	
	public static void SelectfromDropdown(By locator,String val){
	WebElement we=driver.findElement(locator);
	Select s=new Select(we);
	s.deselectByVisibleText(val);
	}
	
	
	public static boolean isDisplayed(By locator, String ElementName){
	
		boolean val = driver.findElement(locator).isDisplayed();
		if(val){
			test.pass(ElementName + " Element displayed");
		}
		else{
			test.fail( ElementName + "Element displayed ");
		}
		return val;
	}
	
	
	public static void E_wait(By locator){
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}



}
