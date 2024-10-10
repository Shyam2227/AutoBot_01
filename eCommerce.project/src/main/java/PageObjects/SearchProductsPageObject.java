package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class SearchProductsPageObject {
	WebDriver driver;
	Actions act;
	
	@FindBy(xpath="//div[text()='Showing all results for']")
	private WebElement pageHeader;
	
	@FindBy(xpath="(//a[@class='ProductCard_medicineUnitWrapper__eoLpy ProductCard_defaultWrapper__nxV0R'])[1]")
	private WebElement firstproduct;
	
	public SearchProductsPageObject(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void validatePageHeader(String expectedHeader) {
		String actualHeader = pageHeader.getText();
		System.out.println(actualHeader);
		Assert.assertEquals(actualHeader, expectedHeader ,"result show scucessful");
	}

	public void clickFirstProduct() {
		if(firstproduct.isDisplayed());{
			act = new Actions(driver);
			act.moveToElement(firstproduct).click().build().perform();
		}

	}
}
