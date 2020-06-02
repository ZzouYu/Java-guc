package lock;

import java.util.concurrent.TimeUnit;

/**
 * @author zouyu
 * @description
 * @date 2020/5/20
 */
public class TestSpinLock {
    public static void main(String[] args) throws InterruptedException {
        SpinLock lock = new SpinLock();
        new Thread(()->{
            try {
                lock.myLock();
                TimeUnit.SECONDS.sleep(2);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.myUnLock();
            }
        }).start();
        TimeUnit.SECONDS.sleep(1);
        new Thread(()->{
            try {
                lock.myLock();
                TimeUnit.SECONDS.sleep(3);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.myUnLock();
            }
        }).start();
    }
  
}
