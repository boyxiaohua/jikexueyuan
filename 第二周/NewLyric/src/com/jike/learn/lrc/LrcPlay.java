package com.jike.learn.lrc;

import com.jike.learn.api.LrcPlayer;
import com.jike.learn.bean.LrcInfo;

/**
 * Created by lihuaye on 15/8/10.
 */
public class LrcPlay implements LrcPlayer
{
    String lrcPath;
    @Override
    public void play()
    {
        LrcInfo info = new LrcInfo(new LrcParse(lrcPath));
        info.singSong();
    }

    public LrcPlay(String lrcPath)
    {
        this.lrcPath = lrcPath;
    }
}
