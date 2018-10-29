package com.fourkings.blog.aspect;

import java.util.Scanner;
public class ClimbStairs
{
    /**
     * 使用朴素递归的方法和动态规划的方法实现求爬楼梯的方法数
     */
    public static void main(String[] args)
    {
        long start1, start2;//用于记录两个子函数开始运行的时间
        Scanner str = new Scanner(System.in);
        int number = str.nextInt();//获得台阶数目
        long count[] = new long[number + 1];//用于记录动态规划中子问题的解
        count[0] = 1L;
        count[1] = 1L;
        start1 = System.currentTimeMillis();//记录函数1的开始时间
        System.out.println("There are " + fun1(number) + " methods.");
        System.out.println("Cost " + (System.currentTimeMillis() - start1) + " ms.");//获得函数1的执行时间
        start2 = System.currentTimeMillis();//记录函数2的开始时间
        System.out.println("There are " + fun2(count, number) + " methods.");
        System.out.println("Cost " + (System.currentTimeMillis() - start2) + " ms.");//获得函数2的运行时间
    }
    //定义朴素递归调用方法
    public static long fun1(int num)
    {
        if (num == 1)//基础情况
            return 1L;
        else if (num == 2)//基础情况
            return 2L;
        else
            return fun1(num - 1) + fun1(num - 2);//递归调用
    }
    //定义动态规划方法
    public static long fun2(long count[], int num)
    {
        if (num == 1)//基础情况
            return 1L;
        else
        {
            for  (int i = 2; i <= num; i++)
            {
                count[i] = count[i - 1] + count[i - 2];//这里并没有调用原函数计算，而是直接使用子问题的结果
            }
        }
        return count[num];
    }
}
