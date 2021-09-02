package starter;

import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.*;

import java.util.NoSuchElementException;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class GeneralMethods {

    public static void clickBtn(WebElementFacade webElementFacade, String buttonName) {

        try {
            System.out.println("Clicking " + buttonName);
            webElementFacade.waitUntilClickable().click();
        } catch (NoSuchElementException nse) {
            System.out.println("Button " + buttonName + " not present");
        } catch (ElementClickInterceptedException ecie) {
            System.out.println("Button " + buttonName + "intercepted exception");
        } catch (StaleElementReferenceException sere) {
            System.out.println("Button " + buttonName + "stale element exception");
        }
    }

    public static void sendKeys(WebElementFacade webElementFacade, String keys, String elementName) {

        try {
            webElementFacade.waitUntilClickable();
            System.out.println("Sending keys " + keys + " on " + elementName);
            webElementFacade.sendKeys(keys);
        } catch (NoSuchElementException nse) {
            System.out.println("Field " + elementName + " not present");
        } catch (ElementNotInteractableException enie) {
            System.out.println("Field " + elementName + " is not interactable");
        }

    }

    public static void shadowClick(String locator, String argument, String elementName) {
        JavascriptExecutor jse = (JavascriptExecutor) getDriver();
        WebElement webElement = (WebElement) jse.executeScript(locator);
        System.out.println("Clicking on shadowRoot element " + elementName);
        ((JavascriptExecutor) getDriver()).executeScript(argument, webElement);
    }



}

