package com.grayzemon.systemtest.utils;

/**
 * Created by Graham.Smith on 18/Oct/2017
 **/

import cucumber.api.Scenario;
import org.openqa.selenium.WebDriver;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.screentaker.ViewportPastingStrategy;

import javax.imageio.ImageIO;
import java.awt.image.RasterFormatException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import static com.grayzemon.systemtest.utils.LoggingFactory.*;

public class Screenshot {

    public final WebDriver webDriver;

    public Screenshot(final WebDriver webdriver) {
        this.webDriver=DriverUtils.getWebDriver ();
    }

    /**
     * Takes a screenshot in png image format after each scenario.
     * Screenshots are placed in the \target\screenshots\ folder.
     * Passed or Failed scenarios are put in a seperate subfolder with YYYY-MM-DD timestamp.
     * @param scenario Cucumber scenario object
     * @throws IOException
     */
    public static void takeScreenshotAfterEveryScenario(Scenario scenario) throws IOException {

        if (DriverUtils.isDriverPresent ()) {
            String currentDir=null;
            final String timeStamp=new SimpleDateFormat ("yyyyMMdd_HHmmss").format (Calendar.getInstance ().getTime ());
            DateFormat dateFormat=new SimpleDateFormat ("yyyy-MM-dd");
            String Today=dateFormat.format (new Date ());
            try {
                if (scenario.isFailed ())
                    currentDir=System.getProperty ("user.dir") + "/target/screenshots/FailedTests_" + Today;
                else currentDir=System.getProperty ("user.dir") + "/target/screenshots/Passed_" + Today;
                ru.yandex.qatools.ashot.Screenshot screenshot=new AShot ().shootingStrategy (new ViewportPastingStrategy (1000)).takeScreenshot (DriverUtils.getWebDriver ());
                Path screenshotDirPath=Paths.get (currentDir);
                if (Files.notExists (screenshotDirPath)) Files.createDirectories (screenshotDirPath.toAbsolutePath ());
                Path screenshotFilePath=screenshotDirPath.resolve (scenario.getName () + "_" + timeStamp + ".png");
                ImageIO.write (screenshot.getImage (), "PNG", screenshotFilePath.toFile ());
            } catch (RasterFormatException rfe) {
                log.error("Rastor Format exception" + rfe.getMessage()); //error not thrown to getround firefox rastor issue
            } catch (final IOException e1) {
                throw new TestException ("Failed to create screenshot after scenario" + scenario.getName (), e1 );
            } catch (Exception e) {
                log.info("Some other exception");
                throw new TestException ("Failed to create screenshot" , e );
            }
        }
    }

    /**
     * For taking an adhoc screenshot in png image format with custom filename.
     * Screenshots are placed in the \target\screenshots\Ad Hoc_YYYY-MM-DD folder.
     * @param screenshotName filename to be used for the screenshot. Note a datestamp is automatically appended
     */
    public static void takeScreenshot(String screenshotName) {
        DateFormat dateFormat=new SimpleDateFormat ("yyyy-MM-dd");
        String Today=dateFormat.format (new Date ());
        final String timeStamp=new SimpleDateFormat ("yyyyMMdd_HHmmss").format (Calendar.getInstance ().getTime ());
        try {
            String currentDir = System.getProperty("user.dir") + "/target/screenshots/Ad hoc_" + Today + "/";
            ru.yandex.qatools.ashot.Screenshot screenshot = new AShot().shootingStrategy(new ViewportPastingStrategy(1000)).takeScreenshot(DriverUtils.getWebDriver());
            Path screenshotDirPath = Paths.get(currentDir);
            if (Files.notExists(screenshotDirPath)) Files.createDirectories(screenshotDirPath.toAbsolutePath());
            Path screenshotFilePath = screenshotDirPath.resolve(screenshotName + "_" + timeStamp + ".png");
            ImageIO.write(screenshot.getImage(), "PNG", screenshotFilePath.toFile());
        } catch (RasterFormatException rfe) {
            log.error("Rastor Format exception" + rfe.getMessage());
        } catch (final IOException e1) {
            log.error("IO Exception");
            throw new TestException ("Failed to create screenshot" + screenshotName, e1 );
        } catch (Exception e) {
            log.info("Some other exception");
            throw new TestException ("Failed to create screenshot" + screenshotName, e );
        }
    }
}
