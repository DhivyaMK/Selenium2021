package week4.day2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnMyntra {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		ChromeDriver driver = new ChromeDriver(options);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		// 1.Open https://www.myntra.com/

		driver.get("https://www.myntra.com/");

		// Instantiate ACtion class

		Actions builder = new Actions(driver);

		WebElement webMen = driver.findElement(By.xpath("//a[text()='Men']"));

		// 2.Mouse hover on MEN

		builder.moveToElement(webMen).perform();

		// 3.Click Jackets

		driver.findElementByLinkText("Jackets").click();

		// 4.Find the total count of item

		String jacketCount = driver.findElementByXPath("//span[@class='title-count']").getText();

		System.out.println("Total items in Jackets:" + jacketCount);

		// Getting Subcategories Values

		String JacketCat1 = driver.findElementByXPath("//span[@class='categories-num']").getText();
		String JacketCat2 = driver.findElementByXPath("(//span[@class='categories-num'])[2]").getText();

		System.out.println("JacketCat1:" + JacketCat1);
		System.out.println("JacketCat2:" + JacketCat2);

		// Replacing Special char in String
		// [//D] Replace all non integers, prints only numbers

		String replaceAll = JacketCat1.replaceAll("[\\D]", "");
		String replaceAll1 = JacketCat2.replaceAll("[\\D]", "");
		String jacketCount1 = jacketCount.replaceAll("[\\D]", "");

		// Converting String to Integer

		int subCat1 = Integer.parseInt(replaceAll);
		int subCat2 = Integer.parseInt(replaceAll1);
		int totalJacketCount = Integer.parseInt(jacketCount1);

		System.out.println("subCat1:" + subCat1);
		System.out.println("subCat2:" + subCat2);
		System.out.println("totalJacketCount:" + totalJacketCount);

		int subTotal = subCat1 + subCat2;
		System.out.println("subTotal:" + subTotal);

		// 5.Validate the sum of categories count matches

		if (totalJacketCount == subTotal) {
			System.out.println("sum of categories count matches");
		} else {
			System.out.println("sum of categories count not matches");
		}

		// 6.Check jackets

		// driver.findElementByXPath("//input[@text='Jackets']").click();

		driver.findElementByClassName("common-checkboxIndicator").click();

		// 7.Click + More option under BRAND
		// div[@class='brand-more']
		// span[text()='Brand']/following-sibling::div[2]

		WebElement scrollEle = driver.findElement(By.xpath("//div[@class='brand-more']"));

		// js.executeScript("arguments[0].scrollIntoView();", scrollEle);
		// js.executeScript("arguments[0].scrollIntoView();", scrollEle);
		// driver.findElement(By.xpath("//div[@class='brand-more']")).click();

		js.executeScript("arguments[0].click()", scrollEle);

		// 8.Type Duke and click checkbox

		driver.findElementByClassName("FilterDirectory-searchInput").sendKeys("Duke", Keys.TAB);

		// Click CheckBox DUKE

		WebElement scrollEle1 = driver.findElement(By.xpath("//input[@value='Duke']"));

		js.executeScript("arguments[0].click()", scrollEle1);

		Thread.sleep(2000);

		// 9) Close the pop-up x

		driver.findElement(By.xpath("//ul[@class='FilterDirectory-indices']/following-sibling::span")).click();

		// 10) Confirm all the Coats are of brand Duke

		// Full details xpath - //div[@class='product-productMetaInfo']

		// only Duke Xpath - //h3[@class='product-brand']

		System.out.println("List of Duke Jackets");
		List<WebElement> jacketList = driver.findElements(By.xpath("//div[@class='product-productMetaInfo']"));
		System.out.println("Size:" + jacketList.size());

		for (WebElement eachString : jacketList) {
			String text = eachString.getText();
			System.out.println(text);
		}
		// String str1 = "Duke";
		// if (str1.equals(text)) {
		// System.out.println("All Jackets are DUKE Brand");
		// } else {
		// System.out.println("All Jackets are not DUKE Brand");
		// }

		// 11.Sort by Better Discount

		WebElement Discount = driver.findElement(By.xpath("//div[@class='sort-sortBy']"));

		builder.moveToElement(Discount).perform();

		WebElement scrollEle2 = driver.findElementByXPath("//input[@value='discount']");

		js.executeScript("arguments[0].click()", scrollEle2);

		Thread.sleep(2000);

		// 12) Find the price of first displayed item

		String ProductPrice = driver.findElement(By.xpath("//span[@class='product-discountedPrice']")).getText();
		System.out.println("price of first displayed item:" + ProductPrice);

		driver.findElement(By.xpath("//span[@class='product-discountedPrice']")).click();

		// 13)Take a screen shot

		Set<String> windowHandlesSet = driver.getWindowHandles();

		System.out.println(windowHandlesSet.size());

		for (String eachstring : windowHandlesSet) {
			System.out.println(eachstring);
		}

		List<String> winList = new ArrayList<String>(windowHandlesSet);

		driver.switchTo().window(winList.get(1));

		System.out.println(driver.getTitle());

		File src1 = driver.getScreenshotAs(OutputType.FILE); // the page that has to be taken screen shot
		File dst = new File("./snaps/seat.png");
		FileUtils.copyFile(src1, dst);

		// 14) Click on WishList Now

		driver.findElementByXPath(
				"//span[@class='myntraweb-sprite pdp-notWishlistedIcon sprites-notWishlisted pdp-flex pdp-center ']")
				.click();

		// 15) Close Browser

		driver.quit();
	}

}
