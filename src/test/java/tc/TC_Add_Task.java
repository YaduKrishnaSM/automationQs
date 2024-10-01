package tc;

//import java.io.File;
//import java.io.IOException;

//import org.apache.commons.io.FileUtils;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.openqa.selenium.devtools.v107.page.Page;
//import org.testng.ITestResult;
//import org.testng.annotations.AfterMethod;
//import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import page.Add_Task;
//import extentReports.ExtentTestManager;
import util.ReadExcel;


public class TC_Add_Task extends Add_Task{
	
	
//	ExtentSparkReporter spark = new ExtentSparkReporter("./test-output/extent.html");
//    ExtentReports extent = new ExtentReports();
//	
//    @BeforeMethod
//    public void ReportsetUp() {      
//     // directory where output is to be printed
//    	spark.config().setTheme(Theme.DARK);
//        extent.attachReporter(spark);

//    }
	
	@DataProvider(name="TaskpageData")
	public Object[][] AddTaskTestData() {
	    Object[][] AddTaskTestData = ReadExcel.ReadTestData(this.getClass().getSimpleName(),"Add_Task", 12);
	    return AddTaskTestData;
	}
	//Test The Task Creation with data Entered In all fields
	@Test(dataProvider= "TaskpageData",priority =1)
	public void Add_Task(String ProjectName,String EnterSubject,String EnterDescription,String StartYear,String StartMonth,String StartDay,String EndYear,String EndMonth,String EndDay,String ESThours,String ActHours,String InputPath) throws InterruptedException {
		ExtentTestDetails("TC_01", "Adding task with all data");
		new Add_Task()
		//.ClickProject()
		.SelectProject(ProjectName)
		.ClickAddTask()
		.SelectType()
		.EnterSUB(EnterSubject)
		.EnterDesc(EnterDescription)
		.SelectCategory()
		.SelectPriority()
		//.SelectAssignee()
		.SelectStartDate(StartYear, StartMonth, StartDay)
		.SelectEndDate(EndYear, EndMonth, EndDay)
		.AddESThours(ESThours)
		.AddActualHrs(ActHours)
		.FileInput(InputPath)
		.ClickAddBtn()
		.VerifytheTaskCreationWithAllData();
//		test.log(Status.PASS, "Test passed.");
		
		}

//    @AfterMethod
//    public void tearDown() {
//        //extent.saveTest(test);
//        extent.flush();
//    }	
//    @AfterMethod
//    public void screenShotForFailedCases(ITestResult result) throws IOException
//    {
//        if(ITestResult.FAILURE==result.getStatus()){
//            System.out.println("Not Able add TASK");
//        }        
//        // Here will compare if test is failing then only it will enter into if condition
//        if(ITestResult.FAILURE==result.getStatus())
//        {
//            TakesScreenshot scrShot =((TakesScreenshot)driver);
//            File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
//            File DestFile=new File("C:\\Users\\Yadu Krishna S M\\eclipse-workspace\\Task_Management\\ScreenShots\\Task.png");
//            FileUtils.copyFile(SrcFile,DestFile);
//        }

//    } 
	
/*	@DataProvider(name="TaskpageDataForRequired")
	public Object[][] AddTaskTestDataRequired() {
	    Object[][] AddTaskTestDataRequired = ReadExcel.ReadTestData(this.getClass().getSimpleName(),"Add_TaskWithRequiredFields", 3);
	    return AddTaskTestDataRequired;
	}
	//Test task creation with data in Required Fields Only
/*	@Test(dataProvider ="TaskpageDataForRequired") 
	public void Add_TaskWithRequiredFields(String ProjectName,String EnterSubject,String EnterDescription) throws InterruptedException {
		System.out.println("Second Test");
//		new Add_Task()
//	    .EnterRequiredFiedOnly(EnterSubject, EnterDescription);
		new Add_Task()
		.ClickProject()
		.SelectProject(ProjectName)
		.ClickAddTask()
		.SelectType()
		.EnterSUB(EnterSubject)
		.EnterDesc(EnterDescription)
		.SelectPriority()
		.ClickAddBtn();
		System.out.println("AddbuttonClicked");
	}*/

}

