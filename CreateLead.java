package week2.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {
	
	public static void main(String[] args) {
		
		//setup WebDriverManager
		
		WebDriverManager.chromedriver().setup();
		System.getProperty("webdriver.chrome.driver", "path");
		// System.out.println(property);
		
		//Instanstiate chromeDriver
		
		ChromeDriver driver = new ChromeDriver();
		
		//Load URL
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		//Locate webelements and cntrl+2,L
		
		WebElement WebUserName = driver.findElement(By.id("username"));
		WebUserName.sendKeys("demosalesmanager");
		
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.manage().window().maximize();
		
		//Get Tiltle and compare
		
		String orgTitle = "Leaftaps - TestLeaf Automation Platform";
		String title = driver.getTitle();
		if(orgTitle.equals(title)) {
			System.out.println("Page landed up correctly");
		}
		else
			System.out.println("Page not landed up correctly");
		
		//click CRM/SFA
		
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		
		
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		String nameToEnter = "Dhivya";
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(nameToEnter);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("P");

		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Dhiv");
		driver.findElement(By.id("createLeadForm_lastNameLocal")).sendKeys("P");
		
		WebElement dd1 = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select drpDwn1 = new Select(dd1);
		drpDwn1.selectByValue("LEAD_COLDCALL");
		
		WebElement dd2 = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select drpDwn2 = new Select(dd2);
		drpDwn2.selectByVisibleText("Affiliate Sites");
		
		driver.findElement(By.name("lastNameLocal")).sendKeys("P");
		driver.findElement(By.name("personalTitle")).sendKeys("QA Engineer");
		driver.findElement(By.id("createLeadForm_birthDate")).sendKeys("07/23/91");
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("QA Tester");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("QA");
		driver.findElement(By.id("createLeadForm_annualRevenue")).sendKeys("800000");
		
		WebElement dd4 = driver.findElement(By.id("createLeadForm_currencyUomId"));
		Select prefCur = new Select(dd4);
		prefCur.selectByValue("INR");
		
		WebElement dd3 = driver.findElement(By.id("createLeadForm_industryEnumId"));
		Select drpDwn3 = new Select(dd3);
		drpDwn3.selectByIndex(1);
		
		driver.findElement(By.id("createLeadForm_numberEmployees")).sendKeys("200");
		
		WebElement dd5 = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select ownerShip = new Select(dd5);
		ownerShip.selectByVisibleText("Sole Proprietorship");
		
		driver.findElement(By.id("createLeadForm_sicCode")).sendKeys("542");
		driver.findElement(By.id("createLeadForm_tickerSymbol")).sendKeys("**");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("*TestLeaf Automation - Selenium Learning*");
		driver.findElement(By.id("createLeadForm_importantNote")).sendKeys("*TestLeaf Automation - Quality Assurance*");
				
		WebElement webCountryCode = driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode"));
		webCountryCode.clear();
		//Thread.sleep(2000);
		webCountryCode.sendKeys("2");
	
		driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys("989");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("9894534236");
		driver.findElement(By.id("createLeadForm_primaryPhoneExtension")).sendKeys("540");	
		driver.findElement(By.id("createLeadForm_primaryPhoneAskForName")).sendKeys("Dhivya");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("dhivyap@gmail.com");
		driver.findElement(By.id("createLeadForm_primaryWebUrl")).sendKeys("TestLeaf.com");

		driver.findElement(By.id("createLeadForm_generalToName")).sendKeys("P.Dhivya");
		driver.findElement(By.id("createLeadForm_generalAttnName")).sendKeys("DhivyaMK");
		
		driver.findElement(By.id("createLeadForm_generalAddress1")).sendKeys("Anna Nagar");
		driver.findElement(By.id("createLeadForm_generalAddress2")).sendKeys("New Colony");
		
		driver.findElement(By.id("createLeadForm_generalCity")).sendKeys("Chennai");
		
		WebElement dd7 = driver.findElement(By.id("createLeadForm_generalCountryGeoId"));
		Select drpCountry = new Select(dd7);
		drpCountry.selectByVisibleText("India");
		
		//WebElement dd6 = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		//Select drpState = new Select(dd6);
		//drpState.selectByValue("IN-TN");
		
		driver.findElement(By.id("createLeadForm_generalPostalCode")).sendKeys("600001");
		
		driver.findElement(By.id("createLeadForm_generalPostalCodeExt")).sendKeys("001");
		
		driver.findElement(By.name("submitButton")).click();
		
		String text = driver.findElement(By.id("viewLead_firstName_sp")).getText();
		System.out.println("Name :" + text);
		
		if(nameToEnter.equals(text)) 
			System.out.println("correct name");
											
		
		}
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	


