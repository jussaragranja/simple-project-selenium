package br.com.simpleProjectSelenium;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestGoogle {
	
	@Test
	public void testGoogleChrome() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jussa\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		Assert.assertEquals("Google", driver.getTitle());
		driver.quit();
	}
	
	@Test
	public void novoTest() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\jussa\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		driver.findElement(By.name("q")).sendKeys("Texto");
		Assert.assertEquals("Texto", driver.findElement(By.name("q")).getAttribute("value"));
		driver.quit();
	}
	
	
}