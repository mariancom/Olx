package starter.utils;

import jxl.common.AssertionFailed;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;


@SuppressWarnings("ALL")
public class LoggerClass {
    public static final Logger LOGGER = LogManager.getLogger(LoggerClass.class);

    private static final String LOG_PATTERN = " \"%s\"";

    private LoggerClass() {
    }

    public static String error(String message) {
        LOGGER.error(String.format(LOG_PATTERN, message));
        return String.format(LOG_PATTERN, message);
    }

    public static String pass(String message) {
        LOGGER.log(Level.forName("PASS", 400), (String.format(LOG_PATTERN, message)));
        return String.format(LOG_PATTERN, "Assert " + message);
    }

    public static void info(String message) {
        LOGGER.info(String.format(LOG_PATTERN, message));
        String.format(LOG_PATTERN, message);
    }

    public static String test(String message) {
        LOGGER.log(Level.forName("TEST", 400), (String.format(LOG_PATTERN, message)));
        return String.format(LOG_PATTERN, message);
    }

    public static String warn(String message) {
        LOGGER.warn(String.format(LOG_PATTERN, message));
        return String.format(LOG_PATTERN, message);
    }

    public static String debug(String message) {
        LOGGER.debug(String.format(LOG_PATTERN, message));
        return String.format(LOG_PATTERN, message);
    }

    public static String trace(String message) {
        LOGGER.trace(String.format(LOG_PATTERN, message));
        return String.format(LOG_PATTERN, message);
    }

    public static String fail(String message) {
        LOGGER.error(String.format(LOG_PATTERN, message));
        throw new AssertionFailed(message);
    }

    public static String fatal(String message) {
        LOGGER.fatal(String.format(LOG_PATTERN, message));
        return String.format(LOG_PATTERN, message);
    }

    @Test
    public void colorsTest() {
        System.out.println("System out text");
        LoggerClass.info("Info text");
        LoggerClass.test("Test text"); //pt informatii folositoare
        LoggerClass.warn("Warn text"); //de monitorizat
        LoggerClass.error("Error text");
        LoggerClass.debug("Debug text"); // pt informatii folositoare doar temporar (alta culoare)
        LoggerClass.trace("Trace text");
        LoggerClass.fatal("Fatal text");
        LoggerClass.pass("Pass message");

        /*###########LOGGER CLASS DEPENDENCIES###############
        *  <!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-api -->
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-api</artifactId>
            <version>2.14.1</version>
        </dependency>


        <!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core -->
        <dependency>
            <groupId>org.apache.logging.log4j</groupId>
            <artifactId>log4j-core</artifactId>
            <version>2.14.1</version>
        </dependency>
        *
        * Fisiere: LoggerClass, log4j.properties, log4j2.xml*/
    }
}
