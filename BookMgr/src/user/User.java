package user;

import book.BookList;
import operation.IOperation;

/**
 * Created by Loinbo
 * DATE:2020/4/30
 * TIME:19:49
 */

public abstract class User {

    public String name;

    protected IOperation[] op;

    public User(String name){
        this.name = name;
    }

    public abstract int menu();

    public void doOperation(BookList bl, int choice){
        this.op[choice].work(bl);
    }

}
