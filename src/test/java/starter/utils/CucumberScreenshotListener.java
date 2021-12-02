package starter.utils;

import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.plugin.ConcurrentEventListener;
import io.cucumber.plugin.event.EventPublisher;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

import static net.serenitybdd.core.Serenity.getDriver;

public class CucumberScreenshotListener implements ConcurrentEventListener {

    /** PT ADAUGARE SCREENSHOT IN TEST RUNNER
     plugin = {"starter.utils.CucumberScreenshotListener"},
     ** PT dechidere fisier doar in explorer
     *  Editor -> File Types -> Images -> Remove extention
    **/

    @Override
    public void setEventPublisher(EventPublisher eventPublisher) {

    }

    @AfterStep
    public void afterCucumberMethod(Scenario scenario) {
        if (scenario.isFailed()) {
            String scenarioName = scenario.getName();
            String screenShot = CaptureScreenShot.captureScreen(getDriver());
            byte[] fileContent = new byte[0];
            try {
                File screenshotFile = new File(screenShot);
                fileContent = FileUtils.readFileToByteArray(screenshotFile);
            } catch (IOException ioe) {
                LoggerClass.info("" + ioe);
            }
//                scenario.log("scenarioName " + scenarioName + NEW_LINE);
            scenario.attach(fileContent, "image/png", scenarioName);
        }

    }
}
