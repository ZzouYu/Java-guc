package lock;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * @author zouyu
 * @description
 * @date 2020/5/19
 */
public class BlockQueue {
    public static void main(String[] args) throws InterruptedException {
        test4();
    }
//会抛出异常
    public static void test1(){
        ArrayBlockingQueue abq = new ArrayBlockingQueue<>(3);
        System.out.println(abq.add("a"));
        System.out.println(abq.add("b"));
        System.out.println(abq.add("c"));
        System.out.println("///////");
        System.out.println(abq.remove());
        System.out.println(abq.remove());
        System.out.println(abq.remove());
    }
    //不会抛出异常
    public static void test2(){
        ArrayBlockingQueue abq = new ArrayBlockingQueue<>(3);
        System.out.println(abq.offer("a"));
        System.out.println(abq.offer("b"));
        System.out.println(abq.offer("c"));

        System.out.println("///////");
        System.out.println(abq.poll());
        //取出队首元素
        System.out.println(abq.peek());
        System.out.println(abq.poll());
        System.out.println(abq.poll());
    }
//阻塞等待（一直等待）没有或者满了
    public static void test3() throws InterruptedException {
        ArrayBlockingQueue abq = new ArrayBlockingQueue<>(3);
        abq.put("a");
        abq.put("b");
       abq.put("c");

        System.out.println("///////");
        //取出对首元素
        System.out.println(abq.take());
        System.out.println(abq.take());
        System.out.println(abq.take());
    }

    public static void test4() throws InterruptedException {
        ArrayBlockingQueue abq = new ArrayBlockingQueue<>(3);
        abq.offer("a");
        abq.offer("b");
        abq.offer("c");
        abq.offer("d",2, TimeUnit.SECONDS);
        System.out.println("///////");
        //取出对首元素
        System.out.println(abq.poll());
        System.out.println(abq.poll());
        System.out.println(abq.poll());
    }
}
