package operation;

import book.BookList;

import java.util.Scanner;

/**
 * Created by Loinbo
 * DATE:2020/5/1
 * TIME:13:44
 */

/**
 * 更改
 * 实现逻辑：更改列表已有的书籍价格
 */
public class Alter implements IOperation{

    @Override
    public void work(BookList bl) {
        System.out.println("====== Alter Books ======");

        Scanner sc = new Scanner(System.in);
        System.out.println("Input the Bookname to Alter:");
        String name = sc.nextLine();
        System.out.println("Input the price:");
        int price = sc.nextInt();

        int i = 0;
        for(; i < bl.getUsedSize(); i++){
            if(bl.getBooks(i).getName().equals(name)){
                bl.getBooks(i).setPrice(price);
                System.out.println("Alter Success！");
                System.out.println();
                return;
            }
        }

        System.out.println("Can Not Find The Book!");
        System.out.println();
    }
}
