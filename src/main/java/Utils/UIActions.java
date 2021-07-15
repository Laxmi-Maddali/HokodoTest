package Utils;

import java.util.ArrayList;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/*
 * All common methods ex: Actions click, switching Windows 
 * which can be used across the project to be written here 
 */

public class UIActions {
	
	
	 public static void switchToModalDialog(WebDriver driver, String parent) { 
     if (driver.getWindowHandles().size() == 2) {
         for (String window : driver.getWindowHandles()) {
             if (!window.equals(parent)) {
                 driver.switchTo().window(window);
                 System.out.println("Modal dialog found");
                 break;
             }
         }
       }
    }
 
	 public static int getRandomNumberBetweenRange(int min, int max ) {
		return (int)(Math.random()*((max-min)+1))+min;
	}
 
	 public static void clickWebElementUsingActions(WebElement element, WebDriver driver) {
		 Actions act = new Actions(driver);
		 act.moveToElement(element).click().build().perform();
	 }
	 
	 public static void typeUsingActions(WebElement element, WebDriver driver, String value) {
		 Actions act = new Actions(driver);
		 act.moveToElement(element).click().sendKeys("value").build().perform();
	 }
	 
	 public static void clickOnLinkToOpenInNewTab(WebElement ele, WebDriver driver) {
		 Actions act = new Actions(driver);
		 act.keyDown(Keys.COMMAND).moveToElement(ele).click().build().perform();
	 }

	 
	 public static void switchToNewTab(WebDriver driver) {
		 ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		 driver.switchTo().window(tabs.get(1));
	 }
}
