package day9.hw2.problem3;

public class Library {
    private Book[] books;

    // 생성자 초기에 책 없음
    public Library(){
        this.books = new Book[0];
    }

    // 책 추가 배열 길이보다 +1 해서 추가
    public void addBook(Book book){
        Book[] newBooks = new Book[books.length + 1];
        System.arraycopy(books, 0, newBooks, 0, books.length);
        newBooks[newBooks.length - 1] = book;
        books = newBooks;
    }

    // 책 이름으로 책 반환
    public Book findBookByTitle(String title){
        for(Book book : books){
            if(book.getBookName().equals(title)){
                return book;
            }
        }
        return null;
    }

    // 대출 가능한 책 목록 출력
    public void displayAvailableBooks(){
        System.out.println("Available Books:");
        for (Book book : books) {
            if (book.getIsAvailable()) { // 대여 가능한 경우만 출력
                System.out.println("Title : " +  book.getBookName());
            }
        }
    }

    // 책 대출 시 출력
    public void borrowBook(String title) {
        Book targetBook = findBookByTitle(title);

        if (targetBook == null) {
            System.out.println("Error: '" + title + "' does not exist.");
            return;
        }

        if (targetBook.getIsAvailable()) {
            targetBook.borrowBook();
            System.out.println("Success: '" + targetBook.getBookName() + "' has been borrowed.");
        } else {
            System.out.println("Fail: '" + targetBook.getBookName() + "' is already on loan.");
        }
    }

    // 책 반환 시 출력
    public void returnBook(String title){
        Book targetBook = findBookByTitle(title);
        if(targetBook == null){
            System.out.println("Title : " +  title + " is not Exist");
        } else {
            if (!targetBook.getIsAvailable()) {
                targetBook.returnBook();
                System.out.println("Title : " +  targetBook.getBookName() + " is Returned");

            }  else if(targetBook.getIsAvailable()) {
                System.out.println("Title : " +  targetBook.getBookName() + " is Already Returned");
            }
        }
    }

}
