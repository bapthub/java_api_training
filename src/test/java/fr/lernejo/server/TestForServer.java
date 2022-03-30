package fr.lernejo.server;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.*;

class TestForServer {

    @Test
    public void test_For_Ping_1() throws IOException, InterruptedException {
        Server server = new Server(9877);
        server.setup_server();
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:9877/ping"))
            .build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        Assertions.assertEquals(HttpURLConnection.HTTP_OK, httpResponse.statusCode());
        Assertions.assertEquals("OK", httpResponse.body());

    }
    @Test
    public void test_setup_server() throws Exception {
        Server server = new Server(9999);
        server.setup_server();
    }
}

