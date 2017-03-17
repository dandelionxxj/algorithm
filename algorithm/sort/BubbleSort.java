package bishi.algorithm.sort;

/**
 * Created by asussl on 2016/10/30.
 */
public class BubbleSort {
    public int[] bubbleSort(int[] A, int n) {
        // write code here
        if(A==null||n<=0){
            return null;
        }

        for(int i=n-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(A[j]>A[j+1]){
                    int temp=A[j];
                    A[j]=A[j+1];
                    A[j+1]=temp;
                }
            }
        }
        return A;
    }
}
