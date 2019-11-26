import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.text.MatchesPattern;
import org.testng.annotations.Test;
import java.util.regex.Pattern;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class JIRAApiTest {

  @Test
  public void getExistingIssue() {

    Response response =
            given().
                    auth().preemptive().basic("webinar5", "webinar5").
                    when().
                    get("http://jira.hillel.it/rest/api/2/issue/WEBINAR-8887").
                    then().
                    extract().response();

    assertEquals(200, response.statusCode());
    assertEquals("WEBINAR-8887", response.path("key"));
    final Matcher<String> matcher = new MatchesPattern(Pattern.compile("[A-Z]+\\-[0-9]+"));
    assertTrue(matcher.matches("WEBINAR-8887"));
  }

  @Test
  public void createIssue() {

    String issueJson = "{\n" +
            "    \"fields\": {\n" +
            "        \"project\": {\n" +
            "            \"id\": \"11400\"\n" +
            "        },\n" +
            "        \"summary\": \"Test API\",\n" +
            "        \"issuetype\": {\n" +
            "            \"name\": \"Bug\"\n" +
            "        },\n" +
            "        \"assignee\": {\n" +
            "            \"name\": \"webinar5\"\n" +
            "        },\n" +
            "        \"reporter\": {\n" +
            "            \"name\": \"webinar5\"\n" +
            "        }\n" +
            "    }\n" +
            "}";
    Response response = given().
            auth().preemptive().basic("webinar5", "webinar5").
            header("Content-Type", "application/json").
            body(issueJson).
            when().
            post("https://jira.hillel.it/rest/api/2/issue").
            then().
            extract().response();
    assertEquals(201, response.statusCode());
  }

  @Test
  public void deleteIssue() {

    // TODO 1) Create Issue
    // TODO 2) response.path("")  вытащить из ответа номер тикета
    // TODO 3) удалить тикет
    //TODO 4) попробовать получить тикет и получить 404

    Response response = given().
            auth().preemptive().basic("webinar5", "webinar5").
            when().
            delete("https://jira.hillel.it/rest/api/2/issue/" + + "").
            then().
            extract().response();
    assertEquals(204, response.statusCode());

  }
}