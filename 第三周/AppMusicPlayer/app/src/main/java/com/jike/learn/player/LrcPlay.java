package com.jike.learn.player;

import com.jike.learn.api.LrcPlayer;
import com.jike.learn.bean.LrcInfo;

import java.io.InputStream;

/**
 * Created by lihuaye on 15/8/10.
 */
public class LrcPlay implements LrcPlayer
{
    private InputStream lrcPath;
    private LrcInfo info;
    @Override
    public void play()
    {
        info.singSong();
    }

    public LrcInfo getInfo()
    {
        return info;
    }

    public LrcPlay(InputStream lrcPath)
    {
        this.lrcPath = lrcPath;
        info= new LrcInfo(new LrcParse(lrcPath));
    }
}
