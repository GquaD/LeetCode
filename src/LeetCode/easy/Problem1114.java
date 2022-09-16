package LeetCode.easy;

import java.util.concurrent.CountDownLatch;

public class Problem1114 {


    //https://leetcode.com/problems/print-in-order/
    public static void main(String[] args) {


    }

    CountDownLatch c;
    CountDownLatch b;

    public Problem1114() {
        b = new CountDownLatch(1);
        c = new CountDownLatch(1);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        b.countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        b.await();
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        c.countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        c.await();
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }

}
