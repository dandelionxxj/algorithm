package bishi.algorithm.binarySearch;

/**
 * Created by asussl on 2016/10/29.
 */
public class MinValue {
}

class MinValueCore {
    public int getMin(int[] arr, int n) {
        // write code here
        if(arr==null||arr.length==0) return -1;
        int len=arr.length;
        if(len==1) return arr[0];
        int left=0;
        int right=n-1;
        while(arr[left]>=arr[right]){
            if(right-left==1) break;
            int mid=left+(right-left)/2;
            if(arr[left]==arr[mid]&&arr[right]==arr[mid]){
                return minInOrder(arr,left,right);
            }
            if(arr[mid]>=arr[left]){
                left=mid;
            }else if(arr[mid]<=arr[left]){//????
                right=mid;
            }
        }
        return Math.min(arr[left],arr[right]);
    }
    public int minInOrder(int []arr,int left,int right){
        int result=arr[left];
        for(int i=left+1;i<=right;i++){
            if(arr[i]<result) result=arr[i];
        }
        return result;
    }
}