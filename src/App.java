import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Collectors;

public class App {

    private static Set<Shape> shapes = new HashSet<>();

    public static void addShapes() {
        // Automatically generate a circle set.
        Set<Shape> circleSet = IntStream.range(0, 5)
                .mapToObj(i -> new Circle(new Position(-i, -i), 0))
                .collect(Collectors.toSet());
        // Add the circle set into the shape set
        shapes.addAll(circleSet);

        // Automatically generate a rectangle set.
        Set<Shape> rectangleSet = IntStream.range(0, 5)
                .mapToObj(i -> new Rectangle(new Position(i, i), 2 * i, 2 * i))
                .collect(Collectors.toSet());
        // Add the rectangle set into the shape set
        shapes.addAll(rectangleSet);
    }

    public static void main(String[] args) throws Exception {
        addShapes();
        shapes.forEach(shape -> shape.draw());
    }
}
