package Adapter;

/**
 * @author zouyu
 * @description
 * @date 2020/5/22
 */
//不能直接连接网线，只能线连接适配器
public class Computer {
    public void net(NetToUsb netToUsb){
        netToUsb.adapter();
    }

    public static void main(String[] args) {
       /* Computer computer = new Computer();
        NetToUsb netToUsb = new NetAdapter();
        computer.net(netToUsb);*/
        Computer computer = new Computer();
        ComposeAdapter composeAdapter = new ComposeAdapter(new NetLine());
        computer.net(composeAdapter);
    }
}
