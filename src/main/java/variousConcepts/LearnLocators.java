package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LearnLocators 
{
	
	WebDriver driver;
	
	
	
	@Before
	public void init() //instead of launchbrowser, in industry we call it "init"- it stands for initialization
	{
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe"); //here the key is "webdriver.chrome.driver"-
		//copy this words from error in the console and in the another string the path will be exe, we have driver folder 
		//in the crm project so we can copy and go to project called session2 and right click on it and paste the 
		//driver folderdriver
		
		 driver = new ChromeDriver(); //here we create object of webdriver
	
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://objectspy.space/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			
	}
	
	@Test	//to run this program we need to add this "Test"
			//we are using junit over here so we don't need static method
	public void testLocators() throws InterruptedException
	{
		//uploading file with s endKeys operation only works with if we have input tag in the coding of objectspy.space
		//if there is no input tag then use class name  Robot
		
		driver.findElement(By.name("firstname")).sendKeys("Selenium"); 
		
		driver.findElement(By.id("sex-1")).click(); //for radio button, select female
		
		//to upload file-- i had one notepad file on desktop_go to that file-right click on it- select the lacation-copy 
		//and paste here--also after past here-we have to add file name for eg. i gave that notepad file name is "name" so
		//we have to add here "\\name.txt" after "C:\\Users\\chint\\OneDrive\\Desktop -- and txt is file extention
		driver.findElement(By.id("photo")).sendKeys("C:\\Users\\chint\\OneDrive\\Desktop\\name.txt");
	
		//LINK text- copy the black font from that is text from left side of objectspy.space and paste here as an arguments ..
		//the text is " OS-API Product FrontEnd"
		//driver.findElement(By.linkText("OS-API Product FrontEnd")).click(); //it will take us to that link page and open 
		//new page API Shop sample
		
		//Thread.sleep(3000);
		
		//driver.navigate().back(); //it will take us back to the previous page
		
		//Thread.sleep(3000);
		
		//PARTIAL LINK text
		//driver.findElement(By.partialLinkText("TF-API")).click();// 
		
		//xPath
		//Absolute xPath
		//driver.findElement(By.xpath("html/body/div/div[2]/div[2]/form/div[10]/input")).sendKeys("is fun");
		
		
		//Relative xPath -in industry we use this realtive path
		//formula for single attribute: //Tag[@Attribute Node = 'Value'] --eg. //input[@name = 'lastname']
		driver.findElement(By.xpath("//input[@name = 'lastname']")).sendKeys("is fun");
		
		Thread.sleep(2000);
		
		//formula for multiple attributes://Tag[@Attribute Node = 'Value' and @Attribute Node = 'Value']
		//eg.-- //input[@name = 'lastname'] and @type =' text']
		driver.findElement(By.xpath("//input[@name = 'lastname' and @type = 'text']")).clear(); //it will clear the above 
		//message" is fun" and it will only display the below message "is not fun"
		driver.findElement(By.xpath("//input[@name = 'lastname' and @type = 'text']")).sendKeys("is not fun");
		
	
		//formula for links/text
		//1) //Tag[text() = 'Value'] 
		//driver.findElement(By.xpath("//strong[text() = 'Link Test : Page Change']")).click();
		
		//2)//Tag [contains(text(), 'Value')]- here text is method, the value is by using coma
		driver.findElement(By.xpath("//strong[contains(text(),'Link Test : Page Change')]")).click();
		
		 
		
		
		
				
	}
	
	
	//@After
	public void tearDown()
	{
		driver.close(); //close method shuts down the driver it focused on
		driver.quit();	//quit method will shut down all the available tabs to the driver
	}





}

