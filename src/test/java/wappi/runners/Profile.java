package wappi.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src\\test\\resources\\features\\wappi\\profile.feature"
        ,glue = "wappi"
        ,snippets = CucumberOptions.SnippetType.CAMELCASE
)
public class Profile {
}
