package Pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePage {

	public static Properties CONFIG=null;
	//private static SafariDriver driver = new ThreadLocal<WebDriver>();
	//private static String browserProp = System.getProperty("browser");
	public static WebDriver driver;

	public static  WebDriver setDriver() throws IOException {
		CONFIG = new Properties();
        FileInputStream fp = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/ConfigReader/config.properties");
        CONFIG.load(fp);
		if(CONFIG.getProperty("browser").equalsIgnoreCase("chrome")) {
		   WebDriverManager.chromedriver().setup();
		   driver = new ChromeDriver();
		} else if(CONFIG.getProperty("browser").equalsIgnoreCase("safari")){
			//System.setProperty("webdriver.safari.driver","C:/safaridriver.exe");
			driver = new SafariDriver();
			driver.manage().window().maximize();
		}
		return driver;
	}
	
//	public static WebDriver getDriver()
//	{
//		return driver.get();
//	}

}
