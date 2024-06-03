package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageClasses.CreateConatctPage;
import PageClasses.loginpage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	public static Properties prop;
	public static WebDriver driver;
	public loginpage lp ;
	public CreateConatctPage addcont;
	 
	public TestBase()    {          // constructor of Base Class for reading the property file

		try {
			 prop =new Properties();			
			 
			 FileInputStream fis = new FileInputStream("D:\\C drive Data 26_06_23\\eclipse-workspace\\VishwaMarch24CucumberProject\\src\\main\\java\\Config\\Configuration.properties");
			
			prop.load(fis);
			
		} 
		
		catch (IOException e) {
			e.getMessage();
		
		}
		
	}
		
		public static void initilizations() {
			
			String browsername  = prop.getProperty("browser"); // read browser property from properties file 
			
			if (browsername.equals("Chrome")) {
				
				WebDriverManager.chromedriver().setup();
				 driver = new ChromeDriver(); 
 
			   
			}    
		     
		     else if (browsername.equals("FF")) {
		    	 
		    	 WebDriverManager.firefoxdriver().setup();

				//	 driver = new FirefoxDriver(); 
		 
		     }
		     else if (browsername.equals("MicrosoftEdge")) {
		    	 
		    	 WebDriverManager.edgedriver().setup();
		    	 
		    	 
		     }
			

		    driver.manage().window().maximize();
			driver.manage().deleteAllCookies();

		   driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		   
		   driver.get(prop.getProperty("url"));
		   
			
			 
		     }
		
		
		public static void Takescreenshot() throws IOException {
			TakesScreenshot  ts= (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File dest = new File ("D:\\C drive Data 26_06_23\\eclipse-workspace\\VishwaMarch24CucumberProject\\target\\Fail.png");
			FileUtils.copyFile(src, dest);
		
		}
		
		
	  
			
		}	
	
	


