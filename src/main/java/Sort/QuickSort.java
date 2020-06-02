package Sort;

/**
 * @author zouyu
 * @description
 * @date 2020/5/18
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {5,6,8,1};
        quickSort( 0, arr.length-1,arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


    public static void quickSort(int start,int end,int... arr){
        int i,j,tmp,t;
        if(start>end){
            return;
        }
        tmp = arr[start];
        i =start ;
        j= end;
        while(i<j){
            while(i<j && tmp<=arr[j]){
                j--;
            }
            while(i<j && tmp>=arr[i]){
                i++;
            }
            if(i<j){
                t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        arr[start] = arr[i];
        arr[i] = tmp;
        quickSort(start,j-1,arr);
        quickSort(j+1,end,arr);
    }
}
