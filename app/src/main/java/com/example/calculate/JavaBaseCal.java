package com.example.calculate;

import java.util.Scanner;

/**
 * create by apple
 * create on 18/11/25
 * description Java基础算法练习
 */
public class JavaBaseCal {

    /**
     * 打印九九乘法表
     */
    public static void multiplicationTable() {
        for (int i = 1; i <= 9; i++) {  //用i控制行，1-9行
            for (int j = 1; j <= i; j++) {  //用j控制列，j最大不超过当前i
                System.out.print(i + "*" + j + "=" + i * j + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 定义一个二维数组，int[2][4]，要求是循环输入8个整数，存入到数组中，然后输出这个数组中的最大值。
     */
    public static void arrayMax() {
        Scanner scanner = new Scanner(System.in);
        int[][] array = new int[2][4];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println("请输入" + i + "行" + j + "列数字");
                array[i][j] = scanner.nextInt();  //获取输入数存在对应行列位置
            }
        }
        int max = array[0][0]; //假定第一个数最大
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < 4; j++) {
                if (array[i][j] > max) {  //有更大就替换
                    max = array[i][j];
                }
            }
        }
        System.out.println("最大数为：" + max);
    }

    /**
     * 定义一个长度为10的整型数组，循环输入10个整数。然后判断这个数组中有几个偶数，再定义一个正好能存放这几个偶数的数组，
     * 将上一个数组中的所有偶数复制过来。最后循环输出这些偶数。
     */
    public static void even() {
        int[] array = new int[10];
        Scanner scanner = new Scanner(System.in);
        int evenCount = 0;
        for (int i = 0; i < array.length; i++) {
            System.out.println("输入第" + (i + 1) + "整数");
            array[i] = scanner.nextInt();
            if (array[i] % 2 == 0) {
                evenCount++;  //输入的同时判断是否为偶数
            }
        }
        int[] evenArray = new int[evenCount];
        evenCount = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                evenArray[evenCount] = array[i];
                evenCount++;  //记录新偶数数组存放个数
            }
        }
        System.out.print("所有的偶数有： ");
        for (int i = 0; i < evenCount; i++) {
            System.out.print(evenArray[i] + " ");
        }
    }

    /**
     * 输入一个数判断一个数是否为质数（只能被1和本身整除的数叫质数）
     */
    public static void primeNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个数：");
        int num = scanner.nextInt();
        int count = 0;  //记录能被整除的数的个数
        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                count++;
            }
        }
        if (count < 3) {
            System.out.println("这个数是质数");
        } else {
            System.out.println("这个数不是质数");
        }
    }

    /**
     * 定义一个二维数组，用来记录3个学生的java,c#,sql三门功课的成绩，二维数组的一行记录一个人的成绩，要求循环输入，最后输出格式如下：
     * java	c#	sql
     * 第1名学生	89	79	98
     * 第2名学生	99	80	100
     * 第3名学生	79	99	87
     */
    public static void printScore() {
        int[][] array = new int[3][3];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < array.length; i++) {
            System.out.println("请输入第" + i + "个学生java成绩：");
            int javaScore = scanner.nextInt();
            System.out.println("请输入第" + i + "个学生c#成绩：");
            int CScore = scanner.nextInt();
            System.out.println("请输入第" + i + "个学生sql成绩：");
            int sqlScore = scanner.nextInt();
        }
    }

    /**
     * 从1不断的累加，最多加到100，但如果你的累加结果
     * 正好大于1000时，要求也结束这个循环。问这个时候正好加
     * 到了几。
     */
    public static void accumulation() {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            sum += i;
            if (sum > 1000) {
                System.out.print("这个时候正好加到：" + i);
                break;
            }
        }
    }

    /**
     * 从1累加到100，但如果要累加的数据能被3整除，
     * 并且也能被7整数，那么就不要累加这个数。最后输出结果。
     */
    public static void accumulation2() {
        int sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 3 == 0 && i % 7 == 0) {
                continue;
            }
            sum += i;
        }
        System.out.print("总和为：" + sum);
    }

    /**
     * 打印图形
     * *
     * ***
     * *****
     * *******
     * *********
     * ***********
     * *************
     */
    public static void printStar() {
        //总共有7行
        for (int i = 0; i < 7; i++) {
            int printCount = 1 + 2 * i;  //每行打印个数规律为1+2*n
            for (int j = 0; j < printCount; j++) {
                System.out.print("*");  //循环打印
            }
            System.out.println();  //换行
        }
    }

    /**
     * *
     * ***
     * *****
     * *******
     * *********
     * ***********
     * *********
     * *******
     * *****
     * ***
     * *
     */
    public static void printStar2() {
        //打印前6行
        for (int i = 0; i < 6; i++) {
            int printCount = 1 + 2 * i;  //每行打印个数规律为1+2*n
            for (int j = 0; j < printCount; j++) {
                System.out.print("*");  //循环打印
            }
            System.out.println();  //换行
        }

        //打印后5行
        for (int i = 4; i >= 0; i--) {
            int printCount = 1 + 2 * i;
            for (int j = 0; j < printCount; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    /**
     * 给一个数组做反序。
     */
    public static void reserseArray() {
        //采用数组对称依次相互交换值得做法
        int[] array = new int[]{13, 0, 6, 42, 8, 24, 9, 10};
        int start = 0;  //低位下标
        int end = array.length - 1;  //高位下标
        for (; start < end; start++) {
            int temp = array[start];
            array[start] = array[end];
            array[end] = temp;
            end--;  //循环依次，低位右移，高位左移
        }
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }

    /**
     * 求1-100以内所有的质数
     */
    public static void getPrimeNumber() {
        System.out.print("1-100以内的质数有： ");
        for (int i = 1; i <= 100; i++) {
            int count = 0;
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) {
                    count++;
                }
            }
            if (count < 2) {
                System.out.print(i + "  ");
            }
        }
    }

    /**
     * 输入一个四位数，要求计算出它的千位，百位，十位，个位，并且打印出来。
     */
    public static void printNum() {
        Scanner scanner = new Scanner(System.in);
        int num;
        do {
            System.out.print("请输入一个四位数：");
            num = scanner.nextInt();
        }while (num/1000 < 1);
        int rest = num;
        int gewei = rest % 10;
        rest /= 10;
        int shiwei = rest % 10;
        rest /= 10;
        int baiwei = rest % 10;
        rest /= 10;
        int qianwei = rest % 10;
        System.out.print("个位" + gewei + "  十位" + shiwei + "  百位" + baiwei + "  千位" + qianwei);
    }

    public static void main(String[] args) {
//        multiplicationTable();
//        arrayMax();
//        even();
//        primeNumber();
//        accumulation();
//        accumulation2();
//        printStar2();
//        printStar2();
//        reserseArray();
//        getPrimeNumber();
//        printNum();
    }
}
