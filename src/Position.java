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
