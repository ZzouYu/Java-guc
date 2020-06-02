package common;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @author zouyu
 * @description
 * @date 2020/5/18
 */
public class SemaphoreTest {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 1; i <=6; i++) {
            final int tmp = i;
            new Thread(()->{
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"抢到了第"+tmp+"个车位");
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println(Thread.currentThread().getName()+"离开了第"+tmp+"个车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            },i+"").start();
        }
    }
}
