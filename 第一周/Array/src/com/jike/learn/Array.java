package com.jike.learn;

/**
 * Created by lihuaye on 15/8/4.
 */
public class Array
{
    public static void main(String[] args)
    {
        int arr[] = new int[20];
        /**
         * 数组的赋值
         */
        for (int i = 0; i < arr.length; i++)
        {
            arr[i]=i+1;
        }
        /**
         * 输出
         */
        for (int i = 0; i < arr.length; i++)
        {
            System.out.println("arr["+i+"] = "+arr[i]);
        }
    }
}
