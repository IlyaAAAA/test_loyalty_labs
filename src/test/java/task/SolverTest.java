package task;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class SolverTest {

    @Test
    public void simpleTest() {
        Solver solver = new Solver();
        Point expectedPoint = new Point(3, 3);

        Point point = solver.solve(
                4,
                4,
                2,
                2,
                Direction.RIGHT,
                List.of(
                        Command.FORWARD,
                        Command.LEFT,
                        Command.RIGHT,
                        Command.RIGHT,
                        Command.FORWARD
                )
        );

        Assertions.assertEquals(expectedPoint, point);
    }

    @Test
    public void simpleTestWithForward() {
        Solver solver = new Solver();
        Point expectedPoint = new Point(2, 3);

        Point point = solver.solve(
                4,
                4,
                2,
                2,
                Direction.RIGHT,
                List.of(
                        Command.FORWARD
                )
        );

        Assertions.assertEquals(expectedPoint, point);
    }

    @Test
    public void testWithOutOfBoundsY() {
        Solver solver = new Solver();
        Point expectedPoint = new Point(4, 4);

        Point point = solver.solve(
                4,
                4,
                4,
                4,
                Direction.RIGHT,
                List.of(
                        Command.FORWARD,
                        Command.FORWARD
                )
        );

        Assertions.assertEquals(expectedPoint, point);
    }

    @Test
    public void testWithOutOfBoundsX() {
        Solver solver = new Solver();
        Point expectedPoint = new Point(1, 4);

        Point point = solver.solve(
                4,
                4,
                1,
                4,
                Direction.RIGHT,
                List.of(
                        Command.LEFT,
                        Command.FORWARD,
                        Command.FORWARD
                )
        );

        Assertions.assertEquals(expectedPoint, point);
    }
}
