package test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Webtables {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver= new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		List<WebElement> Rows=driver.findElements(By.cssSelector("table#customers>tbody>tr"));
		System.out.println("Row size :"+ Rows.size());
		
		List<WebElement> Columns=driver.findElements(By.xpath("//table[@id='customers']//th"));//column : table#customers>tbody>tr>th
		System.out.println("Columns size :"+ Columns.size());
		
		WebElement data=driver.findElement(By.xpath("//table[@id='customers']//tr[4]//td[1]"));
		System.out.println("The date is : "+data.getText());
		
		for(int i=2;i<=Rows.size();i++)
		{
			List<WebElement> TableData=driver.findElements(By.xpath("//table[@id='customers']/tbody/tr["+i+"]/td"));
			System.out.println(TableData.get(0).getText()+ " *** " +TableData.get(1).getText()+ " *** " +TableData.get(2).getText()+ " *** " );
		}
		
	}

}
