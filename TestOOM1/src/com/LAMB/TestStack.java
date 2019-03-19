package com.LAMB;

/**递归实现栈溢出：StackOverflowError
 * Created by Loinbo
 * DATE:2019/3/19
 * TIME:20:53
 */

public class TestStack {
    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {

        TestStack test = new TestStack();

        try {
            test.stackLeak();
        } catch (Throwable e) {

            System.out.println("Stack Length: "+test.stackLength);
            throw e;

        }
    }

}
