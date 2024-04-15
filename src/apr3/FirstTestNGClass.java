package apr3;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class FirstTestNGClass {
	WebDriver driver;
	@BeforeTest
	public void Setup()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://primusbank.qedgetech.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Reporter.log("Running in beforetest",true);
		}
	@Test
	public void pbanking()
	{
		driver.findElement(By.xpath("//a[@href='personal_banking.html']//img")).click();
		Reporter.log("Executing pbanking Test",true);
	}
	@Test
	public void cbanking()
	{
		driver.findElement(By.xpath("//a[@href='Corporate Banking.html']//img")).click();
		Reporter.log("Executing cbanking Test",true);
	}
	@Test
	public void ibanking()
	{
		driver.findElement(By.xpath("//a[@href='International Banking.html']//img")).click();
		Reporter.log("Executing ibanking Test",true);
	}
	@AfterTest
	public void tearDown()
	{
	driver.quit();
	Reporter.log("Running in aftertest",true);
	}
}

 

