package com.Cucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleSteps {

	   public WebDriver driver = null;
	@Given("Open Google in Chrome Browser")
	public void open_google_in_chrome_browser() {
		WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.get("http://google.com");
	}

	@When("Enter any Data in SearchBox")
	public void enter_any_data_in_search_box() {
		driver.findElement(By.name("q")).sendKeys("Selenium");
	  
	}

	@Then("Close the Google browser")
	public void close_the_google_browser() {
	   driver.quit();
	}
	
	@When("Enter {string} keyword in SearchBox")
	public void enter_keyword_in_search_box(String Keyword) throws InterruptedException {
		driver.findElement(By.name("q")).sendKeys(Keyword);
		Thread.sleep(3000);
	}

}
