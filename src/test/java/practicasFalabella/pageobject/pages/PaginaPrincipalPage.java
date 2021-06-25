package practicasFalabella.pageobject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import practicas.pageobject.base.SeleniumBase;
import practicasFalabella.utils.impresion.utilizaFile;

public class PaginaPrincipalPage extends SeleniumBase {
    public PaginaPrincipalPage(WebDriver driver) {
        super(driver);
    }
    utilizaFile imprimeEvidencia = new utilizaFile();
    private By banner = By.xpath("//button[@class='align-right secondary slidedown-button NoFocusable']");
    private By origen = By.xpath("//input[@id='compra-select-origin']");
    private By origenBSAS = By.xpath("//span[@class='highlight']");
    private By destinoSantiago = By.xpath("(//span[@class='highlight'])[2]");
    private By destino = By.xpath("//input[@id='compra-select-destination']");




    public boolean cerrarBanner(){
        try{
            waitDisplayed(banner,5);
            imprimeEvidencia.PasoDelScript("Se visualiza banner principal");
            click(banner);
            Thread.sleep(3000);
            imprimeEvidencia.PasoDelScript("Se cierra banner principal");
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean elegirOrigen(String origenDeVuelo)  {
        try{
        waitDisplayed(origen,5);
        click(origen);
        type(origenDeVuelo, origen);
        imprimeEvidencia.PasoDelScript("Se elige origen");
        Thread.sleep(5000);
        waitDisplayed(origenBSAS,5);
        click(origenBSAS);
        imprimeEvidencia.PasoDelScript("Se elige Buenos Aires");
        Thread.sleep(5000);
        return true;
        }catch (Exception e){ return false;
        }
    }

    public boolean elegirDestino(String destinoDeVuelo)  {
        try{
            waitDisplayed(destino,5);
            click(destino);
            type(destinoDeVuelo, destino);
            imprimeEvidencia.PasoDelScript("Se elige destino");
            Thread.sleep(5000);
            waitDisplayed(destinoSantiago,5);
            click(destinoSantiago);
            imprimeEvidencia.PasoDelScript("Se elige Santiago de Chile");
            Thread.sleep(5000);
            return true;
        }catch (Exception e){ return false;
        }
    }

    public void esperar() throws InterruptedException {
        Thread.sleep(3000);
    }

}
