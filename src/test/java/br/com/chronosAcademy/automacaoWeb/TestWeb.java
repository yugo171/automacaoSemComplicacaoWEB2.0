package br.com.chronosAcademy.automacaoWeb;

import io.github.bonigarcia.wdm.WebDriverManager;
import static org.junit.Assert.*;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestWeb {

    ChromeDriver driver;

    @Before
    public void inicializarTeste(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.chronosacademy.com.br");
        //ChromeDriver driver; quer dizer que ela ta local dentro do método

    }

    @Test
    public void primerioTeste(){
            String xpathTitulo= "//section[2]//h4";
        WebElement txtTitulo = driver.findElement(By.xpath(xpathTitulo));
        String titulo = txtTitulo.getText();
        assertEquals("Porque Tempo É Conhecimento.",titulo);

    }

    @After
    public void finalizaTeste(){
        driver.quit();
    }
}
