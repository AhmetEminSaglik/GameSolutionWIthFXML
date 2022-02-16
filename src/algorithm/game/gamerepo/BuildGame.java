package algorithm.game.gamerepo;

import algorithm.game.Game;
import algorithm.validation.SquareValidationGame;

import java.util.Scanner;

public class BuildGame /*implements IDetermineEdgeValue*/ {

    // horizontalSquare and verticalSquare are unnecessary. But later I may need them if I want to play as a rectangle instead of square
    private int edgeValue;
    //    private int verticalSquare;
    private Game game;
    IDetermineEdgeValue IDetermineEdgeValue;

    public BuildGame(IDetermineEdgeValue IDetermineEdgeValue) {
        this.IDetermineEdgeValue = IDetermineEdgeValue;
        edgeValue = determineEdgeValue();
//        System.out.println("buradaki deger : "+edgeValue);
        buildGame(edgeValue);
//        IDetermineEdgeValue.determineEdgeValue();

    }

//    public BuildGame(int edgeValue) {
//        buildGame(edgeValue);
//    }

    private void buildGame(int edgeValue) {
        try {
            this.edgeValue = edgeValue;
            new SquareValidationGame(edgeValue, edgeValue);
//            this.edgeValue = edgeValue;
//            System.out.println("simdiki edge value : "+edgeValue);
            game = new Game();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            buildGame(determineEdgeValue());

        }
    }

    public Game createGame() {

        game.setModel(new Model());

        game.getModel().setGameSquares(createMultipleArrayFromIntegers(edgeValue));

        return game;
    }

    public Game createVisitedArea() {
        game.getModel().setVisitedAreas(buildVisitedArea(game));
        clearVisitedAreas(game);
        return game;

    }

    public int[][] createMultipleArrayFromIntegers(int edgeValue/*, int horizontalSquare*/) {
        return new int[edgeValue][edgeValue];
    }

    boolean[][] buildVisitedArea(Game game) {
        return new boolean[edgeValue][edgeValue];
    }

    void clearVisitedAreas(Game game) {
        for (int i = 0; i < game.getModel().getVisitedAreas().length; i++) {
            for (int j = 0; j < game.getModel().getVisitedAreas().length; j++) {
                game.getModel().getVisitedAreas()[i][j] = false;
            }
        }
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }


    public int determineEdgeValue() {
//        System.out.print("Determine Edge value of Square :  ");
//        return new Scanner(System.in).nextInt();
        return IDetermineEdgeValue.determineEdgeValue();
    }
}
