public class Rectangle extends Shape {
    private int width;
    private int height;

    public Rectangle(final Position center, final int width, final int height) {
        super(center);
        this.width = width;
        this.height = height;
    }


    public void draw() {
        /* Add some implemetantion here */
        System.out.println("Drawing a rectangle");
    }

    public void scale(double factor) {
        this.width = (int) (this.width * factor);
        this.height = (int) (this.height * factor);
    }

}
