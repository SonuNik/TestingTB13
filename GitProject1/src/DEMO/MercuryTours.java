package DEMO;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MercuryTours
{
public WebDriver driver;
	
	@BeforeSuite
	public void openBrowser()
	{
		System.out.println("this our beforesuite annotation");
		System.setProperty("webdriver.chrome.driver", "G:\\java cjc\\automation testing\\chrome96exe\\chromedriver.exe");
		 driver=new ChromeDriver();
	
	}
	@BeforeTest
	public void enterURL()
	{
		System.out.println("this our beforetest annotattion");
		driver.get("http://demo.guru99.com/test/newtours/index.php");
	}
	@BeforeClass
	public void maximizeBrowser()
	{
		System.out.println("this is our before class annoation");
		driver.manage().window().maximize();
	}
	@BeforeMethod
	public void getCookies()
	{
		System.out.println("this is our beforemethod annotation");
		Set<Cookie> cookies=driver.manage().getCookies();
		for(Cookie cookie:cookies)
		{
			System.out.println(cookie.getName());
		}
	}
	@Test(dataProvider ="getData")
	public void logincheck(String fi,String ln,String ph,String e,String a1,String ci,String st,String zi,String c,String ps) throws InterruptedException
	{
		System.out.println("this is our test annotation");
		driver.findElement(By.linkText("REGISTER")).click();
		//tagname attribute value
		driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys(fi);
		
		//tagname attribute value
		driver.findElement(By.cssSelector("input[name='lastName']")).sendKeys(ln);
		
		//tagname attribute value
		driver.findElement(By.cssSelector("input[name='phone']")).sendKeys(ph);
		
		//tagname id
		driver.findElement(By.cssSelector("input#userName")).sendKeys(e);
		
		//tagname attribute value
		driver.findElement(By.cssSelector("input[name='address1']")).sendKeys(a1);
		
		//tagname attribute value
		driver.findElement(By.cssSelector("input[name='city']")).sendKeys(ci);
		
		//tagname attribute value
		driver.findElement(By.cssSelector("input[name='state']")).sendKeys(st);
		
		//tagname attribute value
		driver.findElement(By.cssSelector("input[name='postalCode']")).sendKeys(zi);
		
		WebElement sel=driver.findElement(By.cssSelector("select[name='country']"));
		Select s1=new Select(sel);
		s1.selectByValue(c);
		
		//tagname idvalue
		driver.findElement(By.cssSelector("input#email")).sendKeys(fi);
				
		//tagname attribute value
		driver.findElement(By.cssSelector("input[name='password']")).sendKeys(ps);
				
		//tagname attribute value
		driver.findElement(By.cssSelector("input[name='confirmPassword']")).sendKeys(ps);
		
		//tagname attribute value
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("input[name='submit']")).click();
	}
	@DataProvider
	public  Object[][] getData()
	{
		return new Object[][]
				{
			new Object[] {"chru","gut","787676565","charu1234gmail.com","karvenagar","pune","maharashtra","44254354","INDIA","54536"},
			new Object[] {"yadnya","pimpl","7836476556","yadnya1234gmail.com","karvenagar","pune","maharashtra","44254354","INDIA","76543"},
			
				};
				
	}
	@AfterMethod
	public void captureScreen() throws IOException 
	{
		System.out.println("this is aftermethod annotation");
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFileToDirectory(src, new File("G:\\java cjc\\automation testing\\scrennshot"));
		System.out.println("sucessfully capture scrennshot");
	}
	@AfterClass
	public void deleteCookies()
	{
		System.out.println("this is our deleteCookies annotation");
		driver.manage().deleteAllCookies();
	}
	@AfterTest
	public void dbClose()
	{
		System.out.println("this is aftertest annotation");
	}
	@AfterSuite
	public void closeBrowser() throws Exception
	{
		System.out.println("this is our aftersuite annotation");
		Thread.sleep(4000);
		driver.close();
	}
	
	
}
