package cn.zqwzhao.recursiontest01;

/**
 *
 * @Auther: zhaoqw
 * @Date: 2021/6/17
 * @version: 1.0
 */
public class RecursionTest0617 {
    public static int getMax(int[] arr,int begin,int end) {

        //递归结束条件： begin - end 之间至少有一个元素，
        //比较begin和end上的元素，返回较大的
        if(begin + 1 >= end) {
            return arr[begin] > arr[end] ? arr[begin] : arr[end];
        }else {
            int mid = begin + ((end - begin) >> 1);
            return Math.max(getMax(arr,begin,mid), getMax(arr, mid + 1,end));
        }


    }

    public static void main(String[] args) {
        int[] arr = {343,4534,23434,66,5555,444333,23222,77777};
        if (arr.length == 1) {
            System.out.println("max" + arr[0]);
        }
        System.out.println(getMax(arr,0,arr.length - 1));
        System.out.println(Code08_GetMax.getMax(arr));
    }

    public static int getMax2(int[] arr,int m,int n) {
        int max;
        if (m >= n - 1) {
            if (arr[m] > arr[n]) {
                max = arr[m];
            } else {
                max = arr[n];
            }
        } else {
            int mid = m + (n - m) >> 1;
            int max1 = getMax2(arr, m, mid);
            int max2 = getMax2(arr, mid + 1, n);
            max = Math.max(max1, max2);
        }
        return max;
    }

}
