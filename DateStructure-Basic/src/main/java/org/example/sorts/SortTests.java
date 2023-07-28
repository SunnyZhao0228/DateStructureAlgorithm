package org.example.sorts;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 排序算法的测试
 *
 * @author zhaoqw
 * @date 2023/7/28
 */
public class SortTests {



    public void sortTest(Class cls, int N){


        try {
            Constructor constructor = cls.getConstructor();
            Object rawInst = constructor.newInstance();
            long l = System.currentTimeMillis();
//            if(rawInst instanceof ISorter) {
//                var A = gen(N);
//                var inst = (IntegerSorter)rawInst;
//                A = inst.sort(A);
//                System.out.println("time usage:" + (System.currentTimeMillis() - start));
//                assertSorted(A);
//
//            } else if(rawInst instanceof IMutableSorter) {
//                var A = gen(N).stream().mapToInt(x->x).toArray();
//                var inst = (IMutableSorter)rawInst;
//                inst.sort(A);
//                System.out.println("time usage:" + (System.currentTimeMillis() - start));
//                assertSorted(A);
//            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    static void assertSorted(int[] A) {
        assertSorted(Arrays.stream(A).boxed().collect(Collectors.toList()));
    }

    static void assertSorted(List<Integer> A) {
        Integer o = Integer.MIN_VALUE;
        for (int i : A) {
            if (o > i) {
                System.out.println(A.toString());
                System.out.println("Array not in sorted order");
            }
            o = i;

        }
    }

}
