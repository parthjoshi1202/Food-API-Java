package Models;

import com.google.gson.annotations.SerializedName;

public class RecipeInfo {

    @SerializedName("title")
    private String title;

    @SerializedName("href")
    private String href;

    @SerializedName("ingredients")
    private String ingredients;

    @SerializedName("thumbnail")
    private String thumbnail;

    public RecipeInfo(String title, String href, String ingredients, String thumbnail) {
        setTitle(title);
        setHref(href);
        setIngredients(ingredients);
        setThumbnail(thumbnail);
    }

    /**
     * Getter, setter methods for recipe title
     * Regex checks for numbers and letters only
     * @return
     */
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title.matches("^[a-zA-Z0-9\" \"\"'\"]*$")) //matches for numbers and letters only
            throw new IllegalArgumentException("Title should contain only alphabets and numbers");
        else
            this.title = title;
    }

    /**
     * Getter, setter methods for href (Recipe link)
     * @return
     */

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    /**
     * Getter, setter methods for ingredients
     * Regex checks for numbers,letters and comma
     * @return
     */

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        if(ingredients.matches("^[a-zA-Z0-9\" \"\",\"\"'\"]*$")) //matches for numbers,letters and comma
            throw new IllegalArgumentException("Ingredients should contain only alphabets, numbers and commas");
        else
        this.ingredients = ingredients;
    }

    /**
     * Getter, setter methods for Thumbnail
     * @return
     */

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    /**
     * This method is useful in displaying recipe titles in the list view gui in this format
     * @return
     */
    public String toString()
    {
        return String.format("%s",this.title);
    }

}
