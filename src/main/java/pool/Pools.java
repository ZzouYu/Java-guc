package pool;

import java.util.concurrent.*;

/**
 * @author zouyu
 *   AbortPolicy() 银行满了还有人来，抛出异常
 *   CallerRunsPolicy  拿来的去哪里，这里会让主线程执行
 *   DiscardPolicy  队列满了丢掉任务，不抛出异常
 *   DiscardOldestPolicy   队列满了舱室和最早的竞争，竞争失败直接丢掉 不会抛出异常
 * @date 2020/5/19
 */
public class Pools {
    public static void main(String[] args) {
       // ExecutorService threadPool = Executors.newFixedThreadPool(5);
        //自定义线程池
        //怎么选择最大线程数量
        //1:cpu密集型，几核就是几可以保证cpu效率最高
        //2：io密集型 判断程序中耗时的操作 》 就好了 一般设置为2倍
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,//核心线程数  。办理业务的人核心线程+等待的人没有超过最大线程就不会触发最大线程的人数。这里为6时触发
                5,//最大线程数，最大五个窗口办理业务
                3,  //超过时间线程开始回收
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(3),//阻塞队列，排队的人,
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        try {
            //最大承载 阻塞队列+最大线程数
            for (int i = 1; i <=10; i++) {
                threadPool.execute(()->{
                    System.out.println(Thread.currentThread().getName()+"ok");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }
//        System.out.println(Runtime.getRuntime().availableProcessors());
    }
}
