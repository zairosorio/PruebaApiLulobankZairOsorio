package com.example.stepdefinition;

import com.example.automation.question.ResponseCodeQuestion;
import com.example.automation.task.GetObtenerEmpleadosTask;
import com.example.automation.utils.GetProperties;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.Ensure;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matchers;
import org.junit.Assert;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.*;
import static org.hamcrest.Matchers.equalTo;

public class GetObtenetEmpleadosStepDefinition {

    @Before
    public void setUp() {
        OnStage.setTheStage(Cast.ofStandardActors());
    }

    @Given("configuro la url base")
    public void configuroLaUrlBase() {
        GetProperties.configProperties();
        OnStage.theActorCalled("zair").
                whoCan(CallAnApi.at(GetProperties.properties.getProperty("url_base").trim()));
    }

    @When("realizo la peticion al servicio con el recurso (.*)$")
    public void realizoLaPeticionAlServicioConElRecurso(String resources) {
        theActorInTheSpotlight().attemptsTo(
                GetObtenerEmpleadosTask.to(resources.trim())
        );
    }

    @Then("valido que el codigo de status sea {int}")
    public void validoQueElCodigoDeStatusSea(Integer status) {
        Assert.assertThat(SerenityRest.lastResponse().getStatusCode(), Matchers.equalTo(status));
        SerenityRest.lastResponse().then().body("status", equalTo("success"));
    }

}
