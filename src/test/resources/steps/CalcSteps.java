package steps;

/**
 * Created with IntelliJ IDEA.
 * User: Igor
 * Date: 8/26/15
 * Time: 1:32 PM
 * To change this template use File | Settings | File Templates.
 */

import cucumber.annotation.After;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import infra.Calc;
import net.masterthought.cucumber.ReportBuilder;
import org.junit.AfterClass;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

//import gherkin.formatter.model.Scenario;

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

   /* @AfterClass
    public void after(){
        try {
            CucumberResultsOverview results = new CucumberResultsOverview();
            results.setOutputDirectory("target");
            results.setOutputName("cucumber-results");
            results.setSourceFile(".target/cucumber-html-report/report.json");
            results.executeFeaturesOverviewReport();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }*/


    @After
    public void after(){
        try {
            File reportOutputDirectory = new File("target");
            List<String> list = new ArrayList<String>();
            list.add("cucumber-report.json");
            list.add("cucumber-report2.json");

            String pluginUrlPath = "";
            String buildNumber = "1";
            String buildProject = "cucumber-jvm";
            boolean skippedFails = true;
            boolean pendingFails = true;
            boolean undefinedFails = true;
            boolean missingFails = true;
            boolean flashCharts = true;
            boolean runWithJenkins = false;
            boolean artifactsEnabled = false;
            String artifactConfig = "";
            boolean highCharts = false;
            boolean parallelTesting = false;

            ReportBuilder reportBuilder = new ReportBuilder(list, reportOutputDirectory, pluginUrlPath, buildNumber,
                    buildProject, skippedFails, pendingFails, undefinedFails, missingFails, flashCharts, runWithJenkins, artifactsEnabled,
                    artifactConfig, highCharts, parallelTesting);
            reportBuilder.generateReports();
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }

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