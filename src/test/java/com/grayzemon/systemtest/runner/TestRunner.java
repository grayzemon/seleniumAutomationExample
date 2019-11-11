package com.grayzemon.systemtest.runner;

import com.cucumber.listener.ExtentProperties;
import com.cucumber.listener.Reporter;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features"},
        glue = {"com.grayzemon.systemtest.steps","com.grayzemon.systemtest.hooks"},
        tags={"@loginTestFeature"} ,
        plugin = {"com.cucumber.listener.ExtentCucumberFormatter:"})

public class TestRunner {

    @BeforeClass
    public static void setup() {
        final String userPath = System.getProperty("user.dir");
        final String reporterPath = userPath + "\\target/report/";
        final String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        final String pathname = reporterPath + "Interviewee Automation Report " + timeStamp + ".html";
        ExtentProperties extentProperties = ExtentProperties.INSTANCE;
        extentProperties.setReportPath(pathname);
    }

    @AfterClass
    public static void teardown() {
        final String userPath = System.getProperty("user.dir");
        final String configLocation = userPath + "/src/main/resources/extent-config.xml";
        Reporter.loadXMLConfig(new File(configLocation));
        Reporter.setSystemInfo("user", System.getProperty("user"));
        Reporter.setSystemInfo("os", System.getProperty("os.name"));
    }

}

