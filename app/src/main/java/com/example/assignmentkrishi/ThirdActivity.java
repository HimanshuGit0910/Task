package com.example.assignmentkrishi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {
TextView showData, userEmailDataShow;
ImageView receiveImage;
Button first;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        showData=findViewById(R.id.name);
        showData.setText(getIntent().getStringExtra("username"));
        userEmailDataShow=findViewById(R.id.userEmail);
        userEmailDataShow.setText(getIntent().getStringExtra("UserEmail"));
        receiveImage=findViewById(R.id.receiveImage);

        Intent intent=getIntent();
        String inputImage = intent.getStringExtra(SecondActivity.KEY2);
        receiveImage.setImageURI(Uri.parse(inputImage));
        first=findViewById(R.id.FirstScreen);


        first.setOnClickListener(view -> {
            Intent i = new Intent(ThirdActivity.this, FirstActivity.class);
            startActivity(i);
        });
    }
}