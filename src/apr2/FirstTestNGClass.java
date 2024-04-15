package apr2;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class FirstTestNGClass {
  @Test
  public void login() {
	  Reporter.log("execute login test",true);
  }
  @Test
  public void compose() {
	  Reporter.log("execute compose test",true);
  }
  @Test
  public void reply() {
	  Reporter.log("execute reply test",true);
  }
  @BeforeMethod
  public void beforeMethod() {
	  Reporter.log("running before method",true);
  }

  @AfterMethod
  public void afterMethod() {
	  Reporter.log("running after method",true);
  }

  @BeforeTest
  public void beforeTest() {
	  Reporter.log("running before test",true);
  }

  @AfterTest
  public void afterTest() {
	  Reporter.log("running after test",true);
  }

  @BeforeSuite
  public void beforeSuite() {
	  Reporter.log("running before suite",true);
  }

  @AfterSuite
  public void afterSuite() {
	  Reporter.log("running after suite",true);
  }

}
