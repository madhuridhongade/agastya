package agastya;

//The method does not use longer is then write @Deprecated. do not delete that method. 
//it might be use anywhere in another class then that method having minus sign on that method

import static com.agastya.constants.Browser.CHROME;
import static com.agastya.constants.Browser.FIREFOX;

import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.agastya.base.Keyword;
import com.agastya.base.TestBase;
//import com.agastya.locators.Locator;
import com.agastya.locators.On;
import com.agastya.utilites.FileUtil;

public class MyntraTest extends TestBase {
	
	//Test cases without using framework
	@Test
	public void verifySearchResultForSneakers() {
		
		getDriver().get("https:/www.myntra.com/");
		getDriver().findElement(By.xpath("//input[@placeholder=\"Search for products, brands and more\"]")).sendKeys("Men Sneakers");
		getDriver().findElement(By.xpath("//a[@class=\"desktop-submit\"]")).click();
		List<WebElement> productList = getDriver().findElements(By.xpath("//div[@class=\"product-productMetaInfo\"]/h4[@class=\"product-product\"]"));
		
		if(productList.isEmpty())
		{
			System.out.println("No matching products found");
		}
		
		
		Iterator<WebElement>itr = productList.iterator();
		while(itr.hasNext())
		{ 
			String productTitle = itr.next().getText();
			System.out.println("Checking : "+productTitle);
			Assert.assertTrue(productTitle.contains("Sneakers"));
		}
	}
	
	
	//Test cases using framework
	@Test
	private void verifySearchResultsForSneakersUsingFramework() {
		Keyword keyword = new Keyword();
		keyword.launchUrl("https:/www.myntra.com/");
		keyword.enterText("xpath", "//input[@placeholder=\"Search for products, brands and more\"]", "Men Sneakers");
		keyword.click("xpath", "//a[@class=\"desktop-submit\"]");
		List<String> productList = keyword.getTexts("xpath", "//div[@class=\"product-productMetaInfo\"]/h4[@class=\"product-product\"]");
	
		Iterator<String>itr = productList.iterator();
		while(itr.hasNext())
		{ 
			String productTitle = itr.next();
			System.out.println("Checking : "+productTitle);
			Assert.assertTrue(productTitle.contains("Sneakers"));
		}
	}
	
	
	//Test cases using framework with locator On
	//MAGNIFIER means to click
		@Test
		public void verifySearchResultsForSneakersUsingFrameworkWithLocator() {
			Keyword keyword = new Keyword();
			keyword.launchUrl("https:/www.myntra.com/");
			keyword.enterText(On.SEARCHCOMPONENT, "Men Sneakers");
			System.out.println("Entering text :");
			keyword.click(On.MAGNIFIER);
			List<String> productList = keyword.getTexts(On.PRODUCTTITLES);
		
			Iterator<String>itr = productList.iterator();
			while(itr.hasNext())
			{ 
				String productTitle = itr.next();
				System.out.println("Checking : "+productTitle);
				Assert.assertTrue(productTitle.contains("Sneakers"));
			}
		}
	
		//Test cases using framework with locator properties file
		//MAGNIFIER means to click
			@Test
			public void verifySearchResultsForSneakersUsingFrameworkWithLocatorPropertiesFile() throws FileNotFoundException {
				Keyword keyword = new Keyword();
				
				FileUtil file = new FileUtil();
				keyword.launchUrl("https:/www.myntra.com/");
				keyword.enterText(file.getLocator("Homepage.SEARCHCOMPONENT"), "Men Sneakers");
				keyword.click(file.getLocator("Homepage.MAGNIFIER"));
				List<String> productList = keyword.getTexts(file.getLocator("Homepage.PRODUCTTITLES"));
			
				Iterator<String>itr = productList.iterator();
				while(itr.hasNext())
				{ 
					String productTitle = itr.next();
					System.out.println("Checking : "+productTitle);
					Assert.assertTrue(productTitle.contains("Sneakers"));
				}
			}
}

