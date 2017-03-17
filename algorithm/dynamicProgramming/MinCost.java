package bishi.algorithm.dynamicProgramming;

/**
 * Created by asussl on 2016/11/4.
 */
public class MinCost {
    public static void main(String[] args){
        int result=findMinCost("bbca",4,"cabacab",7,1,2,7);
        System.out.println(result);
    }
    public static int findMinCost(String A, int n, String B, int m, int c0, int c1, int c2) {
        // write code here
        if(A==null||B==null||m==0||n==0) return 0;
        int dp[][]=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            dp[i][0]=c1*i;
        }
        for(int j=0;j<=n;j++){
            dp[0][j]=c0*j;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                int a=dp[i-1][j]+c1;
                int b=dp[i][j-1]+c0;
                int c=A.charAt(i-1)==B.charAt(j-1)?dp[i-1][j-1]:dp[i-1][j-1]+c2;
                dp[i][j]=Math.min(a,b);
                dp[i][j]=Math.min(dp[i][j],c);
            }
        }
        return dp[m][n];
    }
}
