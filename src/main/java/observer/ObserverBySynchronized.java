package observer;

/**
 * @author zouyu
 * @description 生产者加一，消费者减一
 * @date 2020/5/18
 */
public class ObserverBySynchronized {
    public static void main(String[] args) {
        CaNumber ca = new CaNumber();
        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                ca.addNumber();
            }
        },"A").start();

        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                ca.decNumber();
            }
        },"B").start();
    }
}



//定义一个资源类,生产 等待 业务 消费
class CaNumber{
    private int number;

    public synchronized void addNumber(){
        while (number !=0){ //防止虚假唤醒，if只会执行一次
            try {
                this.wait();  //会释放锁
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //唤醒其他线程
        this.notifyAll();
        number++;
        System.out.println(Thread.currentThread().getName()+"当前number"+number);
    }
    public synchronized void decNumber(){
        while (number ==0){ //防止虚假唤醒，if只会执行一次
            try {
                this.wait();  //会释放锁
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //唤醒其他线程
        this.notifyAll();
        number--;
        System.out.println(Thread.currentThread().getName()+"当前number"+number);
    }

}