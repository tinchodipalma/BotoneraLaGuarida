
package com.tdp.laguarida;

import java.io.File;
import java.util.ArrayList;

import android.app.Application;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Environment;
import android.util.Log;

public class LaGuaridaApp extends Application {

    public static MediaPlayer mediaPlayer;
    public static ArrayList<String> musicList;
    public static File soundsPath;
    public static final String LAGUARIDA_SD_DIR = Environment.getExternalStorageDirectory() + "laguarida/";

    @Override
    public void onCreate() {
        super.onCreate();
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        musicList = new ArrayList<String>();
        // AssetManager assetMgr = getApplicationContext().getAssets();
        //
        // try {
        // musicList = assetMgr.list("");
        // } catch (IOException e) {
        // e.printStackTrace();
        // }

        Log.i("LG", Environment.getExternalStorageDirectory().toString());

        soundsPath = new File(Environment.getExternalStorageDirectory(), "laguarida/");

        if (!(soundsPath.exists() && soundsPath.isDirectory())) {
            soundsPath.mkdir();
        }
        
        String[] auxPaths = soundsPath.list();

        if (auxPaths != null) {
            for (int i = 0; i < auxPaths.length; i++) {
                musicList.add(auxPaths[i]);
            }
            Log.i("LG", musicList.toString());
        } else {
            Log.e("LG", "Esta NULO!!");
        }

    }

}
