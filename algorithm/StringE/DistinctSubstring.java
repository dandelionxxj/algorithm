package bishi.algorithm.StringE;

/**
 * Created by asussl on 2016/10/17.
 */
public class DistinctSubstring {
}
class DistinctSubstringCore {
    public int longestSubstring(String A, int n) {
        // write code here
        if(A==null||n<0||n>500) return 0;
        int [] map=new int[256];
        for(int i=0;i<256;i++){
            map[i]=-1;
        }
        int len=0;
        int cur=0;
        int pre=-1;
        for(int i=0;i<n;i++){
            pre=Math.max(pre,map[A.charAt(i)]);
            cur=i-pre;
            len=Math.max(len,cur);
            map[A.charAt(i)]=i;
        }
        return len;
    }
}