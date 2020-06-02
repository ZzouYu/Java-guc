package function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author zouyu
 * 供给型接口，只返回
 * @date 2020/5/19
 */
public class SupplierDemo {
    public static void main(String[] args) {
        List<Integer> numbetList = getNumbetList(10, () -> {
            return (int) (Math.random() * 100);
        });
        numbetList.forEach(num->System.out.println(num+";"));
    }
    public static List<Integer> getNumbetList(int num,Supplier<Integer> sup){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            list.add(sup.get());
        }
      return list;
    }
}
