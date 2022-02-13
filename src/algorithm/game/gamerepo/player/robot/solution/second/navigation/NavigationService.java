package algorithm.game.gamerepo.player.robot.solution.second.navigation;

import algorithm.errormessage.joptionpanel.ShowPanel;
import algorithm.game.Game;
import algorithm.game.gamerepo.player.robot.Robot;
import algorithm.game.gamerepo.player.robot.solution.second.exitsituation.ExitSituation;
import algorithm.game.location.DirectionLocation;
import algorithm.game.location.direction.LastLocation;

public class NavigationService {
   /* Game game;
    Robot robot;
    public Navigation navigation;

    public NavigationService(Game game, Navigation navigation) {
        this.game = game;
        this.navigation = navigation;
        robot = getRobot(game);
    }*/

    public void setCompulsoryLocationToNavigation(Game game, Navigation navigation, DirectionLocation lastLocation) {
        Robot robot = getRobot(game);

        if (navigation.getOneWayNumbersValue() == 1 &&
                robot.getRobotMemory().getRoadMemory().getExitSituation().getSituation() == ExitSituation.EXIT_LOCATED
                && !navigation.isExitSituationWasLocatedInThisStep()) {
            navigation.setCompulsoryLocation(lastLocation);
        }


    }

    public DirectionLocation getCompulsoryLocation(Navigation navigation) {
//        if (navigation.getCompulsoryLocation() != null) {
//            selectedDirection = navigation.getCompulsoryLocation();
//            ShowPanel.show(getClass(),"Navigation compulsory LOCATION "+navigation.getCompulsoryLocation());

//            ShowPanel.show(getClass(), "navigation.getCompulsoryLocation  >>>>>>>>>>>>>>>>>>>>>>>>>>>> " + navigation.getCompulsoryLocation());
        DirectionLocation selectedDirection = navigation.getCompulsoryLocation();
        if (selectedDirection == null)
            throw new NullPointerException("Compulsory Location Is Null");

        return navigation.getCompulsoryLocation();

//        }
//        throw new NullPointerException("Navigation Compulsory Location is  NULL ");
    }

    public Navigation buildNavigation(Game game, int oneWayNumbersValue, DirectionLocation compulsoryLocation) {
        Navigation navigation = new Navigation();

        navigation.setStep(getRobot(game).getStep());
        navigation.setOneWayNumbersValue(oneWayNumbersValue);
        if (compulsoryLocation != null) {
            navigation.setCompulsoryLocation(compulsoryLocation);
        }

        return navigation;
    }

    public void addNavigationToRoadMemoryList(Navigation navigation, Robot robot) {
        robot.getRobotMemory().getRoadMemory().getOneWayNumbersList().add(navigation);
    }

    private Robot getRobot(Game game) {
        return (Robot) game.getPlayer();
    }
}
