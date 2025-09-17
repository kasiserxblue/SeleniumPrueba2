
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;



public class WebDrivers {


    WebDriver driver;
    WebDriver BrowserDriver;
    static final String URL = "https://www.musicca.com/es/piano";


    // Este constructor se encarga de cargar el Webdriver y uq e navedaor utilizara(Chrome/Edge)
    public WebDrivers(int webBrowser) {

        switch (webBrowser){
            case 1: // Google Chrome
                setBrowserDriver(Chrome(URL));
                break;
            case 2: // Microsof Edge
                setBrowserDriver(Edge(URL));
                break;
            default:
                break;
        }
    }

    public WebDriver getBrowserDriver() {
        return BrowserDriver;
    }

    public void setBrowserDriver(WebDriver browserDriver) {
        BrowserDriver = browserDriver;
    }

    public WebDriver Chrome(String endPoint){

        try{
            // 1. Configurar la ruta del driver (ajusta la ruta según tu sistema)
            System.setProperty("webdriver.chrome.driver", "C:/drivers/chromedriver.exe");

            // 2. Inicializar el navegador
            driver = new ChromeDriver();
            driver.manage().window().maximize(); // Maximizar ventana

            // 3. Abrir una página web de la variable "Endpoint"
            driver.get(endPoint);
            System.out.println("Título de la página: " + driver.getTitle());
        }catch(Exception e){
            System.out.println("Error WebDriver Chrome-->: " + driver.getTitle());
            driver = null;
        }
        return driver;
    }

    public WebDriver Edge(String endPoint) {

        try{

            System.setProperty("webdriver.edge.driver", "C:/drivers/msedgedriver.exe");

            driver = new EdgeDriver();
            driver.manage().window().maximize(); // Maximizar ventana

            // 3. Abrir una página web
            driver.get(endPoint);
            System.out.println("Título de la página: " + driver.getTitle());

        }catch(Exception e){

            System.out.println("Error WebDriver Edge-->: " + driver.getTitle());
            driver = null;
        }
        return driver;
    }

    // Metodo encargado de activar hilos (tiempo de espera en milisegundos)
    public void sleep_wait(int miliseconds){
        try {
            Thread.sleep(miliseconds); // duerme el hilo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
