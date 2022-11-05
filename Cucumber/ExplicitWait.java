package com.Cucumber;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExplicitWait {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//default timeout entire script 
		//applicable for findElement & findElements 
		//whenever selenium not finds element in zero seconds , implicit would apply
		//and it will wait for given amount of time to load element
		//and then identify the element and perform the action
		
		//ExplicitWait
		//Specific scenario's like
		//wait until elementToBeClickable
		//wait until visibilityOf element
		//wait until visibilityOfAllElementsLocatedBy..............
		//
		//
          WebDriverWait wait = new WebDriverWait(driver, 60);
          wait.until(ExpectedConditions.elementToBeClickable(By.xpath("")));
          
          driver.findElement(By.xpath("")).click();
          
          wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(""))));
          
          wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("")));
          
			/*
			 * Wait<WebDriver> wait = new FluentWait<WebDriver>(driver) .withTimeout(30,
			 * TimeUnit.SECONDS) .pollingEvery(5, TimeUnit.SECONDS)
			 * .ignoring(NoSuchElementException.class); WebElement clickseleniumlink =
			 * wait.until(new Function<WebDriver, WebElement>(){
			 * 
			 * public WebElement apply(WebDriver driver ) { return
			 * driver.findElement(By.xpath(
			 * "/html/body/div[1]/section/div[2]/div/div[1]/div/div[1]/div/div/div/div[2]/div[2]/div/div/div/div/div[1]/div/div/a/i"
			 * )); } });
			 */
	}

}
