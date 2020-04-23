package com.algorithm;

import java.util.Arrays;

/**
 * 分治算法
 *
 * @author wangjianfeng
 */
public class MergeMain {

    public static void main(String[] args) {
        Integer[] list = new Integer[]{3, 5, 2};
        Merge.sort(list);
        System.out.println(Arrays.asList(list));
    }

}

class Merge {
    // 不要在 merge 函数里构造新数组了，因为 merge 函数会被多次调用，影响性能
    // 直接一次性构造一个足够大的数组，简洁，高效
    private static Comparable[] aux;

    public static void sort(Comparable[] a) {
        aux = new Comparable[a.length];
        sort(a, 0, a.length - 1);
    }

    private static void sort(Comparable[] a, int lo, int hi) {
        if (lo >= hi) {
            return;
        }
        int mid = lo + (hi - lo) / 2;
        sort(a, lo, mid);
        sort(a, mid + 1, hi);
        merge(a, lo, mid, hi);
    }

    private static void merge(Comparable[] a, int lo, int mid, int hi) {
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            aux[k] = a[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (less(aux[j], aux[i])) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}