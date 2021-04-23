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
public class TC003PayBills extends BaseClass {
	HomePage Hp;
	LoginPage lp;
	AccountSummaryPage Ap;
    PayBillsPage Pb;
    
    @Test
    public void PayAddPayee() throws InterruptedException
    {
    BaseClass.setupBrowser();
	test.log(LogStatus.INFO, "PayBills Test started");
	log.info("verify PayBills test started"); 
	
	Hp=new HomePage(driver);
	Hp.doClick();
	
	lp=new LoginPage(driver);
	lp.doLogin("username", "password");
	
	Ap=new AccountSummaryPage(driver);
    Ap.doClickPayBills();
    
    Pb=new PayBillsPage(driver);
    Thread.sleep(4000);
    Pb.doClickPayAddPayee();
    Thread.sleep(4000);
    Pb.doPayAddPayee("Sprint","Savings","300","2021-04-28","Phone bill");
    Thread.sleep(4000);
    asrt.assertTrue(Pb.alertContent.isDisplayed(), "The payment was successfully submitted.");
	BaseClass.quitBrowser();
    }
}
