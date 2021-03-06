package algorithm.game.gamerepo.player;


import algorithm.compass.Compass;
import algorithm.game.Game;
import algorithm.game.gamerepo.player.robot.TimeKeeper;
import algorithm.game.location.DirectionLocation;
import algorithm.game.location.Location;
import algorithm.game.location.LocationsList;
import algorithm.game.play.PlayerMove;
import algorithm.game.play.input.person.IPlayerInput;
import algorithm.game.rule.BaseGameRule;
import algorithm.print.FileWriteProcess;
import algorithm.print.PrintAble;

public abstract class Player implements UpdateableVistedDirection, PrintableEveryStepToSee {
    protected IPlayerInput iPlayerInput;
    protected PlayerMove playerMove;
    protected String name;
    protected PrintAble printableFileScore;
    protected boolean printAbleEveryStep;

    protected int squareTotalSolvedValue = 0;
    protected Game game;
    private boolean visitedDirections[][];
    TimeKeeper timeKeeper = new TimeKeeper();
    Score score;


    public void clearVisitedDirections() {
        visitedDirections = new boolean[(int) Math.pow(game.getModel().getGameSquares().length, 2)]
                [new LocationsList().getListOfLocationsAccordingToPlayerCompass(game.getPlayer().getCompass()).size()];
    }

    public void clearStepValue() {
        step = 0;
    }

    public void setGame(Game game) {
        this.game = game;
        game.setPlayer(this);
        score = new Score(game, this);
        clearVisitedDirections();


        int squareEdge = game.getModel().getGameSquares().length;
        printableFileScore = new FileWriteProcess((squareEdge * squareEdge) + "_EverySingleSquareTotalValue");

    }

    public abstract void setPlayerMove(PlayerMove playerMove/*MoveForward moveForward, MoveBack moveBack*/);


    public BaseGameRule gameRule;
    Location location = new Location();

    private int step = 0;

    private Compass compass;

    public abstract BaseGameRule getGameRule();

    public void setGameRules(BaseGameRule gameRule) {
        this.gameRule = gameRule;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public void increaseStep() {
        step++;
    }

    public void decreaseStep() {
        step--;
    }

    public final int getInput(Game game) {
        return iPlayerInput.getInput(game);
    }

    public abstract Compass getCompass();

    @Override
    public void updateVisitedDirection(boolean sealOrUnseal, int step, DirectionLocation location) {

    }

    public Game getGame() {
        return game;
    }

    public boolean[][] getVisitedDirections() {
        return visitedDirections;
    }

    public TimeKeeper getTimeKeeper() {
        return timeKeeper;
    }

    public Score getScore() {
        return score;
    }

    public PlayerMove getPlayerMove() {
        return playerMove;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSquareTotalSolvedValue() {
        return squareTotalSolvedValue;
    }

    public void increaseSquareTotalSolvedValue() {
        squareTotalSolvedValue++;
    }

    public void resetSquareTotalSolvedValue() {
        squareTotalSolvedValue = 0;
    }

    public PrintAble getPrintableFileScore() {
        return printableFileScore;
    }

    public IPlayerInput getIPlayerInput() {
        return iPlayerInput;
    }

    public void setIPlayerInput(IPlayerInput iPlayerInput) {
        this.iPlayerInput = iPlayerInput;
    }

}
