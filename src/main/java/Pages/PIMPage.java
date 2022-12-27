package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Bases.OHRMBase;

public class PIMPage extends OHRMBase {
	
	public boolean AddEmployee() throws AWTException {
		
		driver.findElement(By.xpath(prop.getProperty("Usernamexpath"))).sendKeys(prop.getProperty("Username"));
		driver.findElement(By.xpath(prop.getProperty("Passwordxpath"))).sendKeys(prop.getProperty("Password"));
		driver.findElement(By.xpath(prop.getProperty("Loginxpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("PIMMenu"))).click();
		driver.findElement(By.xpath(prop.getProperty("PIMAddEmployeexpath"))).click();
		WebElement Button = driver.findElement(By.xpath(prop.getProperty("PIMPICAddButton")));
		Button.click();
		Robot rb = new Robot();
		rb.delay(3000);
		StringSelection ss = new StringSelection(prop.getProperty("PIMStringSelection"));
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath(prop.getProperty("PIMFirstnamexpath"))).sendKeys(prop.getProperty("PIMFirstname"));
		driver.findElement(By.xpath(prop.getProperty("PIMMiddlenamexpath"))).sendKeys(prop.getProperty("PIMMiddlename"));
		driver.findElement(By.xpath(prop.getProperty("PIMLastnamexpath"))).sendKeys(prop.getProperty("PIMLastname"));
		driver.findElement(By.xpath(prop.getProperty("PIMEmployeeIDxpath"))).sendKeys("22");
		driver.findElement(By.xpath(prop.getProperty("PIMCreateLoginDetailsButton"))).click();
		driver.findElement(By.xpath(prop.getProperty("PIMUsernamexpath"))).sendKeys(prop.getProperty("PIMUsername"));
		driver.findElement(By.xpath(prop.getProperty("PIMPasswordxpath"))).sendKeys(prop.getProperty("PIMPassword"));
		driver.findElement(By.xpath(prop.getProperty("PIMConfirmpasswordxpath"))).sendKeys(prop.getProperty("PIMConfirmpassword"));
		driver.findElement(By.xpath(prop.getProperty("PIMSaveButtonxpath"))).click();
		System.out.println("User Is Added");
		return driver.findElement(By.xpath(prop.getProperty("PIMPersonalDetailsIsDisplayed"))).isDisplayed();
	}

}
