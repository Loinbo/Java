package operation;

import book.Book;
import book.BookList;

import java.util.Scanner;

/**
 * Created by Loinbo
 * DATE:2020/4/30
 * TIME:19:42
 */

/**
 * 上新
 * 实现逻辑：添加列表中没有的书籍
 */
public class Add implements IOperation{

    @Override
    public void work(BookList bl) {

        System.out.println("====== Add Books ======");

        Scanner sc = new Scanner(System.in);
        System.out.println("Input the Bookname to Add:");
        String name = sc.nextLine();
        System.out.println("Input the author:");
        String author = sc.nextLine();
        System.out.println("Input the price:");
        int price = sc.nextInt();
        System.out.println("Input the type:");
        String type = sc.next();//注意
        //nextInt与nextLine 不能合在一起用，改为next

        Book book = new Book(name,author,price,type);

        int curSize = bl.getUsedSize();
        bl.setBooks(curSize,book);
        bl.setUsedSize(curSize + 1);
        System.out.println("Add Success!");
        System.out.println("======= Finished =======");
        System.out.println();
    }
}
