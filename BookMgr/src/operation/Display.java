package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * Created by Loinbo
 * DATE:2020/4/30
 * TIME:19:44
 */

/**
 * 显示
 * 实现逻辑：显示全列表书籍
 */
public class Display implements IOperation {

    @Override
    public void work(BookList bl) {
        System.out.println("====== Display Books ======");

        for(int i = 0; i < bl.getUsedSize(); i++){
            Book book = bl.getBooks(i);
            System.out.println(book);
        }
        System.out.println();
    }
}
