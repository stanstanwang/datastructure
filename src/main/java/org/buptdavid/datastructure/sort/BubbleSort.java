package org.buptdavid.datastructure.sort;

/**
 * 冒泡排序<br>
 * 时间复杂度: 平均情况与最差情况都是O(n^2)<br>
 * 空间复杂度: O(1)
 *
 * @author weijielu
 * @see ISort
 * @see SortTest
 */
public class BubbleSort implements ISort {


    /**
     * 冒泡排序有两个优化点：
     * 1. 每次少交换一趟
     * 2. 一次没有交换过，表示已经稳定了
     */
    public void sort(int[] array) {
        int temp;
        // 外边是循环的趟次
        for (int i = 0; i < array.length; i++) {

            boolean swapped = false;

            // 这里是冒泡的次数，每一次遍历，少一趟
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

}
