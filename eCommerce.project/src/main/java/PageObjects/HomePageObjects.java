package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageObjects {
	WebDriver driver;

	@FindBy(xpath="//img[@alt='pharmeasy-logo']")
	private WebElement logo;

	@FindBy(xpath="(//div[@class=\"c-PJLV c-bXbWpx c-bXbWpx-lfylVv-direction-row c-bXbWpx-fMErMJ-justify-left c-bXbWpx-joJbDg-align-center c-bXbWpx-ielOayq-css\"])[2]")
	private WebElement searchBar;

	@FindBy(xpath="//input[@id='topBarInput']")
	private WebElement insertSearchBar;

	public HomePageObjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public boolean isLogoPresent() {
		boolean logoFlag = logo.isDisplayed();
		return logoFlag;
	}
	
	public boolean isSearchBarPresent() {
		boolean searchBarFlag = searchBar.isDisplayed();
		return searchBarFlag;
	}

	public void setSearchField() {
		searchBar.click();
	}

	public void insertSearchBarField(String input) {
		insertSearchBar.sendKeys(input);
	}
	
}


