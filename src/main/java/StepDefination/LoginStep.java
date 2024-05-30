package StepDefination;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

import PageClasses.loginpage;
import Utils.TestBase;
import io.cucumber.java.en.*;

public class LoginStep extends TestBase  {
public WebDriver driver;
public loginpage lp ;
	
	
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
public void click_on_login_button() {
	lp.clickloginbutton();
   
}

@Then("user should on the homepage")
public void user_should_on_the_homepage() {
	
	Assert.assertEquals("Cogmento CRM", driver.getTitle());
	
	
    
}




}
