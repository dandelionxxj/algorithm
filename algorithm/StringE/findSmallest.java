package bishi.algorithm.StringE;

import java.util.*;

/**
 * Created by asussl on 2016/10/17.
 */
public class findSmallest {

}
 class Prior {
    public class MyComparator implements Comparator<String>{
        @Override
        public int compare(String a, String b){
            return (a+b).compareTo(b+a);
        }
    }
    public String findSmallest(String[] strs, int n) {
        // write code here
        if(strs==null||n<0) return "";
        //冒泡
        Arrays.sort(strs, new MyComparator());
        StringBuffer sb=new StringBuffer();
        for(int i=0,len=strs.length;i<len;i++){
            sb.append(strs[i]);
        }
        return sb.toString();
    }


}