package book;

/**
 * Created by Loinbo
 * DATE:2020/4/30
 * TIME:19:29
 */

public class BookList {

    private Book[] books = new Book[100];
    private int usedSize = 0;

    public BookList(){
        books[0] = new Book("C","AA",56,"Programming");
        books[1] = new Book("Java","BB",78,"Programming");
        books[2] = new Book("Python","CC",45,"Programming");
        this.usedSize = 3;
    }

    public void setBooks(int pos,Book book){
        this.books[pos] = book;
    }

    public int getUsedSize() {
        return usedSize;
    }

    public void setUsedSize(int usedSize) {
        this.usedSize = usedSize;
    }

    public Book getBooks(int pos){
        return this.books[pos];
    }

}
