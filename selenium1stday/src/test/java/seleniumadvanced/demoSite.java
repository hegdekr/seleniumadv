package seleniumadvanced;

import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class demoSite {
	WebDriver driver;
	
	
	@BeforeTest
	@Parameters("browser")
	public void beforeTest(String value,ITestContext result)
	{
		System.out.println(result.getCurrentXmlTest().getName()+"Test has started");
		if(value.equals("chrome"))
		{
			driver = new ChromeDriver();
			System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
		}
		else if(value.equals("ie"))
		{
			driver=new InternetExplorerDriver();
			System.setProperty("webdriver.ie.driver","C:\\IE\\IEDriverServer.exe");
		}
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
	}
	@AfterTest
	public void afterTest(ITestContext result)
	{
		System.out.println(result.getCurrentXmlTest().getName()+"Test is closed");
		driver.close();
	}
	
	
	
	
	
	@Test(dataProvider="dp1")
	public void demoSitelogin(String username,String password)
	{
		driver.findElement(By.linkText("Log in")).click();
		driver.findElement(By.id("Email")).sendKeys(username);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
		Assert.assertNotNull(driver.findElement(By.linkText("Log out")));
		driver.findElement(By.linkText("Log out")).click();
	}
	@DataProvider(name="dp1")
	public Object[][] getData() throws FileNotFoundException
	{
		return loginExcel.logiExcel();
	}

}
