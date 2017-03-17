package bishi.algorithm.permutationAndCombination;

/**
 * Created by asussl on 2016/10/17.
 */
public class StandInLine {
    public static void main(String[] args){
        int [] result=getWays(7,1,2);
        System.out.println(result[0]+" "+result[1]);
    }
    public static int[] getWays(int n, int a, int b) {
        // write code here
        int [] result=new int[2];
        result[0]=1;
        result[1]=1;
        for(int i=n-1;i>1;i--){
            result[1]*=i;
        }
        result[0]=n*result[1]/2;
        return result;
    }
}
