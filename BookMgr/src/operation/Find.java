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
 * 查找
 * 实现逻辑：查找列表中已有的书籍
 */
public class Find implements IOperation {

    @Override
    public void work(BookList bl) {

        System.out.println("====== Find Books ======");

        Scanner sc = new Scanner(System.in);
        System.out.println("Input the Bookname to Find:");
        String name = sc.nextLine();

        for(int i = 0; i < bl.getUsedSize(); i++){
            Book book = bl.getBooks(i);
            if(book.getName().equals(name)){
                System.out.println("Find Success!");
                System.out.println();
                return;
            }
        }
        System.out.println("Can Not Find This Book!");
        System.out.println();
    }
}
