package bishi.algorithm.stackqueue;

import java.util.LinkedList;

/**
 * Created by asussl on 2016/10/30.//剑指offer65
 */
public class SlideWindow {
}
class SlideWindowCore {
    public int[] slide(int[] arr, int n, int w) {
        // write code here
        if(arr==null||n==0||w==0){
            return null;
        }
        int []result=new int[n-w+1];
        int index=0;
        LinkedList<Integer> list=new LinkedList<Integer>();
        for(int i=0,len=arr.length;i<len;i++){
            while(!list.isEmpty()&&arr[list.peekLast()]<=arr[i]){
                list.pollLast();
            }
            list.addLast(i);
            if(list.peekFirst()==i-w){
                list.pollFirst();
            }
            if(i>=w-1){

                result[index++]=arr[list.peekFirst()];
            }
        }
        return result;
    }
}