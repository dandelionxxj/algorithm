package bishi.algorithm.dynamicProgramming;

/**
 * Created by asussl on 2016/10/20.
 */
public class penny {
    public static void main(String[] args){
        Exchange4 e2=new Exchange4();
        int arr[]={1,3,6};
        int result=e2.countWays(arr,3,13);
        System.out.println(result);
    }
}
class Exchange1 {
    //暴力的方法
    public int countWays(int[] penny, int n, int aim) {
        // write code here
        if(penny==null||n==0||aim<0){return 0;}
        return process1(penny,n,aim,0);
    }
    public int process1(int[] arr,int n,int aim,int index){
        int count=0;
        if(n==index) {
            count=aim==0?1:0;
        }else{
            for(int i=0;arr[index]*i<=aim;i++){
                count+=process1(arr,n,aim-arr[index]*i,index+1);
            }
        }
        return count;
    }
}
class Exchange2 {
    //记忆搜索
    public int countWays(int[] penny, int n, int aim) {
        // write code here
        if(penny==null||n==0||aim<0){return 0;}
        int map[][]=new int [n+1][aim+1];
       //System.out.println(map[0][0]);
        return process2(penny,n,aim,0,map);
    }
    public int process2(int[] arr,int n,int aim,int index,int[][] map){
        int count=0;
        if(index==n){
            count=aim==0?1:0;
        }else{
            int mapvalue=0;
            for(int i=0;arr[index]*i<=aim;i++){
               mapvalue=map[index+1][aim-arr[index]*i];
                if(mapvalue!=0){
                    count+=mapvalue==-1?0:mapvalue;
                }else{
                    count+=process2(arr,n,aim-arr[index]*i,index+1,map);
                }
            }
        }
        map[index][aim]=count==0?-1:count;
        return count;
    }
}

class Exchange3{
    public int countWays(int[] penny, int n, int aim) {
        // write code here
        if(penny==null||n==0||aim<0){return 0;}
        int[][] dp=new int[n][aim+1];
        //第一列是值全为1
        for(int i=0;i<n;i++){
            dp[i][0]=1;
        }
        for(int i=penny[0];i<aim+1;i+=penny[0]){
            dp[0][i]=1;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<aim+1;j++){
                dp[i][j]=0;
                for(int k=0;k*penny[i]<=j;k++){
                    dp[i][j]+=dp[i-1][j-k*penny[i]];//注意不要写成aim-k*penny[i]
                }
            }
        }

        return dp[n-1][aim];
    }

}
class Exchange4{
    public int countWays(int[] penny, int n, int aim) {
        // write code here
        if(penny==null||n==0||aim<0){return 0;}
        int[][] dp=new int[n][aim+1];
        //第一列是值全为1
        for(int i=0;i<n;i++){
            dp[i][0]=1;
        }
        for(int i=penny[0];i<aim+1;i+=penny[0]){
            dp[0][i]=1;
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<aim+1;j++){
                dp[i][j]=0;
                for(int k=0;k*penny[i]<=j;k++){
                    dp[i][j]+=dp[i-1][j-k*penny[i]];//注意不要写成aim-k*penny[i]
                }
            }
        }

        return dp[n-1][aim];
    }

}
class Exchange5 {
    public int countWays(int[] penny, int n, int aim) {
        // write code here
        if(penny==null||n==0) return 0;
        int dp[]=new int[1000];
        dp[0]=1;
        for(int i=0;i<n;i++){
            for(int j=penny[i];j<=aim;j++){
                dp[j]=dp[j]+dp[j-penny[i]];
            }
        }
        return dp[aim];
    }
}