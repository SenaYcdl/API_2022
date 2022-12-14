package get_request;

import base_urls.JsonplaceholderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.JsonPlaceHolderPojo;
import utils.ObjectMapperUtils;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get14ObjectMapper_Pojo extends JsonplaceholderBaseUrl {

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

    //ObjectMapper + Pojo = En iyi yontem

    @Test
    public void get14ObjectMapperPojo(){

        //set the url
        spec.pathParams("first","todos", "second",198);

        //set the expected data
        JsonPlaceHolderPojo expectedData=new JsonPlaceHolderPojo(10,"quis eius est sint explicabo",true);
        System.out.println("expectedData = " + expectedData);

        //send the request and get the response
        Response response=given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();

        //do assertion
      JsonPlaceHolderPojo actualData=  ObjectMapperUtils.convertJsonToJava(response.asString(),JsonPlaceHolderPojo.class);
        System.out.println("actualData = " + actualData);

      assertEquals(200,response.getStatusCode());
      assertEquals(expectedData.getUserId(), actualData.getUserId());
      assertEquals(expectedData.getCompleted(), actualData.getCompleted());
      assertEquals(expectedData.getTitle(), actualData.getTitle());
    }
}
