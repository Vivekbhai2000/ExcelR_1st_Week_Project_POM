package Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Bases.OHRMBase;

public class LeavePage extends OHRMBase{
	
	public boolean ApplyLeave() {
		driver.findElement(By.xpath(prop.getProperty("Usernamexpath"))).sendKeys(prop.getProperty("Username"));
		driver.findElement(By.xpath(prop.getProperty("Passwordxpath"))).sendKeys(prop.getProperty("Password"));
		driver.findElement(By.xpath(prop.getProperty("Loginxpath"))).click();
		System.out.println("Login Done");
		driver.findElement(By.xpath(prop.getProperty("LeaveMenu"))).click();
		driver.findElement(By.xpath(prop.getProperty("ApplyLeaveButtonxpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("LeaveTypeDropdownxpath"))).click();
		List<WebElement> LeaveType = driver.findElements(By.xpath(prop.getProperty("LeaveTypeListxpath")));
		for (int i = 0; i<LeaveType.size(); i++) {
			if (LeaveType.get(i).equals("CAN - Bereavement")) {
				LeaveType.get(i).click();
			}
		}
		driver.findElement(By.xpath(prop.getProperty("LeaveFromDatexpath"))).sendKeys(prop.getProperty("LeaveFromDate"));
		driver.findElement(By.xpath(prop.getProperty("LeaveToDatexpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("LeavePartialDaysDropdownxpath"))).click();
		List<WebElement> PartialDays = driver.findElements(By.xpath(prop.getProperty("LeavePartialDaysListxpath")));
		for (int i = 0; i<PartialDays.size(); i++) {
			if (PartialDays.get(i).equals("All Days")) {
				PartialDays.get(i).click();
			}
		}
		driver.findElement(By.xpath(prop.getProperty("LeaveDurationDropdownxpath"))).click();
		List<WebElement> duration = driver.findElements(By.xpath(prop.getProperty("LeaveDurationListxpath")));
		for (int i = 0; i<duration.size(); i++) {
			if (duration.get(i).equals("Half Day - Morning")) {
				duration.get(i).click();
			}
		}
		driver.findElement(By.xpath(prop.getProperty("LeaveCommentxpath"))).sendKeys(prop.getProperty("LeaveComment"));
		driver.findElement(By.xpath(prop.getProperty("LeaveSaveButton"))).click();
		System.out.println("Leave Applied Succesfull");
		return driver.findElement(By.xpath(prop.getProperty("LeaveListIsDisplayed"))).isDisplayed();
	}

}
