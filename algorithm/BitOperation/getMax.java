package bishi.algorithm.BitOperation;

/**
 * Created by asussl on 2016/10/17.
 */
//对于两个32位整数a和b，请设计一个算法返回a和b中较大的。但是不能用任何比较判断。
//若两数相同，返回任意一个。给定两个整数a和b，请返回较大的数。
public class getMax {
}
class Compare {

    public int getMax(int a, int b) {
        //c=a-b;
        //1. 如果a,b同号，取决于c的符号，为正，则a>b,为负，则a<b;
        //2.如果a，b异号，则a符号为正时候为正数；
        // write code here
        int c=a-b;
        int as=sign(a);
        int bs=sign(b);
        int cs=sign(c);
        int diffab=as^bs;
        int sameaf=flip(diffab);
        int returnA=diffab*as+sameaf*cs;
        int returnB=flip(returnA);
        return a*returnA+b*returnB;
    }
    public int flip(int n){//最后一位取反
        return n^1;
    }
    public int sign(int n){//符号位，正数为1，负数为0；
        return flip((n>>31)&1);
    }
}