package Single;

/**
 * @author zouyu
 * @description
 * @date 2020/5/25
 */
public class Hungry {

    private static Hungry hungry = new Hungry();
    private Hungry(){

    }
    public static Hungry getSigle(){
        return hungry;
    }

    public static void main(String[] args) {
        System.out.println(Hungry.getSigle().hashCode());
        System.out.println(Hungry.getSigle().hashCode());
    }
}
