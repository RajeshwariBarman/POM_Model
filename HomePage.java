package POM;

import org.openqa.selenium.By;
import Main.TestBase;
import Main.Web;

public class HomePage extends TestBase{
	
	private static By lbl_Home = By.xpath(".//span[contains(text(), 'Home')]");

	public static boolean VerifyHomeLable = Web.isDisplayed(lbl_Home, "Home Label");
	
	
	
	
}
