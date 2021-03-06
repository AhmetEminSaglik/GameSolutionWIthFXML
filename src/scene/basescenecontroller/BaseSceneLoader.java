package scene.basescenecontroller;

import algorithm.errormessage.ErrorMessage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import scene.scenebuilder.SceneBuilder;

import java.io.IOException;

public abstract class BaseSceneLoader extends AnchorPane {
    protected Scene scene;
    protected BaseSceneController baseSceneController;
    public String fxmlPath, cssPath;

    public BaseSceneLoader(BaseSceneController baseSceneController) {
        this.baseSceneController = baseSceneController;

    }

    public Scene loadFxmlFile(String fxmlPath) {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(fxmlPath));

        fxmlLoader.setController(baseSceneController);

        try {
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            return scene;

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -");
            ErrorMessage.appearFatalError(getClass(), e.getMessage());
        }
        return null;
    }

    public Scene getCreatedScene() {
        return scene;
    }

    public void addCss(Scene scene, String cssPath) {
        new SceneBuilder().addCss(scene, cssPath);
    }


    protected void getSceeneWithAddedCss() {
        scene = loadFxmlFile(fxmlPath);
        addCss(scene, cssPath);
    }
}
