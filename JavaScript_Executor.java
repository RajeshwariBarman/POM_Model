package Main;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class JavaScript_Executor {
	
	public static WebDriver driver;
	
	public static void javaOne(){
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\badigmo1\\Desktop\\Java and Selenium\\latest chrome driver\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("https://gddmdm-qa.eu.novartis.net:8443/ebx-ui/ui");
	
	//	driver.findElement(By.xpath(".//input[@name='login']")).sendKeys("sds");
		driver.findElement(By.name("login")).sendKeys("sds");
		driver.findElement(By.xpath(".//input[@name='password']")).sendKeys("sds");
		WebElement button = driver.findElement(By.xpath(".//span[text()='Log in']"));
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", button);
	}

	@Test
	public void test1(){

		JavaScript_Executor.javaOne();
		driver.close();
	}
}
