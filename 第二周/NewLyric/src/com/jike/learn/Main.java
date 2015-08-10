package com.jike.learn;

import com.jike.learn.api.LrcPlayer;
import com.jike.learn.lrc.LrcPlay;

/**
 * Created by lihuaye on 15/8/10.
 */
public class Main
{
    public static void main(String[] args)
    {
        LrcPlayer player = new LrcPlay("Only My Railgun.lrc");
        player.play();
    }
}
