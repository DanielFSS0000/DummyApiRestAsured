package intereactions;


import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.rest.interactions.Post;

public class PostDummyApi implements Interaction {
    public static Performable on() {
        return Instrumented.instanceOf(PostDummyApi.class).withProperties();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        System.out.println("Method Post:");
        String json = "{\n" +
                "    \"status\": \"success\",\n" +
                "    \"data\": {\n" +
                "        \"name\": \"test\",\n" +
                "        \"salary\": \"123\",\n" +
                "        \"age\": \"23\",\n" +
                "        \"id\": 25\n" +
                "    }\n" +
                "}";
        actor.attemptsTo(Post.to("api/v1/create")
                .with(request -> request.header("Content-Type", "application/json")
                        .header("Accept","*/*")
                        .body(json)
                )
        );
        System.out.println("Response POST: " + SerenityRest.lastResponse().asString());

    }
}
