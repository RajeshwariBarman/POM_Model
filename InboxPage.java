package POM;

import org.openqa.selenium.By;

import Main.TestBase;
import Main.Web;

public class InboxPage extends TestBase{

	//span[contains(text(),'Inbox') and @class="ebx_RawLabel"]
	private static By btn_Inbox = By.xpath(".//span[@class='fa fa-inbox']");
	
	private By txt_Inbox = By.xpath(".//span[@class='_ebx-documentation-label']");
	
//	boolean VerifyInboxTable = Web.isDisplayed(txt_Inbox);
	
	public boolean VerifyInboxTable() throws Exception{
		Web.E_wait(btn_Inbox);
		Web.click(btn_Inbox, "Inbox");
		Web.E_wait(txt_Inbox);
		boolean VIT = Web.isDisplayed(txt_Inbox, "Inbox as table name");
		return VIT;
	}
}
