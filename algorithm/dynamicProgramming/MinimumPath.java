package bishi.algorithm.dynamicProgramming;

/**
 * Created by asussl on 2016/10/28.
 */
public class MinimumPath {
    public static void main(String[] args){
//        [[613,0,93,463],[101,369,112,255],[42,67,86,543],[485,452,393,461]],4,4
        MinimumPathCore s=new MinimumPathCore();
        int arr[][]={{613,0,93,463},{101,369,112,255},{42,67,86,543},{485,452,393,461}};
        int result=s.getMin(arr,4,4);
        System.out.println(result);
    }
}
class MinimumPathCore {
    public int getMin(int[][] map, int n, int m) {
        // write code here
        if(map==null||n<0||m<0) throw new RuntimeException("error");
        int dp[][]=new int[n][m];
        dp[0][0]=map[0][0];
        for(int j=1;j<m;j++){
            dp[0][j]=dp[0][j-1]+map[0][j];
        }
        for(int i=1;i<n;i++){
            dp[i][0]=dp[i-1][0]+map[i][0];
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                int left=dp[i][j-1];
                int top=dp[i-1][j];
                dp[i][j]=left<=top?left+map[i][j]:top+map[i][j];
            }
        }
        return dp[n-1][m-1];
    }
}