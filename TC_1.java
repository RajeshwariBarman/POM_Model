package TestCasesForLogin;

import org.testng.Assert;
import org.testng.annotations.Test;
import Main.ReadXLSFile;
import Main.TestBase;
import POM.InboxPage;
import POM.LoginPage;

public class TC_1 extends TestBase{
	
	@Test(dataProvider = "dpTestData", dataProviderClass = ReadXLSFile.class)
//	@Test
	public static void TestCase1() throws Exception{
		test = extent.createTest("Test Case 1 - Login test");
		String method= Thread.currentThread()  .getStackTrace()[1] .getMethodName(); 
		System.out.println(method);
		LoginPage LP=new LoginPage();
			boolean val = LP.login("Username", "Password");
			Assert.assertEquals(true, val);
		
	}
	
	//@Test(dataProvider = "dpTestData", dataProviderClass=ReadXLSFile.class)
	@Test
	public void TestCase2() throws Exception{
		
		test = extent.createTest("Test Case 2 - Inbox table verification");
		
		String method= Thread.currentThread()  .getStackTrace()[1] .getMethodName(); 
		System.out.println(method);
		LoginPage LP=new LoginPage();
		boolean val1=  LP.login("Username", "Password");
		if(val1){
		InboxPage IP=new InboxPage();
			boolean val2 = IP.VerifyInboxTable();
			System.out.println(val2);
		Assert.assertEquals(true, val2);
		}
	
	}

}
