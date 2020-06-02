package safe;

import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author zouyu
 * @description
 * @date 2020/5/18
 */
public class CopyOnSet {
    public static void main(String[] args) {
        //   Set set = new HashSet<>();
        Set set = new CopyOnWriteArraySet();
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0,5));
                System.out.println(set);
            },String.valueOf(i)).start();
        }
    }


}
