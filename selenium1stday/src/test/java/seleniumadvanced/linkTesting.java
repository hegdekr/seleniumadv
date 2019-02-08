package seleniumadvanced;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class linkTesting {
	
	@Test
	public void linkTest()
	{
	System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.hdfcbank.com/");
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	Actions aci = new Actions(driver);
    aci.moveToElement(driver.findElement(By.xpath("//a[@href='/personal/products']")));
	aci.moveToElement(driver.findElement(By.xpath("//a[@href='/personal/products/cards']")));
    aci.moveToElement(driver.findElement(By.xpath("//a[@href='/personal/products/cards/debit-cards']"))).click();
    aci.perform();
    String url = driver.getCurrentUrl();
    Assert.assertTrue(url.contains("debit-cards"));
    System.out.println("The test has been passed and the landing url is debit cards page");
	 
	
	}

}
