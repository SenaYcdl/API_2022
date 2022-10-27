package get_request;

/*
       Given
           https://restful-booker.herokuapp.com/booking/22
       When
           User send a GET request to the URL
       Then
           HTTP Status Code should be 200
       And
           Response content type is "application/json"
       And
           Response body should be like;
        {
          "firstname": "Howard",
       "lastname": "Colque",
       "totalprice": 111,
          "depositpaid": true,
          "bookingdates": {
       "checkin": "2018-01-01",
       "checkout": "2019-01-01"
   },
    "additionalneeds": "Breakfast"
}
    */

