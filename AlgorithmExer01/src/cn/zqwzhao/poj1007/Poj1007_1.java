package cn.zqwzhao.poj1007;



import java.util.HashMap;
import java.util.Scanner;
/**
 * @Auther: zhaoqw
 * @Date: 2021/6/6 - 06 - 06 - 17:13
 * @Description: cn.zqwzhao.poj1007
 * @version: 1.0
 */
public class Poj1007_1 {

    public static void main(String[] args) {


        //map的key存储字符串的反转次数，value存储字符串
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int count = sc.nextInt();
        String[] strs = new String[count];
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            strs[i] = sc.next();

            int reverseCount = InversionNumber(strs[i],len);
            arr[i] = reverseCount;
            map.put(reverseCount,strs[i]);
        }

        quickSort1(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(map.get(arr[i]));
        }



    }



    //arr[L...R] 范围上，拿arr[R]作划分值
    public static int partition(int[] arr, int L, int R) {
        if (L > R) {
            return -1;
        }
        if (L == R) {
            return L;
        }
        int lessEqual = L - 1;
        int index = L;
        while (index < R) {
            if (arr[index] <= arr[R]) {
                swap(arr, index, ++lessEqual);
            }
            index++;
        }
        swap(arr, ++lessEqual, R);
        return lessEqual;
    }

    public static void quickSort1(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process1(arr, 0, arr.length - 1);
    }

    public static void process1(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        // L..R partition arr[R]  [   <=arr[R]   arr[R]    >arr[R]  ]
        int M = partition(arr, L, R);
        process1(arr, L, M - 1);
        process1(arr, M + 1, R);
    }

    // arr[L...R] 玩荷兰国旗问题的划分，以arr[R]做划分值
    //  <arr[R]  ==arr[R]  > arr[R]
    // 返回等于区域左边界与右边界
    public static int[] partition2(int[] arr, int L, int R) {
        if (L > R) {
            return new int[] { -1, -1 };
        }
        if (L == R) {
            return new int[] { L, R };
        }
        int less = L - 1; // < 区 右边界
        int more = R;     // > 区 左边界
        int index = L;
        while (index < more) {
            if (arr[index] == arr[R]) {
                index++;
            } else if (arr[index] < arr[R]) {
                swap(arr, index++, ++less);
            } else { // >
                swap(arr, index, --more);
            }
        }
        // L...less   less+1...more-1    more...R-1        R
        // L...less   less+1.............more  more+1...   R
        swap(arr, more, R);
        return new int[] { less + 1, more };
    }


    public static void quickSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process2(arr, 0, arr.length - 1);
    }

    public static void process2(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        // L..R partition arr[R]  [   <=arr[R]   arr[R]    >arr[R]  ]
        int[] equalE = partition2(arr, L, R);
        process1(arr, L, equalE[0] - 1);
        process1(arr, equalE[1] + 1, R);
    }


    public static void swap(int[] arr, int i, int j ) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static int InversionNumber(String  str,int len) {
        int ans=0;  //s逆序数
        int A,C,G;  //各个字母出现次数，T是最大的，无需计算T出现次数
        A=C=G=0;
        char[] chars = str.toCharArray();
        for(int i=len-1;i>=0;i--) {
            switch(chars[i]) {
                case 'A':A++;break;  //A是最小的，无逆序数
                case 'C':{
                    C++;
                    ans+=A;  //当前C后面出现A的次数就是这个C的逆序数
                    break;
                }
                case 'G': {
                    G++;
                    ans+=A;
                    ans+=C;
                    break;
                }
                case 'T': {
                    ans+=A;
                    ans+=C;
                    ans+=G;
                    break;
                }
            }
        }
        return ans;
    }


    public static int reverseCount(String s)
    {
        int num = 0;
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length -1; i++)
            for(int j = i + 1; j < chars.length ; j++) {
                //左边字母大于其右侧字母的次数
                if(chars[i] > chars[j]) {
                    num++;
                }
            }
        return num;
    }


    public static void splitNum(int[] arr) {
        //小于等于区最外层数字的索引
        int lessEqualR = -1;
        int index = 0;
        while (index < arr.length ) {
            if(arr[index] <= arr[arr.length - 1]) {
                swap(arr, lessEqualR + 1, index);
                lessEqualR ++;
                index ++;
            }else {
                index ++;
            }
        }

    }

    public static void splitNum2(int[] arr) {
        int N = arr.length - 1;
        //小于等于区最外层数字的索引
        int lessR = -1;
        int moreL = N;
        int index = 0;
        while (index < moreL ) {
            if(arr[index] < arr[N - 1]) {
                swap(arr, lessR + 1, index);
                lessR ++;
                index ++;
            } else if(arr[index] > arr[N - 1]) {
                swap(arr,--moreL, index);
            } else {
                index ++;
            }
        }

        swap(arr, moreL, N);

    }
}
