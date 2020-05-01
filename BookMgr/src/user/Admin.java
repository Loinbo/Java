package user;

import operation.*;

import java.util.Scanner;

/**
 * Created by Loinbo
 * DATE:2020/4/30
 * TIME:19:49
 */

public class Admin extends User{

    public Admin(String name){
        super(name);
        this.op = new IOperation[]{

                new Exit(),
                new Add(),
                new Delete(),
                new Alter(),
                new Find(),
                new Display(),
                new BackToWelc()

        };
    }

    @Override
    public int menu() {

        System.out.println("Welcome "+this.name+" to the BookManager System!");

        System.out.println("------------------------------");
        System.out.println("1.Add Books");
        System.out.println("2.Delete Books");
        System.out.println("3.Alter Books");
        System.out.println("4.FindBooks");
        System.out.println("5.Display Books");
        System.out.println("6.BackToWelc");
        System.out.println("0.Exit");
        System.out.println("------------------------------");
        System.out.println();

        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        return choice;
    }
}
