package bishi.algorithm.binarySearch;

/**
 * Created by asussl on 2016/11/23.
 */
public class findPos {
    public static void main(String [] args){
//        int result=findPos(new int[]{-1,0,2,3},4);
        int result1=findPos(new int[]{0,5,8,9},4);
        System.out.println(result1);
    }
    public static int findPos(int[] arr, int n) {
        // write code here
        if(arr==null||n==0) return -1;
        int result=-1;
        if(arr[0]>n-1||arr[n-1]<0)return result;
        int left=0;
        int right=n-1;
        int mid;
        while(left<=right){
            mid=left+(right-left)/2;
            if(arr[mid]>mid){
                right=mid-1;
            }else if(arr[mid]<mid){
                left=mid+1;
            }else{
                result=mid;
                right=mid-1;
            }
        }
        return result;
    }
}
