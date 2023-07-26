package LeetCode.medium;

public class Problem1115 {
    //https://leetcode.com/problems/print-foobar-alternately/
    public static void main(String[] args) {
        FooBar fooBar = new FooBar(2);
        Thread t1 = new Thread(() -> {
            try {
                fooBar.foo(() -> System.out.print("foo"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        Thread t2 = new Thread(() -> {
            try {
                fooBar.bar(() -> System.out.print("bar"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

//https://leetcode.com/problems/print-foobar-alternately/solutions/3819788/java-100-faster-synchronized-boolean-for-switching/
//15 min
//Runtime
//22 ms
//Beats
//99.66%
//Memory
//43.2 MB
//Beats
//33.41%
class FooBar {
    private int n;
    private int countFoo;
    private int countBar;
    private boolean fooPrinted;

    public FooBar(int n) {
        this.n = n;
        countFoo = 1;
        countBar = 1;
        fooPrinted = false;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        synchronized (this) {
            for (int i = 0; i < n; i++) {
                this.notifyAll();
                if (!fooPrinted) {
                    printFoo.run();
                    fooPrinted = true;
                } else {
                    i--;
                    this.wait();
                }
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        synchronized (this) {
            for (int i = 0; i < n; i++) {
                this.notifyAll();
                if (fooPrinted) {
                    printBar.run();
                    fooPrinted = false;
                } else {
                    i--;
                    this.wait();
                }
            }
        }
    }
}

class FooBar1 {
    private int n;
    private int count;

    public FooBar1(int n) {
        this.n = n;
        count = 0;
    }

    private int getCount() {
        synchronized (this) {
            return count;
        }
    }

    private int increaseCount() {
        synchronized (this) {
            return ++count;
        }
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printFoo.run() outputs "foo". Do not change or remove this line.
            if (count == i) {
                printFoo.run();
                notifyAll();
            } else {
                wait();
                continue;
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {

            // printBar.run() outputs "bar". Do not change or remove this line.
            if (count == i) {
                printBar.run();
                increaseCount();
                notifyAll();
            } else {
                wait();
                continue;
            }
        }
    }
}

