package page;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import util.CommonMethods;

public class Add_Task extends CommonMethods {
	By Projects = By.xpath("//a[@title='Projects']");
	//By Projects = By.xpath("//a[@title='Projects']");
	String ClickonProject = ("//*[(text()=' ");
	By AddTask = By.xpath("//a[@title='Add Task']");
	By IssueType = By.xpath("//label[text()='Issue Type'] /..//input[@type='text']");
	By SelectIssueType = By.xpath("//div[contains(text(),'Bug')]");
	By Subject = By.xpath("//label[text()='Subject'] /..//input");
	By Desc = By.xpath("//div[@aria-label='Editor editing area: main']");
	By Category = By.xpath("//label[text()='Category'] /..//input[@type='text']");
	By SelectCAT = By.xpath("//div[text()='Developer issue']");
	By Priority = By.xpath("//label[text()='Priority'] /following-sibling::input[1]");
	By SelPriority = By.xpath("//div[contains(text(),'High')]");
	By AssigneeDP = By.xpath("//label[text()='Assignee'] /following-sibling::input[1]");
	By AssigneeSLT = By.xpath("//div[@role='option'] /div//div[text()='Hemandh']");
	By StartDate = By.xpath("//input[@placeholder='Start Date']");
	By EndDate = By.xpath("//input[@placeholder='End Date']");
	By EstHrs = By.xpath("//label[text()='Estimated Hours'] /..//input");
	By ActHrs = By.xpath("//label[text()='Actual Hours'] /..//input");
	By FileInput = By.xpath("//input[@type='file']");
	By AddButton = By.xpath("//span[contains(text(),'Save')]");
	By TaskCheck = By.xpath("(//span[contains(text(),'All')])[1]");
	By BatchUpdate =By.xpath("//span[contains(text(),' Batch Update ')]");

	public Add_Task ClickProject() throws InterruptedException {;
		clickElement(Projects);
		return this;	
	}

	public Add_Task SelectProject(String ProjectName) {
		DriverWait();
		//System.out.println("hhhhhhhhhhhhhhhhhhhhhhhhh" + ClickonProject + ProjectName + " ')]");
		driver.findElement(By.xpath(ClickonProject + ProjectName + " ')]")).click();
		return this;
	}

	public Add_Task ClickAddTask() throws InterruptedException {
		Thread.sleep(3000);
		clickElement(AddTask);
		return this;
	}

	public Add_Task SelectType() {
		clickElement(IssueType);
		clickElement(SelectIssueType);
		return this;
	}

	public Add_Task EnterSUB(String EnterSubject) {
		sendKeysToElement(Subject,EnterSubject);
		return this;
	}

	public Add_Task EnterDesc(String EnterDescription) {
		sendKeysToElement(Desc,EnterDescription);
		return this;
	}

	public Add_Task SelectCategory() {
		clickElement(Category);
		clickElement(SelectCAT);
		return this;
	}

	public Add_Task SelectPriority() {
		clickElement(Priority);
		clickElement(SelPriority);
		return this;
	}

//         public Add_Task AddESThours(String ESThours) {
//        	 driver.findElement(EstHrs).sendKeys(ESThours);
//			return this;
//         }
	public Add_Task SelectAssignee() {
		clickElement(AssigneeDP);
		clickElement(AssigneeSLT);
		return this;
	}

	public Add_Task SelectStartDate(String StartYear, String StartMonth, String StartDay) {
		clickElement(StartDate);
		;
		SelectFromSTARTCalender(StartYear, StartMonth, StartDay);
		return this;
	}

	public Add_Task SelectEndDate(String EndYear, String EndMonth, String EndDay) {
		clickElement(EndDate);
		DriverWait();
		SelectFromEndCalender(EndYear, EndMonth, EndDay);
		return this;

	}

	public Add_Task AddESThours(String EstHours) {
		sendKeysToElement(EstHrs,EstHours);
		return this;

	}

	public Add_Task AddActualHrs(String ActHours) {
		sendKeysToElement(ActHrs,ActHours);
		return this;

	}

	public Add_Task FileInput(String InputPath) throws InterruptedException {
		//Thread.sleep(3000);
		//System.out.println("fffffffffffffffffffff");
		//clickElement(FileInput);
		sendKeysToElement(FileInput,InputPath);
		return this;

	}

	public Add_Task ClickAddBtn() {
		clickElement(AddButton);
		return this;

	}

	public Add_Task VerifytheTaskCreationWithAllData() {
		WebElement element = driver.findElement(BatchUpdate);
		  if (element.isDisplayed()) {
		        String actualText = element.getText();
		        String expectedText = "BATCH UPDATEs";
		        Assert.assertEquals(actualText, expectedText, "Element text doesn't match expected value");
		    } else {
		        Assert.fail("Element is not displayed on the page");
		        System.out.println("Element is not displayed on the page");
		    }

		return this;

	}

	public Add_Task EnterRequiredFiedOnly(String EnterSubject, String EnterDescription, String ProjectName) {
		// driver.findElement(ClickonProject).click();
		driver.findElement(By.xpath(ClickonProject + ProjectName + " ')]")).click();
		driver.findElement(AddTask).click();
		driver.findElement(Subject).sendKeys(EnterSubject);
		driver.findElement(Desc).sendKeys(EnterDescription);
		driver.findElement(Priority).click();
		driver.findElement(SelPriority).click();
		driver.findElement(AddButton).click();
		return this;
	}
}
