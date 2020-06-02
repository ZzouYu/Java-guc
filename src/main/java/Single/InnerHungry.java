package Single;

/**
 * @author zouyu
 * @description
 * @date 2020/5/25
 */
public class InnerHungry {

    private InnerHungry(){

    }
    private static class Hungry{
        private static InnerHungry h = new InnerHungry();


    }
    public static InnerHungry getSingle(){
        return Hungry.h;
    }

    public static void main(String[] args) {
        System.out.println(InnerHungry.getSingle().hashCode());
        System.out.println(InnerHungry.getSingle().hashCode());
    }
}
