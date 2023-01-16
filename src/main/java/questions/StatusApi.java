package questions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class StatusApi implements Question<Boolean>{

    private String status;

    public StatusApi(String status){
        this.status = status;
    }
    public static StatusApi result(String status){
        return new StatusApi(status);
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return String.valueOf(SerenityRest.lastResponse().statusCode()).equals(status);
    }
}
