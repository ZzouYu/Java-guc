package Factory.method;

/**
 * @author zouyu
 * @description
 * @date 2020/5/21
 */
public class WulingFactory implements Factory {
    @Override
    public Car getCar() {
        return new Wuling();
    }
}
