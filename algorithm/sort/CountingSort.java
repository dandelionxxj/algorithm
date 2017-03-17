package bishi.algorithm.sort;

/**
 * Created by asussl on 2017/1/31.
 */
public class CountingSort {
    public int[] countingSort(int[] A, int n) {
        // write code here
        //1.找出最大值和最小值，建通
        int max=A[0];
        int min=A[0];
        for(int i=0,len=A.length;i<len;i++){
            if(A[i]<min){
                min=A[i];
            }
            if(A[i]>max){
                max=A[i];
            }
        }
        int newLen=max-min+1;
        int arr[]=new int[newLen];
        //2.放内容
        for(int i=0,len=A.length;i<len;i++){
            arr[A[i]-min]++;
        }
        //3.倒内容
        int index=0;
        for(int i=0;i<newLen;i++){
            for(int j=0;j<arr[i];j++){
                A[index++]=min+i;
            }
        }
        return A;
    }
}
