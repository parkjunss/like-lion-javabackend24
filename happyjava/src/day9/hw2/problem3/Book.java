package day9.hw2.problem3;

public class Book {
    private final String bookName;
    private final String author;
    private final String isbn;
    private boolean isAvaliable;

    // 생성자 책이름 작가 isbn
    public Book(String bookName, String author, String isbn) {
        this.bookName = bookName;
        this.author = author;
        this.isbn = isbn;
        this.isAvaliable = true;
    }

    // 책 대출
    public void borrowBook(){
        if (this.isAvaliable){
            this.isAvaliable = false;
        }
    }
    // 책 반납
    public void returnBook(){
        if (!this.isAvaliable){
            this.isAvaliable = true;
        }
    }
    // 책 정보 반환
    public void showBookInfo(){
        System.out.println("Title: " + this.getBookName());
        System.out.println("Author: " + this.getAuthor());
        System.out.println("ISBN: " + this.getIsbn());
        System.out.println("Status: " + (this.isAvaliable ? "Available" : "Not Available"));
    }

    // 책 대출 가능 여부
    public boolean getIsAvailable(){
        return this.isAvaliable;
    }


    // 책 이름
    public String getBookName(){
        return this.bookName;
    }
    // 책 작가
    public String getAuthor(){
        return this.author;
    }
    // 책 isbn
    public String getIsbn(){
        return this.isbn;
    }
}
