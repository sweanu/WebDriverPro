package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FbLoginin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		//create a facebook new acc
		
		WebElement signin=driver.findElement(By.xpath("//a[@data-testid='open-registration-form-button']"));
		signin.click();
		
		WebElement username=driver.findElement(By.xpath("//input[@name='firstname']"));
		username.sendKeys("sweta");
		
		WebElement lastname=driver.findElement(By.xpath("//input[@name='lastname']"));
		lastname.sendKeys("ramu");
		
		WebElement email=driver.findElement(By.xpath("//input[@name='reg_email__']"));
		email.sendKeys("9999");
		
		WebElement password=driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
		password.sendKeys("hydw5");
	
		WebElement month=driver.findElement(By.xpath("//select[@id='month']"));
		Select Mmonth= new Select(month);
		Mmonth.selectByVisibleText("Apr");
		//Mmonth.selectByValue("10");
		
		WebElement selecteddate=driver.findElement(By.xpath("//select[@id='day']/option[@selected='1']"));
		System.out.println("The selected dtae is :"+selecteddate.getText());
		
		WebElement date=driver.findElement(By.xpath("//select[@id='day']"));
		Select Date= new Select(date);
		Date.selectByVisibleText("10");
		
		WebElement year=driver.findElement(By.xpath("//select[@id='year']"));
		Select Year= new Select(year);
		Year.selectByVisibleText("2000");
		
		List<WebElement> list=driver.findElements(By.xpath("//select[@id='month']/option"));
		for(WebElement Month:list)
		{
			System.out.println(Month.getText());
		}
		
		//WebElement gender=driver.findElement(By.xpath("//input[@value='1' and @type='radio']"));
		//gender.click();
		
		String Gender="Male";
		String genderxpath="//label[text()='swe']";
		String newxpath=genderxpath.replace("swe", Gender);
		System.out.println(newxpath);
		
		//String newxpath="//label[text()='" + Gender + "']";
		
		WebElement genele= driver.findElement(By.xpath(newxpath));
		genele.click();
		
		//driver.close();
	
	}

}
