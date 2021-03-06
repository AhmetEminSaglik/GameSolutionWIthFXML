package algorithm.game.play.input.person;

import algorithm.game.gamerepo.player.person.Person;
import algorithm.game.location.DirectionLocation;
import algorithm.game.location.LocationsList;

import java.util.ArrayList;

public class ButtonClickInputForFXML implements InputWayOfPersonInput {

    private int inputValue;
    Person person;

    public ButtonClickInputForFXML(Person person) {
        this.person = person;
    }

    @Override
    public int getInput() {
        return inputValue;
    }

    public void setLocationToGetCompassDirectionLocation(int x, int y) {
        ArrayList<DirectionLocation> locationArrayList = new LocationsList().getListOfLocationsAccordingToPlayerCompass(person.getCompass());
        for (int i = 0; i < locationArrayList.size(); i++) {
            DirectionLocation directionLocation = locationArrayList.get(i);
            if (person.getLocation().getX() + directionLocation.getX() == x && person.getLocation().getY() + directionLocation.getY() == y) {
                inputValue = directionLocation.getId();
                return;
            }
        }

        inputValue = -1;
    }

}
