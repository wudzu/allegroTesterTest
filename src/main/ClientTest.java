package main;

import main.jsonhandler.JsonBodyHandler;
import main.jsonhandler.model.*;
import org.junit.Test;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.URI;
import java.net.http.HttpResponse;

import static org.junit.jupiter.api.Assertions.*;

public class ClientTest {


    private static HttpRequest generateCategoryRequest(String token, String id) {
        String jsonName = "application/vnd.allegro.public.v1+json";
        String uriString = "https://api.allegro.pl/sale/categories/" + (id);
        return HttpRequest.newBuilder()
                .uri(URI.create(uriString))
                .GET()
                .headers("Authorization", token, "Accept", jsonName)
                .build();
    }

    private static HttpRequest generateCategoriesRequest (String token, String id) {
        String jsonName = "application/vnd.allegro.public.v1+json";
        String uriString = "https://api.allegro.pl/sale/categories";
        if (id != null) {
            uriString = uriString.concat("/?parent.id=").concat(id);
        }

        return HttpRequest.newBuilder()
                .uri(URI.create(uriString))
                .GET()
                .headers("Authorization", token, "Accept", jsonName)
                .build();
    }

    private static HttpRequest generateParametersRequest(String token, String id) {
        String jsonName = "application/vnd.allegro.public.v1+json";
        String uriString = "https://api.allegro.pl/sale/categories/" + id + "/parameters";
        return HttpRequest.newBuilder()
                .uri(URI.create(uriString))
                .GET()
                .headers("Authorization", token, "Accept", jsonName)
                .build();
    }

    private static void recursiveTreeTest (String token, HttpClient client, String id) throws IOException, InterruptedException {
        HttpRequest requestCategories = generateCategoriesRequest(token, id);

        HttpResponse<Categories> response = client.send(requestCategories, new JsonBodyHandler<>(Categories.class));
        Categories responseCategories = response.body();

        assertEquals(200, response.statusCode());

        if (responseCategories.getCategories() != null) {
            for (Category obj : responseCategories.getCategories()) {
                if (id == null) {
                    assertNull(obj.getParent());
                } else {
                    assertEquals(id, obj.getParent().getId());
                }
                obj.isAllInitialized();
            }

            /* Check for first and last child category, full tree check takes about 20 minutes */
            if (responseCategories.getCategories().length > 0) {
                recursiveTreeTest(token, client, responseCategories.getCategories()[0].getId());
                if (responseCategories.getCategories().length > 1) {
                    recursiveTreeTest(token, client, responseCategories.getCategories()[responseCategories.getCategories().length - 1].getId());
                }
            }
        }

    }

    private static void recursiveTreeOnBranchTestStart () throws IOException, InterruptedException {
        String token = TokenSingleton.getTokenSingleton().getToken();
        HttpClient client = HttpClient.newHttpClient();

        recursiveTreeTest(token, client, null);
    }


    private static void checkCategoryById (String[] idsToTest) throws IOException, InterruptedException {
        String token = TokenSingleton.getTokenSingleton().getToken();
        HttpClient client = HttpClient.newHttpClient();

        for (String id : idsToTest) {
            HttpRequest requestCategories = generateCategoryRequest(token, id);

            HttpResponse<Category> response = client.send(requestCategories, new JsonBodyHandler<>(Category.class));
            Category responseCategory = response.body();

            assertEquals(200, response.statusCode());

            responseCategory.isAllInitialized();
        }

    }


    private static void checkParametersById (String[] idsToTest) throws IOException, InterruptedException {
        String token = TokenSingleton.getTokenSingleton().getToken();
        HttpClient client = HttpClient.newHttpClient();


        for (String id : idsToTest) {
            HttpRequest requestParameters = generateParametersRequest(token, id);

            HttpResponse<ParametersRoot> response = client.send(requestParameters, new JsonBodyHandler<>(ParametersRoot.class));
            ParametersRoot responseParameters = response.body();

            assertEquals(200, response.statusCode());

            responseParameters.isAllInitialized();
        }

    }

    private static void check404 (String[] idsToTest) throws IOException, InterruptedException {
        String token = TokenSingleton.getTokenSingleton().getToken();
        HttpClient client = HttpClient.newHttpClient();

        for (String id : idsToTest) {
            HttpRequest requestError;
            HttpResponse<Errors> response;
            Errors responseError;

            requestError = generateCategoryRequest(token, id);

            response = client.send(requestError, new JsonBodyHandler<>(Errors.class));
            responseError = response.body();

            assertEquals(404, response.statusCode());
            responseError.isAllInitialized();

            requestError = generateCategoriesRequest(token, id);

            response = client.send(requestError, new JsonBodyHandler<>(Errors.class));
            responseError = response.body();


            assertEquals(404, response.statusCode());
            responseError.isAllInitialized();

            requestError = generateParametersRequest(token, id);

            response = client.send(requestError, new JsonBodyHandler<>(Errors.class));
            responseError = response.body();


            assertEquals(404, response.statusCode());
            responseError.isAllInitialized();
        }
    }

    private static void checkUnauthorized (String[] idsToTest) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        String[] invalidToken =  new String[] {"1234567890", "", "root"};

        for (String id : idsToTest) {
            HttpRequest requestError;
            HttpResponse<AuthorizationError> response;
            AuthorizationError responseAuthorizationError;

            requestError = generateCategoryRequest(invalidToken[0], id);

            response = client.send(requestError, new JsonBodyHandler<>(AuthorizationError.class));
            responseAuthorizationError = response.body();

            assertEquals(401, response.statusCode());
            responseAuthorizationError.isAllInitialized();

            requestError = generateCategoriesRequest(invalidToken[1], id);

            response = client.send(requestError, new JsonBodyHandler<>(AuthorizationError.class));
            responseAuthorizationError = response.body();


            assertEquals(401, response.statusCode());
            responseAuthorizationError.isAllInitialized();

            requestError = generateParametersRequest(invalidToken[2], id);

            response = client.send(requestError, new JsonBodyHandler<>(AuthorizationError.class));
            responseAuthorizationError = response.body();


            assertEquals(401, response.statusCode());
            responseAuthorizationError.isAllInitialized();


        }

    }

    public static void main(String[] args) throws IOException, InterruptedException {
        recursiveTreeOnBranchTestStart();
        checkCategoryById(new String[] {"5","1510","112714","4bd97d96-f0ff-46cb-a52c-2992bd972bb1"});
        checkParametersById(new String[] {"5","1510","112714","4bd97d96-f0ff-46cb-a52c-2992bd972bb1"});
        check404(new String[] {"WrongCategory", "999999", "Moda"});
        checkUnauthorized(new String[] {"5","1510","112714","4bd97d96-f0ff-46cb-a52c-2992bd972bb1"});
    }
}
