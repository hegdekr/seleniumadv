package seleniumadvanced;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ajaxTest {
	
	@Test
	public void ajaxTest()
	{
		System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demos.telerik.com/aspnet-ajax/treeview/examples/overview/defaultcs.aspx");
		driver.manage().window().maximize();
		Actions act = new Actions(driver);
		WebElement from = driver.findElement(By.xpath("//div[@id='ctl00_ContentPlaceholder1_RadTreeView1']/ul/li/ul/li[3]/ul/li[1]/div/div/span"));
		WebElement to = driver.findElement(By.id("ctl00_ContentPlaceholder1_Label1"));
		act.clickAndHold(from).release(to).perform();
		WebDriverWait wait = new WebDriverWait(driver,100);
		wait.until(ExpectedConditions.invisibilityOfElementWithText(By.id("ctl00_ContentPlaceholder1_Label1"), "Drop a package here to check price"));
		String result = driver.findElement(By.id("ctl00_ContentPlaceholder1_Label1")).getText();
		System.out.println("The actual result is "+result);
		Assert.assertTrue(result.contains("$3999"));
		/*if(result.contains("5999"))
		{
			Assert.assertTrue("Passed",true);
		}*/
		
		
	}

}
