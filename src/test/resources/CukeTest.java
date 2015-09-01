import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created with IntelliJ IDEA.
 * User: Igor
 * Date: 8/24/15
 * Time: 1:03 PM
 * To change this template use File | Settings | File Templates.
 */


@RunWith(Cucumber.class)
@Cucumber.Options(features = "classpath:cuke.feature",format = {"pretty", "html:target/cucumber-html-report"})
/*@Cucumber.Options(
       // format = {"pretty"}

        //glue = {"com.lebara.stepdefs","com.lebara.framework.main", "com.lebara.testrunner"},
        //glue =   {"src.test.resources"},
        features = "C:/Cucumber/src/test/resources",
          //  features = "classpath:cucumber",
        //features = "C:\\Cucumber\\src\\test\\resources",
        format = {"pretty", "html:target/cucumber-html-report", "json-pretty:target/cucumber-report.json"},
        tags = {"@sample1"}
)*/
public class CukeTest {

   // CukeExe cukeExe = new CukeExe();


}
