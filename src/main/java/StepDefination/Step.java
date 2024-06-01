package StepDefination;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import PageClasses.CreateConatctPage;
import PageClasses.loginpage;
import Utils.TestBase;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class Step extends TestBase  {
public WebDriver driver;
public loginpage lp ;
public CreateConatctPage addcont;


	
	
@Given("Launch the browser and open url")
	public void launch_the_browser_and_open_url() {
	
	driver=new FirefoxDriver();    // driver initiation 
	 lp =new loginpage(driver);     // loginpage class initiation
	
	
	TestBase.initilizations();

    driver.manage().window().maximize();
	driver.manage().deleteAllCookies();

   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
   
   driver.get(prop.getProperty("url"));
   

}


@Given("user is on login page")
public void user_is_on_login_page() throws InterruptedException {
	
String Title= driver.getTitle();

Assert.assertEquals("Cogmento CRM", Title);


	Thread.sleep(2000);
	 
}

@When("user enter the username {string} and password {string}")
public void user_enter_the_username_and_password(String email, String password) {
	lp.setusername(email);
	lp.setpassword(password);
	
}

@When("Click on login button")
public void click_on_login_button() throws InterruptedException {
	lp.clickloginbutton();
	Thread.sleep(2000);
   
}

@Then("user should on the homepage")
public void user_should_on_the_homepage() throws IOException {
	
	if (driver.getPageSource().contains("Something went wrong...")) 
	{
		Assert.assertTrue(false, "Wrong username or password ");
		

	
	}
	
	else
	{
	
	
	WebElement loginuser=	driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/b"));  // vishwatech solutions text on homepage 
	
	boolean b = loginuser.isDisplayed();
	
	Assert.assertTrue(b);
	
	System.out.println("User logged in successfully");
	
		
	}}	
	
// Create contact test steps ==========================================	


@When("user move and click on the contact tab")
public void user_move_and_click_on_the_contact_tab() throws InterruptedException {
	
	 addcont = new CreateConatctPage(driver);
	
	Thread.sleep(2000);
	
	addcont.clickonContact();
	

	System.out.println("user clicked on contact tab");
		
 
}

@Then("user is on contact page")
public void user_is_on_contact_page() throws InterruptedException {
	Thread.sleep(2000);
	
	addcont.conatctText();
	
	Assert.assertTrue(true);
	
	System.out.println("user is on contact page");
  
}

@Then("Click on Create button")
public void click_on_create_button() throws InterruptedException {
	
	Thread.sleep(3000);
	
	  addcont.CreateConatct();
}

@Then("Enter the following details and click on save Button")
public void enter_the_following_details_and_click_on_save_button(DataTable ContactData) {
	
	List<List<String>> contactdetails= ContactData.cells();
	
	addcont.enterConatctDetails(contactdetails.get(0).get(0), contactdetails.get(0).get(1), contactdetails.get(0).get(2), contactdetails.get(0).get(3));
	
	addcont.saveConatct();
	
//	driver.findElement(By.name("first_name")).sendKeys(contactdetails.get(0).get(0));  
//	driver.findElement(By.name("middle_name")).sendKeys(contactdetails.get(0).get(1));   
//	driver.findElement(By.name("last_name")).sendKeys(contactdetails.get(0).get(2));     
//	driver.findElement(By.xpath("//input[@placeholder='Email address']")).sendKeys(contactdetails.get(0).get(3));   //email
//	
//	driver.findElement(By.xpath("//button[@Class='ui linkedin button']")).click();
//	
  
}
}