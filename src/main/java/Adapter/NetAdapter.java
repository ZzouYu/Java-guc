package Adapter;

/**
 * @author zouyu
 *类适配器 相当于网线和适配器进行了绑定 实现了联网 不太好
 * @date 2020/5/22
 */
//连接电脑USB和网线插口
public class NetAdapter extends NetLine implements NetToUsb {

    @Override
    public void adapter() {
         super.request();
    }
}
