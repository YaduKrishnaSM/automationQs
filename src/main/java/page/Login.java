package page;
import java.util.concurrent.TimeUnit;

//import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import util.CommonMethods;
public class Login extends CommonMethods {
	//public static WebDriver driver;
	
	By UsernameField= By.xpath("//input[@name='email']");
	By PasswordField=By.xpath("//input[@name='password']");
	By LoginButton=By.xpath("//button[@class='button-18']");
	By ErrorMessage=By.xpath("//p[text()='Inavlid Email or Password']");
	By AfterLoginCheck =By.xpath("//div[text()=' Innovature Technologies K.K ']");
	
	
	public Login EnterUsername(String Username) {
		sendKeysToElement(UsernameField,Username);
		return this;
	}
	public Login EnterPassword(String Password) {
		sendKeysToElement(PasswordField,Password);
		return this;		
	}
	//@SuppressWarnings("deprecation")
	public Login ClickLogin() {
		driver.findElement(LoginButton).click();
		//driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		return this;
	}
	public Login  VerifyErrorMessage() {
		WebElement Element = driver.findElement(ErrorMessage);
		if (Element.isDisplayed());{
		    String ExpectedResult =Element.getText();
		    String ActualResult ="Inavlid Email or Password";
		    Assert.assertEquals(ExpectedResult, ActualResult,"Error message displayed");
	}
		return this;	
	}
	public Login VerifySuccessfullLogin() {
		WebElement Element = driver.findElement(AfterLoginCheck);
		if (Element.isDisplayed());
		{
			String ExpectedResult =Element.getText();
			String ActualResult = "Innovature Technologies K.K";
			Assert.assertEquals(ExpectedResult, ActualResult,"User Not Login");
		}
		return this;			
	}
	public void ClearFields() throws InterruptedException {
		CleardatafromField(UsernameField);
		CleardatafromField(PasswordField);
		
	}
}
