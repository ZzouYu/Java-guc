package function;

import java.util.function.Predicate;

/**
 * @author zouyu
 * 断定型接口，一个传入参数，返回值boolean
 * @date 2020/5/19
 */
public class PredicateDemo {
    public static void main(String[] args) {
       /* Predicate<String> predicate = new Predicate<String>() {
            @Override
            public boolean test(String str) {
                return str.isEmpty();
            };
        };
        System.out.println(predicate.test("aa"));*/
        System.out.println(isEmpty1("bb", (str) -> {
            return str.isEmpty();
        }));

    }

    public static boolean isEmpty1(String str,Predicate<String> pre){
       return pre.test(str);
    }
}
