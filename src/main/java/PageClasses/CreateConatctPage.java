package PageClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateConatctPage {
	
	@FindBy(xpath="/html/body/div[1]/div/div[1]/div[3]/a/span") WebElement ContactTab;
	
	@FindBy(xpath="/html/body/div[1]/div/div[2]/div[2]/div/div[1]/div[1]/span") WebElement text;
	
	@FindBy(xpath="/html/body/div[1]/div/div[2]/div[2]/div/div[1]/div[2]/div/a/button")WebElement Createbutton;
	
	
	@FindBy(name="first_name") WebElement FirstName;
	
	@FindBy(name="middle_name") WebElement MiddleName;
	
	@FindBy(name="last_name") WebElement LastName;
	
	@FindBy(xpath="//input[@placeholder='Email address']") WebElement EmailID;
	
	@FindBy(xpath="//button[@Class='ui linkedin button']") WebElement SaveButton;
	
	
public CreateConatctPage(WebDriver driver) {                            
		
		PageFactory.initElements(driver, this);
		
	}
		

//Action perform method 

public void clickonContact() {
	
	ContactTab.click();
	
}

public void conatctText() {
	
	text.isDisplayed();
}

public void CreateConatct() {
	
	Createbutton.click();
}


	public void enterConatctDetails(String fn, String mn, String ln, String email) {
		
		FirstName.sendKeys(fn);
		MiddleName.sendKeys(mn);
		LastName.sendKeys(ln);
		EmailID.sendKeys(email);
		
	}
	
	
	public void saveConatct() {
		
		SaveButton.click();
	}
	
	

	

}
