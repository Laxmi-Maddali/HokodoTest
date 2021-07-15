package Runners;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import Pages.BasePage;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(monochrome = true, 
				features = "src/test/resources/Features", 
				glue = { "Stepdefs", "Pages/Hooks","Pages" },
				plugin = { "pretty" },
				tags = "@tag1" 
)

public class PaymentPageRunner extends AbstractTestNGCucumberTests {

	@BeforeClass
	public static void setUp() throws IOException {
		BasePage.setDriver();
	}

	@AfterClass
	public static void tearDown() {
		
	}

}