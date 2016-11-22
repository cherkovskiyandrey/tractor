package ru.sbt.gameframework.units;

import ru.sbt.gameframework.Orientation;
import ru.sbt.gameframework.Position;
import ru.sbt.gameframework.gameplaces.GameField;
import ru.sbt.gameframework.units.exceptions.TractorInDitchException;
import ru.sbt.gameframework.commands.MoveForward.MoveForwardHandler;
import ru.sbt.gameframework.commands.TurnClockwise.TurnClockwiseHandler;

public class Tractor implements Unit, MoveForwardHandler, TurnClockwiseHandler {
    private GameField gameField;

    public void turnClockwise() {
        Orientation currentOrientation = gameField.getOrientationBy(this);
        currentOrientation = currentOrientation.turnClockwise();
        gameField.resetOrientation(this, currentOrientation);
    }

    public int getPositionX() {
        return gameField.getPositionBy(this).getX();
    }

    public int getPositionY() {
        return gameField.getPositionBy(this).getY();
    }

    public Orientation getOrientation() {
        return gameField.getOrientationBy(this);
    }


    //TODO: не ясно кто за что ответственен или поле в тихую двигает и уведомляет или мы принимаем команды.
    public void moveForward() throws TractorInDitchException {
        final Orientation orientation = getOrientation();
        final Position newPosition = orientation.moveForwards(gameField.getPositionBy(this));
        gameField.resetPosition(newPosition);
    }

    public void setGameField(GameField gameField) {
        this.gameField = gameField;
    }
}
