package testcases;


import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import base.BaseClass;
import pages.AccountSummaryPage;
import pages.HomePage;
import pages.LoginPage;
import pages.PayBillsPage;
@Listeners(base.CustomListeners.class)
public class TC002Payee extends BaseClass{
	
	@Test
	public void addPayee() throws InterruptedException {
		
	BaseClass.setupBrowser();
	test.log(LogStatus.INFO, "Add Payee Test started");
	
	HomePage hp = new HomePage(driver);
	hp.doClick();
	
	LoginPage lp=new LoginPage(driver);
	lp.doLogin("username", "password");
	
	AccountSummaryPage asp=new AccountSummaryPage(driver);
	asp.doClickPayBills();
	
	PayBillsPage pb=new PayBillsPage(driver);
	Thread.sleep(4000);
	pb.doClickAddPayee();
	Thread.sleep(4000);
	pb.doAddPayee("Telus", "123 45th Ave East", "123456", "cell phone");
	
	asrt.assertTrue(pb.alertContainer.isDisplayed());
	BaseClass.quitBrowser();
	
	}
}
