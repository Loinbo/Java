package TestMain;

import book.BookList;
import user.Admin;
import user.Normal;
import user.User;

import java.util.Scanner;

/**
 * Created by Loinbo
 * DATE:2020/4/30
 * TIME:19:33
 */

public class Test {

    public static User login(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter UserName:");
        String name = sc.nextLine();
        System.out.println("Select Login Identity:1.Admin  2.Normal");

        int choice = sc.nextInt();
        if(choice == 1){
            return new Admin(name);
        }else if(choice == 2){
            return new Normal(name);
        } else {
            throw new Error("Wrong Identity, please Re-enter!");
        }
    }

    public static void main(String[] args) {

        //1.准备书籍
        BookList bl = new BookList();

        //2.登录
        User user = login();
        while(true){
            int choice = user.menu();
            user.doOperation(bl,choice);
        }
    }
}
