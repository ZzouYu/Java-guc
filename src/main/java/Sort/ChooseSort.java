package Sort;

/**
 * @author zouyu
 * @description
 * @date 2020/5/18
 */
public class ChooseSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1,50,2,10,1,5,6,4,8,4};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    //从低到高
    public static void sort(int... arrs){
        int length = arrs.length;
        for (int i = 0; i < length-1; i++) {
            for(int j=i+1;j<length;j++){
                if(arrs[i]>arrs[j]){
                    int tmp = arrs[i];
                    arrs[i] = arrs[j];
                    arrs[j] = tmp;
                }
            }
        }
    }
}
