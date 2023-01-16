package co.com.choucair.stepdefinitions;


import intereactions.GetDummyApi;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;
import questions.StatusApi;

import java.io.IOException;

public class DummyApiStepDefinitions {

    @Before
    public void before() throws IOException {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("As a user I have the dummy apis that I want to validate")
    public void asAUserIHaveTheDummyApisThatIWantToValidate() {
        OnStage.theActorCalled("Daniel").whoCan(CallAnApi.at("https://dummy.restapiexample.com/"));

    }

    @When("User verify the crud service of the apis")
    public void userVerifyTheCrudServiceOfTheApis() {
        OnStage.theActorInTheSpotlight().attemptsTo(
                GetDummyApi.on()
                //La api no permite hacer mas de un solo request.
                //para probrar, GET,POST,PUT y Delete eliminar comentario y ejecutar solo una
                //Aca solo funcionaria GET.

                //PostDummyApi.on()
                //PutDummyApi.on()
                //DeleteDummyApi.on()
        );
    }

    @Then("receive a status {int}")
    public void receiveAStatus(Integer int1) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(StatusApi.result(String.valueOf(int1))));
    }
}
