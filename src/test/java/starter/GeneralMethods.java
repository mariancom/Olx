package starter;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.webdriver.exceptions.ElementShouldBeEnabledException;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import starter.utils.LoggerClass;

import java.util.NoSuchElementException;

public class GeneralMethods {

    public static void clickBtn(WebElementFacade webElementFacade, String buttonName) {
        try {
            LoggerClass.info("Clicking " + buttonName);
            webElementFacade.waitUntilClickable().click();
        } catch (NoSuchElementException nse) {
            LoggerClass.info("Button " + buttonName + " not present");
        } catch (ElementClickInterceptedException ecie) {
            LoggerClass.info("Button " + buttonName + "intercepted exception");
        } catch (StaleElementReferenceException sere) {
            LoggerClass.info("Button " + buttonName + "stale element exception");
        } catch (ElementShouldBeEnabledException esee) {
            LoggerClass.info("Button" + buttonName + "should be enabled exception");
        }
    }

    public static void sendKeys(WebElementFacade webElementFacade, String keys, String elementName) {
        try {
            webElementFacade.waitUntilClickable();
            LoggerClass.info("Sending keys " + keys + " on " + elementName);
            webElementFacade.sendKeys(keys);
        } catch (NoSuchElementException nse) {
            LoggerClass.info("Field " + elementName + " not present");
        } catch (ElementNotInteractableException enie) {
            LoggerClass.info("Field " + elementName + " is not interactable");
        }
    }
}

