package scene.menu.playgame;

import algorithm.Main.ISelectPlayer;
import algorithm.errormessage.joptionpanel.ShowPanel;
import algorithm.game.Game;
import algorithm.game.gamerepo.player.Player;
import algorithm.game.gamerepo.player.person.Person;
import algorithm.game.gamerepo.player.person.PersonSpecialStuffToPrepareBeforeStartGame;
import algorithm.game.gamerepo.player.robot.Robot;
import algorithm.game.gamerepo.player.robot.solution.RobotSpecialStuffToPrepareBeforeStartGame;
import algorithm.game.play.input.person.ButtonClickInputForFXML;
import algorithm.game.play.input.person.PersonInput;
import algorithm.game.play.input.person.PersonPlayingStyle;
import algorithm.game.play.input.person.SafeScannerInput;
import algorithm.game.play.input.robot.RobotPlayingStyle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import preparegamebyselectingmenu.PrepareGameBySelectingMenu;
import scene.SwitchNewScene;
import scene.basescenecontroller.BaseSceneController;
import scene.menu.main.MainMenuSceneUIDesigner;
import scene.menu.playgame.solutionChoice.SolutionChoiceController;
import scene.menu.playgame.solutionChoice.SolutionChoiceSceneUIDesigner;
import scene.menu.selectedgeevalue.EdgeValueController;
import scene.menu.selectedgeevalue.EdgeValueSceneUIDesigner;

import java.net.URL;
import java.util.ResourceBundle;

public class PlayGameMenuController extends BaseSceneController /*implements ISelectPlayer*//*, ISelectPlayer */ {

    private PrepareGameBySelectingMenu prepareGameBySelectingMenu;
//    private Player player;


    public PlayGameMenuController(PrepareGameBySelectingMenu prepareGameBySelectingMenu) {
        super(prepareGameBySelectingMenu);
        this.prepareGameBySelectingMenu = prepareGameBySelectingMenu;
    }


//    @FXML
//    private AnchorPane anchorPane;

    @FXML
    private VBox menuVBox;

    @FXML
    private Button btnPersonWantToPlay;

    @FXML
    private Button btnRobotWillPlay;

    @FXML
    private Button btnPersonvsRobot;

    @FXML
    private Button btnGoBack;


    @FXML
    void playGameByPerson(ActionEvent event) {
        prepareGameBySelectingMenu.setPlayer(new Person());
//        prepareGameBySelectingMenu.selectPlayer(prepareGameBySelectingMenu.getPlayer());
        prepareGameBySelectingMenu.setPlayerPlayingStyle(new PersonPlayingStyle(prepareGameBySelectingMenu.getPlayer()));
        prepareGameBySelectingMenu.setPlayerSpecialStuffToPrepareBeforeStartGame(new PersonSpecialStuffToPrepareBeforeStartGame(prepareGameBySelectingMenu));
//        prepareGameBySelectingMenu.setPersonPlayingStyle(new PersonPlayingStyle(player));


        prepareGameBySelectingMenu.getPlayer().setIPlayerInput(new PersonInput(new ButtonClickInputForFXML((Person) prepareGameBySelectingMenu.getPlayer())));

        new SwitchNewScene().switchScene(anchorPane, new EdgeValueSceneUIDesigner(new EdgeValueController(prepareGameBySelectingMenu)).getCreatedScene());
    }

    @FXML
    void playGameByRobot(ActionEvent event) {
        prepareGameBySelectingMenu.setPlayer(new Robot());

//        prepareGameBySelectingMenu.selectPlayer(prepareGameBySelectingMenu.getPlayer());
        prepareGameBySelectingMenu.setPlayerPlayingStyle(new RobotPlayingStyle(prepareGameBySelectingMenu.getPlayer()));
        new SwitchNewScene().switchScene(anchorPane, new SolutionChoiceSceneUIDesigner(new SolutionChoiceController(prepareGameBySelectingMenu)).getCreatedScene());
        prepareGameBySelectingMenu.setPlayerSpecialStuffToPrepareBeforeStartGame(new RobotSpecialStuffToPrepareBeforeStartGame(prepareGameBySelectingMenu));
//        prepareGameBySelectingMenu.setPlayerPlayingStyle(new RobotPlayingStyle(player));
//        player.setIPlayerInput(new PersonInput(new ButtonClickInputForFXML((Person) player)));

//        new SwitchNewScene().switchScene(anchorPane, new EdgeValueSceneUIDesigner(new EdgeValueController(prepareGameBySelectingMenu)).getCreatedScene());
    }

    @FXML
    void playBothPersonAndRobot(ActionEvent event) {
        ShowPanel.show(getClass(), "DAHA BIR SEY EKLENMEDI");
    }

    @FXML
    void goBackMenu(ActionEvent event) {
        new SwitchNewScene().switchScene(anchorPane, new MainMenuSceneUIDesigner().getCreatedScene());
    }

//    @Override
//    public Player selectPlayer(Game game) {
//        return player;
//    }

 /*   @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }*/

    /*@Override
    public Player selectPlayer(Game game) {
        return null;
    }*/
}
