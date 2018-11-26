package com.example.calculate;

/**
 * create by apple
 * create on 18/11/24
 * description 排序算法合集
 */
public class Sort {

    /**
     * 冒泡排序:每轮两两交换排出一个最大或最小值
     *
     * @param array
     */
    public static void bubbleSort(int[] array) {
        //定义排序的次数，每次找出最大的一个，总共要找array.length次
        //当前排好序的个数为i
        for (int i = 0; i < array.length; i++) {
            //将剩余的未排序的array.length-i个数循环进行排序，比较次数为(array.length-i-1)
            for (int j = 0; j < array.length - i - 1; j++) {
                //如果左边的书比右边的大，相互交换值
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * 插入排序：从第二个数起，将每个插入到前面有序数组中
     *
     * @param arr
     */
    public static void insertSort(int arr[]) {
        for (int i = 1; i < arr.length; i++) {  //除了第一个，后面都要插入排一次
            if (arr[i] < arr[i - 1]) {  //如果后一个比前一个小，需要挪动位置，否则不挪
                int temp = arr[i];  //temp为当前待插入元素
                int j;
                //判断应该插入到哪个位置
                for (j = i - 1; j > 0 && temp < arr[j]; j--) {  //循环判断大小，看是否该往后挪动
                    arr[j + 1] = arr[j];  //需要换位置的数往后移
                }
                arr[j + 1] = temp;  //把当前数插入最终挪出来的空位
            }
        }
    }

    /**
     * 选择排序：每次选其中最小的与第i个位置交换
     *
     * @param array
     */
    public static void selectSort(int[] array) {
        //i表示当前选择到的位置
        for (int i = 0; i < array.length; i++) {
            int minPos = i;  //假设当前一轮选择，最小的数为第一个，即位置i
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minPos]) {  //循环判断与当前最小数进行比较，如有更小的则重新记录最小值位置
                    minPos = j;
                }
            }
            //将最小数与当前轮第一个数交换
            int temp = array[i];
            array[i] = array[minPos];
            array[minPos] = temp;
        }
    }

    public static int getMiddle(int[] array, int low, int high) {
        int base = array[low];  //取第一位置数为基准数，空出第一个位置
        while (low < high) {
            while (low < high && base <= array[high]) {  //从高位找，只要高位比基准数大，就向低位移动继续找
                high--;
            }
            array[low] = array[high];  //终于，在高位找到了比基准数小的数，将其放入低位置
            while (low < high && base >= array[low]) {  //从低位找，只要低位比基准数小，就向高位移动继续找
                low++;
            }
            array[high] = array[low];  //终于，在低位找到了比基准数大的数，将其放入高位置
        }
        //一轮移完位置后，low下标位置仍为空位
        array[low] = base;  //将基准数放入low位置，此时左边数都比base小，右边数都比base大
        return low;
    }

    /**
     * 快速排序，每一轮找到中间值，对左右两边子列表递归调用该快速排序
     *
     * @param array
     * @param low
     * @param high
     */
    public static void quickSort(int[] array, int low, int high) {
        if (low < high) {
            int middle = getMiddle(array, low, high);
            quickSort(array, 0, middle - 1);  //对左部分位置继续调用排序方法
            quickSort(array, middle + 1, high);  //对右部分位置继续调用排序方法
        }
    }

    private static void printArray(int array[]) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args) {
        int[] array = new int[10];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random() * 100 - 20);
        }
        //以下排序任选其一
        bubbleSort(array);
        insertSort(array);
        selectSort(array);
        quickSort(array, 0, array.length - 1);

        printArray(array);
    }
}
