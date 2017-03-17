package bishi.algorithm.sort;

/**
 * Created by asussl on 2016/10/30.
 */
public class QuickSort {
    public static void main(String[]args){
        int[] result=quickSort(new int[]{1,2,3,5,2,3},6);
        for(int i=0;i<result.length;i++){
            System.out.println(result[i]);
        }
    }
    //运行超时什么鬼？？?
    public static int[] quickSort(int[] A, int n) {
        // write code here
        return quick(A,0,n-1);
    }
    public static int[] quick(int[] A, int low, int high){
        if(low<high){
            int mid=sort( A,low,high);
            quick(A,low,mid-1);
            quick(A,mid+1,high);
        }
        return A;
    }
    public static int sort(int[] A, int low, int high){
        int key=A[low];

            while(low<high){
                while(low<high&&A[high]>=key){high--;}
                if(low<high){
                    A[low]=A[high];
                }
                while(low<high&&A[low]<=key){low++;}//注意++和--不能写错，造成数组越界，low<high要放在判断语句前面
                if(low<high){
                    A[high]=A[low];
                }


            A[low]=key;
        }
        return low;
    }
}
