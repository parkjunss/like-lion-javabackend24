package day8;

public class ClassTest {
    public static void main(String[] args) {

        System.out.println("Q1");
        Animal Dog = new Dog("Dogg");
        Animal Cat = new Cat("Catt");

        Dog.makeSound();
        Dog.eat();

        Cat.makeSound();
        Cat.eat();

        System.out.println("Q2");
        Shape[] shapes = new Shape[2];

        shapes[0] = new Rectangle(5, 4);
        shapes[1] = new Circle(3);

        for (Shape shape : shapes) {
            System.out.printf("%s - Area: %.2f, Perimeter: %.2f\n", shape.getName(), shape.getArea(), shape.getPerimeter());
        }

        System.out.println("Q3");
        DocumentConverter htmlConverter = new HtmlConverter();
        DocumentConverter markdownConverter = new MarkdownConverter();

        String htmlContent = htmlConverter.convert("Hello Java");
        String markdownContent = markdownConverter.convert("Hello Java");

        htmlConverter.print(htmlContent);
        markdownConverter.print(markdownContent);

        System.out.println("Q4");
        Payment cardPayment = new CardPayment(10000);
        Payment paypalPayment = new PaypalPayment(5000);
        cardPayment.pay();
        paypalPayment.pay();

        System.out.println("Q5");
        Transport[] transports = new Transport[2];
        transports[0] = new Bus(40);
        transports[1] = new Airplane(300);

        for (Transport transport : transports) {
            transport.move();
            transport.showCapacity();
        }
    }
}
