package com.example.automation.task;

import net.serenitybdd.screenplay.Actor;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.rest.abilities.CallAnApi.as;

import net.serenitybdd.screenplay.rest.interactions.RestInteraction;

import java.util.Map;

public class PostCreateEmpleadosTask extends RestInteraction {
    private final String resource;
    private final Map<String, String> body;

    public PostCreateEmpleadosTask(String resource, Map<String, String> body) {
        this.resource = resource;
        this.body = body;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        rest().body(body);
        rest().log().all().post(as(actor).resolve(resource.trim())).then().log().all();
    }
    public static PostCreateEmpleadosTask postCreateEmpleadosTask(String resource, Map<String, String> body) {
        return instrumented(PostCreateEmpleadosTask.class, resource, body);
    }
}
