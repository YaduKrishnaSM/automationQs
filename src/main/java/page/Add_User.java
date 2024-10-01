package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import util.CommonMethods;

public class Add_User extends CommonMethods {
	
	By PlusBtn=By.xpath("//button[@title='Add']");
	By Usermanagement=By.xpath("//button[text()=' User Management ']");
	By AddUser=By.xpath("//button[@title='Add user']");
	By Name=By.xpath("//input[@id='name']");
	By Email=By.xpath("//input[@id='email']");
	By Role=By.xpath("//input[@placeholder='Role']");
	By SelectURole=By.xpath("//div[text()='User']");
	By SelectARole=By.xpath("//div[text()='Admin']");
	By SubmitBtn=By.xpath("//span[text()=' Save ']");
	By SuccessMessage=By.xpath("//p[text()='User added Successfully']");
	
	
	public Add_User ClickPlusBtn() {
		clickElement(PlusBtn);
		return this;
	}
	public Add_User ClickUserManagement() {
		clickElement(Usermanagement);
		return this;	
	}
	public Add_User ClickAddUser() {
		clickElement(AddUser);
		return this;		
	}
	public Add_User EnterUsername(String UName) {
		sendKeysToElement(Name,UName);
		return this;		
	}
	public Add_User EnterEmail(String UEmail) {
		sendKeysToElement(Email,UEmail);
		return this;		
	}
	public Add_User SelectUserRole() {
		clickElement(Role);
		clickElement(SelectURole);
		return this;		
	}
	public Add_User SelectAdminRole() {
		clickElement(Role);
		clickElement(SelectARole);
		return this;
		
	}
	public Add_User ClickSubmitBtn() {
		clickElement(SubmitBtn);
		return this;
	}
	public Add_User VerifyTheUserAddedOrNot() {
		WebElement Element=driver.findElement(SuccessMessage);
		if(Element.isDisplayed()) {
			String ActualResult=Element.getText();
			String ExpectedResult="User added Successfully";
			Assert.assertEquals(ActualResult, ExpectedResult,"User Added");
		}
		else{
			System.out.println("User is Not added");		
		}
		return this;
		
	}

}
