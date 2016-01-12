/*
 * Copyright (C) 2012 Jacquet Wong
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * musicg api in Google Code: http://code.google.com/p/musicg/
 * Android Application in Google Play: https://play.google.com/store/apps/details?id=com.whistleapp
 * 
 */

package nchu.water_saver;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.musicg.fingerprint.FingerprintSimilarity;
import com.musicg.wave.Wave;

import java.io.InputStream;

public class MainActivity extends Activity
{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InputStream songA = getResources().openRawResource(R.raw.canon_d_major);
        InputStream songB = getResources().openRawResource(R.raw.fing_fing_ha);
        InputStream songC = getResources().openRawResource(R.raw.forrest_gump_theme);
        InputStream songD = getResources().openRawResource(R.raw.imagine);
        InputStream songE = getResources().openRawResource(R.raw.top_of_the_world);

        // create a wave object
        Wave waveA = new Wave(songA);
        Wave waveB = new Wave(songB);
        Wave waveC = new Wave(songC);
        Wave waveD = new Wave(songD);
        Wave waveE = new Wave(songE);

        InputStream recordedClip = getResources().openRawResource(R.raw.top_of_the_world_rec);
        Wave waveRec = new Wave(recordedClip);

        FingerprintSimilarity similarity;

        // song A:
        similarity = waveA.getFingerprintSimilarity(waveRec);
        System.out.println("clip is found at "
                + similarity.getsetMostSimilarTimePosition() + "s in "
                + songA + " with similarity " + similarity.getSimilarity());

        // song B:
        similarity = waveB.getFingerprintSimilarity(waveRec);
        System.out.println("clip is found at "
                + similarity.getsetMostSimilarTimePosition() + "s in "
                + songB + " with similarity " + similarity.getSimilarity());

        // song C:
        similarity = waveC.getFingerprintSimilarity(waveRec);
        System.out.println("clip is found at "
                + similarity.getsetMostSimilarTimePosition() + "s in "
                + songC + " with similarity " + similarity.getSimilarity());

        // song D:
        similarity = waveD.getFingerprintSimilarity(waveRec);
        System.out.println("clip is found at "
                + similarity.getsetMostSimilarTimePosition() + "s in "
                + songD + " with similarity " + similarity.getSimilarity());

        // song E:
        similarity = waveE.getFingerprintSimilarity(waveRec);
        System.out.println("clip is found at "
                + similarity.getsetMostSimilarTimePosition() + "s in "
                + songE + " with similarity " + similarity.getSimilarity());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
        }
        return super.onOptionsItemSelected(item);
    }


    protected void onDestroy()
    {
        super.onDestroy();
        android.os.Process.killProcess(android.os.Process.myPid());
    }
}
