package week4.assignments;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

//Assignment 4: Alerts and WindowHandling

public class AlertsWindowHandling {

	public static void main(String[] args) throws IOException {

		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);

		driver.get("https://www.irctc.co.in/");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//button[@type='submit']")).click();
		driver.findElement(By.xpath("//li[@id='flight']")).click();

		// Title of Main window "IRCTC Next Generation eTicketing System"
		System.out.println(driver.getTitle());

		// How do I get into the new window
		// Step1 : Get all the window handles in a set

		Set<String> windowHandlesSet = driver.getWindowHandles();

		System.out.println(windowHandlesSet.size());

		for (String eachString : windowHandlesSet) {
			System.out.println(eachString);
		}

		// Window handles - 2
		// CDwindow-0A5E9C3122E2FB04E1E1390D26E859DE
		// CDwindow-3BEE86794E2B7801C6D9B86382F526F8

		// Step 2: Move the Set of window handles into a list so that each of the window
		// handle
		// can be accessed using the index value which is not possible with the set

		List<String> winList = new ArrayList<String>(windowHandlesSet);

		// window handle of the second window
		// winList.get(1);

		// Step 3:
		// Switch the control to the specific window by selecting the required window
		// handle
		driver.switchTo().window(winList.get(1));
		System.out.println(driver.getTitle());
		// New window - Air Ticket Booking | Book Flight Tickets | Cheap Air Fare -
		// IRCTC Air

		// Print the customer care email id
		System.out.println(driver.findElementByLinkText("flights@irctc.co.in").getAttribute("href"));

		// Take the screenshot of the current page
		File src1 = driver.getScreenshotAs(OutputType.FILE); // the page that has to be taken screen shot
		File dst = new File("./snaps/seat.png");
		FileUtils.copyFile(src1, dst);

		// Switch control from new window to main window
		driver.switchTo().window(winList.get(0));

		// close current active window
		driver.close();
	}

}
