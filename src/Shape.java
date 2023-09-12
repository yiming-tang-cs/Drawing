public abstract class Shape {
    protected Position position;

    /**
     * Constructor method:
     * - It is used to create objects of this class
     * - The method name should be same as the class name
     * 
     * @param position
     */
    protected Shape(final Position position) {
        this.position = position;
    }

    /**
     * A concrete method with a method body
     * If this method is not a final method, this method could be overriden in
     * subclases
     * 
     * @param position
     */
    public void move(Position position) {
        this.position = position;
    }

    /**
     * An abstract method without method body.
     * You don't have to implement an abstract method. They should be overriden in
     * subclasses.
     */
    public abstract void draw();
}
