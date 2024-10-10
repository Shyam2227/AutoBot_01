package utils;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class CommonUtility {
	WebDriver driver =null;
	
	public WebDriver initSetup(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\eclipse-workspace\\eCommerce.project\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();}
		else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver","C:\\Users\\admin\\eclipse-workspace\\eCommerce.project\\Drivers\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		return driver;
	}

	public void launchURL(String url) {
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	public static void takeSS(WebDriver driver)throws IOException {
		Date d = new Date();
		String da = d.toString().replaceAll(":", " ");
		System.out.println(da);
		
		TakesScreenshot tss = (TakesScreenshot)driver;
		File target = tss.getScreenshotAs(OutputType.FILE);
		File destionation = new File("C:\\Users\\admin\\eclipse-workspace\\eCommerce.project\\src\\test\\resources\\Output Screenshot"+ da +".jpg");
		FileHandler.copy(target, destionation);
		
	}
	
}

