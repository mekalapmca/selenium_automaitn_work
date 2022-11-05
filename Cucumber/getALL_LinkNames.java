package com.Cucumber;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class getALL_LinkNames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://google.com");
		List<WebElement> links= driver.findElements(By.tagName("a"));
		
		int linksCount = links.size();
		System.out.println(linksCount);
		
		for(int i=0;i<linksCount;i++) {
			String linkName = links.get(i).getText();
			System.out.println(linkName);
		}
		
		driver.quit();

	}

}
