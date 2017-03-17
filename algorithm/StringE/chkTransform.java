package bishi.algorithm.StringE;

/**
 * Created by asussl on 2016/10/17.
 */


//对于两个字符串A和B，如果A和B中出现的字符种类相同且每种字符出现的次数相同，则A和B互为变形词，
//请设计一个高效算法，检查两给定串是否互为变形词。
//        给定两个字符串A和B及他们的长度，请返回一个bool值，代表他们是否互为变形词。
//        测试样例：
//        "abc",3,"bca",3
//        返回：true
public class chkTransform {
}

class Transform {
    public boolean chkTransform(String A, int lena, String B, int lenb) {
        // write code here
        if(A==null||B==null||lena<0||lenb<0 ){
            return false;
        }
        char [] arrayA=A.toCharArray();
        char [] arrayB=B.toCharArray();
        int map[]=new int[256];
        for(int i=0;i<lena;i++){
            map[arrayA[i]]++;
        }
        for(int i=0;i<lenb;i++){
            if(map[arrayB[i]]--==0){
                return false;
            }
        }
        return true;
    }

}