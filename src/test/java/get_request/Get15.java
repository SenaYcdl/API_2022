package get_request;

import base_urls.RestfulBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import org.testng.asserts.SoftAssert;
import pojos.BookingDatesPojo;
import pojos.BookingPojo;
import utils.ObjectMapperUtils;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get15 extends RestfulBaseUrl {

    /*
        Given
	            https://restful-booker.herokuapp.com/booking/22
        When
		 		I send GET Request to the URL
		Then
		 		Status code is 200
          {
    "firstname": "Guoqiang",
    "lastname": "Morante Briones",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "Breakfast"
}
     */

    @Test
    public void get15() {

        //set the url
        spec.pathParams("first", "booking", "second", 22);

        //set the expected data
        BookingDatesPojo bookingDatesPojo = new BookingDatesPojo("2018-01-01", "2019-01-01");
        BookingPojo expectedData = new BookingPojo("Guoqiang", "Morante Briones", 111, true, bookingDatesPojo, "breakfast");
        System.out.println("expectedData = " + expectedData);

        //send the request and get the response
        Response response = given().spec(spec).when().get("/{first}/{second}");
        response.prettyPrint();


        //Do Assertion
        BookingPojo actualData = ObjectMapperUtils.convertJsonToJava(response.asString(), BookingPojo.class);


        //softAssertion
        //1.adim obje olustur
        SoftAssert softAssert=new SoftAssert();

        //2.adim assertion yap
        softAssert.assertEquals(actualData.getFirstname(),expectedData.getFirstname(),"Firstname uyusmadi");
        softAssert.assertEquals(actualData.getLastname(),expectedData.getLastname(),"Lastname uyusmadi");
        softAssert.assertEquals(actualData.getTotalprice(),expectedData.getTotalprice(),"TotalPrice uyusmadi");
        softAssert.assertEquals(actualData.getDepositpaid(),expectedData.getDepositpaid(),"Depositpaid uyusmadi");
        softAssert.assertEquals(actualData.getAdditionalneeds(),expectedData.getAdditionalneeds(),"Additional uyusmadi");

        softAssert.assertEquals(actualData.getBookingdates().getCheckin(),bookingDatesPojo.getCheckin(),"Checkin uyusmadi");
        softAssert.assertEquals(actualData.getBookingdates().getCheckout(),bookingDatesPojo.getCheckout(),"Checkout uyusmadi");

        //3.assertall
        softAssert.assertAll();


        //hard assertion
        assertEquals(200, response.statusCode());
        assertEquals(expectedData.getFirstname(), actualData.getFirstname());
        assertEquals(expectedData.getLastname(), actualData.getLastname());
        assertEquals(expectedData.getTotalprice(), actualData.getTotalprice());
        assertEquals(expectedData.getDepositpaid(), actualData.getDepositpaid());

        assertEquals(bookingDatesPojo.getCheckout(), actualData.getBookingdates().getCheckout());
        assertEquals(bookingDatesPojo.getCheckin(), actualData.getBookingdates().getCheckin());

        //eger spesifik olarak firstname degistirmek istersek set i kullaniriz ve bize verilen datayi degistirebiliriz
        //actualData.setFirstname("Mahmut");



    }
}
