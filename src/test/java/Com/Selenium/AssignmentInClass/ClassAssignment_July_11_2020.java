package Com.Selenium.AssignmentInClass;
/*Goto following site https://jqueryui.com/
From this site click to dropable option
Then drag and drop the object
Then click to slider option 
Then ,, move slider in horizontal*/
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class ClassAssignment_July_11_2020 {
	WebDriver driver;
	
  @Test
  public void f() {
	  Actions obj = new Actions (driver);
		
		driver.switchTo().frame(0);
		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));

		obj.dragAndDrop(draggable, droppable).build().perform();
		driver.switchTo().parentFrame();
		driver.findElement(By.linkText("Slider")).click();
		driver.switchTo().frame(0);
		WebElement slider = driver.findElement(By.xpath("//span[@class='ui-slider-handle ui-corner-all ui-state-default']"));
		obj.dragAndDropBy(slider, 500, 0).build().perform();
		
	  
  }
  
  @Parameters ({"browser", "url"})
  @BeforeClass
  public void browser (String browser, String url) throws InterruptedException {

		if (browser.equalsIgnoreCase("Chrome")) {
			String userDirectoryPath = System.getProperty("user.dir");
			System.out.println(userDirectoryPath);

			System.setProperty("webdriver.chrome.driver", "/Volumes/George/Selenium Browser Drivers/chromedriver");
			driver = new ChromeDriver();
			driver.navigate().to(url);
			Thread.sleep(1000); // how to add 6 sec gap to go another website
//			driver.close();
//			driver.quit();
			//System.out.println("URL is : "+ driver.getTitle());

		} else if (browser.equalsIgnoreCase("Firefox")) {
			String userDirectoryPath = System.getProperty("user.dir");
			System.out.println(userDirectoryPath);

			System.setProperty("webdriver.gecko.driver", "/Volumes/George/Selenium Browser Drivers/geckodriver");
			driver = new FirefoxDriver();
			driver.navigate().to(url);
			Thread.sleep(1000); // how to add 6 sec gap to go another website
			driver.close();
			driver.quit();
		}else {
			System.out.println("Wrong browser name");

		}
	}

}
