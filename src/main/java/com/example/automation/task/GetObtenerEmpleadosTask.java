package com.example.automation.task;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.interactions.RestInteraction;
import net.thucydides.core.annotations.Step;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;


public class GetObtenerEmpleadosTask extends RestInteraction {

    private final String resource;

    public GetObtenerEmpleadosTask(String resource) {
        this.resource = resource;
    }

    @Step("{0} resource")
    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().log().all().get(as(actor).resolve(resource));
    }

    public static GetObtenerEmpleadosTask to(String resource) {
        return instrumented(GetObtenerEmpleadosTask.class, resource);
    }
}
