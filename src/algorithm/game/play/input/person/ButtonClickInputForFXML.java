package algorithm.game.play.input.person;

import algorithm.compass.KeyboardCompass;
import algorithm.game.gamerepo.player.Player;
import algorithm.game.gamerepo.player.person.Person;
import algorithm.game.location.DirectionLocation;
import algorithm.game.location.Location;
import algorithm.game.location.LocationsList;

import java.util.ArrayList;

public class ButtonClickInputForFXML implements InputWayOfPersonInput {

    private int inputValue;
    Person person;
//    Location x, y;

    public ButtonClickInputForFXML(Person person) {
        this.person = person;
    }

    @Override
    public int getInput() {
        return inputValue;
    }

    public void setLocationToGetCompassDirectionLocation(int x, int y) {
//        DirectionLocation directionLocation = new DirectionLocation();
        ArrayList<DirectionLocation> locationArrayList = new LocationsList().getListOfLocationsAccordingToPlayerCompass(person.getCompass());
        for (int i = 0; i < locationArrayList.size(); i++) {
            DirectionLocation directionLocation = locationArrayList.get(i);
            if (person.getLocation().getX() + directionLocation.getX() == x && person.getLocation().getY() + directionLocation.getY() == y) {
                inputValue = directionLocation.getId();
                System.out.println("Donecek deger : " + inputValue);
                return;
            }
        }

        inputValue = -1;
    }

}