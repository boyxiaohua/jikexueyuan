package com.jike.learn;

/**
 * Created by lihuaye on 15/8/3.
 */
public class MaxNumber
{
    public static void main(String[] args)
    {
        int arr[]={1,5,7,2,1,9,4,15,3,6,4,8,12};
        System.out.println(max(arr));
    }
    public static int max(int arr[])
    {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++)
        {
            if(max<arr[i])
            {
                max=arr[i];
            }
        }
        return max;
    }
}
