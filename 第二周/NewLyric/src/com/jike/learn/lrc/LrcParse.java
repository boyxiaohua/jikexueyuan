package com.jike.learn.lrc;

import com.jike.learn.api.LrcParser;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by lihuaye on 15/8/10.
 */
public class LrcParse implements LrcParser
{
    private static final String singerNameAttr = "ar";
    private static final String authorAttr = "by";
    private static final String albumNameAttr = "al";
    private static final String singNameAttr = "ti";
    private static final String timeReg = "\\[\\d{2}:\\d{2}.?(\\d{2})?\\]";
    private static final String lyricReg = "[^\\[\\d{2}:\\d{2}.\\d{2}\\]].*";
    private List<String> lrcLine;
    private Map<Integer, String> timeLyric;


    /**
     * 构造函数
     * @param lrcPath String
     */
    public LrcParse(String lrcPath)
    {
        lrcLine = new ArrayList<>();
        timeLyric = new HashMap<>();
        readLyrics(lrcPath);
        parseLyies();
    }

    /**
     * 读取 lrc 的每行
     *
     * @param lrcPath
     */
    private void readLyrics(String lrcPath)
    {
        try
        {
            File lrcfile = new File(lrcPath);
            FileInputStream fis = new FileInputStream(lrcfile);
            InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
            BufferedReader br = new BufferedReader(isr);
            String temp;
            while ((temp = br.readLine()) != null)
            {
                lrcLine.add(temp);
            }
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 歌词解析
     */
    public void parseLyies()
    {
        for (String temp : lrcLine)
        {
            Pattern pattern = Pattern.compile(timeReg);
            Matcher matcher = pattern.matcher(temp);
            List<Integer> millis = new ArrayList<>();
            boolean find = false;
            //单行时间可能会有多个
            while (matcher.find())
            {
                find = true;
                millis.add(getListMilliseconds(matcher.group()));
            }
            if (find)
            {
                //单行歌词一句
                pattern = Pattern.compile(lyricReg);
                matcher = pattern.matcher(temp);
                if (matcher.find())
                {
                    temp = matcher.group();
                }
                else
                {
                    temp = "";
                }

                for (int milli : millis)
                {
                    while(timeLyric.containsKey(milli))
                        milli++;
                    timeLyric.put(milli, temp);
                }
            }
        }
    }

    /**
     * 把时间转成毫秒
     *
     * @param temp
     * @return
     */
    private int getListMilliseconds(String temp)
    {
        int millisencond = 0;
        final String REGEX = "\\d\\d";
        Pattern pattern = Pattern.compile(REGEX);
        Matcher matcher = pattern.matcher(temp);
        for (int i = 0; matcher.find(); i++)
        {
            int tempInt = Integer.parseInt(matcher.group());
            switch (i)
            {
                case 0:
                    millisencond += tempInt * 60 * 1000;
                    break;
                case 1:
                    millisencond += tempInt * 1000;
                    break;
                case 2:
                    millisencond += tempInt * 10;
            }
        }
        return millisencond;
    }

    /**
     * 设置歌的属性
     * 如歌手，专辑
     * @param attr
     * @return
     */
    public String setAttr(String attr)
    {
        for (String temp : lrcLine)
        {
            if (temp.startsWith("["+attr+":"))
            {
                return temp.replace("[" + attr + ":", "").replace("]", "");
            }
        }
        return null;
    }

    /**
     * 返回歌手
     * @return 歌手名
     */
    @Override
    public String getSingerName()
    {
        return setAttr(singNameAttr);
    }

    /**
     * 返回 LRC 作者
     * @return LRC 作者
     */
    @Override
    public String getAuthor()
    {
        return setAttr(authorAttr);
    }

    /**
     * 返回专辑名
     * @return 专辑名
     */
    @Override
    public String getAlbumName()
    {
        return setAttr(albumNameAttr);
    }

    /**
     * 返回歌名
     * @return 歌名
     */
    @Override
    public String getSingName()
    {
        return setAttr(singNameAttr);
    }

    /**
     * 返回时间和歌词对应的 map
     * @return 时间和歌词对应的 map
     */
    @Override
    public Map<Integer, String> getTimeLyricMap()
    {
        return timeLyric;
    }
}
