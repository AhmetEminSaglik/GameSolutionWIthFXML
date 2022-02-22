package fxmlmove;

import algorithm.errormessage.joptionpanel.ShowPanel;
import algorithm.game.Game;
import algorithm.game.move.Move;
import scene.game.GameController;
import scene.game.SquareButton;

public abstract class FxmlMove extends Move {
    FxmlSquareBtnCommunity squareBtnCommunity;
    GameController gameController;
    int playerLocationX, playerLocationY;// = game.getPlayer().getLocation().getX();// = game.getPlayer().getLocation().getY();
    SquareButton currentBtn;

    public FxmlMove(Game game) {
        super(game);
    }


 /*   @Override
    public void updateVisitedDirection() {

    }*/

    SquareButton getCurrentBtn() {
        updatePlayerLocationToGetCurrentBtn();
        return gameController.squareBtnCommunity.getCurrentSquareBtn(playerLocationX, playerLocationY);
    }

    void updatePlayerLocationToGetCurrentBtn() {
        playerLocationX = game.getPlayer().getLocation().getX();
        playerLocationY = game.getPlayer().getLocation().getY();
    }

    @Override
    public String toString() {
        return "FxmlMove{" +
                ", updateValuesInGameModel=" + updateValuesInGameModel +
                '}';
    }

}
