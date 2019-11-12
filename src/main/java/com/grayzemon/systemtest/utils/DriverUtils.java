package com.grayzemon.systemtest.utils;

/**
 * Created by Graham Smith on 02/Oct/2017
 **/

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import static com.grayzemon.systemtest.utils.LoggingFactory.log;

public class DriverUtils {

    public static EventFiringWebDriver webdriver;
    private static String userPath=System.getProperty ("user.dir");
    private static DriverType driverType;
    private static WebDriverEventHandler webDriverEventHandler;

    public enum DriverType {chrome}

    public static DriverType getBrowserType() {
        return driverType;
    }


    private static EventFiringWebDriver getDriverInstance() {

        WebDriver driver = null;
        driverType = DriverType.valueOf ("chrome");


        log.debug("Using browser type: " + driverType.toString());
        switch (driverType) {
            case chrome: {
                System.setProperty ("webdriver.chrome.driver", userPath + "/src/test/resources/drivers/chromedriver.exe");
                HashMap<String, Object> chromePrefs=new HashMap<String, Object> ();
                chromePrefs.put ("profile.default_content_settings.popups", 0);
                ChromeOptions options=new ChromeOptions ();
                options.addArguments ("no-sandbox");
                options.addArguments ("--start-maximized");
                options.setExperimentalOption ("prefs", chromePrefs);
                options.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                options.setCapability(ChromeOptions.CAPABILITY, options);
                System.setProperty ("webdriver.chrome.silentOutput", "true");
                driver=new ChromeDriver (options);
                Capabilities cap2=((RemoteWebDriver) driver).getCapabilities ();
                log.info ("Browser Name    :" + " " + cap2.getBrowserName ());
                log.info ("Browser Version    :" + " " + cap2.getVersion ());
                break;
            }
            default: {
                break;
            }
        }
        webdriver = new EventFiringWebDriver(driver);
        webDriverEventHandler = new WebDriverEventHandler();
        webdriver.register(webDriverEventHandler);
        webdriver.manage ().window ().maximize ();
        int implicitWaitTime = 5;
        webdriver.manage ().timeouts ().implicitlyWait (implicitWaitTime, TimeUnit.SECONDS);
        return webdriver;
    }

    public static WebDriver getWebDriver() {
        if (webdriver==null || webdriver.toString ().contains ("null")) {
            webdriver=DriverUtils.getDriverInstance ();
            log.info ("Creating new driver instance");
        }
        return webdriver;

    }

    static boolean isDriverPresent() {
        return (webdriver!=null && !webdriver.toString ().contains ("null"));
    }

    public static void closeDriver() {
        if (isDriverPresent()) {
            webdriver.unregister(webDriverEventHandler);
            webdriver.quit ();
            webdriver = null;
            log.info ("Closing the driver instance");
        }
    }




}
