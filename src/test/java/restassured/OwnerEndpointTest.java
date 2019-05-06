package restassured;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;
import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.*;
import static io.restassured.path.json.JsonPath.from;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.is;

public class OwnerEndpointTest {

    /**
     * For API dcumentation please visit http://localhost:9966/petclinic/swagger-ui.html
     */

    @Before
    public void setUp() throws Exception {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 9966;
        RestAssured.basePath = "/petclinic";
    }

    @Test
    public void shouldReturnPreDefinedOwners() {
        when().
                get("/api/owners").
                then().
                body("size()", is(10));
    }

    @Test
    public void shouldReturnPreDefinedOwners2() {
        ResponseSpecBuilder builder = new ResponseSpecBuilder();
        builder.expectStatusCode(200);
        ResponseSpecification responseSpec = builder.build();

        Response response = get("/api/owners")
                .then()
                .spec(responseSpec).extract().response();
        String responseBodyString = response.getBody().asString();

        //assertThat(from(responseBodyString).getList("$").size()).isEqualTo(10);
        assertThat(from(responseBodyString).getList("findAll { it.lastName == 'Franklin' }").size()).isEqualTo(1);
        assertThat(from(responseBodyString).getList("findAll { it.lastName == 'Davis' }").size()).isEqualTo(2);

    }

    @Test
    public void shouldAddNewOwner() {
        JSONObject owner = new JSONObject();
        owner.put("id", "0");
        owner.put("firstName", "Singh");
        owner.put("lastName", "simpleuser001");
        owner.put("address", "asasa");
        owner.put("city", "lalla");
        owner.put("telephone", "123456789");
        owner.put("pets", new JSONArray());

        Response response = given().
                contentType("application/json").
                body(owner.toString()).
        when().
                post("/api/owners");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(201, statusCode);
    }

    @Test
    public void shouldAddNewPet() {
        JSONObject owner = new JSONObject();
        owner.put("id", 3);
        owner.put("firstName", "Singh");
        owner.put("lastName", "simpleuser001");
        owner.put("address", "asasa");
        owner.put("city", "lalla");
        owner.put("telephone", "123456789");

        JSONObject type = new JSONObject();
        type.put("id",1);
        type.put("name","sdsdsds");

        JSONObject pet = new JSONObject();
        pet.put("birthDate", "2018/11/24");
        pet.put("id", 0);
        pet.put("name", "Rex");
        pet.put("hasPhoto", "false");
        pet.put("owner", owner);
        pet.put("type", type);
        pet.put("visits", new JSONArray());

        Response response = given().
                contentType("application/json").
                body(pet.toString()).
                when().
                post("/api/pets");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(201, statusCode);
    }

}