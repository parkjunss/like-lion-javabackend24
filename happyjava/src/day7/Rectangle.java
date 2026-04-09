package day7;

public class Rectangle {
    int width;
    int height;

    public Rectangle(int width, int height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException();
        } else {
            this.width = width;
            this.height = height;
        }
    }

    public int getArea() {
        return width * height;
    }

}
