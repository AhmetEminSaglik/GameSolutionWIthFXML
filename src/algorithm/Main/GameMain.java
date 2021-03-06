package algorithm.Main;

import algorithm.errormessage.joptionpanel.ShowPanel;
import algorithm.game.Game;
import algorithm.game.gamerepo.BuildGame;
import algorithm.game.gamerepo.IDetermineEdgeValue;
import algorithm.game.gamerepo.player.Player;
import algorithm.game.gamerepo.player.person.Person;
import algorithm.game.gamerepo.player.robot.Robot;
import algorithm.game.gamerepo.player.robot.solution.BaseSolution;
import algorithm.game.gamerepo.player.robot.solution.first.FirstSolution_Combination;
import algorithm.game.gamerepo.player.robot.solution.second.SecondSolution_CalculateForwardAvailableWays;
import algorithm.game.move.ChangeLocationByAdding;
import algorithm.game.move.ChangeLocationByExactlyLocation;
import algorithm.game.move.fundamental.MoveBack;
import algorithm.game.move.fundamental.MoveForward;
import algorithm.game.play.PlayGame;
import algorithm.game.play.PlayerMove;
import algorithm.game.play.input.person.ButtonClickInputForFXML;
import algorithm.game.play.input.person.PersonInput;
import algorithm.game.play.input.person.SafeScannerInput;
import algorithm.game.play.input.robot.RobotInput;

import java.util.Scanner;


public class GameMain implements ISelectPlayer {

    BaseSolution baseSolution;

    public static void main(String[] args) throws InterruptedException {
        GameMain main = new GameMain();
        IDetermineEdgeValue determineValueWithScanner = new IDetermineEdgeValue() {
            @Override
            public int determineEdgeValue() {
                System.out.print("Determine Edge value of Square :  ");
                return new Scanner(System.in).nextInt();
            }
        };

        BuildGame buildGameModel = new BuildGame(determineValueWithScanner);

        Game game = buildGameModel.createGame();

        Player player = main.selectPlayer(game);


        buildGameModel.createVisitedArea();

        PlayGame playGame = new PlayGame(game);
        playGame.playGame();
        System.out.println();

        if (main.baseSolution != null)
            System.out.println(main.baseSolution.getClass().getSimpleName());
        System.out.println("Game Dimension : " + game.getModel().getGameSquares().length + "-" + game.getModel().getGameSquares().length);

        System.out.println("----------------");


    }

    public Player selectPlayer(Game game) {
        System.out.println("Select Player : \nPerson : 1 \n Robot : 2");

        String input = new Scanner(System.in).nextLine();
        if (input.equals("1")) {
            Person person = new Person();
            person.setGame(game);
            person.setIPlayerInput(new PersonInput(new ButtonClickInputForFXML(person)));
            person.setPlayerMove(new PlayerMove(new MoveForward(person.getGame()), new MoveBack(person.getGame())));
            System.out.println("game : " + game.toString());
            return person;
//            return new Person(/*game*/);
        } else if (input.equals("2")) {
            Robot robot = new Robot();
            robot.setGame(game);
            baseSolution = new SecondSolution_CalculateForwardAvailableWays(/*game*/);
            baseSolution.setGame(game);
            robot.setSolution(baseSolution);
            robot.setIPlayerInput(new RobotInput(robot.getSolution()));
            MoveForward moveForward= new MoveForward(game);
            moveForward.setChangePlayerLocation(new ChangeLocationByExactlyLocation(robot));
            baseSolution.setMoveForward(moveForward);

            MoveBack moveBack= new MoveBack(game);
            moveBack.setChangePlayerLocation(new ChangeLocationByAdding(robot));
            baseSolution.setMoveBack(moveBack);
            robot.setPlayerMove(new PlayerMove(baseSolution.getMoveForward(), baseSolution.getMoveBack()));

//            robot.setPlayerMove(new PlayerMove(new MoveForward(game),new MoveBack(game)));
            System.out.println("Robot : "+robot);
            System.out.println(robot.getPlayerMove().toString());
            return robot;

//            return new Robot(game, baseSolution);

        } else {
            System.out.println("Unknow choice ");
            return selectPlayer(game);
        }

    }





}

