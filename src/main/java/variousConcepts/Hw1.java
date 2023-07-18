package variousConcepts;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*Automate the following test case:
Scenario: Users will be able to add Account in this website http://www.techfios.com/billing/?ng=admin/*/

public class Hw1 
{
	WebDriver driver; //we declare global object "driver" so we can use in all methods in this class called Hw1
			
	@Before //we are using JUnit so this is the @Before annotation
	public void init() 
	{
		System.setProperty("webdriver.chrome.driver", "driver\\chromedriver.exe"); 
		
		driver = new ChromeDriver(); //here we create object of webdriver and launch chrome browser
	
		driver.manage().deleteAllCookies();
		
		driver.manage().window().maximize(); //here we are maximizing the browser window
		
		//STEPS:
		//1) Open Browser and go to site http://www.techfios.com/billing/?ng=admin/ 
		driver.get("https://www.techfios.com/billing/?ng=admin/");
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS); //this will set the maximum wait that any driver 
		//command will use
	}//end of Before annote	
	
	@Test //we are using JUnit so this is the @Test annotation
	public void testLocators() throws InterruptedException
	{
		//here are few other steps to create our account
		
		//2) Enter username: demo@techfios.com 
		//Relative xpath formula for single attribute: //Tag[@Attribute Node = 'Value']
		driver.findElement(By.xpath("//input[@id= 'username']")).sendKeys("demo@techfios.com");
		
		//3) Enter password: abc123
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("abc123");
		
		//4)Click login button
		driver.findElement(By.xpath("//button[@name='login']")).click();
		
		Thread.sleep(3000); //after login pause for 3 seconds
		
		//5) Click on Bank & Cash button
		//formula for links/text:  //Tag[text() = 'Value'] 
		driver.findElement(By.xpath("//span[text() = 'Bank & Cash']")).click();
		
		Thread.sleep(10000); //after login pause for 10 seconds
		
		//6) Click on New Account button 
		//formula for links/text:  //Tag[text() = 'Value'] 
		driver.findElement(By.xpath("//a[text() = 'New Account']")).click();
		
		//7) Fill out the Add New Account form
		//7(a)Account Title
		driver.findElement(By.xpath("//input[@id= 'account']")).sendKeys("my_account1");
		
		//7(b)Description
		driver.findElement(By.xpath("//input[@id= 'description']")).sendKeys("my account is created");
		
		//7(c)Initial Balance
		driver.findElement(By.xpath("//input[@id= 'balance']")).sendKeys("300,000");
		
		//7(d) Account Number
		driver.findElement(By.xpath("//input[@id= 'account_number']")).sendKeys("45783922");
		
		//7(e)Contact Person
		driver.findElement(By.xpath("//input[@id= 'contact_person']")).sendKeys("abcxyz");
		
		//7(f)Phone
		driver.findElement(By.xpath("//input[@id= 'contact_phone']")).sendKeys("123-456-7892");
		
		Thread.sleep(10000); //after login pause for 10 seconds
		
		//8) Click on submit button
		//Relative xpath formula for multiple attribute because this attribute node and value are not unique for 
		//submit button so we need second attribute to use to properly click the Submit button
		//formula for multiple attribute: //Tag[@Attribute Node = 'Value' and @Attribute Node = 'Value']
		driver.findElement(By.xpath("//button[@type='submit' and @class = 'btn btn-primary' ]")).click();
		
		Thread.sleep(5000); //after login pause for 5 seconds
		
		//9) Visually check if the account has been created
	}//end of Test annote
						
	@After //after we create the account we will close the webpage by using After Junit annotation
	public void tearDown()
	{
		driver.close(); //it closes current website
		driver.quit();	//it will shut down all the available tabs to the driver but since we don't have any other tabs, 
							//we don't see any difference
	}//end of After annote
		
}//end of Class
