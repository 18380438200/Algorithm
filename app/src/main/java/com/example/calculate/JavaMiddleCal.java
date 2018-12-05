package com.example.calculate;

import java.text.DecimalFormat;

/**
 * create by apple
 * create on 18/11/29
 * description Java初级算法练习
 */
public class JavaMiddleCal {

    /**
     * 求最大公约数
     */
    public static int gongyue(int a, int b) {
        int gongyue = 0;
        if (a < b) {  // 交换ab的值
            a = a + b;
            b = a - b;
            a = a - b;
        }
        if (a % b == 0) {
            gongyue = b;
        }
        while (a % b > 0) {
            a = a % b;
            if (a < b) {
                a = a + b;
                b = a - b;
                a = a - b;
            }
            if (a % b == 0) {
                gongyue = b;
            }
        }
        return gongyue;
    }

    /**
     * 求最小公倍数
     *
     * @param a
     * @param b
     * @return
     */
    public static int gongbei(int a, int b) {
        return a * b / gongyue(a, b);
    }

    /**
     * 有一对兔子，从出生后第3个月起每个月都生一对兔子，小兔子长到第三个月后每个月又生一对兔子，假如兔子都不死，问每个月的兔子总数为多少？
     */
    public static int calculateRabiit(int month) {
        if (month == 1 || month == 2) {
            return 1;
        } else {
            return calculateRabiit(month - 1) + calculateRabiit(month - 2);
        }
    }

    /**
     * 猴子吃桃问题：猴子第一天摘下若干个桃子，当即吃了一半，还不过瘾，
     * 又多吃了一个 第二天早上又将剩下的桃子吃掉一半，又多吃了一个。
     * 以后每天早上都吃了前一天剩下 的一半零一个。到第10天早上想再吃时，见只剩下一个桃子了。
     * 求第一天共摘了多少。
     */
    public static void monkeyEadPeach() {
        int totalNum = 1;  //第10天为1个，依次倒着推前一天的桃子个数,直到第1天
        for (int i = 9; i >= 1; i--) {
            totalNum = (totalNum + 1) * 2;
        }
        System.out.println("桃子总共有" + totalNum + "个");
    }

    /**
     * 有一分数序列：2/1，3/2，5/3，8/5，13/8，21/13...求出这个数列的前20项之和
     */
    public static void addSum() {
        //分析：得出规律，下一项的分母是上一项的分子，下一项的分子是上一项的分母加分子
        int a = 2;  //用a表示分子
        int b = 1;  //用b表示分母
        double totalSum = 0;
        for (int i = 0; i < 20; i++) {
            totalSum += (double) a / b;
            //改变a和b的值变为下一项的分子分母的值
            int temp = a;
            a = a + b;  //下一项的分子是上一项的分母加分子
            b = temp;  //下一项的分母是上一项的分子
        }
        DecimalFormat format = new DecimalFormat("#0.000");
        System.out.println("前20项之和为 " + format.format(totalSum));
    }

    /**
     * 一球从100米高度自由落下，每次落地后反跳回原高度的一半；再落下，求它在第10次落地时，共经过多少米？第10次反弹多高？
     */
    public static void fallDown() {
        double curPath = 100;
        double totalPath = 100;  //第一次下下落的高度
        totalPath += 100;  //第二次下落上弹的距离
        for (int i = 3; i <= 10; i++) {
            curPath = curPath / 2;  //当前次数经过的距离，每次距离为上次的一半，curPath为上下的距离之和
            totalPath += curPath;
        }
        double fantan = curPath / 2;
        System.out.println("总距离为" + totalPath + "，第10次反弹高度为" + fantan);
    }

    /**
     * 求1+2!+3!+...+10!的和
     */
    public static void product() {
        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            int num = 1;
            for (int j = 1; j <= i; j++) {
                //第i项式
                num *= j;
            }
            sum += num;
        }
        System.out.println("和为" + sum);
    }

    /**
     * 用递归的方式求n的阶乘
     */
    public static int recursion(int n) {
        if (n > 1) {
            return n * recursion(n - 1);  //n的阶乘为n乘以前一个数的阶乘，依次向前递归调用，但是在为1时停止
        } else {
            return 1;
        }
    }

    /**
     * 打印1000以内所有的水仙花数，水仙花数是指一个三位数，其各位数字立方和等于该数本身
     */
    public static void printNarcissus() {
        for (int i = 100; i < 1000; i++) {
            if (isNarcissus(i)) {
                System.out.println(i);
            }
        }
    }

    /**
     * 判断是不是水仙花数
     * @param i
     * @return
     */
    public static boolean isNarcissus(int i) {
        //设个位、十位、百位数字分别为a,b,c
        int c = i % 10;
        int b = i / 10 % 10;
        int a = i / 100;
        if (a * a * a + b * b * b +c * c * c == i) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 将一个正整数分解质因数。例如：输入90,打印出90=2*3*3*5。
     */
    public static void decompositionFactor(int n) {
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                //i为n的一个因数
                System.out.print(i);
                if (n != i) {
                    //未找完，还有其他因数
                    System.out.print("*");
                }
                decompositionFactor(n / i);
            }
        }
        System.exit(0);
    }

    public static void main(String[] args) {
        decompositionFactor(120);
    }

}
