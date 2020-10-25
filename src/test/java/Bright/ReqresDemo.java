package Bright;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItems;

public class ReqresDemo
{
    @Test
    public void getListUsers()
    {
        given().baseUri("https://reqres.in/")
                .when().get("/api/users?page=2")
                .then().log().all()
                .assertThat().body("data.id",hasItems(7,8,9)).and().body("data.email",hasItems("michael.lawson@reqres.in")).and().statusCode(200).and().contentType(ContentType.JSON);
    }
}
