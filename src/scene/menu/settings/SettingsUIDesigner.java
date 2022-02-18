package scene.menu.settings;

import scene.basescenecontroller.BaseSceneController;
import scene.basescenecontroller.BaseSceneLoader;

public class SettingsUIDesigner extends BaseSceneLoader {

    public SettingsUIDesigner(BaseSceneController baseSceneController) {
        super(baseSceneController);
        fxmlPath = "/scene/menu/settings/Settings.fxml";
        cssPath = "/resource/menu.css";
        getSceeneWithAddedCss();
    }


}
