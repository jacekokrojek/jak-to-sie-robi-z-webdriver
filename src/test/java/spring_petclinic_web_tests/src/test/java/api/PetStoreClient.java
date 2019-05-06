package spring_petclinic_web_tests.src.test.java.api;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;

import static spring_petclinic_web_tests.src.test.java.tests.Config.apiUrl;

public class PetStoreClient {

    private CloseableHttpClient client;

    public PetStoreClient(){
        this.client = HttpClients.createDefault();
    }

    public JSONObject addOwner(JSONObject owner) throws IOException {
        HttpPost httpPost = new HttpPost(apiUrl + "/petclinic/api/owners");

        StringEntity entity = new StringEntity(owner.toString());
        httpPost.setEntity(entity);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        CloseableHttpResponse response = client.execute(httpPost);

        String bodyAsString = EntityUtils.toString(response.getEntity());
        JSONObject o = new JSONObject(bodyAsString);
        client.close();
        return o;

    }

    public JSONArray getOwners() throws ClientProtocolException, IOException {

        HttpGet httpGet = new HttpGet(apiUrl + "/petclinic/api/owners");
        httpGet.setHeader("Accept", "application/json");
        CloseableHttpResponse response = client.execute(httpGet);

        String bodyAsString = EntityUtils.toString(response.getEntity());
        System.out.println("bodyAsString = " + bodyAsString);
        JSONArray owners = new JSONArray(bodyAsString);

        client.close();
        return owners;
    }

    public JSONArray findOwners(String text) throws ClientProtocolException, IOException{

        HttpGet httpGet = new HttpGet(apiUrl + "/petclinic/api/owners/*/lastname/" + text);
        httpGet.setHeader("Accept", "application/json");
        CloseableHttpResponse response = client.execute(httpGet);

        String bodyAsString = EntityUtils.toString(response.getEntity());
        System.out.println("bodyAsString = " + bodyAsString);
        JSONArray owners = new JSONArray(bodyAsString);

        client.close();
        return owners;

    }
}
