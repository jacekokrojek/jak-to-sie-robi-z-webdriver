import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class SampleTest {
    private ApiService api = new ApiService();

    @Test
    public void getTest() throws UnirestException {
        HttpResponse<JsonNode> response = api.get("posts");
        int responseStatus = response.getStatus();
        JsonNode responseBody = response.getBody();

        assertThat(responseStatus, equalTo(200));
        assertThat(responseBody, is(instanceOf(JsonNode.class)));
    }

    @Test
    public void postTest() throws  UnirestException {
        JSONObject obj = new JSONObject();
        obj.put("text", "Test text");
        obj.put("body", "Test body");
        obj.put("userId", "101");
        System.out.println(obj);

        HttpResponse<JsonNode> resp = api.post("posts", obj);

        assertThat(resp.getStatus(), equalTo(201));
        assertThat(resp.getBody().toString(), containsString("id"));
    }
}
