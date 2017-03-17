package bishi.algorithm.stackqueue;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by asussl on 2016/10/29.
 */
public class twoStacksSort {
    public static void main(String[] args){
        TwoStacks twoStacks=new TwoStacks();
        ArrayList<Integer> list=twoStacks.twoStacksSort(new int[]{1,4,5,2,3});
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
 class TwoStacks {
    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        // write code here
        Stack<Integer> data=new Stack<Integer>();
        Stack<Integer> s=new Stack<Integer>();
        int len=numbers.length;
        for(int i=0;i<len;i++){
            data.push(numbers[i]);
        }
        while(!data.isEmpty()){
            int temp=data.pop();
            if(!s.isEmpty()&&temp<s.peek()){
                while(!s.isEmpty()&&temp<s.peek()){
                    data.push(s.pop());
                }
            }
            s.push(temp);

        }
        ArrayList<Integer> list=new ArrayList<Integer>();
        for(int i=0;i<len;i++){
            list.add(s.pop());
        }
        return list;
    }
}