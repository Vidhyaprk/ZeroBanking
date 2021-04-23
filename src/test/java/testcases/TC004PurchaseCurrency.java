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
public class TC004PurchaseCurrency extends BaseClass{
	HomePage Hp;
	LoginPage lp;
	AccountSummaryPage Ap;
	PayBillsPage Pb;
	
	@Test
	public void PurchaseCurrency() throws InterruptedException
	{
		BaseClass.setupBrowser();
		test.log(LogStatus.INFO, "PurchaseCurrency test has started");
		log.info("verify PurchaseCurrency test started"); 
		Hp=new HomePage(driver);
		Hp.doClick();		
		lp= new LoginPage(driver);
		lp.doLogin("username", "password");		
	    Ap=new AccountSummaryPage(driver);
	    Ap.doClickPayBills();	    
	    Pb=new PayBillsPage(driver);
	    Thread.sleep(4000);
	    Pb.doClickPurchaseCash();
	    Thread.sleep(4000);
	    Pb.doPurchaseCash("Canada (dollar)", "100");
	    asrt.assertTrue(Pb.alertContent1.isDisplayed(),"Foreign currency cash was successfully purchased.");
		BaseClass.quitBrowser();
	}
	

}
