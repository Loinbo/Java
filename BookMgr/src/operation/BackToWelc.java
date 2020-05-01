package operation;
import TestMain.Test;

import book.BookList;
import user.User;


/**
 * Created by Loinbo
 * DATE:2020/5/1
 * TIME:14:17
 */

/**
 * 返回登录界面
 */
public class BackToWelc implements IOperation{

    @Override
    public void work(BookList bl) {
        User user = Test.login();
        while(true){
            int choice = user.menu();
            user.doOperation(bl,choice);
        }
    }
}
