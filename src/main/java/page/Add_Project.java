package page;

import org.testng.Assert;

import util.CommonMethods;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;

//import dev.failsafe.internal.util.Assert;

public class Add_Project extends CommonMethods {


		// TODO Auto-generated constructor stub


	By PlusButton = By.xpath("//button[@title='Add']");
	By AddProject = By.xpath("//button[@tabindex='0'][@aria-haspopup='true']");
	By ProjectNameE = By.xpath("//input[@placeholder='Project']");
	By ProjectCodeE = By.xpath("//input[@placeholder='Project code']");
	By StartDate = By.xpath("//input[@placeholder='Start Date']");
	By EndDate = By.xpath("//input[@placeholder='End Date']");
	By Description = By.xpath("//textarea[@required='required']");
	By AddButton = By.xpath("//span[text()=' Save ']");
	By Projects = By.xpath("//a[@title='Projects']");
	By ProjectList = By.xpath("//div[@class='widget-heading' and text()=' Asset [aaa60] ']");

	public Add_Project ClickPlusButton() {
		clickElement(PlusButton);
		return this;
	}

	public Add_Project ClickAddProject() {
		clickElement(AddProject);
		DriverWait();
		return this;
	}

	public Add_Project EnterProjectName(String ProjectName) {
		sendKeysToElement(ProjectNameE,ProjectName);
		return this;
	}

	public Add_Project EnterProjectCode(String ProjectCode) {
		sendKeysToElement(ProjectCodeE,ProjectCode);
		return this;
	}

	public Add_Project AddStartDate(String StartYear, String StartMonth, String StartDay) {
		clickElement(StartDate);
		SelectFromSTARTCalender(StartYear, StartMonth, StartDay);
		return this;

	}

	public Add_Project AddEndDate(String EndYear, String EndMonth, String EndDay) throws InterruptedException {
		// TODO Auto-generated method stub
		clickElement(EndDate);
		Thread.sleep(3000);
		SelectFromEndCalender(EndYear, EndMonth, EndDay);
		return this;
	}

	public Add_Project AddDescription(String Desc) {
		sendKeysToElement(Description,Desc);
		return this;
	}

	public Add_Project ClickAddButton() {
		clickElement(AddButton);
		DriverWait();
		return this;
	}

	public Add_Project VerifyProjectCreation() throws InterruptedException {
		Thread.sleep(3000);
		clickElement(Projects);
		Assert.assertEquals(driver.findElement(ProjectList).isEnabled(), true);
		return this;
	}
	// public Add_Project RequiredFiedONLY() {

	// }
}
