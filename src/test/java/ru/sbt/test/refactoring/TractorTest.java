package ru.sbt.test.refactoring;

import java.util.Arrays;
import java.util.List;

import org.junit.After;
import ru.sbt.gameframework.gameplaces.GameField;
import ru.sbt.gameframework.Position;
import ru.sbt.gameframework.gameplaces._2d.Simple2dGameField;
import ru.sbt.gameframework.units.Tractor;
import ru.sbt.gameframework.Orientation;
import junit.framework.TestCase;
import ru.sbt.gameframework.CommandBroker;
import ru.sbt.gameframework.commands.MoveForward.MoveForwardCommand;
import ru.sbt.gameframework.commands.Shoot.ShootCommand;
import ru.sbt.gameframework.commands.TurnClockwise.TurnClockwiseCommand;
import ru.sbt.gameframework.units.Tower;
import ru.sbt.gameframework.units.Unit;

/**
 * @author Ben
 *
 */
public class TractorTest extends TestCase {

    private final GameField gameField;

    public TractorTest() {
        this.gameField = Simple2dGameField.newFieldAsPolygon(
                new Position(-10, -10),
                new Position(-10, 10),
                new Position(10, 10),
                new Position(10, -10)
        );
    }

    @After
    public void destory() {
        gameField.clear();
    }

    public void testUnitsInSquare() {
        final Tractor tractor = new Tractor(); //TODO: size
        gameField.regUnit(tractor, new Position(0, 0), Orientation.NORTH);
        final Tower tower = new Tower(); //TODO: size
        gameField.regUnit(tower, new Position(-5, 5), Orientation.NORTH);
        final List<Unit> units = gameField.getUnitsInSquare(
                new Position(-1, -1),
                new Position(1, 1)
        );
        assertEquals(1, units.size());
        assertEquals(tractor, units.get(0));
    }

    public void testShouldMoveForward() {
        final Tractor tractor = new Tractor(); //TODO: size
        gameField.regUnit(tractor, new Position(0, 0), Orientation.NORTH);
        final List<Unit> units = gameField.getUnitsInSquare(
                new Position(-1, -1),
                new Position(1, 1)
        );
        final CommandBroker broker = new CommandBroker(units);
        broker.applyCommand(new MoveForwardCommand()));
        //tractor.move("F");
        assertEquals(0, tractor.getPositionX());
        assertEquals(1, tractor.getPositionY());
    }

    public void testShouldTurn() {
        final Tractor tractor = new Tractor(); //TODO: size
        gameField.regUnit(tractor, new Position(0, 0), Orientation.NORTH);
        final List<Unit> units = gameField.getUnitsInSquare(
                new Position(-1, -1),
                new Position(1, 1)
        );
        final CommandBroker broker = new CommandBroker(units);
        broker.applyCommand(new TurnClockwiseCommand());
//                tractor.move("T");
        assertEquals(Orientation.EAST, tractor.getOrientation());
//		tractor.move("T");
        broker.applyCommand(new TurnClockwiseCommand());
        assertEquals(Orientation.SOUTH, tractor.getOrientation());
        //tractor.move("T");
        broker.applyCommand(new TurnClockwiseCommand());
        assertEquals(Orientation.WEST, tractor.getOrientation());
        //tractor.move("T");
        broker.applyCommand(new TurnClockwiseCommand());
        assertEquals(Orientation.NORTH, tractor.getOrientation());
    }

    public void testShouldTurnAndMoveInTheRightDirection() {
        final Tractor tractor = new Tractor(); //TODO: size
        gameField.regUnit(tractor, new Position(0, 0), Orientation.NORTH);
        final List<Unit> units = gameField.getUnitsInSquare(
                new Position(-1, -1),
                new Position(1, 1)
        );
        final CommandBroker broker = new CommandBroker(units);
        broker.applyCommands(new TurnClockwiseCommand(), new MoveForwardCommand());
        //tractor.move("T");
        // tractor.move("F");
        assertEquals(3, tractor.getPositionX());
        assertEquals(2, tractor.getPositionY());
        // tractor.move("T");
        // tractor.move("F");
        broker.applyCommands(new TurnClockwiseCommand(), new MoveForwardCommand());
        assertEquals(3, tractor.getPositionX());
        assertEquals(1, tractor.getPositionY());
        //tractor.move("T");
        //tractor.move("F");
        broker.applyCommands(new TurnClockwiseCommand(), new MoveForwardCommand());
        assertEquals(2, tractor.getPositionX());
        assertEquals(1, tractor.getPositionY());
        //tractor.move("T");
        //tractor.move("F");
        broker.applyCommands(new TurnClockwiseCommand(), new MoveForwardCommand());
        assertEquals(2, tractor.getPositionX());
        assertEquals(2, tractor.getPositionY());
    }

    public void testShouldThrowExceptionIfFallsOffPlateau() {
        final Tractor tractor = new Tractor(); //TODO: size
        gameField.regUnit(tractor, new Position(0, 0), Orientation.NORTH);
        final List<Unit> units = gameField.getUnitsInSquare(
                new Position(-1, -1),
                new Position(1, 1)
        );
        final CommandBroker broker = new CommandBroker(units);
        broker.applyCommands(new MoveForwardCommand(), new MoveForwardCommand(), new MoveForwardCommand(), new MoveForwardCommand(), new MoveForwardCommand());
//        tractor.move("F");
        //    tractor.move("F");
        //      tractor.move("F");
        //    tractor.move("F");
        //    tractor.move("F");
        // try {
        //tractor.move("F");
        assertTrue(broker.applyCommand(new MoveForwardCommand()).isEmpty());
        //    fail("Tractor was expected to fall off the plateau");
        // } catch (TractorInDitchException expected) {
        // }
    }

    public void testTowerShouldNotMoveForward() {
        Tower tower = new Tower();
        final CommandBroker broker = new CommandBroker(Arrays.asList(tower));
        assertTrue(broker.applyCommand(new MoveForwardCommand()).isEmpty());
    }

    public void testTowerShouldShoot() {
        Tower tower = new Tower();
        final CommandBroker broker = new CommandBroker(Arrays.asList(tower));
        assertFalse(broker.applyCommand(new ShootCommand()).isEmpty());
    }
}
