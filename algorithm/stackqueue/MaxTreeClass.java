package bishi.algorithm.stackqueue;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by asussl on 2016/10/30.
 */
public class MaxTreeClass {
}
 class MaxTreeCore {

    // 好经典的题目啊
    // 使用一个栈 保存下标，来对比元素
    // 刚开始的话，将所有父结点的小标初始化为 -1
    public int[] buildMaxTree(int[] A, int n) {
        if(A == null || n==0) return null;
        int[] result = new int[n];
        Stack<Integer> st = new Stack<Integer>();

        //初始状态下，所有元素的父结点都为 null，对应下标为-1
        Arrays.fill(result, -1);

        // 循环处理每一个元素
        // 需要一个额外的栈来辅助获取两个阶段的最大值（两个阶段指左边最大值和右边最大值）
        // 每次判断一个元素分三种情况
        //  1. 栈为空，也就是初始状态，直接将元素下标入栈（此时该元素的父结点下标为默认值 -1）
        //  2. 栈不为空，同时即将进栈的元素比栈顶元素小，那么直接将元素进栈同时更新当前元素的
        //     父结点下标为i(设定父结点为左边第一个比该元素大的，右侧第一个比该元素大的第3步说明)
        //  3. 栈不为空，同时即将进栈的元素比栈顶元素小，那么需要将栈顶元素出栈，然后比较
        //     需要分情况:
        //     1) 栈顶元素对应父结点下标为null， 说明栈顶元素左侧没有最大值，此时需要更新
        //        栈顶元素对应父结点下标为当前进栈元素的下标 i，然后将栈顶元素pop 出栈
        //     2) 栈顶元素对应的父结点下标对应数组中元素比，i 位置对应数组元素大，由maxTree 的
        //        定义，我们必须保存左侧和右侧相对较小的那个作为最终结果，所以也更新元素下标为i
        //        然后将栈顶元素 pop 出栈
        //     3) 如果不在上面两种情况范围内，直接将栈顶元素出栈，然后继续循环执行 3 步骤
        for(int i=0;i<n;i++){
            // 比较复杂的核心操作
            while(!st.isEmpty() && A[st.peek()]<A[i]){
                // 如果即将《被pop 元素》的左侧最大值为null 或者其左侧最大值比右侧(A[i])最大值大
                // 需要先更新该元素的父结点为右侧结点下标
                if(result[st.peek()] == -1 || A[result[st.peek()]]>A[i]){
                    result[st.peek()] = i;//更新成右侧最大值
                }

                // 不管更新没更新栈顶元素最终的父结点下标，接下来都需要把其pop 出栈
                st.pop();
            }

            // 经过上面循环，判断一下栈是否为空了
            if(!st.isEmpty()){
                //如果不空，更新当前元素左侧第一个比它大的父结点为栈顶元素
                result[i] = st.peek();
            }
            //不管栈是否为空，最终都要将当前元素进栈
            st.push(i);
        }
        return result;
    }
}