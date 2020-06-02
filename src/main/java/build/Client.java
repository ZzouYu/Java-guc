package build;

/**
 * @author zouyu
 * @description
 * @date 2020/6/1
 */
public class Client {
    public static void main(String[] args) {

        System.out.println(new Directer().build(new Worker(new Product())));
    }
}
