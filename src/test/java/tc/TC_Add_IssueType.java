package tc;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import page.Issue_Type;
import util.ReadExcel;

public class TC_Add_IssueType extends Issue_Type {
	
	
	
	@DataProvider(name ="IssueData")
	public Object [][] TestIssue(){
		Object [][] TestIssue =ReadExcel.ReadTestData(this.getClass().getSimpleName(),"TestAddBtn",1);
		return TestIssue;
		
	}

	
	@Test(dataProvider = "IssueData",priority = 1)
	public void TestAddBtn(String Issuename) {
		new Issue_Type()
		.HomePageAdd()
		.ClickIssueType()
		.ClickAddBtn()
		.IssueNameE(Issuename)
		.SaveBtn();
	}
	@Test
	public void EditIssue() {
		new Issue_Type();
		
	}
}
