package base_urls;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class AutoBaseUrl {

    protected RequestSpecification spec;

    @Before
    public void setUp() throws Exception {

        spec=new RequestSpecBuilder().setBaseUri("https://automationexercise.com/api").build();
    }
}
