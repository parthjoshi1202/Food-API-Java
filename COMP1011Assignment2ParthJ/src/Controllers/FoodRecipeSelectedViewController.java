package Controllers;
import Models.RecipeInfo;
import Utilities.SceneChanger;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import java.awt.Desktop;

public class FoodRecipeSelectedViewController implements Initializable {

        private RecipeInfo recipeInfo;

        @FXML
        private JFXButton backButton;

        @FXML
        private Label titleLabel;

        @FXML
        private Label linkLabel;

        @FXML
        private ImageView imageView;

        @FXML
        private Label ingredientsLabel;

        @FXML
        private WebView webView;

    /**
     * This method changes scenes using SceneChanger
     * @param event
     * @throws IOException
     */

    @FXML
        private void backButton(ActionEvent event) throws IOException  {

                SceneChanger.changeScene(event,"Views/recipeSearch.fxml","Food Recipe Search");
        }

    /**
     * Initializing all fields
     * When a Row is selected and "Select" button is clicked, it loads information of that selected row from JSON File
     * Loading the Link of the recipe selected (in webview) as well as
     * Loading the Thumbnail (if given), otherwise a default image is loaded
     * information is populated based on JSON File in both scenes
     * @param recipe
     */

    public void initData(RecipeInfo recipe) {
            recipeInfo=recipe;
            titleLabel.setText(recipeInfo.getTitle());
            ingredientsLabel.setText(recipeInfo.getIngredients());
            linkLabel.setText(recipeInfo.getHref());
            try {
                        imageView.setImage(new Image(recipeInfo.getThumbnail()));
                }
            catch (Exception e) {
                        imageView.setImage(new Image("./Views/defaultImgFood.png"));
                }

            WebEngine engine=webView.getEngine();
            //engine.load("https://www.google.com/");
                engine.load(recipeInfo.getHref());
        }

    /**
     * Initialize method
     * @param url
     * @param resourceBundle
     */

    @Override
        public void initialize(URL url, ResourceBundle resourceBundle) {

        }
}
