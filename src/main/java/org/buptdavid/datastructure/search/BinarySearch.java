package org.buptdavid.datastructure.search;

/**
 * 二分查找的实现： 在一个有序数组中查找某个值
 * @author weijielu
 * @see BinarySearchTest
 */
public class BinarySearch {

	/**
	 * 使用循环的方式实现二分查找
	 * @param array
	 * @param value
	 * @return +1或者－1可能要好好思考下？ 正常用法够了的
	 * 			具体参考 https://leetcode.cn/problems/koko-eating-bananas/solution/ai-chi-xiang-jiao-de-ke-ke-by-leetcode-s-z4rt/
	 */
	public static Integer searchCirculation(int[] array, int value){
		int low = 0;
		int high = array.length - 1;
		int middle;

		while(low <= high){
			middle = (low + high) / 2;
			if(value < array[middle]){
				high = middle - 1;
			}else if(value > array[middle]){
				low = middle + 1;
			}else{
				return array[middle];
			}
		}

		return null;
	}

	/**
	 * 使用递归的方式实现二分查找
	 * @param array
	 * @param value
	 * @return
	 */
	public static Integer searchRecursive(int[] array, int value){
		return searchRecursive(array, value, 0, array.length - 1);
	}

	private static Integer searchRecursive(int[] array, int value, int low, int high){
		if(high < low){
			return null;
		}

		int middle = (low + high) / 2;

		if(value < array[middle]){
			return searchRecursive(array, value, low, middle - 1);
		}else if(value > array[middle]){
			return searchRecursive(array, value, middle + 1, high);
		}else {
			return array[middle];
		}
	}

}
