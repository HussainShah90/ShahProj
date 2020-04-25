package seleniumDailyPractice;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class April15Nykaa {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "./driversB/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//	    1) Go to https://www.nykaa.com/
		driver.get("https://www.nykaa.com/");

		//		2) Mouseover on Brands and Mouseover on Popular
		Actions action = new Actions(driver);
		WebElement brands = driver.findElementByXPath("//a[text()='brands']");
		action.moveToElement(brands).perform();

		WebElement popular = driver.findElementByXPath("//a[text()='Popular']");
		action.moveToElement(popular).perform();

		//		3) Click L'Oreal Paris
		driver.findElementByXPath("//img[@src='https://adn-static2.nykaa.com/media/wysiwyg/2019/lorealparis.png']").click();
		System.out.println("L'Oreal Paris Brand Clicked");		
		//		4) Go to the newly opened window and check the title contains L'Oreal Paris
		Set<String> WindowHandlesSet = driver.getWindowHandles();
		List<String> WindowHandlesList = new ArrayList<String>(WindowHandlesSet);
		driver.switchTo().window(WindowHandlesList.get(1));
		System.out.println("Switched to New Window");
		String WindowTitle = driver.getTitle();
		System.out.println(WindowTitle);

		if(WindowTitle.contains("L'Oreal"))
		{
			System.out.println("Title Contains L'Oreal");
		}
		else
		{
			System.out.println("Title does not Contain L'Oreal");
		}


		//		5) Click sort By and select customer top rated
		driver.findElementByXPath("//span[text()='Sort By : ']").click();
		driver.findElementByXPath("//span[text()='customer top rated']").click();

		//		6) Click Category and click Shampoo
		driver.findElementByXPath("//div[text()='Category']").click();
		driver.findElementByXPath("(//label[@for='chk_Shampoo_undefined']//span)[1]").click();

		//		7) check whether the Filter is applied with Shampoo
		String AppliedFilter = driver.findElementByXPath("//li[text()='Shampoo']").getText();

		if(AppliedFilter.equals("Shampoo"))
		{
			System.out.println("Shampoo Filter is Selected");
		}
		else
		{
			System.out.println("Wrong Filter Selected");
		}

		//		8) Click on L'Oreal Paris Colour Protect Shampoo
		driver.findElementByXPath("(//div[@class='m-content__product-list__title']//span)[4]").click();
		System.out.println("L'Oreal Paris Colour Protect Shampoo Clicked");

		//		9) GO to the new window and select size as 175ml
		Set<String> WindowHandlesSet2 = driver.getWindowHandles();
		List<String> WindowHandlesList2 = new ArrayList<String>(WindowHandlesSet2);
		driver.switchTo().window(WindowHandlesList2.get(2));
		System.out.println("Switched to 3rd Window");
		driver.findElementByXPath("//span[text()='175ml']").click();
		System.out.println("175ml Shampoo Product Selected");

		//		10) Print the MRP of the product
		String  MRP = driver.findElementByXPath("(//span[@class='post-card__content-price-offer'])[1]").getText();
		System.out.println("MRP is "+MRP);

		//		11) Click on ADD to BAG
		driver.findElementByXPath("(//button[text()='ADD TO BAG'])[1]").click();
		System.out.println("Added To Bag");

		//		12) Go to Shopping Bag
		driver.findElementByClassName("AddBagIcon").click();

		//		13) Print the Grand Total amount
		String GrandAmt = driver.findElementByXPath("//div[@class='value medium-strong']").getText();
		System.out.println("Grand Total Amount - "+GrandAmt);

		//		14) Click Proceed
		driver.findElementByXPath("//span[text()='Proceed']").click();

		//		15) Click on Continue as Guest
		//		cannot continue as guest as grand amount must be above 500

		//		16) Print the warning message (delay in shipment)
		System.out.println("Warning Message : "+driver.findElementByClassName("popup-error").getText());

		//		17) Close all windows
		driver.quit();

	}

}
