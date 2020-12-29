package Utilities;

import Controllers.FoodRecipeSearchController;
import Controllers.FoodRecipeSelectedViewController;
import Models.RecipeInfo;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneChanger {

    /**
     * This method Changes scenes using ActionEvent, used in other Classes
     * @param event
     * @param viewName
     * @param title
     * @throws IOException
     */
    public static void changeScene(ActionEvent event, String viewName, String title) throws IOException {

        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(new Object(){}.getClass().getClassLoader().getResource(viewName));
        Parent root= loader.load();
        Scene scene=new Scene(root);
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle(title);
        stage.getIcons().add(new Image("Icon/food.png"));
        stage.show();
    }

    /**
     * This method updates the new Scene with information based on a JSON File
     * @param event
     * @param viewName
     * @param title
     * @param recipeInfo
     * @throws IOException
     */

    public static void updateScene(ActionEvent event, String viewName, String title, RecipeInfo recipeInfo) throws IOException {

        FXMLLoader loader=new FXMLLoader();
        loader.setLocation(new Object(){}.getClass().getResource("/Views/"+viewName));
        Parent root= loader.load();
        Scene scene=new Scene(root);
        FoodRecipeSelectedViewController controller=loader.getController();
        controller.initData(recipeInfo);

        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle(title);
        stage.getIcons().add(new Image("Icon/food.png"));
        stage.show();

    }
}
