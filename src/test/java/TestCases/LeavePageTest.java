package TestCases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Bases.OHRMBase;
import Pages.LeavePage;

public class LeavePageTest extends OHRMBase{
	
	LeavePage lp;
	
	@BeforeTest
	public void OpenBrowser() {
		Intialization();
		lp = new Pages.LeavePage();
	}
	
	@Test
	public void AddEmployeeTest() throws AWTException {
		boolean check = lp.ApplyLeave();
		Assert.assertTrue(check);
	}
	
	@AfterTest
	public void CloseBrowser() {
		TearDown();
	}

}
