package main;

import main.jsonhandler.JsonBodyHandler;
import main.jsonhandler.model.Authorization;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.util.Base64;

public class TokenSingleton {
    /* Replace with Client ID and Client Secret */
    final static String USER = "";
    final static String SECRET = "";
    private String token = null;
    private static TokenSingleton singleton = null;

    private TokenSingleton() {

    }

    public String getToken() throws IOException, InterruptedException {
        if (token == null) {
            token = generateAuthorizationToken();
        }

        return token;
    }

    private String generateAuthorizationToken () throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();

        String userWithSecret = USER + ":" + SECRET;
        String encodedUserWithSecret = new String(Base64.getEncoder().encode(userWithSecret.getBytes()));
        String authBased = "Basic " + encodedUserWithSecret;

        HttpRequest requestAuth = HttpRequest.newBuilder()
                .uri(URI.create("https://allegro.pl/auth/oauth/token?grant_type=client_credentials"))
                .POST(HttpRequest.BodyPublishers.noBody())
                .header("Authorization", authBased)
                .build();
        Authorization responseAuth = client.send(requestAuth, new JsonBodyHandler<>(Authorization.class)).body();

        return "Bearer " + responseAuth.getAccess_token();
    }

    public static TokenSingleton getTokenSingleton() {
        if (singleton == null) {
            singleton = new TokenSingleton();
        }

        return singleton;
    }


}
