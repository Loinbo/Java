package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * Created by Loinbo
 * DATE:2020/4/30
 * TIME:19:45
 */

/**
 * 归还
 * 实现逻辑：归还列表中已有的书籍
 */
public class Return implements IOperation {

    @Override
    public void work(BookList bl) {
        System.out.println("====== Return Books ======");

        Scanner sc = new Scanner(System.in);
        System.out.println("Input the Bookname to Return:");
        String name = sc.nextLine();

        for(int i = 0; i < bl.getUsedSize(); i++){
            Book book  = bl.getBooks(i);

            if(book.getName().equals(name)){

                book.setBorrowed(false);
                System.out.println("Return Success!");
                System.out.println();
                return;

            } else {
                System.out.println("Return Failed!");
                System.out.println();
            }
        }
        System.out.println("Can Not Find This Book!");
        System.out.println();
    }
}
