package forkJoin;

import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author zouyu
 * @description
 * @date 2020/5/19
 */
public class ForkJoinDemo extends RecursiveTask<Long> {
    private Long start;
    private Long end;
    public ForkJoinDemo(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    private Long tmp = 1000L; //分隔点

    @Override
    protected Long compute() {
        Long sum = 0L;
        if((end-start)<tmp){
            for (Long i = start; i <= end; i++) {
                sum+=i;
            }
            return sum;
        }else{
            Long mid = (end+start)/2; //中间值
            ForkJoinDemo task1 = new ForkJoinDemo(start, mid);
            task1.fork();
            ForkJoinDemo task2 = new ForkJoinDemo(mid+1, end);
            task2.fork();
             return task1.join()+task2.join();
        }
    }
}
