package cn.zqwzhao.test0616;

/**
 * @Auther: zhaoqw
 * @Date: 2021/6/16 - 06 - 16 - 19:50
 * @Description: cn.zqwzhao.test0616
 * @version: 1.0
 */
public class MoveK {
    /**
     * 经典方法，三次倒置数组中对应位置的元素;
     * 简单说一下原理：数组元素右移k个位置的结果是，原来在
     * 后面的k个元素跑到了数组前面，原来在前面的length-k个元素，
     * 跑到了数组的后面，并且前后两部分元素各自的顺序和
     * 移动前一致，而倒置整个数组元素就是让后面k个元素跑到前面去，
     * 让前面length-k个元素跑到后面去，但是倒置之后前后两部分
     * <p>
     * 元素的顺序跟移动之前不一样了，倒置了，所以要把两部分的元素
     * <p>
     * 倒置回来
     * @param array
     * @param k
     */
    public static void moveArrayElement3(int[] array, int k) {
        // 倒置所有元素
        reverse(array);
        // 倒置前k个元素
        reverse(array, 0, k - 1);
        // 倒置后length - k个元素
        reverse(array, k, array.length - 1);
    }

    /**
     * 倒置数组中begin和end之间的元素，包括begin和end
     *
     * @param array
     * @param begin
     * @param end
     */
    private static void reverse(int[] array, int begin, int end) {
        int length = end - begin + 1;
        int half = length >> 1;
        for (int i = 0; i < half; i++) {
            int temp = array[begin];
            array[begin] = array[end];
            array[end] = temp;
            begin++;
            end--;
        }
    }
    private static void reverse(int[] array) {
        reverse(array, 0, array.length - 1);

    }


    public static void move(int[] array){
        int i = 0;
        int j = array.length-1;
        while(i < j){
            while(array[i]<0) i++; //从前往后找第一个>0的数
            while(array[j]>0) j--; //从后往前找第一个<0的数
            //找到就交换
            /*array[i] = array[i]^array[j];
            array[j] = array[i]^array[j];
            array[i] = array[i]^array[j];*/

             int temp =  array[i];
             array[i] = array[j];
             array[j] = temp;
        }
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, -1, -2, 3, -3, 4};
        move(arr);
        for (int i = 0; i< arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println(binarySearch(arr,-3));
    }

    //二分查找
    public static  int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            //int mid = (right + left) / 2;
            int mid = left + ((right - left) >> 1);
            if (nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1;
            else if (nums[mid] > target)
                right = mid - 1;
        }
        System.out.println("没有找到");
        return -1;
    }

}



