package hcm.seldriver;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import hcm.common.ExtendedFirefoxDriver;

public class SeleniumDriver {

	private static final long ELEMENT_APPEAR = 60L;
	private WebDriverWait wait = null;
	public static WebDriver driver;
	private static WebDriver augmentedDriver;
	private static Actions performer;
	
	public void initializeDriver(String hubURL, String browser) throws Exception{
		try {
			driver = new ExtendedFirefoxDriver(getCapability(browser));
			performer = new Actions(driver);
			driver.manage().window().setSize(new Dimension(1020, 737));
			System.out.println("Browser size: "	+ driver.manage().window().getSize());
			augmentedDriver = new Augmenter().augment(driver);
			wait = new WebDriverWait(driver, ELEMENT_APPEAR);
			
		} catch (Exception e) {
			//e.printStackTrace();
			dispose();
			throw e;
		}
	}

	protected DesiredCapabilities getCapability(String browser) {
		try {
			if (browser.contentEquals("firefox"))
				return DesiredCapabilities.firefox();
			else
				return DesiredCapabilities.firefox();

		} catch (Exception e) {

		}
		return null;
	}

	public void testArea() throws InterruptedException
	{
		driver.get("localhost:8080");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='j_username']")));
		driver.findElement(By.xpath("//input[@id='j_username']")).clear();
		driver.findElement(By.xpath("//input[@id='j_username']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='j_password']")).clear();
		driver.findElement(By.xpath("//input[@name='j_password']")).sendKeys("7eaabf2704de4f35ac8a1572cf72db27");
		driver.findElement(By.xpath("//button[text()='log in']")).click();
		System.out.println("Checking Dashboard...");
	}
	
	public void dispose() {
		driver.close();
		driver.quit();
	}

}
