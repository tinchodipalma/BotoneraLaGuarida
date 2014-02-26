
package com.tdp.laguarida.activity;

import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.tdp.laguarida.LaGuaridaApp;
import com.tdp.laguarida.R;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView redButton = (ImageView) this.findViewById(R.id.red_button);

        redButton.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {

                Log.i("LaGuarida", "Click");

                Log.i("LaGuarida", "MUSIC_FILE_ARRAY LENGTH: " + LaGuaridaApp.musicList.size());

                if (LaGuaridaApp.musicList.size() > 0) {

                    int random = (int) Math.ceil(Math.random() * (LaGuaridaApp.musicList.size())) - 1;

                    Log.i("LaGuarida", "Random: " + random);

                    if (LaGuaridaApp.mediaPlayer.isPlaying()) {
                        LaGuaridaApp.mediaPlayer.stop();
                    }

                    try {                        
                        LaGuaridaApp.mediaPlayer.reset();
                        LaGuaridaApp.mediaPlayer.setDataSource(LaGuaridaApp.soundsPath + "/" + LaGuaridaApp.musicList.get(random));
                        LaGuaridaApp.mediaPlayer.prepare();
                        LaGuaridaApp.mediaPlayer.start();

                    } catch (IllegalArgumentException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (SecurityException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IllegalStateException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                } else {
                    Log.e("LG", "Vacioooooooooo");
                }

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (LaGuaridaApp.mediaPlayer.isPlaying()) {
            LaGuaridaApp.mediaPlayer.stop();
        }
        finish();
    }

}
