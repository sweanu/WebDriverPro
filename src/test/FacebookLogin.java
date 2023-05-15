package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FacebookLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		WebElement userid=driver.findElement(By.name("email"));
		userid.sendKeys("swea@gamil.com");
		
		WebElement password=driver.findElement(By.name("pass"));
		password.sendKeys("Swea@gam");
		
		WebElement button=driver.findElement(By.name("login"));
		button.click();
		
		WebElement error=driver.findElement(By.id("error_box"));//class name
		String errormsg=error.getText();//get text
		System.out.println("the error is "+errormsg);
		String experrormsg="Wrong Credentials";
		
		if(error.isDisplayed() && errormsg.contains(experrormsg))
		{
			System.out.println("tc pass");
		}
		else
		{
			System.out.println("tc fail");
		}
	}

}
