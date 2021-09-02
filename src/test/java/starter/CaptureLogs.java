package starter;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;


public class CaptureLogs {
    static ChromeDriver driver;

        public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver",
                "src/test/resources/webdriver/chromedriver.exe");

        ChromeOptions cop = new ChromeOptions();

        LoggingPreferences loggingprefs = new LoggingPreferences();
        loggingprefs.enable(LogType.BROWSER, Level.ALL);
        loggingprefs.enable(LogType.CLIENT, Level.ALL);
        loggingprefs.enable(LogType.PERFORMANCE, Level.ALL);
        loggingprefs.enable(LogType.PROFILER, Level.ALL);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setCapability(CapabilityType.LOGGING_PREFS, loggingprefs);
        cop.setCapability("goog:loggingPrefs", loggingprefs);

        cop.merge(chromeOptions);
        driver = new ChromeDriver(cop);
        driver.get("https://www.olx.ro/");

        logBrowserConsoleLogs();


    }

    public static void logBrowserConsoleLogs() {

        all(LogType.PERFORMANCE);

    }

    public static void all(String logTypes) {
        System.out.println("================== " + logTypes + "  LOGS =======================");

        List<LogEntry> logEntries = driver.manage().logs().get(logTypes).getAll();
        for (LogEntry entry : logEntries) {
            System.out.println(new Date(entry.getTimestamp()) + " " + entry.getLevel() + " " + entry.getMessage());
        }
        System.out.println("=======================================================");
    }
}