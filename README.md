# Creat your Java project

- Open VS code.

- Press `Ctrl + Shift + P` -> Select `Java: Create Java project...` or Click on `Create Java Project` button on the welcome page

- Select `No build tools` (if you want to create a **maven** project,  you can choose maven)

- Select the project folder

- Enter project name, such as "Drawing"


## Create Shape class

- Right click on `src`
- Select `New file`

    VScode can automatically generate the code below for you:
    ```
    public class Shape {
    
    }
    ```
- Change class type
`public class Shape {` -> `public abstract class Shape {`
- Add a position attribute
    - Create a `Position.java` file in `src`. You can create a Positon class as you wish.
    Here is my example: 
    ``` 
    import java.lang.Math;

    public class Position {

        private double x;
        private double y;

        public double getX() {
            return x;
        }

        public double getY() {
            return x;
        }

        public Position(double x, double y){
            this.x = x;
            this.y = y;
        }

        public double distanceTo(Position p) {
            return Math.sqrt(Math.pow(x - p.getX(), 2) + Math.pow(y - p.getY(), 2));
        }

    }
    ```
    - Add a position *attribute* in the `Shape` class. Please note that its attribute modifier is `protected` since you want the `Shape`'s subclasses can access this attribute.
    ```
    protected Position position;
    ```
- Add a *contructor method*. Since `Shape` is an abstract calss, its contructor should be protected.
    ```
    protected Shape(final Position position) {
        this.position = position;
    }
    ```
- Add concrete/abstract methods
    - Add concrete methods:
    ```
    public void move(Position position) {
        this.position = position;
    }
    ```
    - Add abstract methods:
    ```
    public abstract void draw();
    ```

## Create Circle class

- Right click on `src` to create a `Circle.java` file

- Make `Circle` extend `Shape` since `Circle` is the subclass of `Shape`:

    `public class Circle {` -> `public class Circle extends Shape {`

- Add an attribute `radius` which is specific to `Circle`. It is a private attribute since `Circle` is a concete class.
```
    private int radius;
```

- Add a constructor method and this method should invoke the superclass's constructor method.
```
    public Circle(final Position center, final int radius) {
        super(center); 
        this.radius = radius;
    }
```

- Implement the abstract methods from superclass. 
```
    public void draw() {
        /* Add some implemetantion here */
        System.out.println("Drawing a circle");
    }
```


- Add some customized methods:
```
    public void scale(float factor) {
        this.radius = (int) (radius * factor);
    }

    public boolean hasPoint(Position p) {
        return p.distanceTo(position) <= radius;
    }
```

## Create Rectangle class

- Right click on `src` to create a `Rectangle.java` file

- Make `Rectangle` extend `Shape`

- Add attributes `width` and `height`
```
    private int width;
    private int height;
```

- Add a constructor method
```
    public Rectangle(final Position center, final int width, final int height) {
        super(center);
        this.width = width;
        this.height = height;
    }
```

- Implement the abstract methods from superclass. 
```
    public void draw() {
        /* Add some implemetantion here */
        System.out.println("Drawing a circle");
    }
```

-  Add some customized methods. For example:
```
    public void scale(double factor) {
        this.width = (int) (this.width * factor);
        this.height = (int) (this.height * factor);
    }
```

## Modify the main method (it is the entry of your project). 

- Click on `App.java`

- Add an attribute: a set of shapes. I am using a static attribute since I need to use main method as the entry of the project and the main method is a static method.
```
    private static Set<Shape> shapes = new HashSet<>();
```


- Create a method to add testing data. Here is an example. You can create a method as you wish.
    ```
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
    ```

- Modify `main` method.
```
    public static void main(String[] args) throws Exception {
        addShapes();
        shapes.forEach(shape -> shape.draw());
    }
```

# Execution and Output
Click on `Run` -> `Run without Debugging` 

The output should be:
```
Drawing a rectangle
Drawing a rectangle
Drawing a circle   
Drawing a circle   
Drawing a circle   
Drawing a rectangle
Drawing a rectangle
Drawing a circle   
Drawing a rectangle
Drawing a circle  
```

*The order of elements doesn't matter, because set doesn't record the order.*





