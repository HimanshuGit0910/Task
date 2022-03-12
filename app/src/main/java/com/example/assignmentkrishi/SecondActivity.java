package com.example.assignmentkrishi;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.github.dhaval2404.imagepicker.ImagePicker;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
public class SecondActivity extends AppCompatActivity {
    ImageView clickImage;
    public static final String KEY2 ="photo";
    Uri uri;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        EditText Name = findViewById(R.id.editTextTextPersonName);
        EditText emailToText = findViewById(R.id.editTextTextEmailAddress);
        Button sumbit = findViewById(R.id.sumbit);
        clickImage = findViewById(R.id.cameraImage);
        FloatingActionButton click = findViewById(R.id.floatingActionButton);

        sumbit.setOnClickListener(view -> {
            if (Name.getText().toString().isEmpty() || emailToText.getText().toString().isEmpty()) {
                Name.setError("Please enter a Name");
            }
          else if (!Patterns.EMAIL_ADDRESS.matcher(emailToText.getText().toString()).matches()) {
                emailToText.setError("Please enter a Valid E-Mail Address!");
            }
            else if (uri==null){
                Toast.makeText(this, "please capture image ", Toast.LENGTH_SHORT).show();
            }
           else {
                Intent intent=new Intent(getApplicationContext(),ThirdActivity.class);
                intent.putExtra("username",Name.getText().toString());
                intent.putExtra("UserEmail",emailToText.getText().toString());
                intent.putExtra(KEY2,uri.toString());
                intent.setType("image/jpeg");
                startActivity(intent);
           }
        });


        click.setOnClickListener(view -> ImagePicker.Companion.with(SecondActivity.this)
                .cameraOnly()
                .start());
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        uri =data.getData();
        clickImage.setImageURI(uri);
    }
}