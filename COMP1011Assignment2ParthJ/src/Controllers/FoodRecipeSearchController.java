package Controllers;

import Models.RecipeInfo;
import Utilities.FoodRecipeSearchApiUtility;
import Utilities.JSONFileUtility;
import Utilities.SceneChanger;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.io.IOException;

public class FoodRecipeSearchController implements Initializable {

    @FXML
    private JFXListView<RecipeInfo> foodRecipeListView;

    @FXML
    private Label rowsReturnedLabel;

    @FXML
    private JFXTextField ingredientsTextField;

    @FXML
    private JFXTextField dishTextField;

    @FXML
    private JFXButton searchButton;

    /**
     * Initialize method
     * @param url
     * @param resourceBundle
     */

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //adding listener , if row is selected, it shows the title, link href, links and pic
        /*foodRecipeListView.getSelectionModel().selectedItemProperty().addListener(
                (obs,oldValue,recipeSelected) -> {
                    titleLabel.setText(recipeSelected.getTitle());
                    linkLabel.setText(recipeSelected.getHref());
                    ingredientsLabel.setText(recipeSelected.getIngredients());
                    try {
                        imageView.setImage(new Image(recipeSelected.getThumbnail()));
                    }
                    catch (Exception e) {
                        imageView.setImage(new Image("./Views/defaultImgFood.png"));
                    }

                }
        );

         */

        updateLabels();

    }

    /**
     * Updates number of rows returned in list view
     */

    private void updateLabels() {
        rowsReturnedLabel.setText("Rows Returned: "+foodRecipeListView.getItems().size());
    }

    /**
     * Gets Texts from required fields, calls API accordingly and returns results in list view, when search button is clicked
     */

    @FXML
    private void getRecipeResults() {
        foodRecipeListView.getItems().clear();
        try {
            String ingredientNames=ingredientsTextField.getText();
            ingredientNames= ingredientNames.replace(" ","%20");
            String title=dishTextField.getText();
            title=title.replace(" ","%20");

            FoodRecipeSearchApiUtility.getRecipeFromSearch(ingredientNames,title);
            //FoodRecipeSearchApiUtility.getRecipeFromSearch(ingredientsTextField.getText(),dishTextField.getText());
            foodRecipeListView.getItems().addAll(JSONFileUtility.getRecipeList("./src/JSONFiles/food.json"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        updateLabels();

    }

    /**
     * This method changes scenes using SceneChanger
     * @param event
     * @throws IOException
     */
    @FXML
    public void changeToRecipeScene(ActionEvent event) throws IOException {
        if(!foodRecipeListView.getSelectionModel().isEmpty()) {
            SceneChanger.updateScene(event,"recipeSelectedView.fxml","Selected Recipe",foodRecipeListView.getSelectionModel().getSelectedItem());
        }
    }
}
