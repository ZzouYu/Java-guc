package Adapter;

/**
 * @author zouyu
 * @description
 * @date 2020/5/22
 */
public class ComposeAdapter implements NetToUsb {
    private NetLine netLine;
    ComposeAdapter(NetLine netLine){
        this.netLine= netLine;
    }
    @Override
    public void adapter() {
        netLine.request();
    }
}
