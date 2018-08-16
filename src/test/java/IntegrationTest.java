import io.restassured.RestAssured;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static io.restassured.RestAssured.when;

public class IntegrationTest {

    private final static int DEFAULT_PORT = 8080;
    private final static String DEFAULT_HOST = "http://localhost/";

    private APIServer server;

    @Before
    public void setup() {
        RestAssured.baseURI = DEFAULT_HOST;
        RestAssured.port = DEFAULT_PORT;
        server = new APIServer();
    }

    @After
    public void after() {
        server.stop();
    }

    @Test
    public void whenRequestGetNavigatorPose_thenOK(){
        when().request("GET", "/api/robot/navigator/pose")
              .then().statusCode(200);
    }

}
