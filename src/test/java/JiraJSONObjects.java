import org.json.simple.JSONObject;

public class JiraJSONObjects {


    public static String newIssueJSON() {
        JSONObject newIssueJSON = new JSONObject();
        JSONObject fields = new JSONObject();
        fields.put("summary", "Test Summary");
        JSONObject issuetype = new JSONObject();
        issuetype.put("id", "10107");
        JSONObject project = new JSONObject();
        project.put("id", "11400");
        JSONObject assignee = new JSONObject();
        assignee.put("name", "webinar5");

        fields.put("issuetype", issuetype);
        fields.put("project", project);
        fields.put("assignee", assignee);

        newIssueJSON.put("fields", fields);
        return newIssueJSON.toJSONString();
    }

}