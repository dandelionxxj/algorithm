package bishi.algorithm.binarySearch;

/**
 * Created by asussl on 2016/10/29.
 */
public class LeftMostAppearance {
}
class LeftMostAppearanceCore {
    public int findPos(int[] arr, int n, int num) {
        // write code here
        if(arr==null||n==0) return -1;
        int left=0;
        int right=n-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(arr[mid]>num){
                right=mid-1;
            }else if(arr[mid]<num){
                left=mid+1;
            }else{
                right=mid;
            }
        }
        return arr[left]==num?left:-1;
    }
}