package day7;

public class Circle {
    int radius;

    public Circle(int radius) {
        if (radius < 0) {
            throw new IllegalArgumentException();
        } else {
            this.radius = radius;
        }
    }

    public double getArea(){
        return Math.PI * Math.pow(radius, 2);
    }

    public double getCircumference(){
        return 2 * Math.PI * radius;
    }
}
