package starter.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.StaleElementReferenceException;
import starter.GeneralMethods;

import java.util.List;

public class OLX_Page extends PageObject {

    @FindBy(xpath = "//tbody/tr[*]/td/div/table/tbody/tr[2]/td[1]/div/p")
    private List<WebElementFacade> sectorList;

    @FindBy(xpath = "//tbody/tr[*]/td/div/table/tbody/tr[1]/td[2]/div")
    private List<WebElementFacade> offerList;

    @FindBy(id = "cityField")
    private WebElementFacade cityField;

    @FindBy(xpath = "//*[@id=\"regionslinks\"]/ul[1]/li[10]/a/span")
    private WebElementFacade bucharestDropdown;

    @FindBy(xpath = "//*[@id=\"a-region-1\"]")
    private WebElementFacade bucharestDropdownDropdown;

    @FindBy(xpath = "//*[@id=\"searchmain-container\"]/div/div/div[1]/div[2]/div/a")
    private WebElementFacade estateSection;

    @FindBy(xpath = "//*[@id=\"bottom3\"]/ul/li[1]/a/span/span")
    private WebElementFacade apartmentsSaleOption;

    @FindBy(xpath = "//*[@id=\"param_price\"]/div[2]/div[1]")
    private WebElementFacade priceFromBtn;

    @FindBy(xpath = "//*[@id=\"param_price\"]/div[2]/div[1]/label/input")
    private WebElementFacade priceFromField;

    @FindBy(xpath = "//*[@id=\"param_price\"]/div[2]/div[2]/a")
    private WebElementFacade priceToBtn;

    @FindBy(xpath = "//*[@id=\"param_price\"]/div[2]/div[2]/label/input")
    private WebElementFacade priceToField;

    @FindBy(xpath = "//*[@id=\"param_m\"]/div[2]/div[1]/a")
    private WebElementFacade surfaceFieldBtn;

    @FindBy(xpath = "//*[@id=\"param_m\"]/div[2]/div[1]/label/input")
    private WebElementFacade surfaceField;

    @FindBy(id = "search-submit")
    private WebElementFacade searchBtn;

    @FindBy(id = "onetrust-accept-btn-handler")
    private WebElementFacade acceptBtm;

    @FindBy(xpath = "//div[3]/div/div[4]/span[17]/a")
    private WebElementFacade nextBtn;

    private int listaOfertePosition;

    /////Start of methods/////

    public void navigateToOLXSite() {
        getDriver().get("https://www.olx.ro/");
    }

    public void acceptData() {
        GeneralMethods.clickBtn(acceptBtm, "buton accept");
    }

    public void selectAreaAndSection() {
        GeneralMethods.clickBtn(cityField, "zona Romania");
        GeneralMethods.clickBtn(bucharestDropdown, "Bucuresti-Ilfov");
        GeneralMethods.clickBtn(bucharestDropdownDropdown, "Bucuresti");
        GeneralMethods.clickBtn(estateSection, "sectiune Imobiliare");
        GeneralMethods.clickBtn(apartmentsSaleOption, "Apartamente-Garsoniere de Vanzare");
    }

    public void settingPriceAndSurface() {

        GeneralMethods.clickBtn(priceFromBtn, "Pret - de la");
        GeneralMethods.sendKeys(priceFromField, "28000", "Pret - de la");
        GeneralMethods.clickBtn(priceToBtn, "Pret - pana");
        GeneralMethods.sendKeys(priceToField, "40000", "Pret - pana");
        GeneralMethods.clickBtn(surfaceFieldBtn, "Suprafata - de la");
        GeneralMethods.sendKeys(surfaceField, "28", "Suprafata - de la");
        GeneralMethods.clickBtn(searchBtn, "Buton Cauta");

    }

    public void printApartmentList() {

        System.out.println("Printing Apartment List:");

        //Declarat variabila locala offerListSize = cu valoare size de offer list
        int offerListSize = offerList.size();

        //initializare for loop
        for (int i = 0; i < offerListSize; i++) {

            //Declarat variabila tip string offerList, get i + get Text
            String valueOffer = offerList.get(i).getText();

            //Setter lista offerte cu valoarea i -ului
            this.listaOfertePosition = i;

            if (getSectorList().contains("Sectorul 6") || (getSectorList().contains("Sectorul 5"))) {
                continue;
            } else {
                int start = getSectorList().indexOf(",");
                System.out.println(valueOffer + " -" + getSectorList().substring(start + 1));
            }

        }
    }

    //Getter pt lista oferte position
    public int getListaOfertePosition() {
        return listaOfertePosition;
    }

    //Get sector list de tip string cu return value = sectorList.getter. get text
    public String getSectorList() {
        return sectorList.get(getListaOfertePosition()).getText();
    }

    public void iterateThroughPagesAndPrint() {
        int pageNr = 1;
        while (nextBtn.isPresent()) {
            System.out.println();
            System.out.println("Page number is " + pageNr++ + " " + getDriver().getCurrentUrl());
            GeneralMethods.clickBtn(nextBtn, "next");
            printApartmentList();
        }
    }

    // TODO: 8/16/2021 Solve Stale element exception problem

}
