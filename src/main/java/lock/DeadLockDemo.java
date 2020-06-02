package lock;

import java.util.concurrent.TimeUnit;

/**
 * @author zouyu
 * @description
 * @date 2020/5/20
 */
public class DeadLockDemo {
    public static void main(String[] args) {
          String lockA = "a";
          String lockB = "b";
          new Thread(new Mythead(lockA,lockB),"T1").start();
        new Thread(new Mythead(lockB,lockA),"T2").start();
    }

}

class Mythead implements Runnable{
    private  String lockA;
    private  String lockB;

    public Mythead(String lockA, String lockB) {
        this.lockA = lockA;
        this.lockB = lockB;
    }

    @Override
    public void run() {
            synchronized (lockA){
                try {
                    System.out.println(Thread.currentThread().getName()+"拿到了"+lockA+"想去拿"+lockB);
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (lockB){
                    try {
                        System.out.println(Thread.currentThread().getName()+"拿到了"+lockB+"想去拿"+lockA);
                        TimeUnit.SECONDS.sleep(2);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
    }
}