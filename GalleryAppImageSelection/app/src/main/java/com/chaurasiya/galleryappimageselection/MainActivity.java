package com.chaurasiya.galleryappimageselection;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView imgGallery;
    Button btnGallery;
    private static final int REQUEST_CODE_FOR_GALLERY = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imgGallery = findViewById(R.id.imgGallery);
        btnGallery = findViewById(R.id.btnGallery);
        btnGallery.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.TIRAMISU)
            @Override
            public void onClick(View v) {
                Intent iGallery = new Intent();
//
                iGallery.setAction(MediaStore.ACTION_PICK_IMAGES);
//                iGallery.setAction(Intent.ACTION_PICK);
//                iGallery.setData(MediaStore.Images.Media.EXTERNAL_CONTENT_URI);


                startActivityForResult(iGallery, REQUEST_CODE_FOR_GALLERY);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode==RESULT_OK){
            if(requestCode==REQUEST_CODE_FOR_GALLERY){
//                Bitmap bitmap = (Bitmap)data.getExtras().get("data");
//                imgGallery.setImageBitmap(bitmap);
                imgGallery.setImageURI(data.getData());
            }
        }
    }
}

