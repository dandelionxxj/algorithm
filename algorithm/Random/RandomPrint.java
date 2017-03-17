package bishi.algorithm.Random;

import java.util.Random;

/**
 * Created by asussl on 2016/10/20.
 */
public class RandomPrint {
    public static void main(String[] args){
        Random random=new Random();
    }
    public int[] print(int[] arr, int N, int M) {
        Random r=new Random();
        if(M>N) throw new RuntimeException("error");
        int result[]=new int[N];
        int last=N-1;
        int begin=0;
        while(M>0){
            int index=r.nextInt(last+1);
            if(index!=last){
                //交换
                //  System.out.println(arr[index]);
                result[begin++]=arr[index];
                int temp=arr[last];
                arr[last]=arr[index];
                arr[index]=temp;

            }
            M--;
            last--;
        }
        return result;
    }
}
