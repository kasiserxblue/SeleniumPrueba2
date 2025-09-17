import org.junit.AfterClass;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class PlayPiano {

    public static int param;

    /** Notas del piano
     * si = 190
     * do = 84
     * re = 89
     * la = 69
     * sol = 87*/

    private int sc1[] = { 190,190,84,89,89,84,190,69,87,87,69,190,190,69,69 };
    private int sc2[] = { 190,190,84,89,89,84,190,69,87,87,69,190,190,69,69,
                          190,190,84,89,89,84,190,69,87,87,69,190,190,69,69 };
    private int sc3[] = {190,190,84,89,89,84,190,69,87,87,69,190,87,69,190,84,
                        190,87,69,190,87,87,69,89,190,190,84,89,89,84,190,69,87,87,69,190,190,69,69};

    private WebDriver driver;
    private WebDrivers browser;

    // SeUp se encarga de cargar el webDriver
    @BeforeEach
    public void setUp() {
        param = 1; // este parametro es para el Navegador que vamos a utilizas (1)google chrome/ (2)Edge
        browser = new WebDrivers(param);
        driver = browser.getBrowserDriver();
    }

    @Test
    @Order(1)
    //Escenario 1 Notas ♫ si, si, do, re, re, do, si, la, sol, sol, la, si, si, la, la ♪
    public void PlaySc1(){

        try{
            browser.sleep_wait(7000); //Se espera unos 7 segundos a que cargue la pagina

            justPlay(sc1);
            browser.sleep_wait(2000);

        }catch(Exception e){
            System.out.println("Error PlaySc1 --> " + e.getMessage());
        }
    }


    //Escenario 2 Notas ♫ si, si, do, re, re, do, si, la, sol, sol, la, si, si, la, la ♪ X2
    @Test
    @Order(2)
    public void PlaSc2(){

        try{
            browser.sleep_wait(7000);

            justPlay(sc2);
            browser.sleep_wait(2000);

        }catch(Exception e){
            System.out.println("Error PlaySc2 --> " + e.getMessage());
        }
    }

    //Escenario 3: ♫ si, si, do, re, re, do, si, la, sol, sol, la, si, la, sol, sol, la, si, sol, la, si, do, si sol, la, si, do, si, sol, sol, fa, re + Escenario 1 ♪
    @Test
    @Order(3)
    public void PlaSc3(){

        try{
            browser.sleep_wait(7000);

            justPlay(sc3);
            browser.sleep_wait(2000);

        }catch(Exception e){
            System.out.println("Error PlaySc3 --> " + e.getMessage());
        }
    }



    public void justPlay(int[] scParam){

        try{
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        int tempo = 0;
        for(int i=0; i<scParam.length; ++i ){

                WebElement tecla = driver.findElement(By.cssSelector("span.white-key[data-key=\""+scParam[i]+"\"]"));
                //WebElement keyElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("span.white-key[data-key=\""+scParam[i]+"\"]")));
                tecla.click();
                System.out.println("Nota: " + scParam[i]);
                if(i>0)
                    tempo = (scParam[i]==scParam[i-1])?500:1000;
                browser.sleep_wait(tempo);

        }
            System.out.println("Total de teclas presionadas: " + scParam.length);

    } catch (Exception e) {
        System.out.println("Error: " + e.getMessage());
    } finally {
        driver.quit();
    }

  }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
