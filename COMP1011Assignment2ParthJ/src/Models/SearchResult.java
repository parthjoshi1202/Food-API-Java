package Models;

import com.google.gson.annotations.SerializedName;

public class SearchResult {

    @SerializedName("results")
    private RecipeInfo[] recipes;

    private String totalResults;

    public SearchResult(RecipeInfo[] recipes, String totalResults) {
        setRecipes(recipes);
        setTotalResults(totalResults);
    }

    /**
     * Sets and Returns array of recipes
     * @return
     */
    public RecipeInfo[] getRecipes() {
        return recipes;
    }

    public void setRecipes(RecipeInfo[] recipes) {
        this.recipes = recipes;
    }

    /**
     * Sets and Returns total results
     * @return
     */

    public String getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(String totalResults) {
        this.totalResults = totalResults;
    }
}
