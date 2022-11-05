package com.Cucumber;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;

public class HRMSteps {
	public WebDriver driver = null;
	@Given("Open Chrome Browser and enter ORange HRM URL")
	public void open_chrome_browser_and_enter_o_range_hrm_url() {
	   WebDriverManager.chromedriver().setup();
	   driver =  new ChromeDriver();
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   driver.get("https://opensource-demo.orangehrmlive.com/");
	}
	@Then("Verify the login")
	public void verify_the_login() {
	  driver.findElement(By.name("txtUsername")).sendKeys("Admin");
	  driver.findElement(By.name("txtPassword")).sendKeys("admin123");
	  driver.findElement(By.name("Submit")).click();
	}
	@Then("Close the HRM Browser")
	public void close_the_hrm_browser() {
	 driver.quit();
	}

}
