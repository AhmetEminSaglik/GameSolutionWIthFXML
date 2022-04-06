package algorithm.game.location;


import algorithm.compass.Compass;
import algorithm.game.Game;
import algorithm.game.gamerepo.CreateLocationOfLastStep;
import algorithm.game.location.direction.LastLocation;

public class DirectionLocation extends Location {


    private Compass compass;

    private int id;

    public int getId() {
        return id;
    }


    public static Location getLocationFromCompass(Compass compass, int directionIndex) {
        return new SwitchDirection(compass).choseDirection(directionIndex);
    }

    public DirectionLocation getLocationValueAccordingToEnteredValue(Game game, int choose) {

        if (choose == game.getPlayer().getCompass().getLastLocation()) {
            return new CreateLocationOfLastStep(game).createLastStepLocation();
        }
        return new SwitchDirection(game.getPlayer().getCompass()).choseDirection(choose);

    }

    /**
     * Eger burada pusulayi oyuncu pusulasina gore ayarlayabilirsem her sey cok
     * guzel olacak
     */
    public Compass getCompass() {
        return compass;
    }

    public void setCompass(Compass compass) {
        this.compass = compass;
    }

    @Override
    public String toString() {
        return "DirectionLocation{" +" "+getClass().getSimpleName()+
                " id=" + getId() + " X " + getX() + "" +
                "Y " + getY() +
                '}';
    }
}
