package cn.zqwzhao.sortexam;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author zhaoqw
 * @date 2023/01/11
 */
public class InsertionSort implements IMutableSorter {
    @Override
    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int cur = arr[i];
            int j = i;
            for(; j > 0 && arr[j - 1] > cur; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = cur;
        }
    }


    public void sortTest(Class cls, int N) {
        try {
            Constructor constructor = cls.getConstructor();
            Object instance = constructor.newInstance();
            long start = System.currentTimeMillis();
            if (instance instanceof IMutableSorter) {

            }
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
