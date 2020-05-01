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
 * 移除
 * 实现逻辑：删除列表 1.已有的 2.未借出的 书籍
 */
public class Delete implements IOperation {

    @Override
    public void work(BookList bl) {

        System.out.println("====== Delete Books ======");

        Scanner sc = new Scanner(System.in);
        System.out.println("Input the Bookname to Delete:");
        String name  = sc.nextLine();

        int i = 0;
        for(; i < bl.getUsedSize(); i++){
            Book book = bl.getBooks(i);
            if(book.getName().equals(name)){
                break;
            }
        }

        if(i == bl.getUsedSize()){
            System.out.println("Can Not Find The Book!");
            System.out.println();
            return;
        }

        if(bl.getBooks(i).isBorrowed()){
            System.out.println("The Book was Borrowed, Delete Failed!");
            System.out.println();
            return;
        } else {

            for(int pos = i; pos < bl.getUsedSize() - 1; pos ++){
                bl.setBooks(pos,bl.getBooks(pos + 1));
            }

            bl.setUsedSize(bl.getUsedSize() - 1);
            System.out.println("Delete Success！");
            System.out.println();
        }
    }
}
