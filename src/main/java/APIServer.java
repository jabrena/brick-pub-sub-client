import com.sun.net.httpserver.HttpServer;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

public class APIServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(APIServer.class);

    private final static int DEFAULT_PORT = 8080;
    private final static String DEFAULT_HOST = "http://localhost/";

    private HttpServer server;

    public APIServer(final String host, final int port) {
        init(host, port);
    }

    public APIServer() {
        this(DEFAULT_HOST, DEFAULT_PORT);
    }

    private void init(final String host, final int port) {
        URI baseUri = UriBuilder.fromUri(host).port(port).build();
        final ResourceConfig config = getResourceConfig();
        server = JdkHttpServerFactory.createHttpServer(baseUri, config);
        LOGGER.info("Server ready");
    }

    private ResourceConfig getResourceConfig() {
        final ResourceConfig config = new ResourceConfig();
        config.register(APIEventHandler.class);
        config.register(CustomLoggingFilter.class);
        return config;
    }

    public void stop(){
        server.stop(0);
    }

}
