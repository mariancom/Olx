package starter.steps;

import net.thucydides.core.annotations.Step;
import starter.pages.OLX_Page;

public class OLX_Steps {

    OLX_Page olx_page;

    @Step
    public void olx_navigation(){
        olx_page.navigateToOLXSite();
        olx_page.acceptData();
    }

    @Step
    public void olx_searchingApartments(){
        olx_page.selectAreaAndSection();
        olx_page.settingPriceAndSurface();
    }

    @Step
    public void olx_printing_list(){
        olx_page.printApartmentList();
        olx_page.iterateThroughPagesAndPrint();
    }

}
