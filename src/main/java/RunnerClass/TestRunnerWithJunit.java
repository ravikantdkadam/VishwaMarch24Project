package RunnerClass;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)         // this annotation used to start execution of Tests only for run with Junit 

	@CucumberOptions( 
			
			features = "src\\main\\resources\\Feature\\CreateContact.feature",    // The path to the feature file is specified by feature options 
			
			glue={"StepDefination"},   // This argument used to provide step definition file location
			
			dryRun=false,      //dryRun compile the feature file and Step Definition 
			
		   monochrome =true , // Display the console output in readable format 
		   
					//tags= "@SmokeTest and  @RegressionTest",
		   
		      // tags= "not @SmokeTest",  // Ignore Test case 
					
					
							// Or : either one  both tags are in  "@SmokeTest or  @RegressionTest",
							
							//And : both    "@SmokeTest and  @RegressionTest",
			
			
					//This option is used create different type of Reports 

			plugin = {"pretty", "html:target/cucumber-reports.html",   //This option is used create different type of Reports :html report
					  "pretty", "json:target/cucumber-reports.json" ,   //json  report
					"pretty",  "junit:target/cucumber-reports.xml" }  //xml report
					

			)

	public class TestRunnerWithJunit  {
		
		

	}

	