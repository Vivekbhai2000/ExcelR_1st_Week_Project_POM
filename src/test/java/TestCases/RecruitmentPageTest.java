package TestCases;

import java.awt.AWTException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Bases.OHRMBase;
import Pages.RecruitmentPage;

public class RecruitmentPageTest extends OHRMBase {
	
	RecruitmentPage rp;
	
	@BeforeMethod
	public void OpenBrowser() {
		Intialization();
		rp = new Pages.RecruitmentPage();
	}
	
	@Test
	public void AddCandidateTest() throws AWTException {
		boolean check = rp.AddCandidate();
		Assert.assertTrue(check);
	}
	
	@Test
	public void AddVacancyTest() throws AWTException {
		boolean check = rp.AddVacancy();
		Assert.assertTrue(check);
	}
	
	@AfterMethod
	public void CloseBrowser() {
		TearDown();
	}

}
