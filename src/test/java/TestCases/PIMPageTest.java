package TestCases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Bases.OHRMBase;
import Pages.PIMPage;

public class PIMPageTest extends OHRMBase {
	
	PIMPage pi;
	
	@BeforeTest
	public void OpenBrowser() {
		Intialization();
		pi = new Pages.PIMPage();
	}
	
	@Test
	public void AddEmployeeTest() throws AWTException {
		boolean check = pi.AddEmployee();
		Assert.assertTrue(check);
	}
	
	@AfterTest
	public void CloseBrowser() {
		TearDown();
	}

}
