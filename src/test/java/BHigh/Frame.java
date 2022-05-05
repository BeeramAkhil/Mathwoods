package BHigh;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;

public class Frame {
  
	public WebDriver driver;
	
	public Actions action;
	
	
	
	
	
	@Test
  public void havingfun() {

		  // iframe concept
		  driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));
		  
		 
		 
		// Element which needs to drag.
		WebElement DragFrom = driver.findElement(By.id("draggable"));

		// Element on which need to drop.
		WebElement DropTo = driver.findElement(By.id("droppable"));

		// Using Action class for drag and drop.
		action = new Actions(driver);

		// Dragged and dropped.
		action.dragAndDrop(DragFrom, DropTo).build().perform();
		
		//Back to Out of the frame
		driver.switchTo().parentFrame();
	
	
	
	}
  @BeforeTest
  public void beforeTest() {
	  
	  System.setProperty("webdriver.chrome.driver","D:\\Beeram workspace\\chromedriver.exe");
	  driver = new ChromeDriver();
		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
