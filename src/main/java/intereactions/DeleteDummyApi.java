package intereactions;

import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Delete;

public class DeleteDummyApi implements Interaction {
    public static Performable on() {
        return Instrumented.instanceOf(DeleteDummyApi.class).withProperties();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("Method Delete");
        actor.attemptsTo(
                Delete.from("api/v1/delete/25")
                        .with(request -> request.header("Content-Type", "application/json")
                                .header("Accept","*/*"))
        );
        System.out.println("Response DELETE: "+ SerenityRest.lastResponse().asString());
    }
}
