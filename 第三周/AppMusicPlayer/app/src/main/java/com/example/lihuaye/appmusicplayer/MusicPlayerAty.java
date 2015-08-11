package com.example.lihuaye.appmusicplayer;

import android.app.Activity;
import android.os.Bundle;
import android.os.Message;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import com.jike.learn.player.LrcPlay;
import com.jike.learn.player.MusicPlay;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import android.os.Handler;


public class MusicPlayerAty extends Activity
{

    private TextView tv;
    String lyric;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg)
        {
            super.handleMessage(msg);
            tv.setText(lyric);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player_aty);
        tv = (TextView) findViewById(R.id.lyricText);

        setView();
    }


    private void setView()
    {

        //播放音乐
        MusicPlay mp = new MusicPlay(this, R.raw.music);
        mp.play();


        /**
         * 开启个线程
         * 用 Handler 更新 TextView
         */
        new Thread(){
            @Override
            public void run()
            {
                LrcPlay lrc = new LrcPlay(getResources().openRawResource(R.raw.lrc));

                Map<Integer,String> timeLyric=lrc.getInfo().getTimeLyricMap();
                Set<Integer> times = new TreeSet<Integer>(timeLyric.keySet());
                Iterator<Integer> iterator = times.iterator();
                int sillisecond=0;
                while (iterator.hasNext())
                {
                    int silli=iterator.next();
                    try
                    {
                        sleep(silli - sillisecond);
                        sillisecond = silli;
                        lyric=timeLyric.get(silli);
                        handler.sendMessage(handler.obtainMessage());
                    } catch (Exception e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }.start();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_music_player_aty, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
