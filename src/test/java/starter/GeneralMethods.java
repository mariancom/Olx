package starter;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;

import java.util.NoSuchElementException;

public class GeneralMethods {

    public static void clickBtn(WebElementFacade webElementFacade, String buttonName){

        try {
            System.out.println("Clicking " + buttonName);
            webElementFacade.waitUntilClickable().click();
        } catch (NoSuchElementException nse){
            System.out.println("Button " + buttonName + " not present");
        } catch (ElementClickInterceptedException ecie){
            System.out.println("Button " + buttonName + "intercepted exception");
        } catch (StaleElementReferenceException sere){
            System.out.println("Button " + buttonName + "stale element exception");
        }
    }

    public static void sendKeys(WebElementFacade webElementFacade, String keys, String elementName){

        try {
            webElementFacade.waitUntilClickable();
            System.out.println("Sending keys " + keys + " on " + elementName);
            webElementFacade.sendKeys(keys);
        } catch (NoSuchElementException nse){
            System.out.println("Field " + elementName + " not present");
        } catch (ElementNotInteractableException enie){
            System.out.println("Field " + elementName + " is not interactable");
        }

    }

}
