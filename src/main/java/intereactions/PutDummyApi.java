package intereactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Put;

public class PutDummyApi implements Interaction {


    public static Performable on() {
        return Instrumented.instanceOf(PutDummyApi.class).withProperties();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("Mehtod Put:");
        String json = "{\n" +
                "    \"status\": \"success\",\n" +
                "    \"data\": {\n" +
                "        \"name\": \"test\",\n" +
                "        \"salary\": \"123456\",\n" +
                "        \"age\": \"66\",\n" +
                "        \"id\": 25\n" +
                "    }\n" +
                "}";
        actor.attemptsTo(Put.to("api/v1/update/25")
                .with(request -> request.header("Content-Type", "application/json")
                        .header("Accept","*/*")
                        .body(json))
        );
        System.out.println("Response PUT: "+ SerenityRest.lastResponse().asString());
    }
}
