package algorithm.game.gamerepo.player.robot.solution;

import algorithm.game.gamerepo.player.PlayerSpecialStuffToPrepareBeforeStartGame;
import algorithm.game.gamerepo.player.robot.Robot;
import preparegamebyselectingmenu.PrepareGameBySelectingMenu;

public class RobotSpecialStuffToPrepareBeforeStartGame extends PlayerSpecialStuffToPrepareBeforeStartGame {

    public RobotSpecialStuffToPrepareBeforeStartGame(PrepareGameBySelectingMenu prepareGameBySelectingMenu) {
        super(prepareGameBySelectingMenu);
    }

    @Override
    public void prepare() {
        super.prepare();
        Robot robot = (Robot) prepareGameBySelectingMenu.getPlayer();
        robot.buildRobotMove();



    }
}