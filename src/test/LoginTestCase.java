package test;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTestCase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//1) launch chrome browser and open simplilearn website
		
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.simplilearn.com/");
		
		
		//2) maximize the window
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		//3) click on the login link on top right corner
		
		System.out.println("the title of the page is : "+driver.getTitle());
		WebElement login=driver.findElement(By.linkText("Log in")); //link text
		String location=login.getAttribute("href");//get attribute
		System.out.println("this will take you to "+location);
		login.click();//click
		
		
		//4) enter the user name
		
		WebElement Username=driver.findElement(By.name("user_login"));//name
		Username.sendKeys("sweanuta3459@gmail.com");//send keys
		
		//5) enter the password
		
		WebElement password=driver.findElement(By.id("password"));//id
		password.sendKeys("ihateL@12");
		
		//6) click on remember me check box
		
		WebElement checkbox=driver.findElement(By.className("rememberMe"));
		checkbox.click();
		
		//7) click on the login button
		
		WebElement loginbtn=driver.findElement(By.name("btn_login"));//name
		loginbtn.click();
		
		//8) validate the login was successful
		
		WebElement error=driver.findElement(By.className("error_msg"));//class name
		String errormsg=error.getText();//get text
		String experrormsg="The email or password you have entered is invalid.";
		
		if(error.isDisplayed() && errormsg.equals(experrormsg))
		{
			System.out.println("tc pass");
		}
		else
		{
			System.out.println("tc fail");
		}
		
		//9) print all links
		
		List<WebElement> allLinks=driver.findElements(By.tagName("a"));
		System.out.println("total link in this pages are : "+allLinks.size());
		for(WebElement links : allLinks)
		{
			System.out.println("locatins of each links : "+links.getAttribute("href"));
		}
		
		//10) close the browser
		
		driver.close();
	}

}
