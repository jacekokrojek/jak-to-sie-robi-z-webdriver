import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONObject;

public class ApiService {

    public HttpResponse<JsonNode> get(String endpoint) throws UnirestException {
        return Unirest.get(Config.apiUrl + endpoint).asJson();
    }

    public HttpResponse<JsonNode> post(String endpoint, JSONObject requestBody) throws UnirestException {
        return Unirest.post(Config.apiUrl + endpoint)
                .body(requestBody)
                .asJson();
    }
}
