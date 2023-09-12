public class Circle extends Shape {
    private int radius;

    /**
     * Constuctor method. Constructor is optional. If you don't have a constructor
     * method, Java compiler could automatcally create a default one for you.
     * 
     * @param center
     * @param radius
     */
    public Circle(final Position center, final int radius) {
        super(center); // Invoke superclass's constructor method
        this.radius = radius;
    }

    /**
     * You should include the method implementation for this method.
     */
    public void draw() {
        /* Add some implemetantion here */
        System.out.println("Drawing a circle");
    }

    public void scale(double factor) {
        this.radius = (int) (radius * factor);
    }

    /**
     * Please note that position variable in the method is from the superclass
     * 
     * @param p
     * @return
     */
    public boolean hasPoint(Position p) {
        return p.distanceTo(position) <= radius;
    }

}
