package com.jike.learn.player;

import android.content.Context;
import android.media.MediaPlayer;

import java.io.IOException;

/**
 * Created by lihuaye on 15/8/11.
 */
public class MusicPlay
{
    private MediaPlayer mp;
    private int count = 0;

    public MusicPlay(Context context, int resId)
    {
        mp = MediaPlayer.create(context, resId);
        count++;

    }

    public void play()
    {
        mp.start();
        mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener()
        {
            @Override
            public void onCompletion(MediaPlayer mp)
            {
                mp.release();
            }
        });
    }

}
