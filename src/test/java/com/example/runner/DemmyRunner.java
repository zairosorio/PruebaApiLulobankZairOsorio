package com.example.runner;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;


@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/feature/demmy_api.feature",
        glue = "com.example.stepdefinition",
        tags = " @DeleteEmpleados or @PostCreate or @GetEmpleados",
        snippets = CucumberOptions.SnippetType.CAMELCASE

)


public class DemmyRunner {
}
