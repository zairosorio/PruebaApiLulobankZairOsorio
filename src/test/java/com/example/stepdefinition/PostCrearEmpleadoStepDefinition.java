package com.example.stepdefinition;

import com.example.automation.model.PostCreateEmpleadoModel;
import com.example.automation.task.PostCreateEmpleadosTask;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.Matchers.equalTo;

public class PostCrearEmpleadoStepDefinition {

    @Before
    public void setUp() {
        OnStage.setTheStage(Cast.ofStandardActors());
    }

    @When("configuro el cuerpo y realizo la peticion post al servicio con el recurso (.*)$")
    public void configuroElCuerpoYRealizoLaPeticionPostAlServicioConElRecursoCreate(String resources, Map<String, String> body) {
        System.out.println(body);
        theActorInTheSpotlight().attemptsTo(PostCreateEmpleadosTask.postCreateEmpleadosTask(resources, body));
    }
    @Then("valido contenido (.*)(.*)$")
    public void validoContenido(String etiqueta, String valor){
        SerenityRest.lastResponse().then().body(etiqueta,equalTo(valor));
    }
}
