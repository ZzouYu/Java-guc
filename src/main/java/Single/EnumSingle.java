package Single;

/**
 * @author zouyu
 * @description
 * @date 2020/5/25
 */
public enum EnumSingle {
    SINGLE;
    public EnumSingle getSingle(){
        return SINGLE;
    }

    public static void main(String[] args) {
        System.out.println(EnumSingle.SINGLE.getSingle().hashCode());
        System.out.println(EnumSingle.SINGLE.getSingle().hashCode());
    }
}
