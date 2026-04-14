package day8;

abstract class Shape {
    String name;

    abstract double getArea();
    abstract double getPerimeter();

    public String getName() {
        return name;
    }
}

class Rectangle extends Shape {
    private final double width;
    private final double height;

    Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
        this.name = "Rectangle";
    }


    @Override
    double getArea() {
        return width * height;
    }

    @Override
    double getPerimeter() {
        return 2 * (width + height);
    }
}


class Circle extends Shape {
    private final double radius;

    Circle(double radius) {
        this.radius = radius;
        this.name = "Circle";
    }

    @Override
    double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    double getPerimeter() {
        return 2 * Math.PI * radius;
    }
}
