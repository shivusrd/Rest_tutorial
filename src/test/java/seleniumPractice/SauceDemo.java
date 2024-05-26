package seleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SauceDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
double price;
double max=0.0;
	WebDriverManager.chromedriver().setup();
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.saucedemo.com/");
	driver.findElement(By.id("user-name")).sendKeys("standard_user");
	driver.findElement(By.id("password")).sendKeys("secret_sauce");
	driver.findElement(By.id("login-button")).click();	
	List<WebElement> li =driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
	
	/*
	 * for(WebElement w:li) {
	 * 
	 * price =Double.parseDouble(w.getText().trim().replace("$", "")); if(price>max)
	 * { max=price; } }
	 */
	price =li.stream().mapToDouble(e->Double.parseDouble(e.getText().trim().replace("$", ""))).max().getAsDouble();
	System.out.println(price);
	driver.findElement(By.xpath("//div[text()='"+price+"']//parent::div[@class='pricebar']//child::button")).click();
	driver.close();
	
	}
	
}
