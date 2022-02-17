package algorithm.game.move.fundamental;

import algorithm.game.Game;
import algorithm.game.gamerepo.updategamemodel.UpdateForMovedForward;
import algorithm.game.move.Move;

public class MoveForward extends Move {

    public MoveForward(Game game) {
        super(game);
        MoveForward t = this;
        updateValuesInGameModel = new UpdateForMovedForward(game);
    }

    @Override
    public void updateVisitedDirection() {
        game.getPlayer().getScore().lockCounterOfMovingBackLose();
//        System.out.println("geri adim atma kilidi kapatildi");
        updateValuesInGameModel.updateValueVisitedDirection(getDirectionLocation());
    }

    @Override
    public void updateBeforeStep() {
    }

    @Override
    public void updateAfterStep() {
        updatePlayerLocation();
        updateVisitedArea();
        updateVisitedDirection();
    }


}