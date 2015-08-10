package com.jike.learn;

/**
 * Created by lihuaye on 15/8/5.
 */
public class Girl
{
    private String name;
    private int age;

    @Override
    public String toString()
    {
        return "Name:" + getName()+",\t"+"Age:"+getAge();
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
