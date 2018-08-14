import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.when;

public class IntegrationTest {

    @Before
    public void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }

    @Test
    public void whenRequestGetNavigatorPose_thenOK(){
        when().request("GET", "/api/robot/navigator/pose")
              .then().statusCode(200);
    }

}
