package ru.sbt.gameframework.gameplaces;

import ru.sbt.gameframework.Orientation;
import ru.sbt.gameframework.Position;
import ru.sbt.gameframework.units.Unit;

import java.util.List;

public interface GameField {

    <T extends Unit> void regUnit(T unit, Position position, Orientation orientation);

    <T extends Unit> void unregUnit(T unit);

    void clear();

    List<Unit> getUnitsInSquare(Position from, Position to);

    List<Unit> getUnitsInLine(Position from, Position to);

    Position getPositionBy(Unit unit);

    Orientation getOrientationBy(Unit unit);

    void resetOrientation(Unit tractor, Orientation currentOrientation);

    void resetPosition(Position newPosition);

    //TODO: so on
}
