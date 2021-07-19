package week2.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class AcmeSystem {

	public static void main(String[] args) {
			WebDriverManager.chromedriver().setup();
			System.getProperty("webdriver.chrome.driver", "path");
			ChromeDriver driver = new ChromeDriver();
			driver.get("https://acme-test.uipath.com/login");
			WebElement WebUserName = driver.findElement(By.id("email"));
			WebUserName.sendKeys("kumar.testleaf@gmail.com");
			driver.findElement(By.id("password")).sendKeys("leaf@12");
			//driver.findElement(By.className("btn btn-primary")).click();
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			String orgTitle = "ACME System 1 -  Dashboard";
			String title = driver.getTitle();
			System.out.println("Title is : " + title);
			if(orgTitle.equals(title))
				System.out.println("Page landed up correctly");
			else
				System.out.println("Page not landed up correctly");
			//driver.findElement(By.className("navbar-toggle")).click();
			driver.findElement(By.linkText("Log Out")).click();
		    driver.close();
	}
}
