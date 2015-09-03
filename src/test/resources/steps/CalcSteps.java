package steps;

/**
 * Created with IntelliJ IDEA.
 * User: Igor
 * Date: 8/26/15
 * Time: 1:32 PM
 * To change this template use File | Settings | File Templates.
 */

import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
//import gherkin.formatter.model.Scenario;

import gherkin.formatter.model.Scenario;
import infra.Calc;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CalcSteps {
    private Calc calc;

    @Given("^a calculator I just turned on$")
    public void a_calculator_I_just_turned_on() {
        calc = new Calc();
    }

    @When("^I add (\\d+) and (\\d+)$")
    public void adding(int arg1, int arg2) {
        calc.push(arg1);
        calc.push(arg2);
        calc.push("+");
    }

    @Given("^I press (.+)$")
    public void I_press(String what) {
        calc.push(what);
    }

    @Then("^the result is (\\d+)$")
    public void the_result_is(double expected) {
        assertEquals(expected, calc.value());
    }

/*   @Before()//({"~@foo"})
    public void before() {
       // calc = new Calc();
        System.out.println("Runs before scenarios *not* tagged with @foo");
    }*/

   /* @After
    public void after(Scenario scenario) {
         //result.write("HELLLLOO");


    }*/

    @Given("^the previous entries:$")
    public void thePreviousEntries(List<Entry> entries) {
        for (Entry entry : entries) {
            calc.push(entry.first);
            calc.push(entry.second);
            calc.push(entry.operation);
        }
    }

    public class Entry {
        Integer first;
        Integer second;
        String operation;
    }


}