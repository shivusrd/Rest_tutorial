package seleniumPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DynamicXpath {
	static WebDriver   driver;
	public static void main(String[] args) throws InterruptedException {
		
		String currentWorldPop="//div[@class='maincounter-number']//span[@class=\"rts-counter\"]";
		String todayYesterday="//div[text()='Today' or text()='This year']//parent::div//span[@class='rts-counter']";
		
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();

		 driver = new ChromeDriver();
		driver.get("https://www.worldometers.info/world-population/");
		
		//driver.manage().window().maximize();
		int c=1;
		while(true) {
			
			if(c>20)
			{
				break;
		}
			else {
		population(currentWorldPop);
		System.out.println("############################################");
		
		population(todayYesterday);
c++;
Thread.sleep(1000);
			}
	}
		driver.close();
	}
	
	public static void  population(String locator) throws InterruptedException  {
		
		
		List<WebElement> li =driver.findElements(By.xpath(locator));
		for(WebElement e:li) {
			
			
			System.out.println(e.getText());
			}
		
		
		}
		
	}
	
