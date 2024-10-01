package tc;


//import java.io.IOException;
//
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.Login;

//import extentReports.ExtentTestManager;
import util.ReadExcel;

public class TC_Login extends Login {

	
	@BeforeTest
	
	public void driver() {
		new Login().launchAPP();		
}
	@DataProvider(name="testdata")
	public Object[][] LoginTestData() {
	    Object[][] LoginTestData = ReadExcel.ReadTestData(this.getClass().getSimpleName(),"LoginPage", 2);
	    return LoginTestData;
	}
    
	@Test(dataProvider= "testdata",priority =1)
	public void LoginPage(String Username,String Password) {
		ExtentTestDetails("TC_01", "Successfull Login");
		new Login()
		//.ClearFields()
		.EnterUsername(Username)
		.EnterPassword(Password)
		.ClickLogin()
		.VerifySuccessfullLogin();
	}
//    @AfterMethod  
//    public void screenShotForFailedCases(ITestResult result) throws IOException
//    {
//        if(ITestResult.SUCCESS==result.getStatus()){
//            System.out.println("User is successfully Logged IN");          
//        }	
//}
    
	@DataProvider(name="testdataForInvalidUsername")
	public Object[][] LoginTestDataForInvalidLOgin() {
	    Object[][] LoginTestDataForInvalidLOgin = ReadExcel.ReadTestData(this.getClass().getSimpleName(),"LoginWithInvalidUsername", 2);
	    return LoginTestDataForInvalidLOgin;
	}    
  //Test Login  With invalid USERNAME
    @Test(dataProvider="testdataForInvalidUsername",priority =0)
    public void LoginWithInvalidUsername(String Username,String Password) throws InterruptedException {
    	ExtentTestDetails("TC_02", "Invalid Username");
    	new Login()
    	.EnterUsername(Username)
    	.EnterPassword(Password)
    	.ClickLogin()
    	.VerifyErrorMessage()
    	.ClearFields();
    }
//    @AfterTest
//    public void Quit() {
//    	driver.quit();
//    }
//    
    }
    
    

	