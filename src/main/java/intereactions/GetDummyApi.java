package intereactions;


import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Get;

public class GetDummyApi implements Interaction {

    public static Performable on() {
        return Instrumented.instanceOf(GetDummyApi.class).withProperties();}

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("Method get: ");
        actor.attemptsTo(Get.resource("api/v1/employee/6")
                .with(request -> request.header("Content-Type", "application/json")
                        .header("Accept","*/*"))
        );
        System.out.println("Response GET: " + SerenityRest.lastResponse().asString());
    }
}
