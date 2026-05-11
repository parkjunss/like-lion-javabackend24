package day21;
import java.util.*;
import java.util.stream.*;

class Book {
    private String title;
    private String author;
    private int year;
    private double price;

    public Book(String title, String author, int year, double price) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.price = price;
    }

    // TODO: getter 메서드 구현

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", year=" + year +
                ", price=" + price +
                '}';
    }
}


public class BookManagement {
    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("자바의 정석", "남궁성", 2016, 30000),
                new Book("모던 자바", "케빈", 2021, 35000),
                new Book("클린 코드", "로버트", 2013, 25000),
                new Book("이펙티브 자바", "조슈아", 2018, 28000),
                new Book("이펙티브 파이썬", "조슈아", 2022, 30000),

                new Book("자바 병렬 프로그래밍", "브라이언", 2022, 32000)
        );

        // TODO: 요구사항 구현
        // 2020년 이후 출판된 도서만 필터링
        List<Book> lateBooks = books.stream().filter(book -> book.getYear() >= 2020).toList();
        lateBooks.forEach((book) -> System.out.println(book.getTitle() + " : " + book.getAuthor() + " : " + book.getYear() ));

        // 가격이 20000원 이상인 도서 찾기
        List<Book> highBooks = books.stream().filter(book -> book.getPrice() > 20000).toList();
        highBooks.forEach((book) -> System.out.println(book.getTitle() + " : " + book.getPrice() + " : " + book.getYear() ));

        // 저자별로 도서를 그룹화
        Map<String, List<Book>> groupedByAuthor = books.stream().collect(Collectors.groupingBy(Book::getAuthor));
        groupedByAuthor.forEach((author, book) -> System.out.println( author + " : " + book.toString()));

        // 평균 가격 계산
        double avgPrice = books.stream()
                        .mapToDouble(Book::getPrice)
                        .average()
                        .orElse(0.0);
        System.out.println("Average price: " + avgPrice);
    }
}
