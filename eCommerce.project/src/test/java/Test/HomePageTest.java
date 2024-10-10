package Test;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import PageObjects.HomePageObjects;
import PageObjects.ProductDetailPageObject;
import PageObjects.SearchProductsPageObject;
import utils.CommonUtility;

public class HomePageTest {
	WebDriver driver;
	HomePageObjects hpo;
	SearchProductsPageObject sppo;
	ProductDetailPageObject pdpo;
	CommonUtility cu = new CommonUtility();
	
	@BeforeSuite
	@Parameters({"browser","url"})
	void initSetup(String browser,String url) {
		driver = cu.initSetup(browser);
		cu.launchURL(url);
	}
	

	@BeforeClass
	void initObj() {
		hpo = new HomePageObjects(driver);
		sppo = new SearchProductsPageObject(driver);
		pdpo = new ProductDetailPageObject(driver);
	}
	
	@Test(priority=0)
	void urlTest() throws IOException {
		String actualUrl = driver.getCurrentUrl();
		CommonUtility.takeSS(driver);
		Assert.assertEquals(actualUrl, "https://pharmeasy.in/","url test successfully");
	}
	
	@Test(priority=1)
	void logoTest() {
		boolean searchBarFlag = hpo.isLogoPresent();
		Assert.assertTrue(searchBarFlag, "search bar is displayed on homepage");
		hpo.setSearchField();
		hpo.insertSearchBarField("paracetamol"+Keys.ENTER);
	}
	
	@Test(priority=2)
	void pageHeader() {
		sppo.validatePageHeader("Showing all results for paracetamol");
		sppo.clickFirstProduct();
		String actualHeader = pdpo.isProductDetailPageLoaded();
		Assert.assertEquals(actualHeader, "Teplota 100mg Bottle Of 15ml Syrup");
		String actualProductName = pdpo.getProductName();
		Assert.assertEquals(actualProductName,"Teplota 100mg Bottle Of 15ml Syrup");
		boolean actualAddToCardFlag =pdpo.verifyAddTOcardBtn();
	//	Assert.assertEquals(actualAddToCardFlag, "add to cart");
	}
}