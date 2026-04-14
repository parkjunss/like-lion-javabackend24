package day9;

class Pen {
    String color;
    String company;
    String name;

    public Pen(String color, String company, String name) {
        this.color = color;
        this.company = company;
        this.name = name;
    }

    @Override
    public String toString() {
        return "이 펜은 " + company + "에서 만든 " + name + "입니다. 색상은 " + color + "입니다.";
    }
}

public class Exam02 {
    public static void main(String[] args) {
        Pen p = new Pen("빨강", "모나미", "볼펜");
        System.out.println(p);
    }
}