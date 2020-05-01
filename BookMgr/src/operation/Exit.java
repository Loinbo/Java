package operation;

import book.BookList;

/**
 * Created by Loinbo
 * DATE:2020/4/30
 * TIME:19:44
 */

/**
 * 退出
 */
public class Exit implements IOperation {

    @Override
    public void work(BookList bl) {
        System.out.println("====== Exit ======");
        System.exit(1);
    }
}
