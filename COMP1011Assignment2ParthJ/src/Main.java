import Models.RecipeInfo;
import Utilities.FoodRecipeSearchApiUtility;
import Utilities.JSONFileUtility;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.ArrayList;

public class Main extends Application {

    /**
     * Loads stage , scene for fxml view + Icon
     * @param stage
     * @throws Exception
     */
    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("./Views/recipeSearch.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Food Recipe Search");
        stage.getIcons().add(new Image("Icon/food.png"));
        //primaryStage.setScene(new Scene(root, 300, 275));
        stage.show();
    }

    /**
     * Main Method
     * @param args
     */

    public static void main(String[] args) {
        launch(args);

        /*ArrayList<RecipeInfo> recipes = new ArrayList<>();
        try {
            //FoodRecipeSearchApiUtility.getRecipeFromSearch("onion,garlic","omelet");
            FoodRecipeSearchApiUtility.getRecipeFromSearch("onions,garlic","omelet");
            recipes.addAll(JSONFileUtility.getRecipeList("./src/JSONFiles/food.json"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println();
         */
    }
}
