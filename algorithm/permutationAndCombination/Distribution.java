package bishi.algorithm.permutationAndCombination;

/**
 * Created by asussl on 2016/10/17.
 */
public class Distribution {
    public static void main(String[] args){
        int result=getWays(10,3);
        System.out.println(result);
    }
    public static int getWays(int n, int m) {
        // write code here,c(n-1,m-1);
        n--;
        m--;
        int result=1;
        for(int i=n;i>(n-m);i--){
            result*=i;
        }
        for(int i=2;i<=m;i++){
            result/=i;
        }
        return result;
    }
}
