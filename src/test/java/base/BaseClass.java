package base;




import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import utilities.ExcelReader;
import utilities.ExtentManager;


public class BaseClass {
	
	/*
	 * WebDriver
	 * ExcelReader
	 * Logs
	 * Wait
	 * ExtentReports
	 */
	
	public static WebDriver driver;
	public static SoftAssert asrt=new SoftAssert();
	public static Logger log = Logger.getLogger("qaLogger");
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\excel\\testdata.xlsx");
	public static WebDriverWait wait;
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test =new ExtentTest("Test1", "Test2");
	public static String browser;
	public static ChromeOptions handlingSSL = new ChromeOptions();
		
	public static void setupBrowser() {
		
		if(Constants.browser.equalsIgnoreCase("chrome")) {
			 //Create instance of ChromeOptions Class
			
			//Using the accept insecure cert method with true as parameter to accept the untrusted certificate
			handlingSSL.setAcceptInsecureCerts(true);
			//Creating instance of Chrome driver by passing reference of ChromeOptions object
			
			System.setProperty("webdriver.chrome.driver",
					System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
			driver = new ChromeDriver(handlingSSL);
			//Below is for log4j logs
			log.debug("Launching Chrome Browser");
			//Below is for extent report
			test.log(LogStatus.INFO, "Chrome Browser Launched");
		}
		driver.get(Constants.testUrl);
		driver.manage().window().maximize();		
	}
	
	public static void quitBrowser() {
		driver.quit();
		//Below is for log4j logs
		log.debug("Closing Browser");
		//Below is for extent report
		test.log(LogStatus.INFO, "Browser closing");
		
	}

	
}
