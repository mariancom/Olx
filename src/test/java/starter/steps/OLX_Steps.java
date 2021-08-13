package starter.steps;

import net.thucydides.core.annotations.Steps;
import starter.pages.OLX_Page;

public class OLX_Steps {

    @Steps
    OLX_Page olx_page;

    public void olx_navigation(){
        olx_page.navigateToOLXSite();
        olx_page.acceptData();
    }

    public void olx_searchingApartments(){
        olx_page.selectAreaAndSection();
        olx_page.settingPriceAndSurface();
    }

    public void olx_printing_list(){
        olx_page.printApartmentList();
    }

}
