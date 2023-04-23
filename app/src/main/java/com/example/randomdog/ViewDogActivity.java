package com.example.randomdog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.squareup.picasso.Picasso;

public class ViewDogActivity extends AppCompatActivity {
    //Declaration
    private ImageView imageViewDog;
    private VideoView videoViewDog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_dog);

        imageViewDog = findViewById(R.id.image_view_dog);
        videoViewDog = findViewById(R.id.video_view_dog);

        Intent intent=getIntent();
        String dogUrl = intent.getStringExtra("dog_url");

        String extension = dogUrl.substring(dogUrl.lastIndexOf(".") + 1);
        Log.e("--->",extension+"");

        imageViewDog.setVisibility(View.VISIBLE);
        Picasso.with(this).load(dogUrl).into(imageViewDog);


        if (extension.trim().equalsIgnoreCase("mp4")){
            videoViewDog.setVisibility(View.VISIBLE);
            videoViewDog.setVideoURI(Uri.parse(dogUrl));
            MediaController mediaController = new MediaController(this);
            mediaController.setAnchorView(videoViewDog);
            mediaController.setMediaPlayer(videoViewDog);
            videoViewDog.setMediaController(mediaController);
            videoViewDog.start();
        }
    }
}