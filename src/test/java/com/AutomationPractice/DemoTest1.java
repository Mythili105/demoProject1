package com.AutomationPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoTest1 {
	public static WebDriver driver;
	
  @Test
  public void f() {
	  driver.get("https://www.amazon.in/");
		System.out.println("Title is" + driver.getTitle());
  }
  @BeforeMethod
  public void beforeMethod() {
	  WebDriver driver= new ChromeDriver();
	  driver.get("https://www.amazon.in/");
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterMethod() {
	  driver.close();
  }

}
