package seleniumPractice;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class ShadowDom {
	
	public static void main(String args[]) {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://books-pwakit.appspot.com");
		driver.manage().window().maximize();
		WebElement root=driver.findElement(By.xpath("/html/body/book-app"));
		JavascriptExecutor js= (JavascriptExecutor)driver;
		WebElement shadowD=(WebElement) js.executeScript("return arguments[0].shadowRoot", root);
		
	WebElement shadowD1=shadowD.findElement(By.tagName("app-header"));
	WebElement shadowD2=shadowD1.findElement(By.cssSelector("app-toolbar.toolbar-top"));
	WebElement shadowD3=shadowD2.findElement(By.tagName("book-input-decorator"));
		shadowD3.findElement(By.cssSelector("input#input")).sendKeys("test");
		driver.close();
	}
	
	

}
