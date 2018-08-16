import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Request;

@Path("/api/robot/navigator/pose")
public class APIEventHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(APIEventHandler.class);

    public APIEventHandler() {
        super();
    }

    @GET
    @Consumes("application/json")
    @Produces("application/json")
    public String getMovieEvent(@Context Request request) {
        LOGGER.info("received request:" + request.toString());
        return "nothing to report from getMovieEvent";
    }

}