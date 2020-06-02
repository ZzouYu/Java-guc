package StaticProxy;

/**
 * @author zouyu
 * @description
 * @date 2020/5/23
 */
public class ProxyRenct implements Renct {

    private Host host;

    public void setHost(Host host){
        this.host = host;
    }
    @Override
    public void renct() {
        seeHouse();
        host.renct();
    }

    public void seeHouse(){
        System.out.println("中介带看房");
    }
}
