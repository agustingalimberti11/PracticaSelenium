package practicasFalabella.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;
import practicasFalabella.pageobject.pages.OpcionesDeVuelo;
import practicasFalabella.pageobject.pages.PaginaPrincipalPage;
import practicasFalabella.utils.impresion.utilizaFile;

import java.awt.*;
import java.io.IOException;

public class SeleccionarVuelos extends TestBase{
    protected PaginaPrincipalPage homePage;
    protected OpcionesDeVuelo opcionesDeVuelo;
    @Test
    public void LogIn() throws IOException, InvalidFormatException, AWTException {
        utilizaFile imprimeEvidencia = new utilizaFile();
        homePage = new PaginaPrincipalPage(driver);
        opcionesDeVuelo = new OpcionesDeVuelo(driver);
        imprimeEvidencia.InicializaFile();
        homePage.goToUrl("https://www.latam.com/es_ar/");
        homePage.cerrarBanner();
        homePage.elegirOrigen("Buenos Aires");
        homePage.elegirDestino("Santiago de Chile");
        homePage.elegirFechasDeViaje();
        homePage.buscarVuelo();
        opcionesDeVuelo.cerrarAlerta();
        imprimeEvidencia.GeneraEvidencia("OpcionesDeVuelo.docx");
}
}
