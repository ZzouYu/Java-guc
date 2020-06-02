package lock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author zouyu
 * 写写，读写互斥，读读共存
 * @date 2020/5/19
 */
public class ReadWriteLock {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();
        for (int i = 0; i < 10; i++) {
            final int tmp = i;
            new Thread(()->{
                myCache.put(tmp+"",tmp+"");
            }).start();
        }
        for (int i = 0; i < 10; i++) {
            final int tmp = i;
            new Thread(()->{
                myCache.get(tmp+"");
            }).start();
        }
    }

}
class MyCache{
    public volatile Map<String,Object> map = new HashMap<>();
    ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    //存，写
    public void put(String key,Object value){
        readWriteLock.writeLock().lock();
        try {
            System.out.println("写入"+key);
            map.put(key,value);
             System.out.println("完成写入"+key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.writeLock().unlock();
        }
    }
     //读取
    public void get(String key){
        readWriteLock.readLock().lock();
        try {
            System.out.println("读取"+key);
            map.get(key);
            System.out.println("完成读取"+key);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            readWriteLock.readLock().unlock();
        }
    }
}