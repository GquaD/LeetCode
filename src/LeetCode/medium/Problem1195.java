package LeetCode.medium;

import java.util.function.IntConsumer;

public class Problem1195 {
    //https://leetcode.com/problems/fizz-buzz-multithreaded/description/
    public static void main(String[] args) throws InterruptedException {
        FizzBuzz data = new FizzBuzz(15);
        Thread thread1 = new Thread(() -> {
            try {
                data.fizz(() -> System.out.print("fizz"));
            } catch (Exception e) {
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                data.buzz(() -> System.out.print("buzz"));
            } catch (Exception e) {
            }
        });
        Thread thread3 = new Thread(() -> {
            try {
                data.fizzbuzz(() -> System.out.print("fizzbuzz"));
            } catch (Exception e) {
            }
        });
        Thread thread4 = new Thread(() -> {
            try {
                data.number(i -> System.out.print(i));
            } catch (Exception e) {
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();
    }
}

//https://leetcode.com/problems/fizz-buzz-multithreaded/solutions/3816666/java-97-faster-synchronized-while-loop/
//Runtime
//6 ms
//Beats
//96.96%
//Memory
//42.5 MB
//Beats
//30.77%
class FizzBuzz {
    private int n;

    private int counter;

    public FizzBuzz(int n) {
        this.n = n;
        counter = 1;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (counter <= n) {
            synchronized (this) {
                this.notifyAll();
                if (counter % 3 == 0 && counter % 5 != 0) {
                    printFizz.run();
                    counter++;
                } else {
                    this.wait();
                }
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (counter <= n) {
            synchronized (this) {
                this.notifyAll();
                if (counter % 5 == 0 && counter % 3 != 0) {
                    printBuzz.run();
                    counter++;
                } else {
                    this.wait();
                }
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (counter <= n) {
            synchronized (this) {
                this.notifyAll();
                if (counter % 3 == 0 && counter % 5 == 0) {
                    printFizzBuzz.run();
                    counter++;
                } else {
                    this.wait();
                }
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (counter <= n) {
            synchronized (this) {
                this.notifyAll();
                if (counter % 3 != 0 && counter % 5 != 0) {
                    printNumber.accept(counter);
                    counter++;
                } else {
                    this.wait();
                }
            }
        }
    }
}

class FizzBuzz5 {
    private int n;
    private int counter;

    public FizzBuzz5(int n) {
        this.n = n;
        counter = 1;
    }

    private void trigger(Runnable print) throws InterruptedException {
        synchronized (this) {
            if (counter % 3 == 0 && counter % 5 != 0) {
                print.run();
                this.notify();
                System.out.println();
                counter++;
                this.wait();
            } else if (counter % 5 == 0 && counter % 3 != 0) {
                print.run();
                this.notify();
                System.out.println();
                counter++;
                this.wait();
            } else if (counter % 5 == 0 && counter % 3 == 0) {
                print.run();
                this.notify();
                System.out.println();
                counter++;
                this.wait();
            }
        }
    }

    private void trigger(IntConsumer consumer) throws InterruptedException {
        synchronized (this) {
            if (counter % 3 != 0 && counter % 5 != 0) {
                consumer.accept(counter);
                System.out.println();
                counter++;
                this.notify();
                this.wait();
            }
        }
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
//        synchronized (this) {
        while (counter <= n) {
            trigger(printFizz);
        }
//        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
//        synchronized (this) {
        while (counter <= n) {
            trigger(printBuzz);
        }
//        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
//        synchronized (this) {
        while (counter <= n) {
            trigger(printFizzBuzz);
        }
//        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
//        synchronized (this) {
        while (counter <= n) {
            trigger(printNumber);
        }
//        }
    }
}

class FizzBuzz4 {
    private int n;
    private int counter;

    public FizzBuzz4(int n) {
        this.n = n;
        counter = 1;
    }

    private void trigger(Runnable print, IntConsumer consumer) throws InterruptedException {
        synchronized (this) {
            while (counter <= n) {
                if (counter % 3 == 0 && counter % 5 != 0) {
                    if (print != null) print.run();
                } else if (counter % 5 == 0 && counter % 3 != 0) {
                    if (print != null) print.run();
                } else if (counter % 5 == 0 && counter % 3 == 0) {
                    if (print != null) print.run();
                } else {
                    if (consumer != null) {
                        consumer.accept(counter);
                    }
                }
                counter++;
            }
        }
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        trigger(printFizz, null);
        printFizz.run();
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        trigger(printBuzz, null);
        printBuzz.run();
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        trigger(printFizzBuzz, null);
        printFizzBuzz.run();
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        trigger(null, printNumber);
        printNumber.accept(counter);
    }
}


class FizzBuzz3 {
    private int n;
    private int counter;

    private final Object lock = new Object();

    public FizzBuzz3(int n) {
        this.n = n;
        counter = 1;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        synchronized (lock) {
            while (counter <= n) {
                if (counter % 3 == 0 && counter % 5 != 0) {
                    printFizz.run();
                    counter++;
                }
                lock.notify();
                lock.wait();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        synchronized (lock) {
            while (counter <= n) {
                if (counter % 5 == 0 && counter % 3 != 0) {
                    printBuzz.run();
                    counter++;
                }
                lock.notify();
                lock.wait();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        synchronized (lock) {
            while (counter <= n) {
                if (counter % 5 == 0 && counter % 3 == 0) {
                    printFizzBuzz.run();
                    counter++;
                }
                lock.notify();
                lock.wait();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        synchronized (lock) {
            while (counter <= n) {
                if (counter % 5 == 0 && counter % 3 == 0) {
                    printNumber.accept(counter);
                    counter++;
                }
                lock.notify();
                lock.wait();
            }
        }
    }
}

class FizzBuzz2 {
    private int n;
    private int counter;

    public FizzBuzz2(int n) {
        this.n = n;
        this.counter = 0;
    }

    private int getCounter() {
        synchronized (this) {
            return counter;
        }
    }

    private int increaseCounter() {
        synchronized (this) {
            return ++counter;
        }
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        notifyAll();
        increaseCounter();
        if (getCounter() % 3 == 0 && getCounter() % 5 != 0) printFizz.run();
        wait();
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        notifyAll();
        increaseCounter();
        if (getCounter() % 3 != 0 && getCounter() % 5 == 0) printBuzz.run();
        wait();
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        notifyAll();
        increaseCounter();
        if (getCounter() % 3 == 0 && getCounter() % 5 == 0) printFizzBuzz.run();
        wait();
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        notifyAll();
        increaseCounter();
        printNumber.accept(getCounter());
        wait();
    }
}

class FizzBuzz1 {
    private int n;
    private volatile int count;

    public FizzBuzz1(int n) {
        this.n = n;
        count = 1;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (count <= n) {
            if (count % 3 == 0 && count % 5 != 0) {
                printFizz.run();
            }
            count++;
            wait();
            notifyAll();
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (count <= n) {
            if (count % 3 != 0 && count % 5 == 0) {
                printBuzz.run();
            }
            count++;
            wait();
            notifyAll();
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (count <= n) {
            if (count % 3 == 0 && count % 5 == 0) {
                printFizzBuzz.run();
            }
            count++;
            wait();
            notifyAll();
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (count <= n) {
            if (count % 3 != 0 && count % 5 != 0) {
                printNumber.accept(count);
            }
            count++;
            wait();
            notifyAll();
        }
    }
}

