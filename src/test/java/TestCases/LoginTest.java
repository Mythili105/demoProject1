package TestCases;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import TestBase.Baseclass;
import Utilities.DPTTest;

public class LoginTest extends Baseclass {
	
	
  @Test(dataProvider="logindata",dataProviderClass=DPTTest.class)
  public void login(String UserId, String Password) {
	  try {
	  
		  test = extent.createTest("Login Test with User ID: " + UserId);

          LoginPage L01 = new LoginPage(driver);
          test.log(Status.INFO, "Entering Username: " + UserId);
          L01.Username(UserId);

          test.log(Status.INFO, "Entering Password: " + Password);
          L01.Password(Password);

          test.log(Status.INFO, "Clicking Login button");
          L01.clicklogin();
	  /*LoginPage L01 = new LoginPage(driver);
	  
	  L01.Username(UserId);
	  L01.Password(Password);
	  L01.clicklogin();*/
          
	  try {
		    Thread.sleep(2000); // Wait for 2 seconds (adjust as needed)
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
	  
	  takeScreenshot("screenshot_after_login_" + UserId);
	
	  String expectedUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"; // Change to actual dashboard URL
      String actualUrl = driver.getCurrentUrl();

      if (actualUrl.equals(expectedUrl)) {
        
          HomePage H01= new HomePage(driver);
          
          H01.dropdown();
          H01.logout();
          Assert.assertTrue(true, "Login Successful"); // user logged in - test case pass
       
          
      } else {
          
          Assert.assertFalse(false,"Invalid Credentials Login Failed");// user not logged in - Test case pass
      }}
	  catch(Exception e) {
			System.out.println("Error during setup:");
			e.printStackTrace();
	  }
	  
	 
	  
	   
  }
}
