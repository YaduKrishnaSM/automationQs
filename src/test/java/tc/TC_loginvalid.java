package tc;

//import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import page.Login;
import util.ReadExcel;

public class TC_loginvalid extends Login{
	
	@BeforeTest
	public void driver() {
		new Login().launchAPP();		
}
	@DataProvider(name="testdata1")
	public Object[][] LoginTestData1() {
	    Object[][] LoginTestData1 = ReadExcel.ReadTestData(this.getClass().getSimpleName(),"LoginValidT", 2);
	    return LoginTestData1;
	}
	
	@Test(dataProvider= "testdata1")
	public void LoginValidT(String Username ,String Password) {
		new Login()
		.EnterUsername(Username)
		.EnterPassword(Password)
		.ClickLogin();
		
		
	}
//	@AfterTest 	
//	public void Quit () {
//		new Login().QuitB();
//	}
}

