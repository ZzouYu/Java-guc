package Sort;

/**
 * @author zouyu
 * @description
 * @date 2020/5/18
 */
public class MaoPaoSort {
    public static void main(String[] args) {
        int[] arr = new int[]{1,50,2,1,1,5,6,4,8,4};
        sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


    //从低到高,会先找出最大的
    public static void sort(int... arr){
       int length = arr.length;
        for (int i = 0; i < length-1; i++) {
             for(int j=0;j<length-i-1;j++){
                 if(arr[j]>arr[j+1]){
                     int tmp = arr[j];
                     arr[j] = arr[j+1];
                     arr[j+1] = tmp;
                 }
             }
        }
    }
}
