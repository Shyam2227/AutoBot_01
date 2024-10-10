package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ProductDetailPageObject {
	WebDriver driver;
	
	@FindBy(xpath="(//a[@class='BreadCrumbLink_breadCrumb__R6DrR'])[2]")
	private WebElement pageHeader;
	
	@FindBy(xpath="//h1[@class='MedicineOverviewSection_medicineName__dHDQi']")
	private WebElement productHeader;
	
	@FindBy(xpath="(//button[@class='Button_container__okgob Button_default__KBB0P Button_small__zc2Dw'])[1]")
	private WebElement addCartBtn;
	
	public ProductDetailPageObject(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String isProductDetailPageLoaded() {
		String pageTitle =null;
		if(pageHeader.isDisplayed()) {
			pageTitle = pageHeader.getText();
		}else {
			Assert.fail("product details page doesnt load roperly");
		}
		return pageTitle;
				
	}
	
	public String getProductName() {
		String productName = null;
		if(productHeader.isDisplayed()) {
			productName=productHeader.getText();
		}else {
			Assert.fail("product is not displaying on product details page");
		}return productName;
	}
	
	public boolean verifyAddTOcardBtn() {
		boolean addTocartFlag = addCartBtn.isDisplayed();
		addCartBtn.click();
		return addTocartFlag;
	}
}
