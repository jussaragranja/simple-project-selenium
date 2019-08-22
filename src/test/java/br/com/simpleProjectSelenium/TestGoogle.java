package br.com.simpleProjectSelenium;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestGoogle {
	
	@Test
	public void testGoogleChrome() {
		//System.setProperty("webdriver.gecko.driver", "D:\\Projetos\\Pessoal-Teste\\Drivers\\geckodriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		Assert.assertEquals("Google", driver.getTitle());
		driver.quit();
	}
	
	@Test
	public void testGoogleFirefox() {
		//System.setProperty("webdriver.gecko.driver", "D:\\Projetos\\Pessoal-Teste\\Drivers\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		Assert.assertEquals("Google", driver.getTitle());
		driver.quit();
	}

}