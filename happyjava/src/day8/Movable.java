package day8;

interface Movable {
    void move(int x, int y);
}

interface Drawable {
    void draw();
}

class GameObject implements Movable, Drawable {
    int x, y;
    GameObject (int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void draw() {
        System.out.printf("객체가 (%d,%d)에 그려졌습니다.\n", this.x, this.y);
    }
}
