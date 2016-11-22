/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.sbt.gameframework.units;

import ru.sbt.gameframework.CommandBroker;
import ru.sbt.gameframework.Orientation;
import ru.sbt.gameframework.Position;
import ru.sbt.gameframework.commands.Shoot.ShootHandler;
import ru.sbt.gameframework.commands.TurnClockwise.TurnClockwiseHandler;
import ru.sbt.gameframework.gameplaces.GameField;

import java.util.List;

/**
 *
 * @author admin
 */
public class Tower implements Unit, TurnClockwiseHandler, ShootHandler {

    private GameField gameField;
    private Orientation orientation = Orientation.NORTH;

    public void turnClockwise() {
        orientation = orientation.turnClockwise();
    }

    public void shoot() {
        System.out.println("I`am shooting...");
        Position positionFrom = gameField.getPositionBy(this);
        Orientation orientation = getOrientation();
        Position positionTo = orientation.getBorderFor(positionFrom, gameField);
        List<Unit> shootUnits = gameField.getUnitsInLine(positionFrom, positionTo);
        final CommandBroker broker = new CommandBroker(shootUnits);
        broker.applyCommand(new Dead());
    }

    public Orientation getOrientation() {
        return gameField.getOrientationBy(this);
    }

    public void setGameField(GameField gameField) {

    }
}
