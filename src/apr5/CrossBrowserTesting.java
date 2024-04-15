package apr5;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTesting {
	WebDriver driver;
	@Parameters({"Browser"})
	@BeforeTest
	public void setup(String brw)
	{
	switch (brw.toUpperCase()) {
	case "chrome":
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		break;
	case "firefox":
		driver=new FirefoxDriver();
		break;
		default:
			Reporter.log("Browser value is NOT matching",true);
		break;
	}	
		}
	@DataProvider
	public Object supplyData()
	{
		Object login[][]= {{"Admin","Qedge123!@#"},{"Test","Qedge123!@#"},{"Admin","Qedge123!@#"},{"Admin","Qedge123!@#"},
				{"Admin","Qedge123!@#"}};
	return login;
	}
	@Test(dataProvider = "supplyData")
	public void verify_login(String user,String pass)
	{
		driver.get("http://orangehrm.qedgetech.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("txtUsername")).sendKeys(user);
		driver.findElement(By.name("txtPassword")).sendKeys(pass);
		driver.findElement(By.name("Submit")).click();
		String Expected="dashboard";
		String Actual=driver.getCurrentUrl();
		if(Actual.contains(Expected))
		{
			Reporter.log("login Succes::"+Expected+"            "+Actual,true);
		}
		else
		{
			Reporter.log("login Fail::"+Expected+"                "+Actual,true);
		}
		}
		@AfterTest
		public void tearDown()
		{
			driver.quit();
		}








		




		
		
		
		

}
