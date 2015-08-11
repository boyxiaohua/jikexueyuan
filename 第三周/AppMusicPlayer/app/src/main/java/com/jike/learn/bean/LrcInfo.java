package com.jike.learn.bean;

import com.jike.learn.player.LrcParse;

import java.sql.Time;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Created by lihuaye on 15/8/10.
 */
public class LrcInfo
{
    /**
     * 歌手名
     */
    private String singerName;
    /**
     * LRC制作者名
     */
    private String author;
    /**
     * 专辑名
     */
    private String albumName;
    /**
     * 曲名
     */
    private String singName;
    /**
     * 毫秒和歌词对应 map
     */
    private Map<Integer,String> timeLyricMap;

    /**
     * 构造方法
     */
    public LrcInfo(LrcParse lrcParse)
    {
        setSingerName(lrcParse.getSingerName());
        setAuthor(lrcParse.getAuthor());
        setAlbumName(lrcParse.getAlbumName());
        setSingName(lrcParse.getSingName());
        setTimeLyricMap(lrcParse.getTimeLyricMap());
    }

    /**
     * 获取专辑名
     * @return String
     */
    public String getAlbumName()
    {
        return albumName;
    }

    /**
     * 设置专辑名
     * @param albumName
     */
    public void setAlbumName(String albumName)
    {
        this.albumName = albumName;
    }

    /**
     * 获取 LRC 作者
     * @return String
     */
    public String getAuthor()
    {
        return author;
    }

    /**
     * 设置 LRC 作者
     * @param author
     */
    public void setAuthor(String author)

    {
        this.author = author;
    }

    /**
     * 获取毫秒和歌词对应 map
     * @return
     */
    public Map<Integer, String> getTimeLyricMap()
    {
        return timeLyricMap;
    }

    /**
     * 设置毫秒和歌词对应 map
     * @param timeLyricMap
     */
    public void setTimeLyricMap(Map<Integer, String> timeLyricMap)
    {
        this.timeLyricMap = timeLyricMap;
    }

    /**
     * 获取歌手名
     * @return
     */
    public String getSingerName()
    {
        return singerName;
    }

    /**
     * 设置歌手名
     * @param singerName
     */
    public void setSingerName(String singerName)
    {
        this.singerName = singerName;
    }

    /**
     * 获取歌名
     * @return
     */
    public String getSingName()
    {
        return singName;
    }

    /**
     * 设置歌名
     * @param singName
     */
    public void setSingName(String singName)
    {
        this.singName = singName;
    }

    /**
     * 默认的歌词输入
     * 要自己输入歌词
     * 自行获取歌词和时间的 list
     */
    public void singSong()
    {

        int sillisecond = 0;
        long time = System.currentTimeMillis();
        Set<Integer> keySet = timeLyricMap.keySet();
        Set<Integer> treeSet = new TreeSet<>(keySet);
        Iterator<Integer> iterator = treeSet.iterator();
        System.out.println("============================");
        System.out.println("ti->" + getSingName());
        System.out.println("ar->" + getSingerName());
        System.out.println("al->" + getAlbumName());
        System.out.println("by->" + getAuthor());
        System.out.println("============================");
        while (iterator.hasNext())
        {
            int silli=iterator.next();
            try
            {
                Thread.sleep(silli - sillisecond);
                sillisecond = silli;
                System.out.println(String.format("%s", new Time(System.currentTimeMillis() - time) + "\t" + timeLyricMap.get(silli)));
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
