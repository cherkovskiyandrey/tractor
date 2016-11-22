package ru.sbt.gameframework;

import ru.sbt.gameframework.gameplaces.GameField;

public enum Orientation {

    NORTH {

                @Override
                public Orientation turnClockwise() {
                    return EAST;
                }

                @Override
                public Position moveForwards(Position p) {
                    return new Position(p.getX(), p.getY() + 1);
                }
            },
    WEST {

                @Override
                public Orientation turnClockwise() {
                    return NORTH;

                }

                @Override
                public Position moveForwards(Position p) {
                    return new Position(p.getX() - 1, p.getY());
                }
            },
    SOUTH {

                @Override
                public Orientation turnClockwise() {
                    return WEST;
                }

                @Override
                public Position moveForwards(Position p) {
                    return new Position(p.getX(), p.getY() - 1);
                }
            },
    EAST {

                @Override
                public Orientation turnClockwise() {
                    return SOUTH;
                }

                @Override
                public Position moveForwards(Position p) {
                    return new Position(p.getX() + 1, p.getY());
                }
            };

    public abstract Orientation turnClockwise();

    public abstract Position moveForwards(Position p);

    public abstract Position getBorderFor(Position positionFrom, GameField gameField);
}
