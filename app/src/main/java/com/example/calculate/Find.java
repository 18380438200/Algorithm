package com.example.calculate;

/**
 * create by apple
 * create on 18/11/24
 * description 查找算法
 */
public class Find {

    /**
     * 顺序查找
     *
     * @param array
     * @param num
     * @return
     */
    public static int search(int[] array, int num) {
        int position = -1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == num) {
                return i;
            }
        }
        return position;
    }

    /**
     * 折半查找
     *
     * @param array
     * @param start
     * @param end
     * @param num
     * @return
     */
    public static void binerySearch(int[] array, int start, int end, int num) {
        int position = -1;
        int middle = (start + end) / 2;
        if (array[middle] == num) {
            System.out.print("找到第" + middle);
        } else if (array[middle] > num) {
            binerySearch(array, start, middle - 1, num);
        } else if (array[middle] < num) {
            binerySearch(array, middle + 1, end, num);
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{7, -3, 0, 20, 8, 9};

        int position = search(array, 20);
        if (position == -1) {
            System.out.println("没有找到该数");
        } else {
            System.out.println("找到第" + position + "个位置");
        }

        int[] array2 = new int[]{-2,5,10,16,87,99};
        binerySearch(array2,0,array2.length,10);
    }
}
