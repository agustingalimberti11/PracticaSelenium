package practicasFalabella.testcases;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.Test;
import practicasFalabella.pageobject.pages.PaginaPrincipalPage;
import practicasFalabella.utils.impresion.utilizaFile;

import java.awt.*;
import java.io.IOException;

public class IngresoLatam extends TestBase {
    protected PaginaPrincipalPage homePage;
    @Test
    public void LogIn() throws IOException, InvalidFormatException, AWTException {
        utilizaFile imprimeEvidencia = new utilizaFile();
        homePage = new PaginaPrincipalPage(driver);
        imprimeEvidencia.InicializaFile();
        homePage.goToUrl("https://www.latam.com/es_ar/");
        homePage.cerrarBanner();
        imprimeEvidencia.GeneraEvidencia("IngresoLatam.docx");
    }
}
