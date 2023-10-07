package com.agileprocrm.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

    @RunWith(Cucumber.class)
    @CucumberOptions(

            plugin= {"pretty",
                    "html:target/cucumber-reports.html",
                    "rerun:target/rerun.txt",
                    "me.jvt.cucumber.report.PrettyReports:target/cucumber",
                    "json:target/cucumber.json"
            },
            features = "src/test/resources/features",
            glue =  "com/agileprocrm/step_definitions",
            dryRun = false,
            tags = "@SCRUM-1267",
            //kimi istiyorsak onun tag ini yazalım

            //and olunca 2 koşul da sağlanmalı sağlanmıyorsa çalışmaz
            //or da biri olsa yeter çalışır. ikis de vars aikisi de çalışır
            //and not smoke and not student ise -->smoke lu olanlar çalışacak ama student yazan hariç

            publish = true
    )

    public class CukesRunner {}

