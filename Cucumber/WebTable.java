package com.Cucumber;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebTable {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/");
	    driver.findElement(By.id("txtUsername")).sendKeys("Admin");
	    driver.findElement(By.id("txtPassword")).sendKeys("admin123",Keys.ENTER);
	    Actions action = new Actions(driver);
	    
		WebElement adminElement =  driver.findElement(By.id("menu_admin_viewAdminModule"));
		action.moveToElement(adminElement).build().perform();
		
		WebElement userElement = driver.findElement(By.id("menu_admin_UserManagement"));
		action.moveToElement(userElement).build().perform();
		
		driver.findElement(By.id("menu_admin_viewSystemUsers")).click();
		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//*[@id='resultTable']//tr")));
		
	    List<WebElement> tableUserNames =	driver.findElements(By.xpath("//*[@id='resultTable']//tr"));
		int userNamesCount = tableUserNames.size();
		System.out.println(userNamesCount);
		
		String expUsername = "akcel123";
		
		//String actualxpath = "//*[@id='resultTable']//tr[1]//td[2]//a";
		String xpath1 = "//*[@id='resultTable']//tr[";
		String xpath2 = "]//td[2]//a";
		
		boolean editStatus = false;
		for(int i=1;i<userNamesCount;i++) {
			String xpath3 = xpath1+i+xpath2;
			System.out.println(xpath3);
			 String actualUserName = driver.findElement(By.xpath(xpath3)).getText();
			 System.out.println(i+" "+actualUserName);
			 if(actualUserName.equals(expUsername)) {
				 System.out.println("Matched with your expected username");
				 driver.findElement(By.xpath(xpath3)).click();
				 editStatus = true;
				 break;
			 }
		}
		
		if(editStatus==true) {
			//edit
			 //dropdown
			 //text
			 //text
			 //dropdown
			 //checkbox
			 //button
		}
		else
		{
			System.out.println("not matched wih expected data to edit");
		}
		
		
		
		
		
		//driver.quit();
	}

}
