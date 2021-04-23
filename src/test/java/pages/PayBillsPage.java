package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;

public class PayBillsPage extends BasePage {
	
	
	public PayBillsPage(WebDriver driver) {
		super(driver);
		}
	//Add Payee
	@FindBy(xpath="//a[contains(text(),'Add New Payee')]")
	public WebElement lnkAddPayee;
	
	@FindBy(xpath="//input[@id='np_new_payee_name']")
	public WebElement txtPayeeName;
	
	@FindBy(id="np_new_payee_address")
	public WebElement txtPayeeAddress;
	
	@FindBy(id="np_new_payee_account")
	public WebElement txtPayeeAccount;
	
	@FindBy(id="np_new_payee_details")
	public WebElement txtPayeeDetails;
	
	@FindBy(id="add_new_payee")
	public WebElement btnAddPayee;
	
	@FindBy(id="alert_container")
	public WebElement alertContainer;
	
	//Pay Added Payee
	@FindBy(xpath="//a[contains(text(),'Pay Saved Payee')]")
	public WebElement InkPayAddedPayee;
	
	@FindBy(id="sp_payee")
	public WebElement txtSpPayee;

	
	@FindBy(id="sp_account")
	public WebElement txtSpaccount;
	
	@FindBy(id="sp_amount")
	public WebElement txtspamount;
	
	@FindBy(id="sp_date")
	public WebElement txtspdate;
	
	@FindBy(id="sp_description")
	public WebElement txtspdescription;
	
	@FindBy(id="pay_saved_payees")
	public WebElement  btnPaySavedPayees;
	
	@FindBy(id="alert_content")
	public WebElement alertContent;
	
	//Purchase Foreign Currency
	@FindBy(xpath="//a[contains(text(),'Purchase Foreign Currency')]")
	public WebElement InkPurchaseForeignCurrency;
	
	@FindBy(id="pc_currency")
	public WebElement txtpccurrency;
	
	@FindBy(id="pc_amount")
	public WebElement txtpcamount;
	
	@FindBy(xpath="//body/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[3]/form[1]/div[1]/div[1]/article[1]/fieldset[1]/div[2]/div[1]/label[2]")
	public WebElement txtUSDollars;
	
	@FindBy(xpath="//body/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div[3]/form[1]/div[1]/div[1]/article[1]/fieldset[1]/div[2]/div[1]/label[3]")
	public WebElement txtSelectedCurrency;
	
	@FindBy(id="pc_calculate_costs")
	public WebElement btnpccalculatecosts;
	
	@FindBy(id="purchase_cash")
	public WebElement btnpurchasecash;
	
	@FindBy(id="alert_content")
	public WebElement alertContent1;
	
	public void doClickPayAddPayee() {
		InkPayAddedPayee.click();
		
	}
	public void doClickAddPayee() {
		lnkAddPayee.click();
		
	}
	public void doClickPurchaseCash() {
		InkPurchaseForeignCurrency.click();
	
	}
	public void doAddPayee(String pname, String paddress, String paccount, String pdetails) {
		txtPayeeName.sendKeys(pname);
		txtPayeeAddress.sendKeys(paddress);
		txtPayeeAccount.sendKeys(paccount);
		txtPayeeDetails.sendKeys(pdetails);
		btnAddPayee.click();
		
	}
	public void doPayAddPayee(String SpPayee,String Spaccount,String Spamount,String spdate,String spdescription )
	{
        Select PayeeName = new Select((txtSpPayee));
        PayeeName.selectByVisibleText(SpPayee);
        Select PayeeAcct = new Select((txtSpaccount));
        PayeeAcct.selectByVisibleText(Spaccount);
     	txtspamount.sendKeys(Spamount);
		txtspdate.sendKeys(spdate);
		txtspdescription.sendKeys(spdescription);
		btnPaySavedPayees.click();
		}
	public void doPurchaseCash(String txtCurrency,String Amount)
	{
		 Select Currency1=new Select(txtpccurrency);
	     Currency1.selectByVisibleText(txtCurrency);
	     txtpcamount.sendKeys(Amount);
	     WebElement Radio1=txtSelectedCurrency;
	     Radio1.click();
	 	 btnpccalculatecosts.click();
		 btnpurchasecash.click();		
	}
}