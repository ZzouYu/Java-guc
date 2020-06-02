package lock;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author zouyu
 * 自旋锁
 * @date 2020/5/20
 */
public class SpinLock {
    /* public static void main(String[] args) {
        //可以解决aba问题
       AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference(1,1);

        new Thread(()->{
            System.out.println(atomicStampedReference.compareAndSet(1, 2, 1, 2));
            System.out.println(Thread.currentThread().getName()+"修改了值");
        }).start();

        new Thread(()->{
            System.out.println(atomicStampedReference.compareAndSet(2, 3, 2, 3));
            System.out.println(Thread.currentThread().getName()+"修改了值");
        }).start();

       // AtomicReference ar = new AtomicReference();
    }*/
    //Thread 默认为null
     AtomicReference<Thread> ar = new AtomicReference();
    //加锁 第一个线程不释放，其他线程永远自旋转
    public  void myLock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"加上了锁");
        //System.out.println(ar.compareAndSet(null, thread));
        while(!ar.compareAndSet(null,thread)){
             System.out.println(thread.getName()+"旋转");
        }
    }


    //解锁
    public void myUnLock(){
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName()+"释放了锁");
        ar.compareAndSet(thread,null);
    }
}
