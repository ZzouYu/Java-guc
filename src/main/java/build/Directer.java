package build;

/**
 * @author zouyu
 * @description
 * @date 2020/6/1
 */
public class Directer {
    public Product build(Builder builder){
        builder.buildA();
        builder.buildB();
        builder.buildC();
        builder.buildD();
       return  builder.build();
    }

}
