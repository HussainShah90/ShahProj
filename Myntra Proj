package seleniumDailyPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class April15Myntra {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "./driversB/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.myntra.com/");
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElementByXPath("(//a[text()='Women'][1])")).perform();		
		Thread.sleep(1000);
		driver.findElementByXPath("(//a[text()='Jackets & Coats'])[1]").click();

		String coatsjacketstotal = driver.findElementByClassName("title-count").getText();
		String cjnt=coatsjacketstotal.replaceAll("\\D", "");
		int totalcount = Integer.parseInt(cjnt);
		System.out.println("Total Item Count - " +totalcount);
		
		String jackets = driver.findElementByClassName("categories-num").getText();
		String jacketcnt=jackets.replaceAll("\\D", "");
		int jcnt = Integer.parseInt(jacketcnt);
		System.out.println("Jackets - "+jcnt);

		String coats = driver.findElementByXPath("(//span[@class='categories-num'])[2]").getText();
		String coatcnt = coats.replaceAll("\\D", "");
		int ctnt = Integer.parseInt(coatcnt);
		System.out.println("Coats - "+ctnt);

		int categorycount = jcnt+ctnt;

		if(categorycount==totalcount) 
		{

			System.out.println("Total Count is equal To Catergory Count. "+"\n"+"Coats and Jacket Count : "+categorycount+"\n"+"Total CategoryCount : "+totalcount);
		}
		else		
			System.out.println("Count Not Matched"+"\n"+"Category count - "+categorycount+"Total count - "+totalcount);	

		driver.findElementByXPath("(//div[@class='common-checkboxIndicator'])[2]").click();

		driver.findElementByXPath("//div[@class='brand-more']").click();

		driver.findElementByXPath("//input[@class='FilterDirectory-searchInput']").sendKeys("MANGO");

		driver.findElementByXPath("(//div[@class='common-checkboxIndicator'])[11]").click();

		driver.findElementByXPath("//span[@class='myntraweb-sprite FilterDirectory-close sprites-remove']").click();

		Thread.sleep(2000);

		String bname = driver.findElementByXPath("//span[@class='title-count']").getText();
		System.out.println(bname);

		List<WebElement> countofmangobrand = driver.findElementsByXPath("//h3[@class='product-brand']");

		for (WebElement eachBrand : countofmangobrand) {
			String brand=eachBrand.getText();
			System.out.println("Brand Name"+brand);
		}

		action.moveToElement(driver.findElementByXPath("//span[@class='myntraweb-sprite sort-downArrow sprites-downArrow']")).perform();
		driver.findElementByXPath("//label[text()='Better Discount']").click();

		Thread.sleep(2000);

		String bestdiscount = driver.findElementByXPath("(//span[@class='product-discountedPrice'])[1]").getText();
		System.out.println("The price of first displayed item "+bestdiscount);

		action.moveToElement(driver.findElementByXPath("(//span[@class='product-discountedPrice'])[1]")).perform();

		driver.findElementByXPath("//span[@class='product-actionsButton product-wishlist product-prelaunchBtn']").click();

		driver.close();
		 

	}

}
