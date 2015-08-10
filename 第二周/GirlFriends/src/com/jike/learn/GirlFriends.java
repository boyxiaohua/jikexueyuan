package com.jike.learn;


import java.io.*;

/**
 * Created by lihuaye on 15/8/5.
 */
public class GirlFriends
{

    public static void main(String[] args)
    {
        Girl girl;
        for (int i = 0; i <= 1000; i++)
        {
            girl=getGirlEnglish();
            System.out.println(girl.toString());
        }
    }

    /**
     * 获取到 Gril 的实例
     * @return Girl
     */
    public static Girl getGirlEnglish()
    {
        Girl girl=new Girl();
        StringBuffer sb=new StringBuffer();
        int nameLenght= (int) (Math.random()*5) % (5-3+1) + 3;
        for (int i = 0; i < nameLenght; i++)
        {
            sb.append(getCharacter(i));
        }
        girl.setName(sb.toString());
        girl.setAge(getAge());
        return girl;
    }

    /**
     * 获取名字中的字母
     * 第一个字母大写
     * @param i 判断第几个字母
     * @return char
     */
    public static char getCharacter(int i)//i用来判断名字第几个字符，第一个字符大写
    {
        char character=(char)((Math.random() *(int)'z') %((int)'z'-(int)'a'+1) + (int)'a');
        return i == 0 ? (char)(character-32):character ;
    }

    /**
     * 取得年龄
     * @return int
     */
    public static int getAge()
    {
        return (int)((Math.random()*20)%(20-10+1)+10);
    }

}
