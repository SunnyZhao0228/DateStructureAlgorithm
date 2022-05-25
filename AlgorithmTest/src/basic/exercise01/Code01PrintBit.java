package basic.exercise01;

/**
 * 打印
 *
 * @author [zqwzh]
 * @createTime [2022-05-24]
 */
public class Code01PrintBit {

    public static void printIntToBit(int num) {
        for (int i = 31; i >= 0 ; i--) {
            String bit = (num & 1 << i) == 0 ? "0" : "1";
            System.out.print(bit);
        }
        System.out.println();
    }

    public static void printLongToBit(long num) {
        for (int i = 63; i >= 0 ; i--) {
            String bit = (num & 1 << i) == 0 ? "0" : "1";
            System.out.print(bit);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printIntToBit(5);
        printLongToBit(1548455454554l);

        int a = Integer.MIN_VALUE;
        System.out.println(a >> 1); // >>代表带符号的右移
        System.out.println(a >>> 1); // >>> 不带符号右移 0 来补
        printIntToBit(a);
        printIntToBit(a >> 1);
        printIntToBit(a >>> 1);

        int b = 999;
        int c = -b;
        System.out.println(c);
        b = (~b + 1);
        System.out.println(b);
    }



}
