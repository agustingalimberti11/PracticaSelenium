package practicas.pageobject.base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SeleniumBase {

    //atributos
    public WebDriver driver;

    //Constructor Base
    public SeleniumBase(WebDriver driver){
        this.driver = driver;
    }

    //Envoltorios Wrapper
    public WebElement findElement(By locator){
        return driver.findElement(locator);
    }

    public List<WebElement> findElements (By locator){
       return driver.findElements(locator);
    }

    public String getText (By locator){
        return driver.findElement(locator).getText();
    }

    public void type(String inputText, By locator){
        driver.findElement(locator).sendKeys(inputText);
    }

    public void click(By locator){
        driver.findElement(locator).click();
    }

    public void closeDriver(){
        driver.close();
    }
    public Boolean isDisplayed(By locator){
        try {
            return driver.findElement(locator).isDisplayed();
        }catch (org.openqa.selenium.NoSuchContextException e) {
            return false;
        }
    }

    public void goToUrl(String url){
        driver.get(url);
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public void switchFrame(int n){
        driver.switchTo().frame(n);
    }

    public void switchFrameId(String ID){
        driver.switchTo().frame(ID);
    }

    public void switchWindow(){
        Set<String> handles = driver.getWindowHandles();
        for(String handle : driver.getWindowHandles()){
            if(!handles.contains(handle)) {
                driver.switchTo().window(handle);
            }
        }
    }

    public void waitClick(By locator, int n){
        WebDriverWait wait = new WebDriverWait(driver, n);
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void waitDisplayed(By locator, int n){
        WebDriverWait wait = new WebDriverWait(driver, n);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).isDisplayed();
    }

    public void waitSendKeys(By locator, int n, String texto){
        WebDriverWait wait = new WebDriverWait(driver, n);
        wait.until(ExpectedConditions.elementToBeClickable(locator)).sendKeys(texto);
    }

    public void clearText(By locator){
        driver.findElement(locator).clear();
    }

    public void sendKey(Keys key, By locator) {
        driver.findElement(locator).sendKeys(key);
    }

    public void wait(int s, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, s);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
    public void waitFrame(int s, By locator) {
        WebDriverWait waitFrame = new WebDriverWait(driver, s);
        waitFrame.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }


    public void switchFramePadre(){
        driver.switchTo().parentFrame();
    }
    public void switchVentana(int i)  {
        ArrayList <String> ventana = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(ventana.get(i));
        System.out.println("Switch numero: "+i);
    }

    public void btnEnabled(By locator, int n){
        WebDriverWait wait = new WebDriverWait(driver, n);
        if(wait.until(ExpectedConditions.elementToBeClickable(locator)).isEnabled()){
            System.out.println("esta habilitado");
        }else{
            System.out.println("ocurrio un error");
        }
    }

    public void esperar(int n){
        driver.manage().timeouts().implicitlyWait(n, TimeUnit.SECONDS);
    }
}
