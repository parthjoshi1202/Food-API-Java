package Utilities;

import Models.RecipeInfo;
import Models.SearchResult;
import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class JSONFileUtility {

    /**
     * Utility to return an ArrayList of RecipeInfo Objects, derived from JSON File
     * @param jsonFile
     * @return
     */

    public static ArrayList<RecipeInfo> getRecipeList(String jsonFile) {

        ArrayList<RecipeInfo> recipes=new ArrayList<>();

        Gson gson=new Gson();

        try (
            FileReader fileReader=new FileReader(jsonFile);
            JsonReader jsonReader=new JsonReader(fileReader);
        )
        {
            SearchResult searchResult=gson.fromJson(jsonReader,SearchResult.class);
            recipes.addAll(Arrays.asList(searchResult.getRecipes()));
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return recipes;
    }

}
