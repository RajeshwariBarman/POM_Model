package POM;

import org.openqa.selenium.By;
import Main.TestBase;
import Main.Web;

public class LoginPage extends TestBase{
	
	
	private By txt_UserName = By.xpath(".//input[@name='login']");
	
	private By txt_Password  = By.xpath(".//input[@name='password']");
	
	private By btn_Login = By.xpath(".//button[@type='submit']");
	
	private By lbl_WTE = By.xpath(".//div[contains(text(), 'Welcome to EBX')]");
	
	private By dd = By.xpath(".//button[@type='button']");
	
	//Home
	private static By lbl_Home = By.xpath(".//span[contains(text(), 'Home')]");
	
/*------------------------------------------------------------------------------------------------------
 * Method Name 	: Login
 * Parameters	: Username and Password
 * 
 */
	public boolean login(String UName, String Pwd) throws Exception{
	//	try {
	//	Web.SelectfromDropdown(dd, "English (United States)");
		 Web.type(txt_UserName, "sds" , "Username");
		 Web.type(txt_Password, "sds", "Password");
		 Web.click(btn_Login, "Login");
		 Web.E_wait(lbl_Home);
		 boolean HomePageVerification = Web.isDisplayed(lbl_Home, "Home Label");
		 return HomePageVerification;
		 
	//	} catch (Exception e) {
	//		System.out.println("Elements identificaiton failed");
	//	}
	}


}
