package Homeworks;

import base_urls.AutoBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;



import static io.restassured.RestAssured.given;

public class Get01 extends AutoBaseUrl {

    /*
Given
    https://automationexercise.com/api/productsList
When
    User sends a GET Request to the url
Then
    HTTP Status Code should be 200
And
    Content Type should be "text/html; charset=utf-8"
And
    Status Line should be HTTP/1.1 200 OK
And
     There must be 12 Women, 9 Men, 13 Kids usertype in products
  */

    @Test
    public void get01(){

        //Set the Url

        spec.pathParams("first","productsList");

       //Send The Request and Get The Response

        Response response=given().spec(spec).when().get("/{first}");
        response.prettyPrint();


       //Do Assertion
        SoftAssert softAssert = new SoftAssert();
        JsonPath json = response.jsonPath();

        softAssert.assertEquals(response.getStatusCode(),200);
        softAssert.assertEquals(response.getContentType(),"text/html; charset=utf-8");
        softAssert.assertEquals(response.getStatusLine(),"HTTP/1.1 200 OK");
        softAssert.assertEquals(json.getString("usertype.usertype"), "");


        softAssert.assertAll();

    }
}
