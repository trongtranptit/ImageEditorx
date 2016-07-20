package com.example.nghia.imageediter;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.nghia.cameramodul.CameraActivity;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity  {
    ImageButton img_cam, img_galery ;
    public static final int IMAGE_GALLERY_REQUEST = 20;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img_cam = (ImageButton) findViewById(R.id.imb_cam);
        img_galery = (ImageButton) findViewById(R.id.imb_galery);

        ActionClickBut ac = new ActionClickBut() ;

        img_cam.setOnClickListener(ac);
        img_galery.setOnClickListener(ac);
    }

    class ActionClickBut implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.imb_cam : {

                    break;
                }
                case R.id.imb_galery : {
                    Intent t = new Intent(MainActivity.this, PreGallery.class);
                    startActivity(t);
                    break;
                }
            }
        }
    }


}
