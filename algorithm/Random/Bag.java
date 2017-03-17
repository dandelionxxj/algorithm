package bishi.algorithm.Random;

import java.util.Random;

/**
 * Created by asussl on 2016/10/20.
 */
public class Bag {
    private int [] selected = null;
    private static Random rand = new Random(12345);
    // 每次拿一个球都会调用这个函数，N表示第i次调用
    public int[] carryBalls(int N, int k) {
        //N代表第N号球
        if(selected==null){
            selected=new int[k];
        }
        if(N<=k){
            selected[N-1]=N;
        }else{
            if(rand.nextInt(N)<k){
                //以k/i的概率
                selected[rand.nextInt(k)]=N;
            }
        }
        return selected;
    }
    public static void main(String [] args){

    }
}
