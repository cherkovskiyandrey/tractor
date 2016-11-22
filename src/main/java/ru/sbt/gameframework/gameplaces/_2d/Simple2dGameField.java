package ru.sbt.gameframework.gameplaces._2d;

import ru.sbt.gameframework.Orientation;
import ru.sbt.gameframework.gameplaces.GameField;
import ru.sbt.gameframework.Position;
import ru.sbt.gameframework.units.Tractor;
import ru.sbt.gameframework.units.Unit;
import ru.sbt.gameframework.units.exceptions.TractorInDitchException;

import java.util.List;

public class Simple2dGameField implements GameField{

    public static GameField newFieldAsPolygon(Position position, Position position1, Position position2, Position... position3) {
    //TODO
        return null;
    }


    public <T extends Unit> void regUnit(T unit, Position position, Orientation orientation) {

    }

    public <T extends Unit> void unregUnit(T unit) {

    }

    public void clear() {

    }

    public List<Unit> getUnitsInSquare(Position from, Position to) {
        return null;
    }

    public List<Unit> getUnitsInLine(Position from, Position to) {
        return null;
    }

    public Position getPositionBy(Unit unit) {
        return null;
    }

    public Orientation getOrientationBy(Tractor unit) {
        return null;
    }

    public void resetOrientation(Tractor tractor, Orientation currentOrientation) {

    }

    public void resetPosition(Position newPosition) {

        if (p.getX() > field[0] || p.getY() > field[1] || p.getX() < 0 || p.getY() < 0) {
            throw new TractorInDitchException();
        }
        position = p;
    }
}
