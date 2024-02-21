package task;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Path path = Path.of("input_file");

        try (Stream<String> stream = Files.lines(path)) {
            int n;
            int m;
            int currX;
            int currY;
            Direction direction;
            List<Command> commands = new ArrayList<>();

            List<String> lines = stream.toList();


            String[] split = lines.get(0).split(" ");
            n = Integer.parseInt(split[0]);
            m = Integer.parseInt(split[1]);

            split = lines.get(1).split(" ");

            currX = Integer.parseInt(split[0]);
            currY = Integer.parseInt(split[1]);

            direction = Direction.valueOf(lines.get(2));

            for (int i = 3; i < lines.size(); i++) {
                commands.add(Command.valueOf(lines.get(i)));
            }

            Solver solver = new Solver();
            Point point = solver.solve(n, m, currX, currY, direction, commands);

            System.out.println("X : " + point.x() + " and Y: " + point.y());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
