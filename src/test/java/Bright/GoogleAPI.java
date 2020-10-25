package Bright;

import extraResource.Payload;
import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

public class GoogleAPI
{


    @Test
    public void postDemo()
    {
        given().baseUri("https://rahulshettyacademy.com").contentType(ContentType.JSON)
               /* .body("{\n" +
                "  \"location\": {\n" +
                "    \"lat\": -38.383494,\n" +
                "    \"lng\": 33.427362\n" +
                "  },\n" +
                "  \"accuracy\": 50,\n" +
                "  \"name\": \"Frontline house\",\n" +
                "  \"phone_number\": \"(+91) 983 893 3937\",\n" +
                "  \"address\": \"29, side layout, cohen 09\",\n" +
                "  \"types\": [\n" +
                "    \"shoe park\",\n" +
                "    \"shop\"\n" +
                "  ],\n" +
                "  \"website\": \"http://google.com\",\n" +
                "  \"language\": \"French-IN\"\n" +
                "}\n")*/
                .body(Payload.GoogleAPIPost())
                .when().post("/maps/api/place/add/json?key =qaclick123")
                .then().log().all()
                .assertThat().statusCode(200).and().body("scope",is("APP")).and().contentType(ContentType.JSON);
    }


    @Test
    public void putDemo()
    {
        given().baseUri("https://rahulshettyacademy.com").contentType(ContentType.JSON)
                .body("{\n" +
                        "\"place_id\":\"e5fd03b118a283a8091eefc32c9d9040\",\n" +
                        "\"address\":\"80 Summer walk, USA\",\n" +
                        "\"key\":\"qaclick123\"\n" +
                        "}\n")
                .when().put("/maps/api/place/add/json?key =qaclick123")
                .then().log().all()
                .assertThat().statusCode(200).and().contentType(ContentType.JSON);
    }

    @Test
    public void deleteDemo()
    {
        given().baseUri("https://rahulshettyacademy.com").contentType(ContentType.JSON)
                .body("{\n" +
                        "    \"place_id\":\"e5fd03b118a283a8091eefc32c9d9040\"\n" +
                        "}\n")
                .when().delete("/maps/api/place/delete/json?key =qaclick123")
                .then().log().all()
                .assertThat().statusCode(200).and().body("status",is("OK")).and().contentType(ContentType.JSON);
    }
}
