package bishi.algorithm.sort;

/**
 * Created by asussl on 2016/10/30.
 */
public class MergeSort {
    public int[] mergeSort(int[] A, int n) {
        // write code here
        if(A==null||n<=0){
            return null;
        }
        process(A,0,n-1);
        return A;

    }
    public void process(int[] arr,int left,int right){
        if(left==right){
            return;
        }
        int mid=left+(right-left)/2;
        process(arr,left,mid);
        process(arr,mid+1,right);
        merge(arr,left,mid,right);
    }
    public void merge(int[] arr,int left,int mid,int right){
        int []help=new int[right-left+1];
        int l=left;
        int r=mid+1;
        int index=0;
        while(l<=mid&&r<=right){
            if(arr[l]<=arr[r]){
                help[index++]=arr[l++];
            }else{
                help[index++]=arr[r++];
            }
        }
        while(l<=mid){
            help[index++]=arr[l++];
        }
        while(r<=right){
            help[index++]=arr[r++];
        }
        for(int i=0;i<help.length;i++){
            arr[left+i]=help[i];
        }
    }
}
