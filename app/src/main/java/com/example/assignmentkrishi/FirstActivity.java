package com.example.assignmentkrishi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.ArrayList;
import java.util.List;

public class FirstActivity extends YouTubeBaseActivity {
    String api_key = "AIzaSyD0ZQVheE9Off0CCd66TRI746LLpWXJVv0";
        @Override
        protected void
        onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.first_activity);
            Button nextPage=findViewById(R.id.button2);
            YouTubePlayerView ytPlayer = (YouTubePlayerView)findViewById(R.id.ytPlayer);
            ytPlayer.initialize(api_key, new YouTubePlayer.OnInitializedListener() {
                @Override
                public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

                    List<String> videoList = new ArrayList<>();
                      videoList.add("IEF6mw7eK4s");
                      videoList.add("8CEJoCr_9UI");
                      videoList.add("344u6uK9qeQ");
                      videoList.add("3-nM3yNi3wg");
                      videoList.add("RlcY37n5j9M");
                      videoList.add("nB7nGcW9TyE");
                      youTubePlayer.loadVideos(videoList);
                    youTubePlayer.play();
                }
                @Override
                public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                    Toast.makeText(getApplicationContext(), "Video player Failed", Toast.LENGTH_SHORT).show();
                }
            });

            nextPage.setOnClickListener(view -> {
                Intent i = new Intent(FirstActivity.this, SecondActivity.class);
                startActivity(i);
            });
   }
}