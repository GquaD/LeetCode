package LeetCode.medium;

import java.util.function.IntConsumer;

public class Problem1116 {
    //https://leetcode.com/problems/print-zero-even-odd/
    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(1000);
        Thread t0 = new Thread(() -> {
            try {
                zeroEvenOdd.zero((a) -> System.out.print(a));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t1 = new Thread(() -> {
            try {
                zeroEvenOdd.odd((a) -> System.out.print(a));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                zeroEvenOdd.even((a) -> System.out.print(a));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        t0.start();
        t1.start();
        t2.start();

        try {
            t0.join();
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}

//https://leetcode.com/problems/print-zero-even-odd/solutions/3824272/java-100-faster-while-loop-synchronized/
//20-25min
//Runtime
//6 ms
//Beats
//100%
//Memory
//41.4 MB
//Beats
//85.44%
class ZeroEvenOdd {
    private int n;
    private int counter;

    public ZeroEvenOdd(int n) {
        this.n = n;
        counter = 0;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        while (counter < 2 * n) {
            synchronized (this) {
                this.notifyAll();
                if (counter % 2 == 0) {
                    printNumber.accept(0);
                    counter++;
                } else {
                    this.wait();
                }
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        while (counter < 2 * n) {
            synchronized (this) {
                this.notifyAll();
                if (counter % 4 == 3) {
                    printNumber.accept((counter + 1) / 2);
                    counter++;
                } else {
                    this.wait();
                }
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        while (counter < 2 * n) {
            synchronized (this) {
                this.notifyAll();
                if (counter % 4 == 1) {
                    printNumber.accept(counter / 2 + 1);
                    counter++;
                } else {
                    this.wait();
                }
            }
        }
    }
}
