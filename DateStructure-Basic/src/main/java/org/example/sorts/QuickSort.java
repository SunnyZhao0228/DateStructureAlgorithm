package org.example.sorts;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author zhaoqw
 * @date 2023/01/29
 */
public class QuickSort implements ISorter<Integer>{
    @Override
    public List<Integer> sort(List<Integer> A) {
        return this.quickSort(A);
    }

    @Override
    public List<Integer> sort(HashSet<Integer> hashSet) {
        return null;
    }

    private List<Integer> quickSort(List<Integer> A) {
        if (A.size() <= 1) {
            return A;
        }
        // | ----left ----| x | ----right----|
        Integer x = A.get(0);
        List<Integer> left = A.stream().filter(a -> a < x).collect(Collectors.toList());
        List<Integer> mid = A.stream().filter(a -> a == x).collect(Collectors.toList());
        List<Integer> right = A.stream().filter(a -> a > x).collect(Collectors.toList());

        left = quickSort(left);
        right = quickSort(right);
        left.addAll(mid);
        left.addAll(right);
        return left;
    }
}
