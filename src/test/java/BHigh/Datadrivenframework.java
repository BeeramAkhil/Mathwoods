package BHigh;

import org.testng.annotations.Test;

import jxl.Sheet;
import jxl.Workbook;

import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Datadrivenframework {
  
	public WebDriver driver;
	
	
	
	@Test
  public void havingfun() throws Exception {
  
		
		FileInputStream fi = new FileInputStream("C:\\Users\\user\\Documents\\singar2.xls");
		Workbook wb = Workbook.getWorkbook(fi);
		Sheet s = wb.getSheet("Sheet1");
	
		driver.findElement(By.id("login_field")).sendKeys(s.getCell(0,1).getContents());
		Thread.sleep(3000);
		
		
		
		driver.findElement(By.id("password")).sendKeys(s.getCell(1,1).getContents());
		Thread.sleep(3000);
	
		
		driver.findElement(By.xpath("//*[@id=\"login\"]/div[4]/form/div/input[12]")).click();
	}
	@BeforeTest
  public void beforeTest() {
  
		System.setProperty("webdriver.chrome.driver","D:\\Beeram workspace\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://github.com/login?return_to=%2Flogins");
		driver.manage().window().maximize();
	
	
	}

  @AfterTest
  public void afterTest() {
  }

}
