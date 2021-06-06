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
        HashMap<Integer, String> map = new HashMap<Integer, String>();
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int count = sc.nextInt();
        String[] strs = new String[count];
        int[] arr = new int[count];
        for (int i = 0; i < count; i++) {
            strs[i] = sc.next();

            int reverseCount = reverseCount(strs[i]);
            arr[i] = reverseCount;
            map.put(reverseCount,strs[i]);
        }

        quickSort1(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(map.get(arr[i]));
        }



    }

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

    public static void swap(int[] arr, int i, int j ) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
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
}
