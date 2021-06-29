package practicasFalabella.pageobject.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import practicas.pageobject.base.SeleniumBase;
import practicasFalabella.utils.impresion.utilizaFile;
import org.openqa.selenium.WebDriver;

public class OpcionesDeVuelo extends SeleniumBase {
    public OpcionesDeVuelo(WebDriver driver) {
        super(driver);
    }

    //Se inicializa clase para generar evidencias.
    utilizaFile imprimeEvidencia = new utilizaFile();

    //Elementos de la page
    private By alerta = By.xpath("(//i[@class='icon-int-close'])[1]");

    //Métodos de la page
    public boolean cerrarAlerta(){
        try{
            waitDisplayed(alerta,5);
            imprimeEvidencia.PasoDelScript("Se visualiza alerta");
            click(alerta);
            Thread.sleep(3000);
            imprimeEvidencia.PasoDelScript("Se cierra alerta");
            return true;
        }catch (Exception e){
            return false;
        }
    }
}
