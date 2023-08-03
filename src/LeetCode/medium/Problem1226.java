package LeetCode.medium;

public class Problem1226 {
    //https://leetcode.com/problems/the-dining-philosophers/
    public static void main(String[] args) {

    }
}

//https://leetcode.com/problems/the-dining-philosophers/solutions/3858511/java-using-boolean-array-84-faster-98-memory/
//15-20 min
//Runtime
//13 ms
//Beats
//83.70%
//Memory
//44.4 MB
//Beats
//97.83%
class DiningPhilosophers {

    private volatile boolean[] forksBusy;
    public DiningPhilosophers() {
        forksBusy = new boolean[5];
    }

    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        //synchronized (this) {
            while (forksBusy[philosopher]) {
                this.notifyAll();
                this.wait();
            }
            if (!forksBusy[philosopher]) {
                pickLeftFork.run();
                forksBusy[philosopher] = true;
                int idxRight = (philosopher + 1) % forksBusy.length;

                if (!forksBusy[idxRight]) {
                    pickRightFork.run();
                    forksBusy[idxRight] = true;
                    eat.run();
                    putLeftFork.run();
                    forksBusy[idxRight] = false;
                }

                putRightFork.run();
                forksBusy[philosopher] = false;
            }
        //}
    }
}

//15-20 min
//Runtime
//15 ms
//Beats
//20.29%
//Memory
//45 MB
//Beats
//25%
class DiningPhilosophers1 {

    private boolean[] forksBusy;
    private Object lock;
    public DiningPhilosophers1() {
        forksBusy = new boolean[5];
        lock = new Object();
    }

    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        synchronized (lock) {
            while (forksBusy[philosopher]) {
                lock.notifyAll();
                lock.wait();
            }
            if (!forksBusy[philosopher]) {
                pickLeftFork.run();
                forksBusy[philosopher] = true;
                int idxRight = (philosopher + 1) % forksBusy.length;

                if (!forksBusy[idxRight]) {
                    pickRightFork.run();
                    forksBusy[idxRight] = true;
                    eat.run();
                    putLeftFork.run();
                    forksBusy[idxRight] = false;
                }

                putRightFork.run();
                forksBusy[philosopher] = false;
            }
        }
    }
}
