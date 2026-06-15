package br.com.chronosAcademy.automacaoWeb;

import br.com.chronosAcademy.core.Driver;
import br.com.chronosAcademy.pages.CursoPage;
import br.com.chronosAcademy.pages.PrincipalPage;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;

public class TestWeb {

    Driver DriverWeb;
    WebDriver driver;
    PrincipalPage principalPage;
    CursoPage cursoPage;

    @Before
    public void inicializarTeste(){
        DriverWeb = new Driver("chrome");
        driver = DriverWeb.getDriver();
        driver.get("https://www.chronosacademy.com.br");
        principalPage = new PrincipalPage(driver);
    }

    @Test
    public void primerioTeste(){
        String titulo = principalPage.getTitulo();
        assertEquals("Porque Tempo É Conhecimento.",titulo);

    }

    @Test
    public void segundoTeste() throws InterruptedException {
        cursoPage = new CursoPage(driver);
        principalPage.clickBotao();
        Thread.sleep(1000);
        String titulo = cursoPage.getTitulo2();

        assertEquals("Conheça todos os nossos cursos.", titulo);
    }

    @After
    public void finalizaTeste(){
        driver.quit();
    }
}
