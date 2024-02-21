package task;

import java.util.List;

public class Solver {
    public Point solve(int n, int m, int x, int y, Direction startDirection, List<Command> commandList) {
        int currentX = x - 1;
        int currentY = y - 1;

        Direction currDirection = startDirection;


        for (Command command : commandList) {

            switch (command) {
                case Command.FORWARD -> {
                    if (currDirection == Direction.DOWN) {
                        if (currentX + 1 < n) {
                            currentX++;
                        }
                    }

                    if (currDirection == Direction.UP) {
                        if (currentX - 1 > 0) {
                            currentX--;
                        }
                    }

                    if (currDirection == Direction.LEFT) {
                        if (currentY - 1 > 0) {
                            currentY--;
                        }
                    }

                    if (currDirection == Direction.RIGHT) {
                        if (currentY + 1 < m) {
                            currentY++;
                        }
                    }
                }
                case Command.LEFT -> {
                    switch (currDirection) {
                        case UP -> currDirection = Direction.LEFT;
                        case DOWN -> currDirection = Direction.RIGHT;
                        case LEFT -> currDirection = Direction.DOWN;
                        case RIGHT -> currDirection = Direction.UP;
                    }
                }
                case Command.RIGHT -> {
                    switch (currDirection) {
                        case UP -> currDirection = Direction.RIGHT;
                        case DOWN -> currDirection = Direction.LEFT;
                        case LEFT -> currDirection = Direction.UP;
                        case RIGHT -> currDirection = Direction.DOWN;
                    }
                }
            }

        }

        return new Point(currentX + 1, currentY + 1);
    }
}
