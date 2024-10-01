package tc;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import page.Add_User;
import util.ReadExcel;

public class TC_Add_User extends Add_User {

	@DataProvider(name="DataForUserAdd")
	public Object[][] AddUserTestData() {
	    Object[][] AddUserTestData = ReadExcel.ReadTestData(this.getClass().getSimpleName(),"AddUser", 2);
	    return AddUserTestData;
	}
	
	@Test(dataProvider="DataForUserAdd")
	public void AddUser(String UName,String UEmail)throws InterruptedException {
		ExtentTestDetails("TC_01", "Adding Normal User");
		new Add_User()
		.ClickPlusBtn()
		.ClickUserManagement()
		.ClickAddUser()
		.EnterUsername(UName)
		.EnterEmail(UEmail)
		.SelectUserRole()
		.ClickSubmitBtn()
		.VerifyTheUserAddedOrNot();
}	
	@DataProvider(name="DataForAdminUserAdd")
	public Object[][] AddAdminUserTestData() {
	    Object[][] AddAdminUserTestData = ReadExcel.ReadTestData(this.getClass().getSimpleName(),"AddAdminUser", 2);
	    return AddAdminUserTestData;
	}
	@Test(dataProvider="DataForAdminUserAdd",priority=1)
	public void AddAdminUser(String UName,String UEmail) {
		ExtentTestDetails("TC_02", "Adding Admin User");
		new Add_User()
		.ClickAddUser()
		.EnterUsername(UName)
		.EnterEmail(UEmail)
		.SelectAdminRole()
		.ClickSubmitBtn()
		.VerifyTheUserAddedOrNot();
		
		
	}
}
