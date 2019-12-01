package br.com.simpleProjectSelenium.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TesteCampoTreinamento {
	
	
	private String Url = "file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html";
	
	@Test
	public void teste() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		//driver.get("file:///D:/Projetos/Pessoal-Teste/campo-treinamento/componentes.html");
		driver.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
		driver.quit();
	}
	
	@Test
	public void testePreencherNome() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
		driver.findElement(By.id("elementosForm:nome")).sendKeys("NOME");
		assertEquals("NOMEAAAAAAAA", driver.findElement(By.id("elementosForm:nome")).getAttribute("value"));
		driver.quit();
	}
	
	@Test
	public void testePreencherSobrenome() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
		driver.findElement(By.id("elementosForm:sobrenome")).sendKeys("SOBRENOME");
		assertEquals("SOBRENOME", driver.findElement(By.id("elementosForm:sobrenome")).getAttribute("value"));
		driver.quit();
	}
	
	@Test
	public void deveInteragirComRadioButton() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
		driver.findElement(By.id("elementosForm:sexo:1")).click();
		assertEquals("F", driver.findElement(By.id("elementosForm:sexo:1")).getAttribute("value"));
		assertTrue(driver.findElement(By.id("elementosForm:sexo:1")).isSelected());
	}
	
	@Test
	public void deveInteragirComCheckbox() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
		driver.findElement(By.id("elementosForm:comidaFavorita:2")).click();
		assertEquals("pizza", driver.findElement(By.id("elementosForm:comidaFavorita:2")).getAttribute("value"));
		assertTrue(driver.findElement(By.id("elementosForm:comidaFavorita:2")).isSelected());
		driver.quit();
	}
	
	@Test
	public void deveSelecionarComboBoxSelect() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
		WebElement elemento = driver.findElement(By.id("elementosForm:escolaridade"));
		Select comboBox = new Select(elemento);
		//comboBox.selectByIndex(5);
		//comboBox.selectByValue("superior");
		comboBox.selectByVisibleText("Mestrado");
		assertEquals("Mestrado", comboBox.getFirstSelectedOption().getText());
		driver.quit();
	}
	
	@Test
	public void deveVerificarValoresComboBoxSelect() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
		WebElement elemento = driver.findElement(By.id("elementosForm:escolaridade"));
		Select comboBox = new Select(elemento);
		List<WebElement> options = comboBox.getOptions();
		assertEquals(8, options.size());
		
		boolean encontrou = false;
		
		for (WebElement option : options){
			if(option.getText().equals("Mestrado")) {
				encontrou = true;
				break;
			}
		}
		
		assertTrue(encontrou);
		
		driver.quit();
	}
	
	@Test
	public void devePreencherEVerificarComboBox() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Url);
		WebElement elemento = driver.findElement(By.id("elementosForm:esportes"));
		Select comboBox = new Select(elemento);
		comboBox.selectByVisibleText("Futebol");
		comboBox.selectByVisibleText("Natacao");
		comboBox.selectByVisibleText("Corrida");
		
		List<WebElement> allSelectedOptions = comboBox.getAllSelectedOptions();
		assertEquals(3, allSelectedOptions.size());
		
		comboBox.deselectByVisibleText("Natacao");
		allSelectedOptions = comboBox.getAllSelectedOptions();
		assertEquals(2, allSelectedOptions.size());
		
		comboBox.deselectAll();
		allSelectedOptions = comboBox.getAllSelectedOptions();
		assertEquals(0, allSelectedOptions.size());
		driver.quit();
	}
	
	@Test
	public void devePreencherTextArea() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("file:///" + System.getProperty("user.dir") + "/src/test/resources/componentes.html");
		driver.findElement(By.id("elementosForm:sugestoes")).sendKeys("Teste\n\nTeste2");
		assertEquals("Teste\n\nTeste2", driver.findElement(By.id("elementosForm:sugestoes")).getAttribute("value"));
		driver.quit();
	}
	
	@Test
	public void deveInteragirComBotoes() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Url);
		WebElement botao = driver.findElement(By.id("buttonSimple"));
		botao.click();
		assertEquals("Obrigado!", botao.getAttribute("value"));
		driver.quit();	
	}
	
	@Test
	public void deveInteragirComLink() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Url);
		driver.findElement(By.linkText("Voltar")).click();
		assertEquals("Voltou!", driver.findElement(By.id("resultado")).getText() );
		driver.quit();
	}
	
	@Test
	public void deveBuscarTextosNaPagina() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Url);
		//assertTrue(driver.findElement(By.tagName("body")).getText().contains("Campo de Treinamento"));
		//WebElement texto = driver.findElement(By.tagName("h3"));
		//assertEquals("Campo de Treinamento", texto.getText());
		WebElement texto = driver.findElement(By.className("facilAchar"));
		assertEquals("Cuidado onde clica, muitas armadilhas...", texto.getText());
		driver.quit();
	}
		
}
