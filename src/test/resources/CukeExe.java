import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.annotation.en.And;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.runtime.PendingException;
import gherkin.formatter.model.Background;

import static junit.framework.TestCase.assertTrue;

/**
 * Created with IntelliJ IDEA.
 * User: Igor
 * Date: 8/24/15
 * Time: 1:05 PM
 * To change this template use File | Settings | File Templates.
 */
public class CukeExe {

    //@Given("aaa")
    public void testCuke1() {System.out.println("aaa");}

   // @When("bbb")
    public void testCuke2() {System.out.println("bbb");}

    //@Then("ccc")
    public void testCuke3() {System.out.println("ccc");}


    @Before
    public void beforeScenario(){}

    @After
    public void afterScenario(){}

    @Given("^Test \"([^\"]*)\"$")
    public void Test(String arg1) throws Throwable {
        // Express the Regexp above with the code you wish you had
        //throw new PendingException();

        System.out.println("Given");
    }

    @When("^I start CukeTest \"([^\"]*)\"$")
    public void I_start_CukeTest(String arg1) throws Throwable {
        // Express the Regexp above with the code you wish you had
        //throw new PendingException();

        System.out.println("When");
    }

    @Then("^I report \"([^\"]*)\"$")
    public void I_report(String arg1) throws Throwable {
        // Express the Regexp above with the code you wish you had

        System.out.println("Then");
        //throw new PendingException();
    }


    @Given("^Test : |Sanity| |Regression| |Stress|$")
    public void Test_Sanity_Regression_Stress() throws Throwable {
        // Express the Regexp above with the code you wish you had
       // throw new PendingException();
    }




    @Given("^_cuke I follow \"([^\"]*)\"$")
    public void I_follow(String arg1) throws Throwable {
        // Express the Regexp above with the code you wish you had
       // throw new PendingException();
    }

    @When("^_cuke I fill in \"([^\"]*)\" with \"([^\"]*)\"$")
    public void I_fill_in_with(String arg1, String arg2) throws Throwable {
        // Express the Regexp above with the code you wish you had
        //throw new PendingException();
    }

    @When("^_cuke I click \"([^\"]*)\"$")
    public void _cuke_I_click(String arg1) throws Throwable {
        // Express the Regexp above with the code you wish you had
        //throw new PendingException();
    }


   @Then("^_cuke I should see the inline error \"([^\"]*)\" for \"([^\"]*)\" with value \"([^\"]*)\"$")
    public void I_should_see_the_inline_error_for(String error, String field,String value) throws Throwable {
        // Express the Regexp above with the code you wish you had
       // throw new PendingException();

       // assertTrue("Account Number Can't be blank " + arg1 + " " +arg2,arg1.isEmpty());
        if (value.isEmpty() || value == null || value.length()>12 || !java.util.regex.Pattern.matches("\\d+", value))  //!value.matches("\\d+");
            assertTrue(error + " in " + field + " field",false);

    }

    //@Background
    //@And()
}
