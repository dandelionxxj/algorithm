package bishi.algorithm.sort;

/**
 * Created by asussl on 2016/10/30.
 */
public class InsertionSort {
    public int[] insertionSort(int[] A, int n) {
        // write code here
        if(A==null||n<=0){
            return null;
        }
        for(int i=1;i<n;i++){
            for(int j=i;j>0;j--){
                if(A[j]<A[j-1]){
                    swap(A,j-1,j);
                }else{
                    break;
                }
            }

        }
        return A;
    }
    public static void swap(int []arr,int index1,int index2){
        int temp=arr[index1];
        arr[index1]=arr[index2];
        arr[index2]=temp;
    }
}
