package build;

/**
 * @author zouyu
 * @description
 * @date 2020/6/1
 */
public class Worker extends Builder {
    private Product product;
    Worker(Product product){
      this.product = product;
    }
    @Override
    void buildA() {
        product.setBuildA("A");
        System.out.println("A");
    }

    @Override
    void buildB() {
        product.setBuildA("A");
        System.out.println("B");
    }

    @Override
    void buildC() {
        product.setBuildB("B");
        System.out.println("C");
    }

    @Override
    void buildD() {
        product.setBuildC("C");
        System.out.println("D");
    }

    @Override
    Product build() {
        product.setBuildD("D");
        return product;
    }
}
