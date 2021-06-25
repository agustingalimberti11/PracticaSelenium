package practicasFalabella.utils.impresion;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;



import org.apache.poi.openxml4j.exceptions.InvalidFormatException;



public class utilizaFile {

    GeneraEvidencias ImprEvi;


    public void PasoDelScript(String descripcionPaso) throws InvalidFormatException, IOException, HeadlessException, AWTException {
        GeneraEvidencias.OpenFile(1,descripcionPaso);
        GeneraEvidencias.screenshoot();
    }

    public void InicializaFile() throws HeadlessException, InvalidFormatException, IOException, AWTException {
        GeneraEvidencias.defineVariables();
    }

    public void GeneraEvidencia(String NombreArchivo) throws IOException{
        GeneraEvidencias.CloseFile(NombreArchivo);
    }
}