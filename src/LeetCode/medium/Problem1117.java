package LeetCode.medium;

public class Problem1117 {
    //https://leetcode.com/problems/building-h2o/

    public static void main(String[] args) {
        H2O h2o = new H2O();

        Thread t1 = new Thread(() -> {
            try {
                h2o.oxygen(() -> System.out.print("O"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread t2 = new Thread(() -> {
            try {
                h2o.hydrogen(() -> System.out.print("H"));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        String s = "OOHHHH";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'O') {
                new Thread(t1).start();
            } else {
                new Thread(t2).start();
            }
        }
        /*t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
    }

}

//nnnnn
//1 -1.5 hour
//Runtime
//17 ms
//Beats
//100%
//Memory
//45.3 MB
//Beats
//38.8%
class H2O {
    private int count;
    public H2O() {
        count = 0;
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        synchronized (this) {
            while (count == 2) {
                this.wait();
            }
            releaseHydrogen.run();
            count++;
            this.notifyAll();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        synchronized (this) {
            while (count != 2) {
                this.wait();
            }
            releaseOxygen.run();
            count = 0;
            this.notifyAll();
        }
    }
}

class H2O2 {

    int countH, countO;

    public H2O2() {
        countH = 0;
        countO = 0;
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        synchronized (this) {
            while (countH < 2) {
                this.notifyAll();
                if (countH < 2) {
                    releaseHydrogen.run();
                    countH++;
                } else {
                    countO = 0;
                    this.wait();
                }
            }
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        synchronized (this) {
            while (countO == 0) {
                this.notifyAll();
                if (countH == 0) {
                    releaseOxygen.run();
                    countO++;
                } else {
                    if (countH >= 2) countH = 0;
                    this.wait();
                }
            }
        }
    }
}

class H2O1 {

    int countH, countO;

    public H2O1() {
        countH = 0;
        countO = 0;
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        synchronized (this) {
            this.notifyAll();
            if (countO == 0) this.wait();
            if (countO == 1 && countH < 2) {
                releaseHydrogen.run();
                countH++;
            }
            if (countH >= 2) countH = 0;
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        synchronized (this) {
            this.notifyAll();
            if (countO == 1 && countH < 2) {
                this.wait();
            }
            if (countO == 0) {
                releaseOxygen.run();
                countO++;
            } else {
                countO = 0;
            }
        }
    }
}
