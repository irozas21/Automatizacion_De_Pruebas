package com.iplacex.automatizacion;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Clase de Pruebas de Integración con Selenium.
 * @version 1.0
 */
public class SeleniumIntegrationTest {

    @Test
    @DisplayName("Prueba de Integración: Verificar título de Google")
    public void testTituloGoogle() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*"); 

        WebDriver driver = new ChromeDriver(options);

        try {
            // Navegar a Google
            driver.get("https://www.google.com");

            // Obtener el título de la página
            String titulo = driver.getTitle();
            System.out.println("Título obtenido: " + titulo);

            // Verificar que el título contenga "Google"
            assertTrue(titulo.contains("Google"), 
                "El título de la página debe contener 'Google'. Título actual: " + titulo);

        } finally {
            driver.quit();
        }
    }
}