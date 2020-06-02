package forkJoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.stream.LongStream;

/**
 * @author zouyu
 * @description
 * @date 2020/5/19
 */
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger(2);

        //如果期望值达到就更新
        System.out.println(atomicInteger.compareAndSet(2, 4));
        System.out.println(atomicInteger.compareAndSet(4, 5));
        System.out.println(atomicInteger.compareAndSet(4, 6));
        int a;
        do{
          a= atomicInteger.getAndIncrement();
            System.out.println(a);
        }while(a<=10);
        System.out.println("结束");

        //test1();
        //test2();
        //test3();
    }

  // 普通计算
    public static void  test1(){
        long start = System.currentTimeMillis();
        Long sum =0L;
        for (Long i = 1L; i <= 10_0000_0000L; i++) {
            sum+=i;
        }
        long end = System.currentTimeMillis();
        System.out.println("sum="+sum+"  耗时："+(end-start));
    }
    //forkJoin计算
    public static void  test2() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();
        Long sum =0L;
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Long> submit = forkJoinPool.submit(new ForkJoinDemo(0L, 10_0000_0000L));
         sum= submit.get();
        long end = System.currentTimeMillis();
        System.out.println("sum="+sum+"  耗时："+(end-start));
    }
    //stream并行流计算
    public static void  test3(){
        long start = System.currentTimeMillis();
        Long sum = LongStream.rangeClosed(0L,10_0000_0000L).parallel().reduce(0L,Long::sum);
        long end = System.currentTimeMillis();
        System.out.println("sum="+sum+"  耗时："+(end-start));
    }
}
