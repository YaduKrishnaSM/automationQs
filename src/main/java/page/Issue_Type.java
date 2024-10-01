package page;

import org.openqa.selenium.By;

import util.CommonMethods;

public class Issue_Type extends CommonMethods{
	
	By IssueTymeM = By.xpath("(//button[text() =' Issue Type Management '])[2]");
	By AddBtn     = By.xpath("//button[@title =\"Add Issue Type\"] /span[@class=\"v-btn__content\"]");
	By IssueName  = By.id("name");
	By SaveBtn    = By.id("btnshadow");
	
	
	
//	public Issue_Type ClickIssueType() {
//		new CommonMethods().HomePageAddBtn();
//		clickElement(IssueTymeM);
//		return this ;	
//	}
	public Issue_Type HomePageAdd() {
		DriverWait();
		HomePageAddBtn();
		return this;
		
	}
	public Issue_Type ClickAddBtn () {
		clickElement(AddBtn);
		return this;	
	}
	public Issue_Type ClickIssueType() {
		// TODO Auto-generated method stub
		//new CommonMethods().HomePageAddBtn();
		clickElement(IssueTymeM);
		return this ;
		
	}
	public Issue_Type IssueNameE(String Issuename ) {
		sendKeysToElement(IssueName, Issuename);
		return this;
		
	}
	public Issue_Type SaveBtn() {
		clickElement(SaveBtn);
		return this;
	}

	

}
