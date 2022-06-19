package org.buptdavid.datastructure.sort;

import java.util.Arrays;

/**
 * 归并排序<br>
 * 时间复杂度: 平均情况与最差情况都是O(nlog(n))<br>
 * 空间复杂度: It Depends
 *
 * @author weijielu
 * @see ISort
 * @see org.buptdavid.datastructure.sort.SortTest
 */
public class MergeSort implements ISort {


    // b栈参考 https://www.bilibili.com/video/BV1Pt4y197VZ
    public void sort(int[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    /**
     * 从索引low到high归并排序数组array
     *
     * @param array
     * @param low
     * @param high
     */
    private void mergeSort(int[] array, int low, int high) {
        // 1. 边界值
        if (low < high) {

            // 2. 递归
            int middle = (low + high) / 2;
            mergeSort(array, low, middle);
            mergeSort(array, middle + 1, high);

            // 3. 合并，将两个有序的数组合并成一个大的数组后像上返回
            // 递归到最末尾，这个归并其实是两个一个元素的小数组，合并成两个元素的一个数组
            merge(array, low, middle, high);
        }
    }

    /**
     * 将两个有序的子数组，合并成大数组
     *
     * @param array  原数组的元素
     * @param low    左边数组的起点
     * @param middle 右边数组的起点
     * @param high
     */
    private void merge(int[] array, int low, int middle, int high) {

        /*
         * 辅助数组 ，为什么需要辅助数组？
         * 用于存放旧的数据，比较两个有序数组的数据就直接放到目标数组中去了
         */
        int[] helper = new int[array.length];
        for (int i = 0; i <= high; i++) {
            helper[i] = array[i];
        }

        int helperLeft = low;
        int helperRight = middle + 1;
        int current = low;

        /*
         * 迭代访问helper数组，比较左右两半元素
         * 并将较小的元素复制到原先的数组中
         */
        while (helperLeft <= middle && helperRight <= high) {
            if (helper[helperLeft] <= helper[helperRight]) {
                array[current++] = helper[helperLeft++];
            } else {
                array[current++] = helper[helperRight++];
            }
        }

        /*
         * 将数组左半剩余元素复制到原先的数组中
         * 这里是不管右边的，因为右边本来就有序了的？
         * 右边为什么本来就会有序了？ 因为必定是处理完子串的有序了的，才会做归并哦
         */
        int remaining = middle - helperLeft;
        for (int i = 0; i <= remaining; i++) {
            array[current + i] = helper[helperLeft + i];
        }

        // 3,5  2,4,7
        // 2,3,4,5

    }


    public static void main(String[] args) {
        // int[] arr = new int[]{3, 5, 2, 4, 7};
        int[] arr = new int[]{3, 5, 7, 2, 4};
        MergeSort mergeSort = new MergeSort();
        mergeSort.merge(arr, 0, 2, 4);
        System.out.println(Arrays.toString(arr));
    }

}
