package bishi.algorithm.binarySearch;

/**
 * Created by asussl on 2016/10/29.
 */
public class getLessIndex {
    public static void main(String[] args){

    }
}
class Solution {
    public int getLessIndex(int[] arr) {
        if(arr==null||arr.length==0) return -1;
        if(arr.length==1) return 0;
        if(arr[0]<arr[1]) return 0;
        int n=arr.length;
        if(arr[n-1]<arr[n-2]) return n-1;
        int left=0;int right=n-1;
        while(left<right){
            int mid=left+(right-left)/2;
            if(arr[mid]<arr[mid+1]&&arr[mid]<arr[mid-1]) {
                return mid;
            }else if(arr[mid]<arr[mid+1]&&arr[mid]>arr[mid-1]){
                right=mid-1;

            }else{
                left=mid+1;
            }

        }
        return -1;
    }
}