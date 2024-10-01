package util;


import java.time.Duration;

//import java.io.File;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import extentReports.ExtentTestManager;







public class CommonMethods{ 

   public static WebDriver driver;
   // WebDriverWait wait;
   // public CommonMethods(WebDriver driver) {
        //this.driver = driver;
    //    this.wait = new WebDriverWait(driver, 10); // Adjust the timeout as necessary
    //}

	
	public void launchAPP()
    {
		//System.out.println("NOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
		ChromeOptions chromeOptions = new ChromeOptions();

		chromeOptions.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
		//System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");
		driver = new ChromeDriver(chromeOptions);
     
	driver.get("https://dev-tm.innovaturelabs.com/");
	driver.manage().window().maximize();
	
	}
	@SuppressWarnings("deprecation")
	public void DriverWait(){
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	}
	public void SelectFromSTARTCalender(String StartYear,String StartMonth,String StartDay) {
   	    WebElement year = driver.findElement(By.xpath("//div[@class='v-picker v-card v-picker--date theme--light'] /div/div//div[text()='2023']"));
     	year.click();
		WebElement YearSelect = driver.findElement(By.xpath("//li[normalize-space()="+StartYear+"]"));
		YearSelect.click();
		DriverWait();
		WebElement MonthSelect = driver.findElement(By.xpath("//div[normalize-space()='"+StartMonth+"']"));
		MonthSelect.click();
		WebElement DateSelect = driver.findElement(By.xpath("//div[normalize-space()='"+StartDay+"']"));
		DateSelect.click();
		DriverWait();
		}

    public void SelectFromEndCalender(String EndYear,String EndMonth,String EndDay) {
       	WebElement year = driver.findElement(By.xpath("(//div[@class='v-picker v-card v-picker--date theme--light'] /div/div//div[text()='2023'])[2]"));
     	year.click();
		WebElement YearSelect = driver.findElement(By.xpath("//li[normalize-space()="+EndYear+"]"));
		YearSelect.click();
		DriverWait();
		WebElement MonthSelect = driver.findElement(By.xpath("//div[normalize-space()='"+EndMonth+"']"));
		MonthSelect.click();
		WebElement DateSelect = driver.findElement(By.xpath("(//div[normalize-space()='"+EndDay+"'])[2]"));
		DateSelect.click();
		DriverWait();
    }
    public void clickElement( By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        driver.findElement(element).click();
    }
    public void sendKeysToElement( By element,String Text) {
        driver.findElement(element).sendKeys(Text);
    }
    public void ExtentTestDetails(String TCID,String TCDescription) {
    	ExtentTestManager.getTest().assignCategory(this.getClass().getSimpleName());
    	ExtentTestManager.getTest().assignAuthor("YaduKrishna").assignDevice("Windows Chrome");
    	ExtentTestManager.getTest().info(MarkupHelper.createLabel(TCID, ExtentColor.INDIGO));
    	ExtentTestManager.getTest().info(TCDescription);
    }
	public static WebDriver getDriver() {
		
	    return driver;

	}
	public void CleardatafromField(By element) {
		driver.findElement(element).sendKeys(Keys.CONTROL+"a");
		driver.findElement(element).sendKeys(Keys.DELETE);
	}
	public void QuitB() {
		driver.quit();
	}
	public void HomePageAddBtn () {
		By addBtn = By.xpath("(//button[@title='Add'])[2]");
		driver.findElement(addBtn).click();
		//WebElement element = wait.until(ExpectedConditions.elementToBeClickable(addBtn));
		
       
	}

}

