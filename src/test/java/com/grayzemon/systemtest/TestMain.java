package com.grayzemon.systemtest;

import static com.grayzemon.systemtest.utils.LoggingFactory.log;

public class TestMain {

    public static void main(String[] args) throws Throwable {
        String tags = "@loginTestFeature";

        if (args.length == 1) {
            tags = args[0];
        }
        log.info("Tags passed in command line: " + tags);

        String[] arguments = {"--tags",tags,
                "--glue","com.grayzemon.systemtest.steps",
                "--glue","com.grayzemon.systemtest.hooks",
                "-p","com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html",
                "src/test/resources/features/"
        };
        cucumber.api.cli.Main.main(arguments);
    }

}
