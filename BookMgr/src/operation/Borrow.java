package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * Created by Loinbo
 * DATE:2020/4/30
 * TIME:19:43
 */

/**
 * 借阅
 * 实现逻辑：借阅列表 1.已有的 2.未借出 的书籍
 */
public class Borrow implements IOperation{

    @Override
    public void work(BookList bl) {

        System.out.println("====== Borrow Books ======");

        Scanner sc = new Scanner(System.in);
        System.out.println("Input the Bookname to Borrow:");
        String name = sc.nextLine();

        int i = 0;
        for(; i < bl.getUsedSize(); i++){
            Book book = bl.getBooks(i);
            if(book.getName().equals(name)){
                break;
            }
        }

        if(i >= bl.getUsedSize()){
            System.out.println("Can Not Find The Book!");
            System.out.println();
            return;
        }

        Book book = bl.getBooks(i);
        if(book.isBorrowed()){
            System.out.println("The Book was Borrowed!");
            System.out.println();
            return;
        } else {
            book.setBorrowed(true);
            System.out.println("Borrow Success!");
            System.out.println();
        }
    }
}
