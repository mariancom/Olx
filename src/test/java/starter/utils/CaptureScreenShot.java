package starter.utils;


import org.apache.commons.io.FileUtils;
import org.assertj.core.util.DateUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.ScreenshotException;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class CaptureScreenShot {
    private static final DateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_SSS");

    private static final String WINDOWS_SS_DIR_WITH_SS_BASE = System.getProperty("user.dir") + "\\Test-ScreenShots";
    private static String WINDOWS_SS_DIR_WITH_SS;

    public static String captureScreen(WebDriver driver) {
        String dest = "";
        String screenshotName = String.valueOf(DateUtil.millisecondOf(DateUtil.tomorrow()));
        String screenshotNameFolder = "target/screenshots";
        try {
            TakesScreenshot screen = (TakesScreenshot) driver;
            File src = screen.getScreenshotAs(OutputType.FILE);

            WINDOWS_SS_DIR_WITH_SS = WINDOWS_SS_DIR_WITH_SS_BASE + "\\" + screenshotNameFolder + screenshotName + ".png";

            dest = getSSDirByPlatform();

            File target = new File(dest);
            try {
                FileUtils.copyFile(src, target);
            } catch (IOException e) {
                LoggerClass.info("error while copy screenshot" + e);
            }
            //putting this here so is easy to find screenshot on fail for easy debugging
            String hyperlinkString = "file://" + target.toURI().getRawPath();
            System.out.println(System.lineSeparator() + "Below is the screenshot: " + System.lineSeparator());
            System.out.println("SCREENSHOT " + System.lineSeparator()  + hyperlinkString);
        } catch (ScreenshotException se) {
            LoggerClass.info("" + se);
        }
        return dest;
    }

    //Select the extent report file location based on platform
    private static String getSSDirByPlatform() {

        return WINDOWS_SS_DIR_WITH_SS;
    }
}