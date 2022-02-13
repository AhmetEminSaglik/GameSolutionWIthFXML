package algorithm.game.location.direction;

import algorithm.game.location.DirectionLocation;


public class NorthEast extends DirectionLocation {

    @Override
    public int getId() {
                return getCompass().getNorthEast();
    }

    @Override
    public int getX() {
        return 2;
    }

    @Override
    public int getY() {
        return 2;
    }

}
