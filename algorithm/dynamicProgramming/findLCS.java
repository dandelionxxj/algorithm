package bishi.algorithm.dynamicProgramming;

/**
 * Created by asussl on 2016/10/29.
 */
public class findLCS {
    public static void main(String[] args){
        LCS lcs=new LCS();
//        int result=lcs.findLCS("1A2C3D4B56",10,"B1D23CA45B6A",12);
//        int result2=lcs.findLCS("slvo",4,"tysoklr",7);
        int result3=lcs.findLCS("rsymsknwbiapzhuoeyhjubogitoqfkswhbqhwqzyjuvdlzjlhlaubecnkzgvurdsuvqghpjazgxvue",78,"sclzdzbtrrkdybusjyjrszzqaebkpdtqnqadndvkenqirqqsplmceuuzhukcxxnkcyyvucqjlkysfarxkulpayvtwfmfaqpikzdslpklomafvtesecxygahwnyljldutzsoywiwkugerfbfefcqfvcrzcvbevufzbkbhfeshhdasqo",174);
        System.out.println(result3);
    }
}
class LCS {
    public int findLCS(String A, int n, String B, int m) {
        // write code here
        if(A==null||B==null||n<=0||m<=0) return 0;
        int dp[][]=new int[n][m];
        boolean fi=false;
        for(int i=0;i<n;i++){
            if(fi){
                dp[i][0]=1;
            }else{
                if(A.charAt(i)==B.charAt(0)){
                    dp[i][0]=1;
                    fi=true;
                }
            }
        }
        fi=false;
        for(int i=0;i<m;i++){
            if(fi){
                dp[0][i]=1;
            }else{
                 if(B.charAt(i)==A.charAt(0)){
                        dp[0][i]=1;
                        fi=true;
                }
            }
        }
        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(A.charAt(i)==B.charAt(j)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=dp[i-1][j]>=dp[i][j-1]?dp[i-1][j]:dp[i][j-1];
                }
            }
        }
        return dp[n-1][m-1];
    }
}
class LCS2 {
    public int findLCS(String A, int n, String B, int m) {
        // write code here
        if(A==null||B==null||n<=0||m<=0) return 0;
        int dp[][]=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(A.charAt(i-1)==B.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                dp[i][j]=Math.max(dp[i][j],Math.max(dp[i-1][j],dp[i][j-1]));

            }
        }
        return dp[n][m];
    }
}