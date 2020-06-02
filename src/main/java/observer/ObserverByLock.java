package observer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zouyu
 * condition可以精准通知唤醒
 * @date 2020/5/18
 */
public class ObserverByLock {
    public static void main(String[] args) {
    CaNumber1 ca1 = new CaNumber1();
    new Thread(()->{
        for (int i = 0; i < 20; i++) {
            ca1.addNumber();
        }
    },"A").start();

    new Thread(()->{
        for (int i = 0; i < 20; i++) {
            ca1.decNumber();
        }
    },"B").start();
        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                ca1.addNumber2();
            }
        },"C").start();

        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                ca1.decNumber2();
            }
        },"D").start();
}

}


//定义一个资源类,生产 等待 业务 消费
class CaNumber1{
    private int number;
    private static Lock lock = new ReentrantLock();//可重入锁可自定义是否  公平 默认非公平
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();
    Condition condition4 = lock.newCondition();

    public  void addNumber(){
        lock.lock();
        try {
            while (number !=0){ //防止虚假唤醒，if只会执行一次
                    condition1.await();  //会释放锁
            }
            //唤醒其他线程
            condition2.signal();
            number++;
            System.out.println(Thread.currentThread().getName()+"当前number"+number);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public  void decNumber(){
        lock.lock();
        try {
            while (number ==0){ //防止虚假唤醒，if只会执行一次
                condition2.await();  //会释放锁
            }
            //唤醒其他线程
            condition3.signal();
            number--;
            System.out.println(Thread.currentThread().getName()+"当前number"+number);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public  void addNumber2(){
        lock.lock();
        try {
            while (number !=0){ //防止虚假唤醒，if只会执行一次
                condition3.await();  //会释放锁
            }
            //唤醒其他线程
            condition4.signal();
            number++;
            System.out.println(Thread.currentThread().getName()+"当前number"+number);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public  void decNumber2(){
        lock.lock();
        try {
            while (number ==0){ //防止虚假唤醒，if只会执行一次
                condition4.await();  //会释放锁
            }
            //唤醒其他线程
            condition1.signal();
            number--;
            System.out.println(Thread.currentThread().getName()+"当前number"+number);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}