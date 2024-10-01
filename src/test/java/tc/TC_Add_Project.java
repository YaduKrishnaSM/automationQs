package tc;

import java.io.IOException;

//import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.Add_Project;
//import Page.Login;
import util.ReadExcel;

public class TC_Add_Project extends Add_Project{


	@DataProvider(name="testdata")
	public Object[][] AddProjectTestData() {
	    Object[][] AddProjectTestData = ReadExcel.ReadTestData(this.getClass().getSimpleName(),"Addproject", 9);
	    return AddProjectTestData;
	}
	
	
	@Test(dataProvider= "testdata")
	public void Addproject(String ProjectName,String ProjectCode,String StartYear,String StartMonth,String StartDay,String EndYear,String EndMonth,String EndDay,String Desc) throws InterruptedException
	
	{
		 new Add_Project()
		 
		.ClickPlusButton()
		.ClickAddProject()
		.EnterProjectName(ProjectName)
		.EnterProjectCode(ProjectCode)
		.AddStartDate(StartYear,StartMonth,StartDay)
    	.AddEndDate(EndYear,EndMonth,EndDay)
    	.AddDescription(Desc)
		.ClickAddButton()
		.VerifyProjectCreation();
		
	}
    @AfterMethod
    public void screenShotForFailedCases(ITestResult result) throws IOException
    {
        if(ITestResult.FAILURE==result.getStatus()){
            System.out.println("Project Not ADDED");
            
        }
		
}}
	


