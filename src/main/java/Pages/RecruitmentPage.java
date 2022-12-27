package Pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Bases.OHRMBase;

public class RecruitmentPage extends OHRMBase {
	
	public boolean AddCandidate() throws AWTException {
		
		driver.findElement(By.xpath(prop.getProperty("Usernamexpath"))).sendKeys(prop.getProperty("Username"));
		driver.findElement(By.xpath(prop.getProperty("Passwordxpath"))).sendKeys(prop.getProperty("Password"));
		driver.findElement(By.xpath(prop.getProperty("Loginxpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("RecruitmentMenu"))).click();
		driver.findElement(By.xpath(prop.getProperty("RCAddRecruitmentButton"))).click();
		driver.findElement(By.xpath(prop.getProperty("RCFirstnamexpath"))).sendKeys(prop.getProperty("RCFirstname"));
		driver.findElement(By.xpath(prop.getProperty("RCMiddlenamexpath"))).sendKeys(prop.getProperty("RCMiddlename"));
		driver.findElement(By.xpath(prop.getProperty("RCLastnamexpath"))).sendKeys(prop.getProperty("RCLastname"));
		driver.findElement(By.xpath(prop.getProperty("RCVacancyDropdownbutton"))).click();
		List<WebElement> Vacancy = driver.findElements(By.xpath(prop.getProperty("RCVacancyList")));
		for (int i = 0; i < Vacancy.size(); i++) {
			if(Vacancy.get(i).equals("Associate IT Manager")) {
				Vacancy.get(i).click();
			}
		}
		driver.findElement(By.xpath(prop.getProperty("RCEmailxpath"))).sendKeys(prop.getProperty("RCEmail"));
		driver.findElement(By.xpath(prop.getProperty("RCNumberxpath"))).sendKeys(prop.getProperty("RCNumber"));
	    driver.findElement(By.xpath(prop.getProperty("RCResumeAddButton"))).click();
		Robot rb = new Robot();
		rb.delay(3000);
		StringSelection ss = new StringSelection(prop.getProperty("RCStringSelection"));
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		driver.findElement(By.xpath(prop.getProperty("RCKeywordsxpath"))).sendKeys(prop.getProperty("RCKeywords"));
        driver.findElement(By.xpath(prop.getProperty("RCDateOfApplicationxpath"))).clear();
		driver.findElement(By.xpath(prop.getProperty("RCNotesxpath"))).sendKeys(prop.getProperty("RCNotes"));
		driver.findElement(By.xpath(prop.getProperty("RCConsentclick"))).click();
		driver.findElement(By.xpath(prop.getProperty("RCSaveButton"))).click();
		System.out.println("Recruitment Added");
		return driver.findElement(By.xpath(prop.getProperty("RCAapplicationStageIsDisplayed"))).isDisplayed();
	}
	
	public boolean AddVacancy() {
		
		driver.findElement(By.xpath(prop.getProperty("Usernamexpath"))).sendKeys(prop.getProperty("Username"));
		driver.findElement(By.xpath(prop.getProperty("Passwordxpath"))).sendKeys(prop.getProperty("Password"));
		driver.findElement(By.xpath(prop.getProperty("Loginxpath"))).click();
		driver.findElement(By.xpath(prop.getProperty("RecruitmentMenu"))).click();
		driver.findElement(By.xpath(prop.getProperty("RVVacanciesMenu"))).click();
		driver.findElement(By.xpath(prop.getProperty("RVAddVacancyButton"))).click();
		driver.findElement(By.xpath(prop.getProperty("RVNamexpath"))).sendKeys(prop.getProperty("RVName"));
		driver.findElement(By.xpath(prop.getProperty("RVJobTitiledropdownkeyxpath"))).click();
		List<WebElement> JobTitle = driver.findElements(By.xpath(prop.getProperty("RVJobTitilelistxpath")));
		for (int i = 0; i<JobTitle.size(); i++) {
			if (JobTitle.get(i).equals("Chief Executive Officer")) {
				JobTitle.get(i).click();
			}
		}
		driver.findElement(By.xpath(prop.getProperty("RVDescriptionxpath"))).sendKeys(prop.getProperty("RVDescription"));
		driver.findElement(By.xpath(prop.getProperty("RVHiringManagerxpath"))).sendKeys(prop.getProperty("RVHiringManager"));
		driver.findElement(By.xpath(prop.getProperty("RVPositionxpath"))).sendKeys(prop.getProperty("RVPosition"));
		driver.findElement(By.xpath(prop.getProperty("RVSubmitxpath"))).click();
		System.out.println("Vacancy Details Added");
		return driver.findElement(By.xpath(prop.getProperty("RVEditVacancyIsDisplayed"))).isDisplayed();
	}

}
