package tests;

/**
 * Created with IntelliJ IDEA.
 * User: Igor
 * Date: 8/26/15
 * Time: 1:36 PM
 * To change this template use File | Settings | File Templates.
 */

import cucumber.junit.Cucumber;
import infra.Calc;
import org.junit.runner.RunWith;
import steps.CalcSteps;

@RunWith(Cucumber.class)
@Cucumber.Options(
        features = {"classpath:features/calc.feature"},         //features/calc.feature
        format = {"pretty", "html:target/cucumber-html-report"} ,glue =   {"infra","steps"}


)

public class CalcTest {

}