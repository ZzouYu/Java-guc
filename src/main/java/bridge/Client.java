package bridge;

/**
 * @author zouyu
 * @description
 * @date 2020/5/22
 */
public class Client {
    public static void main(String[] args) {
        Computer computer = new DeskTop(new AppleBrand());
        computer.info();
    }
}
