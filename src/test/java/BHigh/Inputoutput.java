package BHigh;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Inputoutput {
  
	public WebDriver driver;
	public String str;
	
	
	@Test
  public void havinfun() throws Exception {
  
	
	
		//Read the data from the input file	  
		FileInputStream fi = new FileInputStream("C:\\Users\\user\\Documents\\singar22.xls");
			  Workbook w = Workbook.getWorkbook(fi);
			  Sheet s = w.getSheet("Sheet2");


		//Create the result file under the result folder		  
		FileOutputStream fo = new FileOutputStream("C:\\Users\\user\\Documents\\singar22.xls");
			  WritableWorkbook wb = Workbook.createWorkbook(fo);
			  WritableSheet ws = wb.createSheet("Results", 0);
			
			  
			  
		for (int i = 1; i < s.getRows(); i++) {

		//Enter username,Password and click on signin by taking data from input file
		driver.findElement(By.id("txtUsername")).sendKeys(s.getCell(0, i).getContents());
		Thread.sleep(3000);
		driver.findElement(By.id("txtPassword")).sendKeys(s.getCell(1, i).getContents());
		Thread.sleep(3000);

		driver.findElement(By.id("btnLogin")).click();
		Thread.sleep(5000);

		//Validate singout, if available assign pass to str, else assign fail to str
		try{
			
		driver.findElement(By.linkText("Welcome Rahul")).click();	
			
		driver.findElement(By.linkText("Logout")).click();

			Thread.sleep(6000);
			str="Pass";
			
			
		}catch(Exception e)
		{
			str="Fail";

		}


		//Add str value to the result file under result column
		jxl.write.Label result = new jxl.write.Label(2, i, str);
		ws.addCell(result);


		//Add input data to the result file
		for (int j = 0; j < s.getColumns(); j++) {
			
			System.out.println(s.getCell(j, i).getContents());
			jxl.write.Label l = new jxl.write.Label(j, i, s.getCell(j, i).getContents());
			ws.addCell(l);
			
			
		}
			
		}
		//Add the heading

		jxl.write.Label un = new jxl.write.Label(0,0,"Username");
		jxl.write.Label pw = new jxl.write.Label(1,0,"Password");
		jxl.write.Label rs = new jxl.write.Label(2, 0, "Results");
			ws.addCell(un);
			ws.addCell(pw);
			ws.addCell(rs);

			//Write and close the result file	
				wb.write();
				wb.close();


		
		
		
		
	}
  
	
	@BeforeTest
  public void beforeTest() {
		 System.setProperty("webdriver.chrome.driver","D:\\Beeram workspace\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.get("https://opensource-demo.orangehrmlive.com/");
		  driver.manage().window().maximize();
	
	
	}

  @AfterTest
  public void afterTest() {
  }

}
