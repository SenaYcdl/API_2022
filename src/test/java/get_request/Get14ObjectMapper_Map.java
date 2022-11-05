package get_request;

import base_urls.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import test_data.JsonPlaceHolderTestData;
import utils.ObjectMapperUtils;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get14ObjectMapper_Map extends JsonplaceholderBaseUrl {

    /*
        Given
	        https://jsonplaceholder.typicode.com/todos/198
        When
	 		I send GET Request to the URL
	 	Then
	 		Status code is 200
	 		And response body is like {
									    "userId": 10,
									    "id": 198,
									    "title": "quis eius est sint explicabo",
									    "completed": true
									  }
     */

    @Test
    public void get14ObjectMapper_Map() {

        //get request yapıyrz. expected datayı convert methoda string olarak koy. map e çevir
        //responce yi de map e çevir ve karşılaştır.

        //set the url
        spec.pathParams("first", "todos", "second", 198);

        //set the expected data
        String expectedDataInString = new JsonPlaceHolderTestData().expectedDataInString(10, "quis eius est sint explicabo", true);
        Map expectedData = ObjectMapperUtils.convertJsonToJava(expectedDataInString, Map.class);
        System.out.println("expectedData = " + expectedData);

        //send the request and get the response
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();


        //do assertion
       Map actualData= ObjectMapperUtils.convertJsonToJava(response.asString(),Map.class);
        System.out.println("actualData = " + actualData);

        assertEquals(200,response.getStatusCode());
        assertEquals(expectedData.get("userId"),actualData.get("userId"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("completed"),actualData.get("completed"));
    }
}
