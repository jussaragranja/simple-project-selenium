package br.com.simpleProjectSelenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicPage {
	
	public WebDriver driver;
	
	//Executado ANTES cada teste
	@Before
	public void before() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();		
	}

	//Executado APÓS cada teste
	@After
	public void after() {
		driver.quit();
	}
	
	public void acessarGoogle() {
		driver.get("https://www.google.com");
	}

}
