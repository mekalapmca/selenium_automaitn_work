package com.Cucumber;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class RadioBtns_Count {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://www.echoecho.com/htmlforms10.htm");
		List<WebElement> radioBtns= driver.findElements(By.xpath("//*[@type='radio']"));
		int radioCount = radioBtns.size();
	    System.out.println("radio buttons in page: "+radioCount);
		driver.quit();

	}

}
