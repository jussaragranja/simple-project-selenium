package br.com.simpleProjectSelenium;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;

public class TestGoogle extends BasicPage {
	
	
	@Test
	public void testGoogleChrome() {
		acessarGoogle();
		Assert.assertEquals("Google", driver.getTitle());
	}
	
	@Test
	public void novoTest() {
		acessarGoogle();
		driver.findElement(By.name("q")).sendKeys("Texto");
		Assert.assertEquals("Texto", driver.findElement(By.name("q")).getAttribute("value"));
	}
	
	
}