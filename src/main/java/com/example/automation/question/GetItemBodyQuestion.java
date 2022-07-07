package com.example.automation.question;

import io.restassured.response.ResponseBody;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class GetItemBodyQuestion implements Question<ResponseBody> {

    private String etiqueta;
    private String valor;

    public GetItemBodyQuestion(String etiqueta, String valor) {
        this.etiqueta = etiqueta;
        this.valor = valor;
    }

    @Override
    public ResponseBody answeredBy(Actor actor) {
        return SerenityRest.lastResponse().getBody();
    }


}


