package testcases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import base.BaseClass;
import com.relevantcodes.extentreports.LogStatus;

import pages.AccountSummaryPage;
import pages.HomePage;
import pages.LoginPage;
@Listeners(base.CustomListeners.class)
public class TC001Login extends BaseClass {
	
	HomePage hp;
	LoginPage lp;
	AccountSummaryPage asp;
	
	
	@Test
	public void verifyLogin() {
		
		BaseClass.setupBrowser();
		test.log(LogStatus.INFO, "Login Test started");
		log.info("verify login test started");
		hp = new HomePage(driver);
		hp.doClick();
		test.log(LogStatus.INFO, "SignIn Clicked");
		lp=new LoginPage(driver);
		lp.doLogin("username", "password");
		test.log(LogStatus.INFO, "LoggedIn Successfully");
		String actual = BaseClass.driver.getTitle();
		System.out.println(actual);
		String expected="Zero - Account Summary";
		asrt.assertEquals(actual, expected);	
		BaseClass.quitBrowser();
		
	}
	
	
}
