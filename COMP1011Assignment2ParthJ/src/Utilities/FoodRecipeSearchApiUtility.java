package Utilities;

import com.squareup.okhttp.*;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FoodRecipeSearchApiUtility {

    /**
     * This method invokes API Call and sends the information in JSON File
     * @param ingredients
     * @param dish
     * @throws IOException
     * @throws InterruptedException
     */

    public static void getRecipeFromSearch(String ingredients, String dish) throws IOException, InterruptedException {

        String searchURL = "http://www.recipepuppy.com/api/?i=" + ingredients + "&q=" + dish + "&p=1";;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(searchURL)).build();

        HttpResponse<Path> response =
                client.send(request, HttpResponse.BodyHandlers.ofFile(
                        Paths.get("./src/JSONFiles/food.json")));

    }

}
